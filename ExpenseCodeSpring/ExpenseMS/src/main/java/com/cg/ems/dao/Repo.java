package com.cg.ems.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ems.dto.Expense;
@Repository
@Transactional
public interface Repo extends CrudRepository<Expense, Integer>{

}
