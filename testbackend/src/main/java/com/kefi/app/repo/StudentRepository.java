package com.kefi.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kefi.app.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
}