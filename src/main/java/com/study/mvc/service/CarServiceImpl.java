package com.study.mvc.service;

import com.study.mvc.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class CarServiceImpl implements CarService {
    private final String componentName = "a"; // final 붙여줘야 함!

    @Autowired
    //@Qualifier("a")
    @Qualifier(componentName) // 상수 변수에 담아서 사용 가능
    private CarRepository carRepository;



    @Override
    public String getCarNames() {

        return String.join(",", carRepository.getCarsName());
    }

    @Override
    public int addCar(String carName) {

        return 0;
    }
}
