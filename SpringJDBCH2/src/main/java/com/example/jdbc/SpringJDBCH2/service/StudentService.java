package com.example.jdbc.SpringJDBCH2.service;

import com.example.jdbc.SpringJDBCH2.model.Student;
import com.example.jdbc.SpringJDBCH2.repo.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public Studentrepo repo;

    public Studentrepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(Studentrepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student s) {
        repo.save(s);
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }
}
