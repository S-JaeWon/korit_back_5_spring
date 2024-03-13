package com.study.mvc.controller;

import com.study.mvc.aop.annotation.ParamsAspect;
import com.study.mvc.dto.ParamsTestDto;
import com.study.mvc.service.AOPService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AOPController { //TODO AOP

    @Autowired
    private AOPService aopService;

    @ParamsAspect
    @GetMapping("/aop/params")
    public ResponseEntity<?> paramsTest(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer option
    ) {


        aopService.test("심재원", 29);
        //log.info/*error*/("params:{}", paramsTestDto);

        // 데이터베이스에서 정보 조회

        return ResponseEntity.ok(null);
    }

}
