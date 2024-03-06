package com.study.mvc.diAndIoc;

import java.util.List;

public class DiService {

    private DiRepository diRepository; // = new DiRespository(); 생성 하면 결합도 높으므로 선언만 하기

    public DiService(DiRepository diRepository) { // controller에서 넘겨받은 repository 주소를 통해 값 참조
        this.diRepository = diRepository; // 받은 주소 값을 자기 자신에 대입
    } // DiRespository diRespository = new DiRespository(); 전역으로 묶어서 결합도 상대적 ↓, 하지만 생성은 해야함.

    public int getTotal() {
        //DiRepository diRepository = new DiRepository(); // 매번 호출 1), 결합도 ↑
        int total = 0;
        List<Integer> scoreList = diRepository.getScoreList();
        for (Integer score : scoreList) {
            total += score;
        }

        return  total;
    }

    public double getAverage() {
        //DiRepository diRepository = new DiRepository(); // 매번 호출 2)
        double avg = 0;
        int total = 0;
        List<Integer> scoreList = diRepository.getScoreList();
        for (Integer score : scoreList) {
            total += score;
        }
        avg = total / scoreList.size();

        return  avg;
    }
}
