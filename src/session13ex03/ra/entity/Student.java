package session13ex03.ra.entity;

import java.time.LocalDate;

public class Student {
    private int id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String email;

    public Student() {
    }

    public Student(int id, String fullName, LocalDate dateOfBirth, String email) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "ID: " + id +
                " | Ho ten: " + fullName +
                " | Ngay sinh: " + dateOfBirth +
                " | Email: " + email;
    }
}

