package ORDER;
import MAIN.*;
import java.util.Scanner;
import PRODUCTS.*;
public class bill {
    private String billCode; // Mã hóa đơn
    protected String maSP; // Mã sản phẩm
    private String productName; // Tên sản phẩm
    private double productPrice; // Giá sản phẩm
    private int quantity; // Số lượng
    private double totalAmount; // Tổng giá
    Kiemtra kt = new Kiemtra();
    public bill() {
        this.billCode = "";
        this.maSP = "";
        this.productName = "";
        this.productPrice = 0;
        this.quantity = 0;
        this.totalAmount = 0;
    }

    public bill(String billCode, String maSP, String productName, double productPrice, int quantity,
            double totalAmount) {
        this.billCode = billCode;
        this.maSP = maSP;
        this.productName = productName;
        this.productPrice = productPrice;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
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