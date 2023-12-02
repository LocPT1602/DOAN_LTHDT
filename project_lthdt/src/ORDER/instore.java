package ORDER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import PRODUCTS.SanPham;

public class instore extends order {
    private double tienmat;
Scanner sc = new Scanner(System.in);
    public instore(String orderCode, String customerCode, String employeeCode, String orderDate, List<SanPham> SanPhamList, int quantity, double totalValue, boolean paymentConfirmed, boolean orderConfirmed, double tienmat, String status) {
        super(orderCode, customerCode, employeeCode, orderDate, SanPhamList, quantity, totalValue, paymentConfirmed, orderConfirmed, status);
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
    public void displayorderInfo() {
        super.displayorderInfo();
        double tienNhan = gettienmat();
        double tienThoi = tienNhan - getTotalValue();

        System.out.println("Số tiền nhận: " + tienNhan);
        System.out.println("Số tiền thối: " + tienThoi);
    }

    public static void main(String[] args) {
        instore order = new instore();
       
}
}