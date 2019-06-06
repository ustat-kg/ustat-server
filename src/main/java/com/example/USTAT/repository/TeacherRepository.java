package com.example.USTAT.repository;

import com.example.USTAT.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("teacherRepository")
public interface TeacherRepository
        extends JpaRepository<Teacher,Long> {
}
