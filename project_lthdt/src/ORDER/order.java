package ORDER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import PRODUCTS.SanPham;
import ORDER.BillDetail;

public class order {
    private String orderCode;            // Mã đơn hàng
    private String customerCode;         // Mã khách hàng
    private String employeeCode;         // Mã nhân viên
    private String orderDate;            // Ngày đặt hàng
    private List<SanPham> SanPhamList;   // Danh sách sản phẩm
    private int quantity;                // Số lượng sản phẩm
    private double totalValue;           // Tổng giá trị đơn hàng
    private boolean paymentConfirmed;    // Xác nhận thanh toán
    private boolean orderConfirmed;      // Xác nhận đơn hàng
    private String status;               //Trạng thái đơn hàng
        BillDetail billdetail = new BillDetail();

    public order() {
        SanPhamList = new ArrayList<>();
        this.status = "Chưa xác nhận";
    }
    public order(String orderCode, String customerCode, String employeeCode, String orderDate, List<SanPham> sanPhamList, int quantity, double totalValue, boolean paymentConfirmed, boolean orderConfirmed) {
        this.orderCode = orderCode;
        this.customerCode = customerCode;
        this.employeeCode = employeeCode;
        this.orderDate = orderDate;
        this.SanPhamList = sanPhamList;
        this.quantity = quantity;
        this.totalValue = totalValue;
        this.paymentConfirmed = paymentConfirmed;
        this.orderConfirmed = orderConfirmed;
    }
 Scanner scanner = new Scanner(System.in);

    // Getter và Setter cho các thuộc tính
    public String getorderCode() {
        return orderCode;
    }

    public void setorderCode(String orderCode) {
        this.orderCode = scanner.nextLine();
    }

    public String getStatus(){
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
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
        this.orderDate = scanner.nextLine();    }

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
        this.quantity = scanner.nextInt();    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        calculateTotalValue();
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
        System.out.println("Nhap ma don hang: ");
        setorderCode(orderCode);
        System.out.println("Nhap ma khach hang: ");
        setCustomerCode(customerCode);
        System.out.println("Nhap ma nhan vien: ");
        setEmployeeCode(employeeCode);
        System.out.println("Ngay dat hang: ");
        setorderDate(orderDate);
        System.out.println("danh sach san pham: ");
        setSanPhamList(SanPhamList);
        System.out.println("Nhap so luong: ");
        setQuantity(quantity);
        System.out.println("Tong gia tri don hang: ");
        setTotalValue(totalValue);
        //...
    }

    // Phương thức xuất thông tin đơn hàng
    public void displayorderInfo() {
        // Hiển thị thông tin đơn hàng ra màn hình
        System.out.println("Mã đơn hàng: " + orderCode);
        System.out.println("Ma khach hang: "+customerCode);
        System.out.println("Ma nhan vien: " +employeeCode);
        System.out.println("Ngay dat hang: "+ orderDate);
        System.out.println("Danh sach san pham da dat: " + SanPhamList);
        System.out.println("Tong gia tri don hang: 0"+totalValue);
        //...
    }

    // Ghi đè phương thức toString()
    @Override
    public String toString() {
        return "Don hang{" +
                "Ma don hang : '" + orderCode + '\'' +
                ", Ma khach hang: '" + customerCode + '\'' +
                ", Ma nhan vien: '" + employeeCode + '\'' +
                ", Ngay dat hang: '" + orderDate + '\'' +
                ", Danh sach san pham: " + SanPhamList +
                ", So luong: " + quantity +
                ", Tong gia tri: " + totalValue +
                ", Xac nhan thanh toan: " + paymentConfirmed +
                ", Xac nhan don hang: =" + orderConfirmed +
                ", Tinh trang don hang: =" + status +

                '}';
    }

    public static void main(String[] args) {
        order order = new order();
       
    }
}
