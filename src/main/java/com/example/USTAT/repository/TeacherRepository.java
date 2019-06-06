package com.example.USTAT.repository;

import com.example.USTAT.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("teacherRepository")
public interface TeacherRepository
        extends JpaRepository<Teacher,Long> {
//
//    @Query("select p from Payment p join fetch p.client c " +
//            "where c.phoneNo = coalesce(:phoneNo, c.phoneNo) " +
//            "and c.fio = coalesce(:fio, c.fio) " +
//            "and p.status = coalesce(:status, p.status) " +
//            "")
}
