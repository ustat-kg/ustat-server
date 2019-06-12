package com.example.USTAT.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ustat_request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "request_subject",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subject;


    @Column(name = "massage")
    private String massage;

    public Request(Teacher teacher, Student student, List<Subject> subject, String massage) {
        this.teacher = teacher;
        this.student = student;
        this.subject = subject;
        this.massage = massage;
    }

    public Request() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
