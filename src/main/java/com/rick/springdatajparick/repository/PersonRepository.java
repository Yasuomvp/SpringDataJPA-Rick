package com.rick.springdatajparick.repository;

import com.rick.springdatajparick.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonRepository extends JpaRepository<Person,Integer>, JpaSpecificationExecutor<Person> {

}
