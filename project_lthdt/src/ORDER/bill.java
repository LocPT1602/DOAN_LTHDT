package ORDER;
import MAIN.*;
import java.util.Scanner;
// import PRODUCTS.SanPham;
public class Bill {
    protected String billCode; // Mã hóa đơn
    protected String maSP; // Mã sản phẩm
    protected String tenSP; // Tên sản phẩm
    protected double donGia; // Giá sản phẩm
    private int quantity; // Số lượng
    private double totalAmount; // Tổng giá
    Kiemtra kt = new Kiemtra();
    // SanPham sp = new SanPham();

    public Bill() {
        this.billCode = "";
        this.maSP = "";
        this.tenSP = "";
        this.donGia = 0;
        this.quantity = 0;
        this.totalAmount = 0;
    }
    
    public Bill(String billCode, String maSP, String tenSP, double donGia, int quantity,
            double totalAmount) {
        this.billCode = billCode;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    Scanner sc = new Scanner(System.in);

    // Getter và Setter cho thuộc tính
    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getmaSP() {
        return maSP;
    }

    public void setmaSP(String maSP) {
        this.maSP = maSP;
    }

    public String gettenSP() {
        return tenSP;
    }

    public void settenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getdonGia() {
        return donGia;
    }

    public void setdonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    
}