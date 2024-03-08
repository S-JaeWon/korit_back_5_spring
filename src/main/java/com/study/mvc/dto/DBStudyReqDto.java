package com.study.mvc.dto;

import com.study.mvc.entity.Study;
import lombok.Data;

@Data
public class DBStudyReqDto {
    private String name;
    private int age;

    //put, update
    public Study toEntity(int id) {
        return Study.builder()
                .id(id) // id 값이 없으므로 외부에서 받아옴
                .name(name)
                .age(age)
                .build();
    }
}
