package com.study.mvc.controller;

import com.study.mvc.diAndIoc.DiRepository;
import com.study.mvc.diAndIoc.DiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class DiController {

    /*
    *
    * DI(Dependency Injection) - 의존성 주입
    * */

    @GetMapping("/di")
    public ResponseEntity<?> diTest() {
        DiRepository diRepository = new DiRepository(); // 생성 할때 (new 할때) 주소 생성 후 1)
        DiService diService = new DiService(diRepository); // service에 주소 넘겨주기 괄호안에 넣기 2), service로
        Map<String, Object> responseData =
                Map.of(
                        "total", diService.getTotal(),
                        "average", diService.getAverage()
                );
        return ResponseEntity.ok(responseData);
    }
}
