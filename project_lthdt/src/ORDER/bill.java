package ORDER;
import MAIN.*;
import java.util.Scanner;
import PRODUCTS.SanPham;
public class bill {
    protected String billCode; // Mã hóa đơn
    protected SanPham maSP; // Mã sản phẩm
    protected SanPham tenSP; // Tên sản phẩm
    protected SanPham donGia; // Giá sản phẩm
    private int quantity; // Số lượng
    private double totalAmount; // Tổng giá
    Kiemtra kt = new Kiemtra();
    // SanPham sp = new SanPham();

    public bill() {
        // this.billCode = "";
        // this.maSP = "";
        // this.tenSP = "";
        // this.donGia = 0;
        // this.quantity = 0;
        // this.totalAmount = 0;
    }
    
    public bill(String billCode, SanPham maSP, SanPham tenSP, SanPham donGia, int quantity,
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

    public SanPham getmaSP() {
        return maSP;
    }

    public void setmaSP(SanPham maSP) {
        this.maSP = maSP;
    }

    public SanPham gettenSP() {
        return tenSP;
    }

    public void settenSP(SanPham tenSP) {
        this.tenSP = tenSP;
    }

    public SanPham getdonGia() {
        return donGia;
    }

    public void setdonGia(SanPham donGia) {
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