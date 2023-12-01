
package project_lthdt;
import java.util.Scanner;

public class Kiemtra {
    public static boolean kiemTraHoTen(String hoTen) {
        return !hoTen.isEmpty();
    }

    public static boolean kiemTraNgaySinh(String ngaySinh) {
        return ngaySinh.matches("\\d{1,2}/\\d{1,2}/\\d{4}");
    }

    public static boolean kiemTraSoDienThoai(String soDienThoai) {
        return soDienThoai.matches("\\d{9}");
    }

    public static boolean kiemTraEmail(String email) {
        return email.matches("\\S+@\\S+\\.\\S+");
    }

    public static boolean kiemTraGioiTinh(String gioiTinh) {
        return !gioiTinh.isEmpty();
    }

    // Bạn có thể thêm các phương thức kiểm tra khác nếu cần

    public static boolean kiemTraNhapPerson(person person) {
        Scanner scanner = new Scanner(System.in);

        while (!kiemTraHoTen(person.getFullname())) {
            System.out.println("Họ tên không được để trống. Nhập lại:");
            person.setFullname(scanner.nextLine());
        }

        while (!kiemTraNgaySinh(person.getBirthday())) {
            System.out.println("Định dạng ngày sinh không hợp lệ. Nhập lại (d/m/y):");
            person.setBirthday(scanner.nextLine());
        }

        while (!kiemTraSoDienThoai(person.getPhonenumber())) {
            System.out.println("Số điện thoại không hợp lệ. Nhập lại:");
            person.setPhonenumber(scanner.nextLine());
        }

        while (!kiemTraEmail(person.getEmail())) {
            System.out.println("Email không hợp lệ. Nhập lại:");
            person.setEmail(scanner.nextLine());
        }

        while (!kiemTraGioiTinh(person.getGender())) {
            System.out.println("Giới tính không được để trống. Nhập lại:");
            person.setGender(scanner.nextLine());
        }

        // Kiểm tra nhập địa chỉ
        if (!AddressValidator.kiemTraNhapAddress(person.getAddress())) {
            return false; // Trả về false nếu địa chỉ không hợp lệ
        }

        return true;
    }
}

