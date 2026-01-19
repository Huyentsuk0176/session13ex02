package session13_ex02;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StudentManagement studentManagement=new StudentManagement();
        while(true){
            System.out.println("student management");
            System.out.println("1.Hien thi danh sach sinh vien");
            System.out.println("2.Them moi sinh vien");
            System.out.println("3.Thoat");
            System.out.println("...................");
            int choice=Validator.getInt(scanner,"moi nhap lua chon:");
            switch (choice){
                case 1:
                    studentManagement.displayListStudent();
                    break;
                case 2:
                    studentManagement.addStudent(scanner);
                    break;
                case 3:
                    System.out.println("tam biet");
                    System.exit(0);
                default:
                    System.out.println("lua chon khong hop le");
            }
        }
    }

}
