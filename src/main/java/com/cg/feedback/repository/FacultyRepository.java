package com.cg.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.feedback.enitity.FacultyEntity;
 
public interface FacultyRepository extends JpaRepository<FacultyEntity, Long> {
	
	FacultyEntity findByFacultyId(long facultyId);
	FacultyEntity findByFacultyName(String facultyName);
	boolean existsByFacultyIdOrFacultyName(long facultyId,String facultyName);

}
