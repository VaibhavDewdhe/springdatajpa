package com.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.exception.InvalidArgument;
import com.dev.exception.NotFoundException;
import com.dev.model.Student;
import com.dev.repository.StudentRepo;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo sRepo;

	@Transactional
	public Student registerStudent(Student student) {
		return sRepo.save(student);
	}

	@Transactional
	public Student getStudentByRoll(Integer roll) throws NotFoundException {
		return sRepo.findById(roll).orElseThrow(() -> new NotFoundException("Student not found with roll no. " + roll));
	}

	@Override
	public List<Student> getAllStudents() throws NotFoundException {
		List<Student> students = sRepo.findAll();
		if (students.size() == 0)
			throw new NotFoundException("No student found");

		return students;
	}

	@Override
	public Student deleteStudentByRoll(Integer roll) throws NotFoundException {
		Student s = sRepo.findById(roll)
				.orElseThrow(() -> new NotFoundException("Student not found with roll no. " + roll));

		sRepo.delete(s);
		return s;
	}

	@Override
	public Student updateStudent(Student student) throws NotFoundException {
		sRepo.findById(student.getRoll())
				.orElseThrow(() -> new NotFoundException("Student not found with roll no. " + student.getRoll()));

		sRepo.save(student);
		return student;
	}

	@Override
	public Student updateStudentMarks(Integer roll, Integer graceMarks) throws NotFoundException, InvalidArgument {
		Student student = sRepo.findById(roll)
		.orElseThrow(() -> new NotFoundException("Student not found with roll no. " + roll));
		
		Integer afterGrace = student.getMarks()+graceMarks;
		if(afterGrace>800)
			throw new InvalidArgument("After grace Marks are greater than Max Marks, marks after grace: "+afterGrace);
		
		student.setMarks(afterGrace);
		sRepo.save(student);
		return student;
	}

	@Override
	public List<Student> getAllStudentsByName(String name) throws NotFoundException {
		List<Student> students = sRepo.findByName(name);
		if (students.size() == 0)
			throw new NotFoundException("No student found");

		return students;
	}

	@Override
	public String getStudentNameByRoll(Integer roll) {
		String name = sRepo.getNameByRoll(roll);
		if(name==null)
			throw new NotFoundException("Student not found with roll no. " + roll);
		
		return name;
	}
}
