package io.Bedi.postgrescrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.Bedi.postgrescrud.model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
