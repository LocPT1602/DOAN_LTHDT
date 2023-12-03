package ORDER;

import java.util.Scanner;

public class orderitem {
    private String product; // Tên sản phẩm
    private int quantity; // Số lượng sản phẩm
    Scanner sc = new Scanner(System.in);

    // Phương thức setter cho thuộc tính product
    public void setProduct(String product) {
        System.out.println("Nhap san pham: ");
        this.product = sc.nextLine();
    }

    // Phương thức getter cho thuộc tính product
    public String getProduct() {
        return product;
    }

    // Phương thức setter cho thuộc tính quantity
    public void setQuantity(int quantity) {
        System.out.println("Nhap so luong: ");
        this.quantity = sc.nextInt();
    }

    // Phương thức getter cho thuộc tính quantity
    public int getQuantity() {
        return quantity;
    }

    // Phương thức tính tổng giá trị sản phẩm
    public double calculateTotalValue(double pricePerUnit) {
        return quantity * pricePerUnit;
    }

    public static void main(String[] args) {

    }
}
