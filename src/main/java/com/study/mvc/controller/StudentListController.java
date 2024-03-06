package com.study.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.study.mvc.service.Student1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentListController {

    @Autowired
    private Student1Service student1Service;

    @GetMapping("/ex1/students")
    public ResponseEntity<?> getList() throws JsonProcessingException {
        String list = student1Service.getStudentList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/ex1/student/0")
    public ResponseEntity<?> getStudentByIndex(@PathVariable int index) {

        return null;
    }
}
