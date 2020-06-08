package com.nix.homework.servise.impl;

import com.nix.homework.data.Course;
import com.nix.homework.repository.CourseRepository;
import com.nix.homework.repository.impl.CourseRepositoryImpl;
import com.nix.homework.servise.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

	private final CourseRepository courseRepository = new CourseRepositoryImpl();

	public Course findByCourseName(String name) {
		return courseRepository.findByName(name);
	}

	@Override
	public void saveOrUpdate(Course course) {
		if(course.getId() == null) {
			long id = courseRepository.findAll().size();
			course.setId(++id);
			courseRepository.save(course);
		} else {
			courseRepository.update(course);
		}
	}

	@Override
	public Course findById(Long id) {
		return courseRepository.findById(id);
	}

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		courseRepository.remove(id);
	}
}
