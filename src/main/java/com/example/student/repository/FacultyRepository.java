package com.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}