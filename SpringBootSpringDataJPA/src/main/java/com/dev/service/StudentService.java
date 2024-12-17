package com.dev.service;


import java.util.List;

import com.dev.exception.InvalidArgument;
import com.dev.exception.NotFoundException;
import com.dev.model.Student;

public interface StudentService {
	public Student registerStudent(Student student);
	public Student getStudentByRoll(Integer roll) throws NotFoundException;
	public List<Student> getAllStudents() throws NotFoundException;
	public Student deleteStudentByRoll(Integer roll) throws NotFoundException;
	public Student updateStudent(Student student) throws NotFoundException;
	public Student updateStudentMarks(Integer roll, Integer graceMarks) throws NotFoundException, InvalidArgument;
	public List<Student> getAllStudentsByName(String name) throws NotFoundException;
	public String getStudentNameByRoll(Integer roll);
}
