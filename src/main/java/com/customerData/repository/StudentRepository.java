package com.customerData.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.customerData.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	@Query("from Student")
	List<Student> findAllStudents();
	
	@Query("select firstName, lastName, score from Student")
	List<Object[]>findStudentsPartialData();
	
	@Query("from Student where firstName=:fname")
	List<Student> findStudentByFirstName(@Param("fname") String firstName);
	
	@Query("from Student where score between :lnum and :unum")
	List<Student> findStudentByScoreBetween(@Param("lnum")int lnum,@Param("unum")int unum);
	
	@Modifying
	@Query("delete from Student where firstName=:fname")
	void deleteByFirstName(@Param("fname") String firstName);
}
