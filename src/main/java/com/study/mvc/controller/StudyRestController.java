package com.study.mvc.controller;

import com.study.mvc.dto.HelloDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/*
* Controller명: StudentController
*
* 메소드명: getsStudentInfo()
* 요청 메소드: Get
* 요청 URL: /student
* 요청 Params: name, age, phone, address
* 응답데이터: JSON(name, age, phone, address)
*
* */



@RestController // 하나씩 @Responsebody 붙일 필요 없이 모든 응답이 data 응답으로, 대신 JSON 형식으로만 되고 html로 못 보냄
public class StudyRestController {

    @GetMapping("/hello/test")
    public String hello(HelloDto helloDto) {

        System.out.println(helloDto);
        return "Hello";
    }
}
