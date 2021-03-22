package io.Bedi.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.Bedi.model.Employee;
import io.Bedi.repository.EmployeeRepository;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;

	// GetAllProducts
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Employee> getAllProducts() {
		return repository.findAll();
	}

	// GetByid
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getProductId(@PathVariable("id") ObjectId id) {
		return repository.findByOid(id);

	}

	// Put
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyProductById(@PathVariable("id") ObjectId id, @Validated @RequestBody Employee employee) {
		employee.setOid(ObjectId.get());
		repository.save(employee);
	}

	// post
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Employee createProduct(@Validated @RequestBody Employee employee) {
		employee.setOid(ObjectId.get());
		repository.save(employee);
		return employee;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable ObjectId id) {
		repository.delete(repository.findByOid(id));
	}
}
