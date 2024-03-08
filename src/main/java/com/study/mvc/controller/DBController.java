package com.study.mvc.controller;

import com.study.mvc.dto.DBStudyReqDto;
import com.study.mvc.service.DBStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBController {

    @Autowired
    private DBStudyService dbStudyService;

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody/*Json body를 받을 때*/ DBStudyReqDto dbStudyReqDto /* joson으로 받아온 값 일치, json값이 객체로 변환되어 들어옴*/) {
        System.out.println(dbStudyReqDto);
        return ResponseEntity.ok(dbStudyService.createStudy(dbStudyReqDto)); // dbStudyReqDto 안 내용을 createStudy로 넘겨주기
    }
}
