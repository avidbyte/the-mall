package com.inst.mall.cloud.backstage.aop;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统一AOP记录接口访问日志
 *
 * @author aaron
 * @since 2021-02-09
 **/
@Aspect
@Component
@Order(1)
@Slf4j
public class ApplicationLogAspect {

    @Resource
    private MongoTemplate mongoTemplate;

    @Pointcut("execution(public * com.inst.mall.cloud.backstage.controller.*.*(..))")
    public void applicationLog() {

    }

//    @Before("applicationLog()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        log.info("Before");
//    }
//
//    @AfterReturning(value = "applicationLog()", returning = "ret")
//    public void doAfterReturning(Object ret) throws Throwable {
//        log.info("AfterReturning");
//    }

    @Around("applicationLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
        LocalDateTime startTime = LocalDateTime.now();
        //获取当前请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //记录请求信息
        BackstageRequestLog applicationLog = new BackstageRequestLog();
        Object result = joinPoint.proceed();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        //ApiOperation   swagger里的
//        if (method.isAnnotationPresent(ApiOperation.class)) {
//            ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
//            applicationLog.setDescription(apiOperation.value());
//        }
//        long endTime = System.currentTimeMillis();
        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime,endTime);
        long millis = duration.toMillis();
        String urlStr = request.getRequestURL().toString();
        applicationLog.setBasePath(StrUtil.removeSuffix(urlStr, URLUtil.url(urlStr).getPath()));
        applicationLog.setIp(request.getRemoteUser());
        applicationLog.setMethod(request.getMethod());
        applicationLog.setParameter(getParameter(method, joinPoint.getArgs()));
        applicationLog.setSpendTime((millis));
        applicationLog.setStartTime(startTime);
        applicationLog.setEndTime(endTime);
        applicationLog.setUri(request.getRequestURI());
        applicationLog.setUrl(request.getRequestURL().toString());
        log.info("{}", JSONUtil.parse(applicationLog));
        mongoTemplate.save(applicationLog);
        return result;
    }

    /**
     * 根据方法和传入的参数获取请求参数
     */
    private Object getParameter(Method method, Object[] args) {
        List<Object> argList = new ArrayList<>();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            //将RequestBody注解修饰的参数作为请求参数
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            if (requestBody != null) {
                argList.add(args[i]);
            }
            //将RequestParam注解修饰的参数作为请求参数
            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
            if (requestParam != null) {
                Map<String, Object> map = new HashMap<>();
                String key = parameters[i].getName();
                if (!StringUtils.isEmpty(requestParam.value())) {
                    key = requestParam.value();
                }
                map.put(key, args[i]);
                argList.add(map);
            }
        }
        if (argList.size() == 0) {
            return null;
        } else if (argList.size() == 1) {
            return argList.get(0);
        } else {
            return argList;
        }
    }

}
