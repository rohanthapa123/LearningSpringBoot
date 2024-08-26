package com.aop.AOP.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//
//    @Before("execution(* com.aop.AOP.demo.controller.*.*(..))")
//    public void beforeMethod(JoinPoint joinPoint){
//        System.out.println("This is logged before method :" +
//         joinPoint.getSignature().getName());
//    }
//
//    @After("execution(* com.aop.AOP.demo.controller.*.*(..))")
//    public void afterMethod(){
//        System.out.println("This is logged after method");
//    }



//    @AfterReturning(pointcut = "execution(* com.aop.AOP.demo.controller.*.*(..))", returning = "result")
//    public void afterReturning(JoinPoint joinPoint, Object result){
//        System.out.println(joinPoint.getSignature().getName() + " method returned :" + result );
//    }
//
//
//    @AfterThrowing(pointcut = "execution(* com.aop.AOP.demo.controller.*.*(..))", throwing = "error")
//    public void afterThrowing(Throwable error){
//        System.out.println("Method threw exception " + error);
//    }
//
//    @Around("execution(* com.aop.AOP.demo.controller.*.*(..))")
//    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
//        System.out.println("Around Before method: " + proceedingJoinPoint.getSignature().getName());
//        Object result = proceedingJoinPoint.proceed();
//        System.out.println("Around after method:" + proceedingJoinPoint.getSignature().getName());
//        return result;
//    }


    //    @Pointcut("execution(* com.aop.AOP.demo.controller.*.**(..))")
//    private void myPointCut(){
//    }
//
//    @Before("myPointCut()")
//    public void logBefore(JoinPoint joinPoint){
//        System.out.println("Executing before method" + joinPoint.getSignature().getName());
//    }


}
