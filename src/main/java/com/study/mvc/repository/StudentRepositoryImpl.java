package com.study.mvc.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
    private List<String> studentList = List.of("철수", "민수", "영희");

    @Override
    public List<String> getStudentListAll() {
        return studentList; // ->DTO , ->Map(key, value) 2가지 방법
    }

    @Override
    public String findStudentByIndex(int index) { // 객체 였으면 foreach문으로 하나씩 꺼내기
        return studentList.get(index);
    }
}
