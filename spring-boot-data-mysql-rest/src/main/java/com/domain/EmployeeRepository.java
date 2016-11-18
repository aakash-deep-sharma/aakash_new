package com.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	Employee findByStudentName(String name);
	List<Employee> findByAddress_state(String state);
}
