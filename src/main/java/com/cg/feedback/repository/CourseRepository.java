package com.cg.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.feedback.enitity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long>{
	
	CourseEntity findByCourseId(long courseId);
	CourseEntity findByCourseName(String courseName);
	
}
