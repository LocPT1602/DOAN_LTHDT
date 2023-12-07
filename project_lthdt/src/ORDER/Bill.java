package ORDER;
import MAIN.*;
import java.util.Scanner;
import PRODUCTS.*;
public class Bill {
    protected HoaDon maHD; // Mã hóa đơn
    protected SanPham maSP; // Mã sản phẩm
    protected SanPham tenSP; // Tên sản phẩm
    protected SanPham donGia; // Giá sản phẩm
    protected int quantity; // Số lượng
    protected double totalAmount; // Tổng giá
    Kiemtra kt = new Kiemtra();
    public Bill() {
        this.quantity = 0;
        this.totalAmount = 0;
    }

    public Bill( int quantity, double totalAmount) {
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    Scanner sc = new Scanner(System.in);

    // Getter và Setter cho thuộc tính
    public SanPham getMaSP() {
        return maSP;
    }

    public void setMaSP(SanPham maSP) {
        this.maSP = maSP;
    }

    public HoaDon getmaHD() {
        return maHD;
    }

    public void setmaHD(HoaDon maHD) {
        this.maHD = maHD;
    }

    public SanPham getTenSP() {
        return tenSP;
    }

    public void setTenSP(SanPham tenSP) {
        this.tenSP = tenSP;
    }

    public SanPham getDonGia() {
        return donGia;
    }

    public void setDonGia(SanPham donGia) {
        this.donGia = donGia;    }

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
