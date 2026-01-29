
package session13ex03.ra.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtil {

    private static final Scanner sc = new Scanner(System.in);

    // ====== NHẬP STRING (KHÔNG RỖNG) ======
    public static String inputString(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("❌ Không được để trống, nhập lại!");
        }
    }

    // ====== NHẬP INT ======
    public static int inputInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Phải nhập số nguyên, nhập lại!");
            }
        }
    }

    // ====== NHẬP EMAIL ======
    public static String inputEmail(String message) {
        while (true) {
            System.out.print(message);
            String email = sc.nextLine().trim();
            if (email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
                return email;
            }
            System.out.println("❌ Email không đúng định dạng, nhập lại!");
        }
    }

    // ====== NHẬP NGÀY (yyyy-MM-dd) ======
    public static LocalDate inputDate(String message) {
        while (true) {
            try {
                System.out.print(message);
                return LocalDate.parse(sc.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("❌ Ngày sai định dạng (yyyy-MM-dd), nhập lại!");
            }
        }
    }
}
