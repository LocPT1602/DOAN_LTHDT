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
        this.billCode = " ";
        this.productCode = 0;
        this.productName = "";
        this.productPrice =0;
        this.quantity =0;
        this.totalAmount =0;
    }

    public Bill(String billCode, int productCode, String productName, double productPrice, int quantity, double totalAmount) {
        this.billCode = billCode;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }
Scanner sc = new Scanner(System.in);

    //Get và Set
    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        System.out.println("Nhap ma hoa don: ");
        billCode=sc.nextLine();
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        System.out.println("Nhap ma san pham: ");
        productCode=sc.nextInt();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        System.out.println("Nhap ten san pham: ");
        productName=sc.nextLine();
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        System.out.println("Nhap gia san pham: ");
        productPrice=sc.nextDouble();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        System.out.println("so luong: ");
        quantity=sc.nextInt();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
    this.totalAmount=totalAmount;    }
}