package com.cg.feedback.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.feedback.enitity.CourseEntity;
import com.cg.feedback.model.CourseModel;
import com.cg.feedback.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping(value = "/getall")
	public List<CourseModel> getAllCourses() {
		List<CourseModel> courses = courseService.getAllCourses();
		return courses;
	}

	@GetMapping(value = "/{courseName}")
	public CourseModel getCourseByName(@PathVariable("courseName") String courseName) {
		CourseModel course = courseService.getCourseByName(courseName);
		return course;
	}

	@DeleteMapping(value = "/{courseId}")
	public ResponseEntity<String> delteCourseById(@PathVariable("courseId") long courseId) {
		courseService.removeCourse(courseId);
		return new ResponseEntity<>("Course Deleted Successfully", HttpStatus.OK);
	}

	@PostMapping(value = "/addCourse")
	public ResponseEntity<CourseModel> addCourse(@Valid @RequestBody CourseModel course) {
		CourseModel model = courseService.addCourse(course);
		return new ResponseEntity<>(model, HttpStatus.OK);
	}
}
