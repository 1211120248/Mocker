package com.mocker.core.log.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mocker.core.log.domain.Log;
import com.mocker.core.log.service.ILogService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.Date;

/**
 * @author Mocker
 * @Date 2017-01-02 下午11:22
 * @Description Aop日志拦截器
 * @Version 1.0
 */
@Aspect
@Component
public class WebLogAspect {

    private Logger logger = Logger.getLogger(getClass());

    ThreadLocal<Log> logThreadLocal = new ThreadLocal<Log>();

    private  ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private ILogService logService;

    @Pointcut("execution(public * com.mocker.web..*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        Log log = new Log();
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) attributes.getRequest();
        // 记录下请求内容
        log.setCreateTime(new Date());
        log.setUrl(request.getRequestURL().toString());
        log.setMethod(request.getMethod());
        log.setIp(request.getRemoteAddr());
        log.setClassMethod(joinPoint.getSignature().getDeclaringTypeName()+ "." + joinPoint.getSignature().getName());
        log.setArgs(mapper.writeValueAsBytes(joinPoint.getArgs()));
        logThreadLocal.set(log);
    }

    @AfterReturning(returning = "ret", pointcut = "log()")
    public void doAfterReturning(Object ret) throws Throwable {
        Log log = logThreadLocal.get();
        //相应内容
        log.setArgs(mapper.writeValueAsBytes(ret));
        //设置相应时间
        log.setResponseTime(new Date(System.currentTimeMillis() - log.getCreateTime().getTime()));
        logService.save(log);
    }
}
