package com.study.mvc.service;


import com.fasterxml.jackson.core.JsonProcessingException;

public interface Student1Service {
    public String getStudentList() throws JsonProcessingException;
    public int getStudent(int index);
}
