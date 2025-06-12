package com.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

	Optional<Student> findByName(String name);
}
