package com.bbd.dafei.biz.service.exetime;

import com.bbd.dafei.common.util.ResponseBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Ian.Su
 * @version $Id: TimeConsumingAspect.java, v 0.1 2017/3/6 15:52 Ian.Su Exp $
 */
@Aspect
@Component
public class TimeConsumingAspect {

    Logger LOGGER = LoggerFactory.getLogger(TimeConsumingAspect.class);

    @Pointcut("execution(* com.bbd..service.impl..*(..))")
    private void serviceCostTime() {
    }

    @Pointcut("execution(* com.bbd..service.components..*(..))")
    private void componentCostTime() {
    }


    @Pointcut("execution(* com.bbd..*Controller.*(..))")
    private void controllerCostTime() {
    }



    @Around("serviceCostTime() || controllerCostTime() || componentCostTime()")
   //@Around("serviceCostTime()")
   public Object around(ProceedingJoinPoint pjp) throws Throwable {


        Long start = System.currentTimeMillis();
        StackTraceElement[] stes = Thread.currentThread().getStackTrace();
        StringBuilder methodLink = new StringBuilder(500);
        String endMethod = "";
        String endClass = "";
        String thisClassName = this.getClass().getName();
        for (int len = stes.length - 1; len > -1; len--) {
            StackTraceElement ste = stes[len];
            String className = ste.getClassName();
            if (className.contains("BySpringCGLIB") && className.startsWith("com.bbd")
                && !className.equals(thisClassName)) {

                String[] cns = className.split("\\.");
                endMethod = ste.getMethodName();
                String typeName = cns[cns.length - 1];
                if (!typeName.contains("FastClassBySpringCGLIB")) {

                    endClass = typeName.replaceAll("\\$.*", "");
                    methodLink.append(endClass).append(".").append(endMethod).append(":");

                }

            }

        }

        Object r = pjp.proceed();

        if (methodLink.length() > 0 && !thisClassName.contains(endClass)) {
            Long times = System.currentTimeMillis() - start;
            TheadLocalData.addCostTime(methodLink.append(times).append("ms").toString());

            if(endClass.contains("Controller") &&  r instanceof ResponseBean ){
                ((ResponseBean)r).setExeTimes( TheadLocalData.getCostTimeAndClean() );
            }
        }
        return r;
    }

}
