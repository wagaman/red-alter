
package com.bbd.dafei.web.interceptor;

import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.util.Constants;
import com.bbd.dafei.common.util.ResponseBean;
import com.google.gson.Gson;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tuanhong on 2017-05-06.
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse response, Object o) throws Exception {
        response.setContentType("text/html;charset=UTF-8");

        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        UserPO userPO = (UserPO) attrs.getRequest().getSession().getAttribute(Constants.SESSION_USER);
        if (StringUtils.isEmpty(userPO)) {
            Gson gson = new Gson();
            Object r = ResponseBean.errorResponse(332, "未登录");
            response.getWriter().write(gson.toJson(r));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
