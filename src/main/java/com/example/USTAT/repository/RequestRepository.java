package com.example.USTAT.repository;

import com.example.USTAT.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository
        extends JpaRepository<Request,Long> {
    List<Request> findAllById(Long id);

  //  @Query(value = "select  from TABLE ", nativeQuery = true)
}
