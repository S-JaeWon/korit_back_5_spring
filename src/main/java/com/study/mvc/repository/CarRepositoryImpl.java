package com.study.mvc.repository;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component("a")
@Repository("a")
public class CarRepositoryImpl implements CarRepository { /*CarRepositoryInterface에 구현한 클래스 */

    @Override
    public List<String> getCarsName() {

        return List.of("아반떼", "소나타");
    }

    @Override
    public int insertCar(String carName) {
        System.out.println("등록된 차량: " + carName);
        return 1;
    }
}
