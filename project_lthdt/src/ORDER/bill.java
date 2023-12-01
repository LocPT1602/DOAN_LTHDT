package ORDER;

import java.util.Scanner;
public class Bill {
    private String billCode; //Mã hóa đơn
    private int productCode; //Mã sản phẩm
    private String productName; //Tên sản phẩm
    private double productPrice; //Giá sản phẩm
    private int quantity; //Số lượng
    private double totalAmount; //Tổng cộng

    public Bill() {
    }

    public Bill(String billCode, int productCode, String productName, double productPrice, int quantity, double totalAmount) {
        this.billCode = billCode;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    //Get và Set
    public String getBillCode() {
        Scanner sc = new Scanner();
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
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