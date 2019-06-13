package com.example.USTAT.repository;

import com.example.USTAT.Helper.ToGetAllRequestsByTeacher;
import com.example.USTAT.Helper.ToGetAllRequestsByTeacher2;
import com.example.USTAT.model.Request;
import com.example.USTAT.model.Teacher;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RequestRepository
        extends JpaRepository<Request,Long> {
    List<Request> findAllById(Long id);

    @Query(value = "select * from ustat_request ur join request_subject rs on ur.teacher_id = :teacher_id" , nativeQuery = true)
    Set<ToGetAllRequestsByTeacher> getAllRequests(@Param("teacher_id") Long teacher_id);

}
