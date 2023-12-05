package ORDER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import PRODUCTS.SanPham;
import java.time.LocalDate;
public class instore extends Order {
    private double tienmat;
Scanner sc = new Scanner(System.in);
    public instore(String orderDateStr ,String orderCode, String customerCode, String employeeCode, LocalDate orderDate, List<SanPham> sanPhamList, int quantity, double totalValue, boolean paymentConfirmed, boolean orderConfirmed, double tienmat, String status) {
        super(orderDateStr ,orderCode, customerCode, employeeCode, orderDate, sanPhamList, quantity, totalValue, paymentConfirmed, orderConfirmed, status);
        this.tienmat = tienmat;
    }
    public instore(){
        this.tienmat = 0;
    }
    public double gettienmat() {
        return tienmat;
    }

    public void settienmat(double tienmat) {
        this.tienmat = sc.nextDouble();
    }

    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
        double tienNhan = gettienmat();
        double tienThoi = tienNhan - getTotalValue();

        System.out.println("Số tiền nhận: " + tienNhan);
        System.out.println("Số tiền thối: " + tienThoi);
    }

    public static void main(String[] args) {
        instore Order = new instore();
       
}
}