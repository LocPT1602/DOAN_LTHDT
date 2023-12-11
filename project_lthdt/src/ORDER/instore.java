package ORDER;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import PRODUCTS.SanPham;

public class instore extends Order {
    public double cash; // Tiền mặt
    Scanner scanner = new Scanner(System.in);

    public instore(String orderCode, String customer, String employee,List<SanPham> sanPhamList, LocalDate orderDate, int quantity, double totalValue, boolean paymentConfirmed, boolean orderConfirmed, String status, double cash) {
        // super(orderCode, customer, employee,sanPhamList, orderDate, quantity, totalValue, paymentConfirmed, orderConfirmed, status);
        this.cash = cash;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
    
   public void nhap(){
    System.out.println("Nhập tiền nhận: ");
    this.cash = scanner.nextDouble();
   }
    
    // Ghi đè phương thức displayOrderInfo() để xuất ra tiền nhận và tiền thối
    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
        double change = cash - getTotalValue();
        System.out.println("Tiền nhận: " + cash);
        System.out.println("Tiền thối: " + change);
    }
}