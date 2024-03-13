package com.study.mvc.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({/*ElementType.TYPE*/ ElementType.METHOD /*ElementType.FIELD*/}) // 클래스, 메소드, 변수 위에 달 수 있게해줌
public @interface ParamsAspect {} //TODO 어노테이션 등록


