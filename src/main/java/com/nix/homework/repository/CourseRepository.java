package com.nix.homework.repository;

import com.nix.homework.data.Course;
import com.nix.homework.data.Student;

import java.util.List;

public interface CourseRepository extends AbstractRepository<Course> {
	Course findByName(String name);
	List<Course> findByStudent(Student student);
}
