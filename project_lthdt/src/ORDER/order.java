package ORDER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import PRODUCTS.SanPham;
import MAIN.Kiemtra;
import java.time.LocalDate;

public class Order{
    private String orderCode;
    private String customerCode;
    private String employeeCode;
    private LocalDate orderDate;
    private List<SanPham> sanPhamList;
    private int quantity;
    private double totalValue;
    private boolean paymentConfirmed;
    private boolean orderConfirmed;
    private String status;

    Kiemtra kt = new Kiemtra();

    public Order(String orderCode,String customerCode, String employeeCode, LocalDate orderDate, List<SanPham> sanPhamList, int quantity, double totalValue, boolean paymentConfirmed, boolean orderConfirmed, String status) {
        this.orderCode = orderCode;
        this.customerCode = customerCode;
        this.employeeCode = employeeCode;
        this.orderDate = LocalDate.now();
        this.sanPhamList = sanPhamList;
        this.quantity = quantity;
        this.paymentConfirmed = paymentConfirmed;
        this.orderConfirmed = orderConfirmed;
        this.status = status;
    }

    public Order() {
        this.orderCode = "";
        this.customerCode = "";
        this.employeeCode = "";
        this.orderDate = LocalDate.now();
        this.sanPhamList = new ArrayList<>();
        this.quantity = 0;
        this.paymentConfirmed = false;
        this.orderConfirmed = false;
        this.status = "Chưa xác nhận";
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public List<SanPham> getSanPhamList() {
        return sanPhamList;
    }

    public void setSanPhamList(List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return totalValue;
    }
    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue
    }
    public boolean isPaymentConfirmed() {
        return paymentConfirmed;
    }

    public void setPaymentConfirmed(boolean paymentConfirmed) {
        this.paymentConfirmed = paymentConfirmed;
    }

    public boolean isOrderConfirmed() {
        return orderConfirmed;
    }

    public void setOrderConfirmed(boolean orderConfirmed) {
        this.orderConfirmed = orderConfirmed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void calculateTotalValue() {
        totalValue = 0;
        for (SanPham sp : sanPhamList) {
            totalValue += sp.getDonGia() * quantity;
        }
    }

    public void addSanPhamToOrder(SanPham sanPham) {
        sanPhamList.add(sanPham);
    }

    public void removeSanPhamFromOrder(SanPham sanPham) {
        sanPhamList.remove(sanPham);
    }

    public void inputOrderInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập mã đơn hàng: ");
        this.orderCode = scanner.nextLine();
        System.out.println("Nhập mã khách hàng: ");
        this.customerCode = kt.kiemtraMakhachhang();
        System.out.println("Nhập mã nhân viên: ");
        this.employeeCode = kt.kiemtraManhanvien();
        this.orderDate = LocalDate.now();
        System.out.println("Nhập số lượng: ");
        this.quantity = kt.KiemTraNhapSoTuNhien();
        // ...
    }

    public void displayOrderInfo() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------THÔNG TIN ĐƠN HÀNG-------------------------");
        System.out.println("Mã đơn hàng: " + orderCode);
        System.out.println("Mã khách hàng: " + customerCode);
        System.out.println("Mã nhân viên: " + employeeCode);
        System.out.println("Ngày đặt hàng: " + orderDate);
       // Hiển thị thông tin về sản phẩm
        System.out.println("Danh sách sản phẩm:");
        for (SanPham sp : sanPhamList) {
            System.out.println(sp);
        }

        System.out.println("Số lượng: " + quantity);
        System.out.println("Tổng giá trị: " + totalValue);
        System.out.println("Trạng thái: " + status);
        System.out.println("--------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderCode='" + orderCode + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", orderDate=" + orderDate +
                ", sanPhamList=" + sanPhamList +
                ", quantity=" + quantity +
                ", totalValue=" + totalValue +
                ", paymentConfirmed=" + paymentConfirmed +
                ", orderConfirmed=" + orderConfirmed +
                ", status='" + status + '\'' +
                '}';
    }
    public static void main(String[] args) {
        Order order = new Order();
        // SanPham sp = new SanPham();
        order.inputOrderInfo();
        order.toString();
        // order.addSanPhamToOrder(sanPham);
        order.displayOrderInfo();
        // ...
    }
}