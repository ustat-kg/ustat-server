package com.example.USTAT.repository;

import com.example.USTAT.model.Request;
import com.example.USTAT.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository
        extends JpaRepository<Request,Long> {
    List<Request> findAllById(Long id);

    @Query(value = "select * from ustat_request ur where ur.teacher_id = :teacher_id" , nativeQuery = true)
    List<Request> getAllRequests(@Param("teacher_id") Long teacher_id);
}
