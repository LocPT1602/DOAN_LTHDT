package ORDER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import PRODUCTS.SanPham;
import MAIN.Kiemtra;
// import PERSON.*;
public class order {
    private String orderCode;
    private String customerCode;
    private String employeeCode;
    private String orderDate;
    private List<SanPham> sanPhamList;
    private int quantity;
    private double totalValue;
    private boolean paymentConfirmed;
    private boolean orderConfirmed;
    private String status;

    BillDetail billdetail = new BillDetail();
    Kiemtra kt = new Kiemtra();

    public order(String orderCode, String customerCode, String employeeCode, String orderDate,
                 List<SanPham> sanPhamList, int quantity, double totalValue, boolean paymentConfirmed,
                 boolean orderConfirmed, String status) {
        this.orderCode = orderCode;
        this.customerCode = customerCode;
        this.employeeCode = employeeCode;
        this.orderDate = orderDate;
        this.sanPhamList = sanPhamList;
        this.quantity = quantity;
        this.totalValue = totalValue;
        this.paymentConfirmed = paymentConfirmed;
        this.orderConfirmed = orderConfirmed;
        this.status = status;
    }

    public order() {
        this.orderCode = "";
        this.customerCode = "";
        this.employeeCode = "";
        this.orderDate = "";
        this.sanPhamList = new ArrayList<>();
        this.quantity = 0;
        this.totalValue = 0;
        this.paymentConfirmed = false;
        this.orderConfirmed = false;
        this.status = "";
    }

    Scanner scanner = new Scanner(System.in);

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<SanPham> getSanPhamList() {
        return sanPhamList;
    }
    public void setSanPhamList(List<SanPham> SanPhamList) {
        this.sanPhamList = SanPhamList;
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
        totalValue = 0;
        for (SanPham sp : sanPhamList) {
            totalValue += sp.getDonGia() * quantity;
        }
    }

    // Phương thức thêm sản phẩm vào đơn hàng
    public void addSanPhamToorder(SanPham SanPham) {
        sanPhamList.add(SanPham);
    }

    // Phương thức xóa sản phẩm khỏi đơn hàng
    public void removeSanPhamFromorder(SanPham SanPham) {
        sanPhamList.remove(SanPham);
    }

    // Phương thức nhập thông tin đơn hàng
    public void inputorderInfo() {
        // Nhập thôgetBillDetailCode
        System.out.println("Nhap ma don hang: ");
        this.orderCode= scanner.nextLine();
        System.out.println("Nhap ma khach hang: ");
        this.customerCode= kt.kiemtraMakhachhang();
        System.out.println("Nhap ma nhan vien: ");
        this.employeeCode= kt.kiemtraManhanvien();
        System.out.println("Ngay dat hang: ");
        this.orderDate= kt.nhapNgay();
        System.out.println("Nhap  so luong: ");
        this.quantity= kt.KiemTraNhapSoTuNhien();
        // ...
    }

    // Phương thức xuất thông tin đơn hàng
    public void displayorderInfo() {
        // Hiển thị thông tin đơn hàng ra màn hình
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------THONG TIN DON HANG-----------------------------");
        System.out.println("Mã đơn hàng: " + orderCode);
        System.out.println("Mã khách hàng: "+ customerCode);
        System.out.println("mã nhân viên: "+ employeeCode);
        System.out.println("Ngày đặt hàng: "+ orderDate);
        System.out.println("Danh sách sản phẩm đã đặt: "+ sanPhamList);
        System.out.println("Số lượng sản phẩm: "+ quantity);
        System.out.println("Tổng giá trị đơn hàng: " +totalValue);
        // ...
    }

    // Ghi đè phương thức toString()
    @Override
    public String toString() {
        return "Don hang{" +
                "Ma don hang : '" + orderCode + '\'' +
                ", Ma khach hang: '" + customerCode + '\'' +
                ", Ma nhan vien: '" + employeeCode + '\'' +
                ", Ngay dat hang: '" + orderDate + '\'' +
                ", Danh sach san pham: " + sanPhamList +
                ", So luong: " + quantity +
                ", Tong gia tri: " + totalValue +
                ", Xac nhan thanh toan: " + paymentConfirmed +
                ", Xac nhan don hang: =" + orderConfirmed +
                ", Tinh trang don hang: =" + status +

                '}';
    }

    public static void main(String[] args) {
        order order = new order();
        order.inputorderInfo();
        order.toString();
        order.displayorderInfo();

    }
}
