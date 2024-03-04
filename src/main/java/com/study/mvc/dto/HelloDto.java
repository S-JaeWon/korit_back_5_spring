package com.study.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@AllArgsConstructor // 모든 값이 필수로 채워져야 함 @Builder 또한 같음, 되도록 사용 x
@NoArgsConstructor // 기본값, setter로 값을 채울 수 있음 -> @Builder, @AllArgsConstructor 사용 가능 */
@Data
public class HelloDto {
    private String name;
    private int age;
}
