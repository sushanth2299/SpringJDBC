package com.example.jdbc.SpringJDBCH2.repo;

import com.example.jdbc.SpringJDBCH2.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Studentrepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        String sql = "insert into student(sNo,name,marks) values (?,?,?)";
        int rows = jdbc.update(sql,s.getsNo(),s.getName(),s.getMarks());
        System.out.println(rows + "affected");

    }

    public List<Student> findAll() {

        String sql = "select * from student";

        RowMapper<Student> mapper = (ResultSet rs, int rowNum) -> {

                Student s = new Student();
                s.setsNo(rs.getInt("sNo"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));

                return s;

        };
        return jdbc.query(sql,mapper);

    }
}
