package ORDER;

import PRODUCTS.SanPham;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Online extends Order {
    private String diachigiaohang;

    public Online(String diachigiaohang, String orderCode, String customerCode, String employeeCode, LocalDate orderDate, List<SanPham> sanPhamList, int quantity, double totalValue, boolean paymentConfirmed, boolean orderConfirmed, String status) {
        super(orderCode, customerCode, employeeCode, orderDate, sanPhamList, quantity, totalValue, paymentConfirmed, orderConfirmed, status);
        this.diachigiaohang = diachigiaohang;
    }

    public Online() {
        super();
        this.diachigiaohang = "";
    }

    public String getDiachigiaohang() {
        return diachigiaohang;
    }

    public void setDiachigiaohang(String diachigiaohang) {
        this.diachigiaohang = diachigiaohang;
    }

    public void xacnhandonhangonline() {
        if (getStatus().equals("Chưa xác nhận")) {
            // Thực hiện xác nhận đơn hàng
            setStatus("Đã xác nhận");
            System.out.println("Đơn hàng đã được xác nhận.");

            // Ghi thông tin đơn hàng đã xác nhận vào tệp tin
            try {
                FileWriter writer = new FileWriter("online.txt", true);
                writer.write("Đơn hàng đã được xác nhận:\n");
                writer.write("Mã đơn hàng: " + getOrderCode() + "\n");
                // Ghi thông tin khác về đơn hàng tại đây
                writer.write("\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Lỗi khi ghi tệp tin.");
            }
        } else if (getStatus().equals("Đã xác nhận")) {
            System.out.println("Đơn hàng đã được xác nhận trước đó.");
        }
    }

    public void huyDonHangOnline() {
        // Kiểm tra trạng thái đơn hàng trước khi hủy
        if (getStatus().equals("Chưa xác nhận")) {
            // Thực hiện hủy đơn hàng
            setStatus("Đã hủy");
            System.out.println("Đơn hàng đã được hủy.");

            // Ghi thông tin đơn hàng đã hủy vào tệp tin
            try {
                FileWriter writer = new FileWriter("online.txt", true);
                writer.write("Đơn hàng đã được hủy:\n");
                writer.write("Mã đơn hàng: " + getOrderCode() + "\n");
                // Ghi thông tin khác về đơn hàng tại đây
                writer.write("\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Lỗi khi ghi tệp tin.");
            }
        } else if (getStatus().equals("Đã xác nhận")) {
            System.out.println("Không thể hủy đơn hàng đã được xác nhận.");
        } else {
            System.out.println("Đơn hàng đã được hủy trước đó.");
        }
    }
}