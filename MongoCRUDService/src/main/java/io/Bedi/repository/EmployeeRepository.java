package io.Bedi.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.Bedi.model.Employee;


@Repository
public interface EmployeeRepository extends MongoRepository<Employee, ObjectId>{
	List<Employee> findAll();
	Employee findByOid(ObjectId id);
}
