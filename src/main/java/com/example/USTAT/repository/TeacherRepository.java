package com.example.USTAT.repository;

import com.example.USTAT.model.Teacher;
import com.example.USTAT.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface TeacherRepository
        extends JpaRepository<Teacher,Long> {

    List<Teacher> findAllBySubjects (String subject);

    @Query("select u from User u where login = :login")
    User getUserByLogin (@Param("login") String login);

    @Query("select t from Teacher t where t.subjects = :subject")
    List<Teacher> getAllBySubject(String subject);

//    @Query("select t from Teacher t where t.age = :age")
//    List<Teacher> getAllByAge(Integer age);

    @Query(value = "select t from teacher_subjetc t where :subject = ")

    List<Teacher> getAllByAge(Integer age);
}
