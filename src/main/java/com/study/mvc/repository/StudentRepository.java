package com.study.mvc.repository;

import java.util.List;

public interface StudentRepository {
    public List<String> getStudentListAll();
    public String findStudentByIndex(int index); // int자료형인 index를 받아 String 이름 찾기
}
