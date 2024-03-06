package com.study.mvc.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class Student1RepositoryImpl implements Student1Repository {
    public List<String> studentList = List.of("철수", "영희", "민수");

    @Override
    public Map<String, String> getStudentListAll() {
        Map<String, String> studentMap = new HashMap<>();
        for(int i = 0; i < studentList.size(); i++) {
            studentMap.put("name" + (i +1), studentList.get(i));
        }
        return studentMap;
    }

    @Override
    public int findStudentNameByIndex(int index) {
        System.out.println("이름: " + index);
        return 1;
    }

}
