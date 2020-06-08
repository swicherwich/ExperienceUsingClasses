package com.nix.homework.repository.impl;

import com.nix.homework.data.Course;
import com.nix.homework.data.Student;
import com.nix.homework.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {

	private final List<Course> courseList = new ArrayList<>();

	@Override
	public Course findByName(String name) {
		for (Course currentCourse: courseList) {
			if(currentCourse.getCourseName().equals(name)) return currentCourse;
		}
		return null;
	}

	@Override
	public List<Course> findByStudent(Student student) {
		for(Course currentCourse: courseList) {
			currentCourse.getStudents().forEach(currentStudent -> {
				if(currentStudent.getId().equals(student.getId())) {
					return currentStudent.getCourses();
				}
			});
		}
		return null;
	}

	@Override
	public void save(Course course) {
		courseList.add(course);
	}

	@Override
	public Course findById(Long id) {
		for (Course currentCourse: courseList) {
			if(currentCourse.getId().equals(id)) return currentCourse;
		}
		return null;
	}

	@Override
	public List<Course> findAll() {
		return courseList;
	}

	@Override
	public void update(Course course) {
//		courseList.forEach(currentCourse -> {
//			if(course.getId().equals(currentCourse.getId())) {
//				currentCourse.setStudents(course.getStudents());
//				currentCourse.setCourseName(course.getCourseName());
//			}
//		});
		for(Course currentCourse: courseList) {
			if (course.getId().equals(currentCourse.getId())) {
				currentCourse.setStudents(course.getStudents());
				currentCourse.setCourseName(course.getCourseName());
			}
		}
	}

	@Override
	public void remove(Long id) {
		courseList.removeIf(course -> course.getId().equals(id));
	}
}
