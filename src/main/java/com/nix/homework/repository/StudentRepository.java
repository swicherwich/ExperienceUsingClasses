package com.nix.homework.repository;

import com.nix.homework.data.Course;
import com.nix.homework.data.Student;

import java.util.List;

public interface StudentRepository extends AbstractRepository<Student>{
	Student findByName(String name);
	List<Student> findByCourse(Course course);
}
