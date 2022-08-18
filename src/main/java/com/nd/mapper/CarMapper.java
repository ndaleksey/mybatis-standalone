package com.nd.mapper;

import com.nd.entity.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
    List<Car> findAll();

    void addCar(@Param("car") Car car);
}
