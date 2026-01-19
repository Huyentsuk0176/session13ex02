package session13_ex02;

import session13_ex02.Database.Database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {

    // hiển thị danh sách sinh viên
    public void displayListStudent() {
        List<Student> students = new ArrayList<>();

        try (Connection connection = Database.getConnection()) {
            CallableStatement callableStatement =
                    connection.prepareCall("{call get_all_students()}");
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setFullName(resultSet.getString("full_name"));
                student.setDateOfBirth(
                        resultSet.getDate("date_of_birth").toLocalDate()
                );
                student.setEmail(resultSet.getString("email"));
                students.add(student);
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi lấy danh sách sinh viên");
            e.printStackTrace();
        }

        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống");
        } else {
            System.out.println("Danh sách sinh viên:");
            for (Student student : students) {
                student.display();
            }
        }
    }

    // thêm mới sinh viên
    public void addStudent(Scanner scanner) {
        Student student = new Student();

        student.setFullName(
                Validator.getString(scanner, "Nhập họ tên:")
        );
        student.setEmail(
                Validator.getString(scanner, "Nhập email:")
        );

        String dobStr =
                Validator.getString(scanner, "Nhập ngày sinh (dd/MM/yyyy):");
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dob = LocalDate.parse(dobStr, formatter);
        student.setDateOfBirth(dob);

        try (Connection connection = Database.getConnection()) {
            CallableStatement callableStatement =
                    connection.prepareCall("{call add_student(?,?,?)}");

            callableStatement.setString(1, student.getFullName());
            callableStatement.setDate(2, Date.valueOf(student.getDateOfBirth()));
            callableStatement.setString(3, student.getEmail());

            boolean result = callableStatement.executeUpdate() > 0;

            if (result) {
                System.out.println("Thêm sinh viên thành công");
            } else {
                System.out.println("Thêm sinh viên thất bại");
            }

        } catch (Exception e) {
            System.out.println("Lỗi khi thêm sinh viên: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
