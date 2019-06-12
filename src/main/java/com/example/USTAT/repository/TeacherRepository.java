package com.example.USTAT.repository;

import com.example.USTAT.model.Teacher;
import com.example.USTAT.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface TeacherRepository
        extends JpaRepository<Teacher,Long> {

    List<Teacher> findAllBySubjects (String subject);

    @Query("select u from User u where login = :login")
    User getUserByLogin (@Param("login") String login);

    @Query(value = "select * from teacher_subject ts join ustat_teacher ut on ts.subject_id = :subject" , nativeQuery = true)
    Set<Teacher> getAllBySubject(@Param("subject")Long subject);

//    @Query("select t from Teacher t where t.age = :age")
//    List<Teacher> getAllByAge(Integer age);

//    Set<Teacher> getAllByAge(Integer age);
}
