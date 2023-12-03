package ORDER;

import PRODUCTS.SanPham;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ORDER.order;
import java.util.Scanner;

public class online extends order {
    private String diachigiaohang;
    order order = new order();
    Scanner sc = new Scanner(System.in);

public online(String diachigiaohang, String orderCode, String customerCode, String employeeCode, String orderDate, List<SanPham> SanPhamList, int quantity, double totalValue, boolean paymentConfirmed, boolean orderConfirmed, String status) {
    super(orderCode, customerCode, employeeCode, orderDate, SanPhamList, quantity, totalValue, paymentConfirmed, orderConfirmed,status);
    this.diachigiaohang = diachigiaohang;
}
public online(){
    super();
    this.diachigiaohang =" ";

}
public String getdiachigiaohang() {
        return diachigiaohang;
    }
public void setdiachigiaohang(String diachigiaohang) {
        this.diachigiaohang = diachigiaohang;
    }
    public void xacnhandonhangonline(order order) {
        if (order.getStatus().equals("Chưa xác nhận")) {
            // Thực hiện xác nhận đơn hàng
            order.setStatus("Đã xác nhận");
            System.out.println("Đơn hàng đã được xác nhận.");

            // Ghi thông tin đơn hàng đã xác nhận vào tệp tin
            try {
                FileWriter writer = new FileWriter("online.txt", true);
                writer.write("Đơn hàng đã được xác nhận:\n");
                writer.write("Mã đơn hàng: " + order.getOrderCode() + "\n");
                // Ghi thông tin khác về đơn hàng tại đây
                writer.write("\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Lỗi khi ghi tệp tin.");
            }
        } else if (order.getStatus().equals("Đã xác nhận")) {
            System.out.println("Đơn hàng đã được xác nhận trước đó.");
        }
    }

    public void huyDonHangOnline(order order) {
        // Kiểm tra trạng thái đơn hàng trước khi hủy
        if (order.getStatus().equals("Chưa xác nhận")) {
            // Thực hiện hủy đơn hàng
            order.setStatus("Đã hủy");
            System.out.println("Đơn hàng đã được hủy.");

            // Ghi thông tin đơn hàng đã hủy vào tệp tin
            try {
                FileWriter writer = new FileWriter("online.txt", true);
                writer.write("Đơn hàng đã được hủy:\n");
                writer.write("Mã đơn hàng: " + order.getOrderCode() + "\n");
                // Ghi thông tin khác về đơn hàng tại đây
                writer.write("\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Lỗi khi ghi tệp tin.");
            }
        } else if (order.getStatus().equals("Đã xác nhận")) {
            System.out.println("Không thể hủy đơn hàng đã được xác nhận.");
        } else {
            System.out.println("Đơn hàng đã được hủy trước đó.");
        }
    }

}

