package com.example.app.student;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	
	private static final List<Student> STUDENTS=Arrays.asList(
			new Student(1, "ROHITH", Gender.MALE),
			new Student(2, "ABC", Gender.MALE),
			new Student(3, "XYZ", Gender.FEMALE),
			new Student(4, "ABCDXYZ", Gender.MALE)
			);

	@GetMapping("")
	public List<Student> getStudents() {
		return STUDENTS.stream().collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable int id) {
		return STUDENTS.stream()
				.filter(Student->Student.getId() ==id)
				.findFirst()
				.orElseThrow(()->new IllegalStateException("Student with id "+id+" not found"));
	}
	
}