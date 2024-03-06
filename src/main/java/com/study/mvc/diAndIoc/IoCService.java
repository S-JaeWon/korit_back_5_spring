package com.study.mvc.diAndIoc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component // IoCContainer에 등록
@RequiredArgsConstructor
public class IoCService {

    //@Autowired // @Component를 붙여서 IoCContainer에 등록된 것들을 알아서 추출
    private final IoCRepository ioCRepository; // 변수에 fianl이 붙고 (상수), @RequiredArgsConstructor 가 있다면 @Autowired 없이 사용 가능

    public String getJson() throws JsonProcessingException { // map을 json으로 변환
        Map<String, String> nameMap = ioCRepository.convertNameMap();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValueAsString(nameMap);
        return objectMapper.writeValueAsString(nameMap);
    }

}
