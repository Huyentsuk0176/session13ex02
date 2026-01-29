package session13ex03.ra.presentation;

import session13ex03.ra.dao.StudentDao;
import session13ex03.ra.entity.Student;
import session13ex03.ra.util.InputUtil;

import java.time.LocalDate;
import java.util.List;

public class Main {

    private static final StudentDao studentDao = new StudentDao();

    public static void main(String[] args) {

        while (true) {
            System.out.println("========== STUDENT MANAGEMENT ==========");
            System.out.println("1. Hien thi danh sach sinh vien");
            System.out.println("2. Them moi sinh vien");
            System.out.println("3. Sua sinh vien");
            System.out.println("4. Xoa sinh vien");
            System.out.println("5. Thoat");
            System.out.println("========================================");

            int choice = InputUtil.inputInt("Chon chuc nang: ");

            switch (choice) {
                case 1:
                    showAllStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh!");
                    return;
                default:
                    System.out.println("❌ Lua chon khong hop le, nhap lai!");
            }
        }
    }

    // ====== 1. HIEN THI ======
    private static void showAllStudents() {
        List<Student> students = studentDao.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("Danh sach sinh vien rong!");
        } else {
            students.forEach(System.out::println);
        }
    }

    // ====== 2. THEM ======
    private static void addStudent() {
        String name = InputUtil.inputString("Nhap ho ten: ");
        LocalDate dob = InputUtil.inputDate("Nhap ngay sinh (yyyy-MM-dd): ");
        String email = InputUtil.inputEmail("Nhap email: ");

        boolean result = studentDao.addStudent(name, dob, email);
        if (result) {
            System.out.println("✅ Them sinh vien thanh cong!");
        } else {
            System.out.println("❌ Them sinh vien that bai!");
        }
    }

    // ====== 3. SUA ======
    private static void updateStudent() {
        int id = InputUtil.inputInt("Nhap ID sinh vien can sua: ");
        String name = InputUtil.inputString("Nhap ho ten moi: ");
        LocalDate dob = InputUtil.inputDate("Nhap ngay sinh moi (yyyy-MM-dd): ");
        String email = InputUtil.inputEmail("Nhap email moi: ");

        boolean result = studentDao.updateStudent(id, name, dob, email);
        if (result) {
            System.out.println("✅ Cap nhat sinh vien thanh cong!");
        } else {
            System.out.println("❌ Cap nhat that bai!");
        }
    }

    // ====== 4. XOA ======
    private static void deleteStudent() {
        int id = InputUtil.inputInt("Nhap ID sinh vien can xoa: ");

        boolean result = studentDao.deleteStudent(id);
        if (result) {
            System.out.println("✅ Xoa sinh vien thanh cong!");
        } else {
            System.out.println("❌ Xoa that bai!");
        }
    }
}
