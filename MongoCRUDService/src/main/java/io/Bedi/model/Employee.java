package io.Bedi.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Emp")
public class Employee {

	@Id
	public ObjectId oid;
	private int eId;
	private String name;
	private int age;
	
	public Employee() {
	}
	
	public Employee(ObjectId oid, int eId, String name, int age) {
		this.oid = oid;
		this.eId = eId;
		this.name = name;
		this.age = age;
	}
	
	public ObjectId getOid() {
		return oid;
	}

	public void setOid(ObjectId oid) {
		this.oid = oid;
	}

	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
