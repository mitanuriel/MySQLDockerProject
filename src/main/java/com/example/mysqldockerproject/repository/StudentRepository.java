package com.example.mysqldockerproject.repository;

import com.example.mysqldockerproject.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to insert a new student
    public int save(Student student) {
        String sql = "INSERT INTO student (name, age) VALUES (?, ?)";
        return jdbcTemplate.update(sql, student.getName(), student.getAge());
    }

    // Method to fetch all students
    public List<Student> findAll() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    // RowMapper class to map the ResultSet to the Student object
    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            return student;
        }
    }
}
