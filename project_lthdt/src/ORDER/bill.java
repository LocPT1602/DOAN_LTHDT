package ORDER;

import java.util.Scanner;
<<<<<<< HEAD
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
=======

public class bill {
    private String billCode; // Mã hóa đơn
    private int productCode; // Mã sản phẩm
    private String productName; // Tên sản phẩm
    private double productPrice; // Giá sản phẩm
    private int quantity; // Số lượng
    private double totalAmount; // Tổng cộng

    public bill() {
        this.billCode = " ";
        this.productCode = 0;
>>>>>>> parent of 34d247d (mdsgajs)
        this.productName = "";
        this.productPrice = 0;
        this.quantity = 0;
        this.totalAmount = 0;
    }

<<<<<<< HEAD
    public bill(String billCode, String maSP, String productName, double productPrice, int quantity,
            double totalAmount) {
        this.billCode = billCode;
        this.maSP = maSP;
=======
    public bill(String billCode, int productCode, String productName, double productPrice, int quantity,
            double totalAmount) {
        this.billCode = billCode;
        this.productCode = productCode;
>>>>>>> parent of 34d247d (mdsgajs)
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    Scanner sc = new Scanner(System.in);

    // Get và Set
    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        System.out.println("Nhap ma hoa don: ");
        billCode = sc.nextLine();
    }

<<<<<<< HEAD
    public String getmaSP() {
        return maSP;
    }

    public void setmaSP(String maSP) {
        this.maSP = maSP;
=======
    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        System.out.println("Nhap ma san pham: ");
        productCode = sc.nextInt();
>>>>>>> parent of 34d247d (mdsgajs)
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
<<<<<<< HEAD
        this.productName = productName;
=======
        System.out.println("Nhap ten san pham: ");
        productName = sc.nextLine();
>>>>>>> parent of 34d247d (mdsgajs)
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
<<<<<<< HEAD
        this.productPrice = productPrice;
=======
        System.out.println("Nhap gia san pham: ");
        productPrice = sc.nextDouble();
>>>>>>> parent of 34d247d (mdsgajs)
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        System.out.println("so luong: ");
        quantity = sc.nextInt();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}