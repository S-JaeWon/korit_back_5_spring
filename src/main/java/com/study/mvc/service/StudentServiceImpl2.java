package com.study.mvc.service;


import com.study.mvc.dto.StudentExDto;
import com.study.mvc.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl2 implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<?> getStudentList() { // Map이 아닌 DTO로 변환하기
        List<StudentExDto> studentDtoList = new ArrayList<>();
        List<String> studentList = studentRepository.getStudentListAll();

        for(String studentName: studentList) {
            studentDtoList.add(new StudentExDto(studentName));

        }
        return studentDtoList;
    }

    @Override
    public Object getStudent(int index) {
        String studentName = studentRepository.findStudentByIndex(index);
        return new StudentExDto(studentName);
    }
}

