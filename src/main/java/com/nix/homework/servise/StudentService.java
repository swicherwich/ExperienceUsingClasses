package com.nix.homework.servise;

import com.nix.homework.data.Student;

public interface StudentService extends AbstractService<Student> {
	Student findStudentByName(String name);
	void saveOrUpdate(Student student);
}
