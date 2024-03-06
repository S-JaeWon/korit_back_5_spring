package com.study.mvc.repository;


import java.util.Map;

public interface Student1Repository {
    public Map<String, String> getStudentListAll();
    public int findStudentNameByIndex(int index);

}
