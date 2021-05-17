//package com.inst.mall.cloud.backstage.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 网络请求 aop 日志输出
// * @author nf
// * @since 2020/1/8 16:29
// */
//@Aspect
//@Slf4j
//@Component
//public class HttpLogAspect {
//
//    /**
//     * 开始时间 线程缓存
//     */
//    private ThreadLocal<Long> startTime = new ThreadLocal<>();
//
//    /**
//     * 切入点
//     */
//    @Pointcut("execution(public * com.inst.mall.cloud.backstage.controller..*.*(..))")
//    public void pointCut(){
//
//    }
//
//    /**
//     * 请求处理 进入方法之前
//     * @param joinPoint joinPoint
//     */
//    @Before(value = "pointCut()")
//    public void beforeExecute(JoinPoint joinPoint){
//        startTime.set(System.currentTimeMillis());
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if (requestAttributes != null) {
//            HttpServletRequest request = requestAttributes.getRequest();
//            // 记录下请求内容
//            log.info("START : {} : {}",joinPoint.getTarget().getClass().getName(),joinPoint.getSignature().getName());
//            log.info("==> CLASS_METHOD : {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//            log.info("==> URL : {}" , request.getRequestURL().toString());
//            log.info("==> HTTP_METHOD : {}" , request.getMethod());
//            log.info("==> IP : {}" , request.getRemoteAddr());
//        }
//    }
//
//    /**
//     * 请求处理结束后
//     * @param ret  ret
//     */
//    @AfterReturning(value = "pointCut()",returning = "ret")
//    public void afterReturning(JoinPoint joinPoint, Object ret){
//        log.info("<== RESPONSE: {}",ret);
//        log.info("耗时 : {}ms", System.currentTimeMillis() - startTime.get());
//        log.info("END : {} : {}",joinPoint.getTarget().getClass().getName(),joinPoint.getSignature().getName());
//        startTime.remove();
//    }
//}
