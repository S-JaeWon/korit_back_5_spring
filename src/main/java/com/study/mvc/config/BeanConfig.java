package com.study.mvc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// Bean 수동 등록 (2개 이상 등록 가능)

@Configuration
public class BeanConfig { // 설정을 다룸

    @Bean // @Component는 클래스위에만 사용 가능하므로 메서드에 쓸려면 @Bean 사용 -> 대신 @Configuration 필요
    public ObjectMapper objectMapper() { // ObjectMapper 는 라이브러리이기 때문에(우리가 직접 만든게 아님X -> 수정 불가) @Component가 안붙어서 @Autowired 안됨
        return new ObjectMapper();
    }

}
