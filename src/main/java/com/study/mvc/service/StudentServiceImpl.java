package com.study.mvc.service;


import com.study.mvc.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<?> getStudentList() {
        List<Map<String, String>> studentMapList = new ArrayList<>(); // return 타입 정해주기
        List<String> studentList = studentRepository.getStudentListAll(); // Repository 리스트 가져오기

        for(String studentName: studentList) { // 가져온 리스트를 하나씩 꺼내서 각각 Map으로 변환
            studentMapList.add(Map.of("name", studentName));
            // studentList 안에 있는 이름을 studentName에 담아서 studentMapList(ArrayList) 에 Map형식으로 각각 담기 -> studentMapList 안에 각각 Map 하나씩
        }
        return studentMapList;
    }

    @Override
    public Object getStudent(int index) {
        String studentName = studentRepository.findStudentByIndex(index);
        return Map.of("name", studentName);
    }
}













