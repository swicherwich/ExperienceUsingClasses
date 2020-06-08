package com.nix.homework.data;

import java.util.List;

public class Student extends AbstractData<Student> {
	private String fullName;
	private List<Course> courses;

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Course> getCourses() {
		return courses;
	}
}
