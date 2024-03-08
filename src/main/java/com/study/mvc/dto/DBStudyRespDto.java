package com.study.mvc.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DBStudyRespDto { // 응답 dto
    private int id;
    private String name;
    private String age;
}
