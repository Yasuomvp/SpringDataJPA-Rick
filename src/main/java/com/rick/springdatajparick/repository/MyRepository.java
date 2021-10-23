package com.rick.springdatajparick.repository;

import com.rick.springdatajparick.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MyRepository extends JpaRepository<Pet,Integer> , JpaSpecificationExecutor<Pet> {


    @Query(value = "from Pet where color = ?1")
    Pet find_by_color(String color);

    Pet findByColor(String color);

    Pet findByName(String name);

}
