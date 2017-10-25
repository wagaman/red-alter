package com.bbd.dafei.web.sys;

import com.bbd.dafei.biz.service.utils.DateConvert;
import com.bbd.dafei.common.exception.CommonException;
import com.bbd.dafei.common.util.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * 异常处理
 * @author Ian.Su * @version $Id: sys.java, v 0.1 2017/4/18 14:39 Ian.Su Exp $
 */
@ControllerAdvice("com.bbd.dafei.web.controller")
public class RaHandlerException {
    Logger logger = LoggerFactory.getLogger(RaHandlerException.class);

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object exception(MissingServletRequestParameterException ex) {

        String detail = getDetail(ex);

        StringBuilder msg = new StringBuilder("参数 ");
        msg.append(ex.getParameterName());
        msg.append(" 为必传参数,类型为 ");
        msg.append(ex.getParameterType());

        return ResponseBean.errorResponse(400,msg.toString(),detail);

    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object exception(MethodArgumentTypeMismatchException ex) {

        String detail = getDetail(ex);

        StringBuilder msg = new StringBuilder("参数类型不匹配: 参数 ");
        msg.append(ex.getName());
        msg.append(" 类型为 ");
        msg.append(ex.getRequiredType().getSimpleName());

        return ResponseBean.errorResponse(400,msg.toString(),detail);

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object exception(Exception ex) {

        String detail = getDetail(ex);

        if(ex instanceof CommonException){
            return ResponseBean.errorResponse(((CommonException) ex).getErrCode(),ex.getMessage(),detail);
        }

        if(ex.getClass().getName().startsWith("com.bbd")){

            return ResponseBean.errorResponse(500,ex.getMessage(),detail);

        }else{
            return ResponseBean.errorResponse(500,"数据请求出现故障.",detail);
        }
    }





    private String getDetail(Exception ex){

//        ex.printStackTrace();

        logger.error(ex.getMessage(),ex);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
//        ex.printStackTrace(pw);
        logger.error(ex.getMessage(),pw);
        return sw.toString();
    }


}
