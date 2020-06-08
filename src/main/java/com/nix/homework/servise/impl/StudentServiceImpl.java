package com.nix.homework.servise.impl;


import com.nix.homework.data.Student;
import com.nix.homework.repository.StudentRepository;
import com.nix.homework.repository.impl.StudentRepositoryImpl;
import com.nix.homework.servise.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository = new StudentRepositoryImpl();

	public Student findStudentByName(String name) {
		return studentRepository.findByName(name);
	}

	@Override
	public void saveOrUpdate(Student student) {
		if(student.getId() == null) {
			long id = findAll().size();
			student.setId(++id);
			studentRepository.save(student);
		} else {
			studentRepository.update(student);
		}
	}

	@Override
	public Student findById(Long id) {
		return studentRepository.findById(id);
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		studentRepository.remove(id);
	}

}
