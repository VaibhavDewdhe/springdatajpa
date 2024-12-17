package com.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.exception.InvalidArgument;
import com.dev.exception.NotFoundException;
import com.dev.model.Student;
import com.dev.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class MyController {
	@Autowired
	private StudentService sService;

	@PostMapping("/students")
	public ResponseEntity<Student> registerStudent(@Valid @RequestBody Student student) {
		Student s = sService.registerStudent(student);
		return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
	}

	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer roll) throws NotFoundException {
		Student s = sService.getStudentByRoll(roll);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() throws NotFoundException {
		return new ResponseEntity<>(sService.getAllStudents(), HttpStatus.OK);
	}

	@DeleteMapping("/students/{roll}")
	public ResponseEntity<Student> deleteStudentById(@PathVariable Integer roll) throws NotFoundException {
		Student s = sService.deleteStudentByRoll(roll);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student) throws NotFoundException {
		Student s = sService.updateStudent(student);
		return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
	}

	@PutMapping("/students/{roll}")
	public ResponseEntity<Student> updateStudentMarks(@PathVariable Integer roll, @RequestParam Integer gMarks)
			throws NotFoundException, InvalidArgument {
		Student s = sService.updateStudentMarks(roll, gMarks);
		return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getstudentsbyname/{name}")
	public ResponseEntity<List<Student>> getAllStudentsByName(@PathVariable String name) throws NotFoundException {
		return new ResponseEntity<>(sService.getAllStudentsByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/getname/{roll}")
	public ResponseEntity<String> getNameByRollHandler(@PathVariable Integer roll) {
		return new ResponseEntity<>(sService.getStudentNameByRoll(roll), HttpStatus.OK);
	}
}
