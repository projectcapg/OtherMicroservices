package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.beans.EmployeeCode;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeCode, Integer>
{

}
