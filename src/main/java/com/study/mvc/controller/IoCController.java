package com.study.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.study.mvc.diAndIoc.DiRepository;
import com.study.mvc.diAndIoc.DiService;
import com.study.mvc.diAndIoc.IoCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController // IoC를 할려면 @Component 달아줘야 하지만 @RestController 에는 포함됨.
public class IoCController { // https://velog.io/@gillog/Spring-DIDependency-Injection

//    private DiService diService; // 전역으로 뺌
//
//    // Component 객체, Bean 객체 -> 안에서 직접 new 하지 않기
//    public IoCController() {
//        DiRepository diRepository = new DiRepository(); // 생성될때 같이 생성
//        diService = new DiService(diRepository); // 넘겨줌
//    }
    @Autowired // @Component를 붙여서 IoCContainer에 등록된 것들을 알아서 추출 // final 붙이고 R.A.Constructor 사용가능
    private IoCService ioCService; // new 없이는 null만 존재함

    @GetMapping("/ioc")
    public ResponseEntity<?>/*get요청*/ iocTest() throws JsonProcessingException {
//        int total = diService.getTotal();
//        double avg = diService.getAverage();
//        Map<String, Object> map =
//                Map.of("total", total, "avg", avg);
        String json = ioCService.getJson(); // IoCService 에서 writeValueAsString 에대 한 예외처리를 해주었기 때문에 여기서 해줌

        return ResponseEntity.ok(json);
    }
}













