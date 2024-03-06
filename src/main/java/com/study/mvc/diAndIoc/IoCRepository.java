package com.study.mvc.diAndIoc;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component // IoCContainer에 등록
public class IoCRepository {
    private List<String> nameList = List.of("철수", "영희", "민수");

    public Map<String, String> convertNameMap() {
        Map<String, String> nameMap = new HashMap<>();
        for(int i = 0; i < nameList.size(); i++) {
            nameMap.put("name" + (i + 1), nameList.get(i));
        }
        return nameMap;
    }
}
