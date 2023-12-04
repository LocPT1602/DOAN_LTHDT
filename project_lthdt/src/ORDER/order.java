package ORDER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import PRODUCTS.SanPham;
import MAIN.Kiemtra;
import PERSON.*;
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
    Kiemtra kt = new Kiemtra();
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
    public order()
    {
        this.orderCode="";
        this.customerCode="";
        this.employeeCode="";
        this.orderDate="";
        this.SanPhamList=null;
        this.quantity=0;
        this.totalValue=0;
        this.paymentConfirmed=false;
        this.orderConfirmed=false;
        this.status="";


    }

    Scanner scanner = new Scanner(System.in);

    // Getter và Setter cho các thuộc tính
    public String getorderCode() {
        return orderCode;
    }

    public void setorderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getStatus() {
        return status;
    }

    public void setstatus(String status) {
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

    public String getorderDate() {
        return orderDate;
    }

    public void setorderDate(String orderDate) {
        this.orderDate = orderDate;
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
        System.out.println("Danh sách sản phẩm đã đặt: "+ SanPhamList);
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
        order.inputorderInfo();
        order.toString();
        order.displayorderInfo();

    }
}
