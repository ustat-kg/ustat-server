package com.example.USTAT.repository;

import com.example.USTAT.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("subjectRepository")
public interface SubjectRepository
        extends JpaRepository<Subject,Long> {
}
