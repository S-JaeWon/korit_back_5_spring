package com.study.mvc.controller;

import com.study.mvc.dto.DBStudyReqDto;
import com.study.mvc.service.DBStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DBController {

    @Autowired
    private DBStudyService dbStudyService;

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody/*Json body를 받을 때*/ DBStudyReqDto dbStudyReqDto /* joson으로 받아온 값 일치, json값이 객체로 변환되어 들어옴*/) {
        System.out.println(dbStudyReqDto);
        return ResponseEntity.ok(dbStudyService.createStudy(dbStudyReqDto)); // dbStudyReqDto 안 내용을 createStudy로 넘겨주기

    }

    @GetMapping("/select/study/{id}")
    public ResponseEntity<?> selectStudy(@PathVariable int id) {

        return ResponseEntity.ok(dbStudyService.findStudyById(id));
    }

    @GetMapping("/select/study") // ?name=~~
    public ResponseEntity<?> selectStudy(@RequestParam String name) {

        return ResponseEntity.ok(dbStudyService.findStudyByName(name));
    }

    @GetMapping("/select/studies")
    public ResponseEntity<?> selectStudyAll() {
        return ResponseEntity.ok(dbStudyService.findAll()/*.findAll2()*/);
    }

    @DeleteMapping("/delete/study/{id}")
    public ResponseEntity<?> deleteStudy(@PathVariable int id ) {
        return ResponseEntity.ok(dbStudyService.deleteById(id));
    }

    @PutMapping("/update/study/{id}") // 전체 수정
    public ResponseEntity<?> putStudy( // @RequestBody ~~ 수정할 데이터 받아오기
            @PathVariable int id,
            @RequestBody DBStudyReqDto dbStudyReqDto) {
       return ResponseEntity.ok(dbStudyService.putById(id, dbStudyReqDto));
    }
    @PatchMapping ("/update/study/{id}") // 부분 수정
    public ResponseEntity<?> patchStudy( // 수정시 put & patch Mapping 같이 씀
            @PathVariable int id,
            @RequestBody DBStudyReqDto dbStudyReqDto) {
       return ResponseEntity.ok(dbStudyService.patchById(id, dbStudyReqDto));
    }
}
