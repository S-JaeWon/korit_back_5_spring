package com.study.mvc.controller;

import com.study.mvc.model.HelloModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller // Servlet 파일 만듦과 같음
public class StudyController {

    // MVC
    @GetMapping("/hello")
    public String helloPage(Model model) {
//        model.addAttribute("name1", "민지");
//        model.addAttribute("name2", "철수");
//        model.addAttribute("name3", "영지");
//        Map<String, Object> model = new HashMap<>();
//        model.put("name1", "민지");
//        model.put("name2", "철수");
//        model.put("name3", "영지");
//        return new ModelAndView("hello", model);
        HelloModel helloModel = HelloModel.builder()
                .name1("철수")
                .name2("영희")
                .name3("민지")
                .build();
        model.addAttribute("helloModel", helloModel);
        return "hello";
    }

    // REST
    @GetMapping("/test")
    @ResponseBody // viewname return x (age 반환 x) "test"라는 문자열이 렌더링 됨
    public Map<String, Object> testPage(/*Model model*/) {
//        model.addAttribute("age", "32");
        Map<String, Object> testObj = new HashMap<>();
        testObj.put("age", 32);
        return testObj;
    }



}
