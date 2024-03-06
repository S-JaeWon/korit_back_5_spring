package com.study.mvc.repository;

import java.util.List;

public interface CarRepository {
    public List<String> getCarsName();
    public int insertCar(String carName);
}
