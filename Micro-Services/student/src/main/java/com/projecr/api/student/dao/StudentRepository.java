package com.projecr.api.student.dao;

import com.projecr.api.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllBySchoolId(Integer schoolId);
}
