package com.example.USTAT.repository;

import com.example.USTAT.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("studentRepository")
public interface StudentRepository
        extends JpaRepository<Student,Long> {
}
