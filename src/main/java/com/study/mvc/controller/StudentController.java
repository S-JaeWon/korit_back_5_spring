package com.study.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.mvc.dto.StudentReqDto;
import com.study.mvc.entity.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/student") //@RequestBody, json 변환, json 형식이 아닐시 빼줘야함
    public ResponseEntity<?> addStudent(@CookieValue(required = false) String students, @RequestBody Student student) throws JsonProcessingException, UnsupportedEncodingException {
                                                /*쿠키가 없어도된다는 코드*/
        ObjectMapper objectMapper = new ObjectMapper(); // 오브젝트생성
        List<Student> studentList = new ArrayList<>(); // 빈배열 생성
        int lastId = 0; // ID 0값

        System.out.println(students);

        if(students != null) { // null 이 아니고 빈값이 아니라면 반복을 통해1),
            if(!students.isBlank()) {
                for(Object object : objectMapper.readValue(students, List.class)) { // json을 list로 변환2), list 안에는 student 객체가 아닌 오브젝트로 저장
                    Map<String, Object> studentMap = (Map<String, Object>) object; // 오브젝트를 Map으로 다운캐스팅
                    studentList.add(objectMapper.convertValue(studentMap, Student.class)); // 위에서 만든 빈배열에 Map으로 다운캐스팅한것을 student 객체로 저장
                }
                lastId = studentList.get(studentList.size() - 1).getStudentId(); // List의 마지막 인덱스 불러오기
            }
        }

        student.setStudentId(lastId + 1);
        studentList.add(student);

        ObjectMapper newStudentList = new ObjectMapper();
        String studentListJson = objectMapper.writeValueAsString(studentList);

        System.out.println(studentListJson);
        ResponseCookie responseCookie = ResponseCookie
                .from("students", URLEncoder.encode(studentListJson, "UTF-8")) // 쿠키에 "" 문자가 인식x, 인코딩
                .httpOnly(true)
                .secure(true) // 암호화
                .path("/") // 경로, / -> 모든 경로 허용, /~~~ -> ~~~ 이하 경로일때만 쿠키 사용가능
                .maxAge(60)
                .build();

        // (")문자 저장x

        return ResponseEntity
                .created(null)
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString()) // 문자열로 쿠키 넣기
                .body(student);
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
