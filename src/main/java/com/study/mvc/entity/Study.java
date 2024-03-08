package com.study.mvc.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder // AllArgs 자동생성,
// @NoArgsConstructor
@Data
public class Study {
    private int id;
    private String name;
    private int age;
    private LocalDateTime createData;
}
