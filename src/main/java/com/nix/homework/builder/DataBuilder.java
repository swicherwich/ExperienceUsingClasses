package com.nix.homework.builder;

import com.nix.homework.config.ApplicationEnvironment;
import com.nix.homework.data.Course;
import com.nix.homework.data.Student;
import com.nix.homework.servise.CourseService;
import com.nix.homework.servise.StudentService;
import com.nix.homework.servise.impl.CourseServiceImpl;
import com.nix.homework.servise.impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DataBuilder implements AbstractBuilder {

	private final StudentService studentService = new StudentServiceImpl();
	private final CourseService courseService = new CourseServiceImpl();

	@Override
	public void buildDataList() {
		for(Map.Entry<String, String> entry: getKeyValueMapByBundleProperties(ApplicationEnvironment.getPropertyLang()).entrySet()) {
			Course course = new Course();
			String courseNameProperties = String.join("", entry.getKey().split("_"));
			course.setCourseName(courseNameProperties);

			List<Student> studentList = new ArrayList<>();
			if(entry.getValue().contains(";")) {
				List<String> studentFullNameProperties = Arrays.asList(entry.getValue().split(";"));
				studentFullNameProperties.forEach(currentStudentName -> {
					Student s = new Student();
					s.setFullName(currentStudentName);
					studentService.saveOrUpdate(s);
					studentList.add(studentService.findStudentByName(currentStudentName));
				});
			} else {
				Student s = new Student();
				String studentName = entry.getValue();
				s.setFullName(studentName);
				studentService.saveOrUpdate(s);
				studentList.add(studentService.findStudentByName(studentName));
			}
			course.setStudents(studentList);
			courseService.saveOrUpdate(course);
		}

		courseService.findAll().forEach(currentCourse -> {
			StringBuilder students = new StringBuilder();
			currentCourse.getStudents().forEach(student -> {
				students.append(student.getFullName());
				students.append(" ");
			});
			students.toString();
			System.out.println(currentCourse.getCourseName() + " course: " + students);
			System.out.println(currentCourse.getCourseName() + " course id: " + currentCourse.getId());
			System.out.println();
		});
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public StudentService getStudentService() {
		return studentService;
	}
}
