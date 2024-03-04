package com.study.mvc.controller;

import com.study.mvc.dto.StudentReqDto;
import com.study.mvc.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    /*@GetMapping("/student")
    public Map<String, Object> student() {
        Map<String, Object> studentObj = new HashMap<>();
        studentObj.put("name", "심재원");
        studentObj.put("age", 29);
        studentObj.put("phone", "010-5170-4834");
        studentObj.put("address", "부산 남구");
        return studentObj;
    }*/

    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@RequestBody/*json 변환*/ Student student) {
                                        // json 형식이 아닐시 빼줘야함
        return ResponseEntity.created(null).body(student);
    }

    @GetMapping("/student")
    public ResponseEntity<?> getStudentInfo(StudentReqDto studentReqDto) {
        System.out.println(studentReqDto);
        return ResponseEntity.badRequest().body(studentReqDto.toRespDto());
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable/*주소에서 값을 가져옴*/ int studentId) {

        List<Student> studentList = List.of(
          new Student(1, "철수"),
          new Student(2, "영희"),
          new Student(3, "민지"),
          new Student(4, "민수")
        );

        Student findStudent = null;
        for(Student student : studentList) {
            if(student.getStudentId() == studentId) {
                findStudent = student;
            }
        }

        /*Optional<Student> optionalStudent =
                studentList.stream().filter(student -> student.getStudentId() == studentId).findFirst();

        if(optionalStudent.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("errorMessage", "존재하지 않는 ID입니다."));
        }
        findStudent = optionalStudent.get();*/

        if(findStudent == null) {
            return ResponseEntity.badRequest().body(Map.of("errorMessage", "존재하지 않는 ID입니다."));
        }

        return ResponseEntity.ok().body(findStudent);
    }

}
