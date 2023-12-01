package ORDER;

import java.util.ArrayList;
import java.util.List;

import PRODUCTS.SanPham;

public class instore extends order {
    private double tienmat;

    public instore(String orderCode, String customerCode, String employeeCode, String orderDate, List<SanPham> SanPhamList, int quantity, double totalValue, boolean paymentConfirmed, boolean orderConfirmed, double tienmat) {
        super(orderCode, customerCode, employeeCode, orderDate, SanPhamList, quantity, totalValue, paymentConfirmed, orderConfirmed);
        this.tienmat = tienmat;
    }
    public instore(){
        this.tienmat = 0;
    }
    public double gettienmat() {
        return tienmat;
    }

    public void settienmat(double tienmat) {
        this.tienmat = tienmat;
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
        order.setorderCode("DH001");
        order.setCustomerCode("KH001");
        order.setEmployeeCode("NV001");

        List<SanPham> SanPhamList = new ArrayList<>();
        SanPhamList.add(new SanPham("SP001", "Sản phẩm 1", 10.0));
        SanPhamList.add(new SanPham("SP002", "Sản phẩm 2", 20.0));
        order.setSanPhamList(SanPhamList);

        order.calculateTotalValue();
        order.settienmat(200.0);

        order.displayorderInfo();
    }
}