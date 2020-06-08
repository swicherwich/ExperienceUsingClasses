package com.nix.homework.repository.impl;

import com.nix.homework.data.Course;
import com.nix.homework.data.Student;
import com.nix.homework.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

	private final List<Student> studentList = new ArrayList<>();


	@Override
	public Student findByName(String name) {
		for(Student currentStudent: studentList) {
			if(currentStudent.getFullName().equalsIgnoreCase(name)) return currentStudent;
		}
		return null;
	}

	@Override
	public List<Student> findByCourse(Course course) {
		for(Student currentStudent: studentList) {
//			currentStudent.getCourses().forEach(currentCourse -> {
//				if(currentCourse.getId().equals(course.getId())) {
//					return currentCourse.getStudents();
//				}
//			});
			for(Course currentCourse: currentStudent.getCourses()) {
				if(currentCourse.getId().equals(course.getId())) {
					return currentCourse.getStudents();
				}
			}
		}
		return null;
	}

	@Override
	public void save(Student student) {
		studentList.add(student);
	}

	@Override
	public Student findById(Long id) {
		for(Student currentStudent: studentList) {
			if(currentStudent.getId().equals(id)) return currentStudent;
		}
		return null;
	}

	@Override
	public List<Student> findAll() {
		return studentList;
	}

	@Override
	public void update(Student student) {
		studentList.forEach(currentStudent -> {
			if(currentStudent.getId().equals(student.getId())) {
				currentStudent.setCourses(student.getCourses());
			}
		});
	}

	@Override
	public void remove(Long id) {
		studentList.removeIf(student -> student.getId().equals(id));
	}
}
