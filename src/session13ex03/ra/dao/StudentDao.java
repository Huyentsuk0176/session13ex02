package session13ex03.ra.dao;

import session13ex03.ra.entity.Student;
import session13ex03.ra.util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {


    // 1) GET ALL
    // CALL get_all_students();

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "{CALL get_all_students()}";
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                students.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.out.println("Loi getAllStudents: " + e.getMessage());
        }

        return students;
    }


    // 2) ADD
    // CALL add_student(in_full_name, in_date_of_birth, in_email);

    public boolean addStudent(String fullName, LocalDate dateOfBirth, String email) {
        String sql = "{CALL add_student(?,?,?)}";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, fullName);
            cs.setDate(2, Date.valueOf(dateOfBirth));
            cs.setString(3, email);

            cs.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Loi addStudent: " + e.getMessage());
            return false;
        }
    }


    // 3) UPDATE
    // CALL update_student(in_id, in_full_name, in_date_of_birth, in_email);

    public boolean updateStudent(int id, String fullName, LocalDate dateOfBirth, String email) {
        String sql = "{CALL update_student(?,?,?,?)}";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id);
            cs.setString(2, fullName);
            cs.setDate(3, Date.valueOf(dateOfBirth));
            cs.setString(4, email);

            cs.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Loi updateStudent: " + e.getMessage());
            return false;
        }
    }

    // 4) DELETE
    // CALL delete_student(in_id);

    public boolean deleteStudent(int id) {
        String sql = "{CALL delete_student(?)}";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id);
            cs.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Loi deleteStudent: " + e.getMessage());
            return false;
        }
    }


    // 5) FIND BY ID
    // CALL find_student_by_id(in_id);

    public Student findStudentById(int id) {
        String sql = "{CALL find_student_by_id(?)}";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id);

            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }

        } catch (SQLException e) {
            System.out.println("Loi findStudentById: " + e.getMessage());
        }

        return null;
    }


    // 6) SEARCH BY NAME
    // CALL search_student_by_name(in_name);
    // =========================
    public List<Student> searchStudentByName(String name) {
        List<Student> students = new ArrayList<>();
        String sql = "{CALL search_student_by_name(?)}";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, name);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    students.add(mapRow(rs));
                }
            }

        } catch (SQLException e) {
            System.out.println("Loi searchStudentByName: " + e.getMessage());
        }

        return students;
    }

    // =========================
    // Helper: map ResultSet -> Student
    // =========================
    private Student mapRow(ResultSet rs) throws SQLException {
        Student s = new Student();

        // cột theo DB: id, full_name, date_of_birth, email
        s.setId(rs.getInt("id"));
        s.setFullName(rs.getString("full_name"));

        Date dob = rs.getDate("date_of_birth");
        if (dob != null) {
            s.setDateOfBirth(dob.toLocalDate());
        } else {
            s.setDateOfBirth(null);
        }

        s.setEmail(rs.getString("email"));

        return s;
    }
}

