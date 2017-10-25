package com.bbd.dafei.web.sys;

/**
 * Created by wish on 2017/4/18.
 */

import com.bbd.dafei.biz.service.sys.UserLogThreadPool;
import com.bbd.dafei.biz.shared.UserLogService;
import com.bbd.dafei.common.annotation.UserLog;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.modal.dto.UserInfo;
import com.bbd.dafei.common.modal.dto.UserLogDTO;
import com.bbd.dafei.common.util.Constants;
import com.google.common.base.Joiner;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * aop日志记录
 * Created by wish on 2017/4/18.
 */
@Aspect
@Component
public class UserLogAspect {

    private final static String WEB_PAGE = "operationPage";

    @Autowired
    private UserLogService userLogService;

    @Pointcut("execution(* com.bbd.dafei.web.controller.*Controller.*(..))")
    private void controllerMethod() {
    }

    @Around("controllerMethod()")
    public Object controllerMethodAround(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest request = getHttpServletRequest();
        Method method = getMethod(pjp);
        executeAddLog(request, method);
        Object result = pjp.proceed();
        return result;
    }

    /**
     * 加入到线程池执行记录日志
     *
     * @param request
     * @param method
     */
    private void executeAddLog(final HttpServletRequest request, final Method method) {
        HttpSession session = request.getSession();
        UserPO userPO = (UserPO) session.getAttribute(Constants.SESSION_USER);
        if (userPO == null) {
            return;
        }

        UserLog userLogAnnotation = method.getAnnotation(UserLog.class);
        //没有加UserLog注解，不记录日志
        if (userLogAnnotation == null) {
            return;
        }

        String methodDescribe = getMethodDescribe(method);

        final UserLogDTO userLogDTO = new UserLogDTO();
        //用户名
        userLogDTO.setUserName(userPO.getUsername());

        userLogDTO.setPage(request.getParameter(WEB_PAGE));
        userLogDTO.setUrl(request.getRequestURI());
        userLogDTO.setOperation(methodDescribe);
        userLogDTO.setDetail(getParams(request, method));
        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_INFO);
        if (userInfo != null) {
            userLogDTO.setIp(userInfo.getIp());
            userLogDTO.setIpLocation(userInfo.getIpLocation());
        }

        UserLogThreadPool.execute(() -> userLogService.saveUserLog(userLogDTO));
    }

    /**
     * 取得controller的描述
     *
     * @param controller
     * @return
     */
    private String getControllerDescribe(Object controller) {
        Api api = controller.getClass().getAnnotation(Api.class);
        if (api != null && api.tags() != null && api.tags().length > 0) {
            return Joiner.on(",").skipNulls().join(api.tags());
        }
        return controller.getClass().getName();
    }

    /**
     * 取得方法的描述
     *
     * @param method
     * @return
     */
    private String getMethodDescribe(Method method) {
        UserLog userLog = method.getAnnotation(UserLog.class);
        //如果UserLog注解value值不为空，优先取UserLog的value作为方法的描述
        if (userLog != null && StringUtils.isNotBlank(userLog.value())) {
            return userLog.value();
        }
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        if (apiOperation != null && StringUtils.isNotBlank(apiOperation.value())) {
            return apiOperation.value();
        }
        return method.getName();
    }

    /**
     * 获取参数
     *
     * @param request
     * @param method
     * @return
     */
    private String getParams(HttpServletRequest request, Method method) {
        List<ApiImplicitParam> apiImplicitParamList = new ArrayList<>();
        //获取方法上面的swagger2 参数注解
        ApiImplicitParams apiImplicitParams = method.getAnnotation(ApiImplicitParams.class);
        if (apiImplicitParams != null) {
            CollectionUtils.addAll(apiImplicitParamList, apiImplicitParams.value());
        }
        CollectionUtils.addIgnoreNull(apiImplicitParamList, method.getAnnotation(ApiImplicitParam.class));

        //参数和对应描述
        Map<String, String> paramDescribeMap = new HashMap<>();
        for (ApiImplicitParam p : apiImplicitParamList) {
            paramDescribeMap.put(p.name(), p.value());
        }

        StringBuilder params = new StringBuilder();
        //获取参数
        Map<String, String[]> paramMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            String paramName = entry.getKey();
            //特殊参数不记录
            if (WEB_PAGE.equals(paramName) || "token".equals(paramName)) {
                continue;
            }
            String paramDescribe = paramDescribeMap.get(paramName);
            if (StringUtils.isBlank(paramDescribe)) {
                //没有参数注解，跳过
                continue;
            }
            params.append(paramDescribe);
            params.append(":");

            String[] values = entry.getValue();
            if (ArrayUtils.isNotEmpty(values)) {
                params.append(Joiner.on(",").skipNulls().join(values));
            }
            params.append(";");
        }
        return params.toString();
    }

    /**
     * 获取request
     *
     * @return
     */
    public HttpServletRequest getHttpServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return request;
    }

    /**
     * 获取方法
     *
     * @param pjp
     * @return
     * @throws Exception
     */
    private Method getMethod(ProceedingJoinPoint pjp) throws Exception {
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = pjp.getTarget();
        Method method = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        return method;
    }

}
