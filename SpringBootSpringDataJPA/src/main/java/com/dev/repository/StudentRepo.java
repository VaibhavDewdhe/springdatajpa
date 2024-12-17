package com.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.model.Student;

//the Spring Data JPA will provide the implementation for this interface
//and register that implementation class object with Spring container as a spring bean
public interface StudentRepo extends JpaRepository<Student, Integer>{
	public List<Student> findByName(String name);
	@Query("select name from Student where roll=:r")
	public String getNameByRoll(@Param("r") Integer roll);
}
