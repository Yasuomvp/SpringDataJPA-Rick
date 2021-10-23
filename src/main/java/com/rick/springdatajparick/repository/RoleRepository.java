package com.rick.springdatajparick.repository;

import com.rick.springdatajparick.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepository extends JpaRepository<Role,Integer>, JpaSpecificationExecutor<Role> {

}
