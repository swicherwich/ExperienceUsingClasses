package com.nix.homework;

import com.nix.homework.builder.DataBuilder;
import com.nix.homework.config.ApplicationEnvironment;
import com.nix.homework.servise.CourseService;
import com.nix.homework.servise.StudentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataBuildTest {

	@BeforeAll
	public static void setEnv() {
		ApplicationEnvironment.setPropertyLang("en");
	}

	@Test
	public void build() {
		DataBuilder dataBuilder = new DataBuilder();
		StudentService studentService = dataBuilder.getStudentService();
		CourseService courseService  = dataBuilder.getCourseService();
		dataBuilder.buildDataList();

		assertEquals(9, studentService.findAll().size());
		assertEquals(3, courseService.findAll().size());

		assertEquals("Math", courseService.findByCourseName("Math").getCourseName());
		assertEquals("John Brown", studentService.findStudentByName("John Brown").getFullName());

		courseService.findAll().forEach(currentCourse -> {
			assertEquals(3, currentCourse.getStudents().size());
		});
	}
}
