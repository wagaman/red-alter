package com.bbd.dafei.biz.service.exetime;


import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;



/**
 * 数据库操作性能拦截器,记录耗时
 * @author Ian.Su
 * @version $Id: SqlStatementInterceptorAspect.java, v 0.1 2017/3/8 18:18 Ian.Su Exp $
 */
@Intercepts(value = {
        @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
        @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class }),
        @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,RowBounds.class, ResultHandler.class }) })
public class SqlStatementInterceptorAspect implements Interceptor{

    private static Logger LOGGER = LoggerFactory.getLogger(SqlStatementInterceptorAspect.class);

    private Properties properties;

    @Override
    public Object intercept(Invocation action) throws Throwable
    {



        long start = System.currentTimeMillis();
        Object returnValue = action.proceed();


        MappedStatement mappedStatement = (MappedStatement) action.getArgs()[0];
        String [] sqlIds = mappedStatement.getId().split("\\.");

        if(mappedStatement.getId().startsWith(this.getClass().getName())){
            return returnValue;
        }

        StackTraceElement[] stes = Thread.currentThread().getStackTrace();
        StringBuilder methodLink = new StringBuilder(500);
        String endMethod="";
        String endCalss="";
        String thisClassName = this.getClass().getName();
        for(int len = stes.length-1;len > -1;len--){
            StackTraceElement ste = stes[len];
            String className = ste.getClassName();
            if( className.contains("BySpringCGLIB") &&
                    className.startsWith("com.bbd") && !className.equals( thisClassName )){
                String[] cns = className.split("\\.");
                endMethod = ste.getMethodName();
                String typeName = cns[cns.length-1];
                if(!typeName.contains("FastClassBySpringCGLIB") && !typeName.contains(this.getClass().getName())){
                    endCalss = typeName.replaceAll("\\$.*","");
                    methodLink.append(endCalss).append(".").append(endMethod).append(":");

                }
            }
        }

        methodLink.append(sqlIds[sqlIds.length-2]).append(".").append(sqlIds[sqlIds.length-1]).append(":");
        if(!thisClassName.contains(endCalss)){
            TheadLocalData.addCostTime(methodLink.append(System.currentTimeMillis()-start).append("ms").toString());
        }

        return returnValue;
    }

    @Override
    public Object plugin(Object arg0)
    {
        return Plugin.wrap(arg0, this);
    }

    @Override
    public void setProperties(Properties arg0)
    {
        this.properties = arg0;
    }
}
