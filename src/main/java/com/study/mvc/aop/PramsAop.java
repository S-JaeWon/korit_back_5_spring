package com.study.mvc.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class PramsAop {

    @Pointcut("@annotation(com.study.mvc.aop.annotation.ParamsAspect)") // 이 @ 가 달려있는 메소드를 찾고 - 1
    private void pointCut() {}

    @Around("pointCut()") // 찾은 메소드에 적용 - 2
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs(); // 변수 값

        CodeSignature codeSignature = (CodeSignature) proceedingJoinPoint.getSignature(); // 변수명과 자료형
        String[] paramsName = codeSignature.getParameterNames();

        String className = codeSignature.getDeclaringTypeName(); // 클래스명
        String methodName = codeSignature.getName(); // 메소드명

//        for(Object obj : args) {
//            log.info("{}", obj);
//        }
        for(int i = 0; i < args/*paramsName*/.length; i++) { // 배열안의 값과 변수의 수는 같으므로 인덱스를 이용해서 반복문 사용가능
            log.info("{}.{} >>> {}: {}", className, methodName, paramsName[i], args[i]);
        }

        //log.info("전처리");
        Object result =  proceedingJoinPoint.proceed(); // 비즈니스 로직, 실제로 실행되는 메소드

        //log.info("후처리");
        //log.info("response: {}", result);

        return result;
    }
}
