package session13_ex02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validator {

    // nhập chuỗi không rỗng
    public static String getString(Scanner scanner, String message) {
        while (true) {
            System.out.print(message + " ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Không được để trống!");
        }
    }

    // nhập số nguyên
    public static int getInt(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message + " ");
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        }
    }

    // nhập ngày theo định dạng dd/MM/yyyy
    public static LocalDate getLocalDate(Scanner scanner, String message) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            try {
                System.out.print(message + " ");
                return LocalDate.parse(scanner.nextLine().trim(), formatter);
            } catch (Exception e) {
                System.out.println("Sai định dạng ngày (dd/MM/yyyy)");
            }
        }
    }
}
