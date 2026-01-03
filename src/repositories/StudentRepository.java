package repositories;

import database.Database;
import models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentRepository {

    public void add(Student s) {
        String sql = "INSERT INTO students(name, department) VALUES(?,?)";
        try (Connection conn = Database.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getDepartment());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("[StudentRepo] Hata: " + e.getMessage());
        }
    }
}
