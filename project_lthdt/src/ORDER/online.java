package ORDER;

import PRODUCTS.SanPham;
import java.util.ArrayList;
import java.util.List;
import ORDER.order;
public class online extends order {
    private String diachigiaohang;

public online(String diachigiaohang, String orderCode, String customerCode, String employeeCode, String orderDate, List<SanPham> SanPhamList, int quantity, double totalValue, boolean paymentConfirmed, boolean orderConfirmed, String status) {
    super(orderCode, customerCode, employeeCode, orderDate, SanPhamList, quantity, totalValue, paymentConfirmed, orderConfirmed);
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
    public void xacnhandonhangonline() {
        order order = new order();
        if (order.status.equals("Chưa xác nhận")) {
            // Thực hiện xác nhận đơn hàng
            order.status = "Đã xác nhận";
            System.out.println("Đơn hàng đã được xác nhận.");
        } else if (order.status.equals("Đã xác nhận")) {
            System.out.println("Đơn hàng đã được xác nhận trước đó.");
        }
    }
    
    public void huyDonHangOnline() {
        // Kiểm tra trạng thái đơn hàng trước khi hủy
        if (order.status.equals("Chưa xác nhận")) {
            // Thực hiện hủy đơn hàng
            order.status="Đã hủy";
            System.out.println("Đơn hàng đã được hủy.");
        } else if (order.status.equals("Đã xác nhận")) {
            System.out.println("Không thể hủy đơn hàng đã được xác nhận.");
        } else {
            System.out.println("Đơn hàng đã được hủy trước đó.");
        }
    }

}

