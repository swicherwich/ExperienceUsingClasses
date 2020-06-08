package com.nix.homework.servise;

import com.nix.homework.data.Course;

public interface CourseService extends AbstractService<Course> {
	Course findByCourseName(String name);
}
