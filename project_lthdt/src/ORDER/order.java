package ORDER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import PRODUCTS.SanPham;
import ORDER.BillDetail;

public class order {
    private String orderCode; // Mã đơn hàng
    private String customerCode; // Mã khách hàng
    private String employeeCode; // Mã nhân viên
    private String orderDate; // Ngày đặt hàng
    private List<SanPham> SanPhamList; // Danh sách sản phẩm
    private int quantity; // Số lượng sản phẩm
    private double totalValue; // Tổng giá trị đơn hàng
    private boolean paymentConfirmed; // Xác nhận thanh toán
    private boolean orderConfirmed; // Xác nhận đơn hàng
    private String status; // Trạng thái đơn hàng
    BillDetail billdetail = new BillDetail();
    Scanner scanner = new Scanner(System.in);

    public order(String orderCode2, String customerCode2, String employeeCode2, String orderDate2, List<SanPham> sanPhamList2, int quantity2, double totalValue2, boolean paymentConfirmed2, boolean orderConfirmed2) {
        SanPhamList = new ArrayList<>();
        this.status = "Chưa xác nhận";
    }

    public order(String orderCode, String customerCode, String employeeCode, String orderDate,
            List<SanPham> sanPhamList, int quantity, double totalValue, boolean paymentConfirmed,
            boolean orderConfirmed, String status) {
        this.orderCode = orderCode;
        this.customerCode = customerCode;
        this.employeeCode = employeeCode;
        this.orderDate = orderDate;
        this.SanPhamList = sanPhamList;
        this.quantity = quantity;
        this.totalValue = totalValue;
        this.paymentConfirmed = paymentConfirmed;
        this.orderConfirmed = orderConfirmed;
        this.status = status;
    }

    // Getter và Setter cho các thuộc tính
    public String getorderCode() {
        return orderCode;
    }

    public void setorderCode(String orderCode) {
        this.orderCode = scanner.nextLine();
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = scanner.nextLine();
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = scanner.nextLine();
    }

    public String getorderDate() {
        return orderDate;
    }

    public void setorderDate(String orderDate) {
        this.orderDate = scanner.nextLine();
    }

    public List<SanPham> getSanPhamList() {
        return SanPhamList;
    }

    public void setSanPhamList(List<SanPham> SanPhamList) {
        this.SanPhamList = SanPhamList;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = scanner.nextInt();
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public boolean isPaymentConfirmed() {
        return paymentConfirmed;
    }

    public void setPaymentConfirmed(boolean paymentConfirmed) {
        this.paymentConfirmed = paymentConfirmed;
    }

    public boolean isorderConfirmed() {
        return orderConfirmed;
    }

    public void setorderConfirmed(boolean orderConfirmed) {
        this.orderConfirmed = orderConfirmed;
    }

    // Phương thức tính tổng giá trị đơn hàng
    public void calculateTotalValue() {
        double total = 0;
        for (SanPham SanPham : SanPhamList) {
            total += SanPham.getDonGia();
        }
        this.totalValue = total;
    }

    // Phương thức thêm sản phẩm vào đơn hàng
    public void addSanPhamToorder(SanPham SanPham) {
        SanPhamList.add(SanPham);
    }

    // Phương thức xóa sản phẩm khỏi đơn hàng
    public void removeSanPhamFromorder(SanPham SanPham) {
        SanPhamList.remove(SanPham);
    }

    // Phương thức nhập thông tin đơn hàng
    public void inputorderInfo() {
        // Nhập thôgetBillDetailCode
        setorderCode(orderCode);
        setCustomerCode(customerCode);
        setCustomerCode(customerCode);
        setorderDate(orderDate);
        // ...
    }

    // Phương thức xuất thông tin đơn hàng
    public void displayorderInfo() {
        // Hiển thị thông tin đơn hàng ra màn hình
        System.out.println("Mã đơn hàng: " + orderCode);
        // ...
    }

    // Ghi đè phương thức toString()
    @Override
    public String toString() {
        return "order{" +
                "orderCode='" + orderCode + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", SanPhamList=" + SanPhamList +
                ", quantity=" + quantity +
                ", totalValue=" + totalValue +
                ", paymentConfirmed=" + paymentConfirmed +
                ", orderConfirmed=" + orderConfirmed +
                '}';
    }

    public static void main(String[] args) {
        order order = new order();
        order.setorderCode("DH001");
        order.setCustomerCode("KH001");
        order.setEmployeeCode("NV001");

        List<SanPham> SanPham1 = new ArrayList<>();
        SanPham1.add(new SanPham("SP001", "Sản phẩm 1", 10.0));
        SanPham1.add(new SanPham("SP002", "Sản phẩm 2", 20.0));
        order.setSanPhamList(SanPham1);

        order.calculateTotalValue();

        System.out.println(order);
    }
}
