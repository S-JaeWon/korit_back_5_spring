package com.study.mvc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.mvc.repository.Student1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Student1ServiceImpl implements Student1Service {

    @Autowired
    private Student1Repository studentRepository;

    @Override
    public String getStudentList() throws JsonProcessingException {
        Map<String, String> studentMap = studentRepository.getStudentListAll();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValueAsString(studentMap);

        return objectMapper.writeValueAsString(studentMap);
    }


    @Override
    public int getStudent(int index) {

        return 1;
    }

}

