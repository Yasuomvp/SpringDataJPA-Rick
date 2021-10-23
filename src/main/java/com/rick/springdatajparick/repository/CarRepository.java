package com.rick.springdatajparick.repository;

import com.rick.springdatajparick.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarRepository extends JpaRepository<Car,Integer> , JpaSpecificationExecutor<Car> {


}
