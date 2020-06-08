package com.nix.homework.data;

import java.util.List;

public class Course extends AbstractData<Course>{
	private String courseName;
	private List<Student> students;

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}
}
