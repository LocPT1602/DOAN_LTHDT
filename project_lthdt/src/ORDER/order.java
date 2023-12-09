package ORDER;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import PRODUCTS.SanPham;
import MAIN.Kiemtra;
import java.nio.file.Files;
import java.nio.file.Path;
import PRODUCTS.GioHang;

public class Order {
    private String orderCode; // Mã đơn hàng
    private String customer; // Mã khách hàng
    private String employee; // Mã nhân viên
    private String productCode; // Mã sản phẩm
    private LocalDate orderDate; // Ngày đặt hàng
    private List<SanPham> sanPhamList; // Danh sách sản phẩm
    private int quantity; // Số lượng sản phẩm
    private double totalValue; // Tổng giá trị đơn hàng
    private boolean paymentConfirmed; // Xác nhận thanh toán
    private boolean orderConfirmed; // Xác nhận đơn hàng
    private String status; // Trạng thái đơn hàng
    Kiemtra kt = new Kiemtra();
    GioHang gh = new GioHang();
    Scanner scanner = new Scanner(System.in);

    public Order(String orderCode, String customer, String employee, LocalDate orderDate, List<SanPham> sanPhamList,
            int quantity, double totalValue, boolean paymentConfirmed, boolean orderConfirmed, String status) {
        this.orderCode = orderCode;
        this.customer = customer;
        this.employee = employee;
        this.orderDate = LocalDate.now();
        this.sanPhamList = sanPhamList;
        this.quantity = quantity;
        this.totalValue = totalValue;
        this.paymentConfirmed = paymentConfirmed;
        this.orderConfirmed = orderConfirmed;
        this.status = status;
    }

    public Order() {
        this.orderDate = LocalDate.now();
        this.sanPhamList = new ArrayList<>();
        this.quantity = 0;
        this.totalValue = 0;
        this.status = "";
    }

    // Getter và Setter cho các thuộc tính
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<SanPham> getSanPhamList() {
        return sanPhamList;
    }

    public void setSanPhamList(List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public boolean isPaymentConfirmed() {
        return paymentConfirmed;
    }

    public void setPaymentConfirmed(boolean paymentConfirmed) {
        this.paymentConfirmed = paymentConfirmed;
    }

    public boolean isOrderConfirmed() {
        return orderConfirmed;
    }

    public void setOrderConfirmed(boolean orderConfirmed) {
        this.orderConfirmed = orderConfirmed;
    }

    // Phương thức tính tổng giá trị đơn hàng
    public void calculateTotalValue() {
        double total = 0;
        for (SanPham sanPham : sanPhamList) {
            total += sanPham.getDonGia();
        }
        this.totalValue = total;
    }

    // Phương thức thêm sản phẩm vào đơn hàng
    public void addSanPhamToOrder(SanPham sanPham) {
        sanPhamList.add(sanPham);
    }

    // Phương thức xóa sản phẩm khỏi đơn hàng
    public void removeSanPhamFromOrder(SanPham sanPham) {
        sanPhamList.remove(sanPham);
    }

    public void checkorderConfirmed() {
        boolean validOrderConfirmed = false;
        while (!validOrderConfirmed) {
            String orderConfirmedInput = scanner.nextLine();
            if (orderConfirmedInput.equalsIgnoreCase("true") || orderConfirmedInput.equalsIgnoreCase("false")) {
                validOrderConfirmed = true;
                orderConfirmed = Boolean.parseBoolean(orderConfirmedInput);
            } else {
                System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại (true/false):");
            }
        }
    }

    public void checkpaymentConfirmed() {
        boolean validPaymentConfirmed = false;
        while (!validPaymentConfirmed) {
            String paymentConfirmedInput = scanner.nextLine();
            if (paymentConfirmedInput.equalsIgnoreCase("true") || paymentConfirmedInput.equalsIgnoreCase("false")) {
                validPaymentConfirmed = true;
                paymentConfirmed = Boolean.parseBoolean(paymentConfirmedInput);
            } else {
                System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại (true/false):");
            }
        }
    }

    public void checkStatus() {
        while (this.status.equals("Đã xác nhận")) {
            if (this.orderConfirmed && this.paymentConfirmed) {
                this.status = "Đã xác nhận";
            } else if (this.orderConfirmed && !this.paymentConfirmed) {
                this.status = "Chưa xác nhận";
                System.out.println("Chọn lại xác nhận thanh toán (true/false)");
                checkpaymentConfirmed();
            } else if (!this.orderConfirmed && this.paymentConfirmed) {
                this.status = "Chưa xác nhận";
                System.out.println("Chọn lại xác nhận đơn hàng (true/false)");
                checkorderConfirmed();
            }
        }
    }

    // Phương thức nhập thông tin đơn hàng
    public void inputOrderInfo() {
        Scanner scanner = new Scanner(System.in);
        // System.out.print("Nhap ma don hang: ");
        Random random = new Random();
        int randomNumbers = random.nextInt(1000);
        String formattedRandomNumbers = String.format("%03d", randomNumbers);
        String orderCode = "MDH" + formattedRandomNumbers;

        this.orderCode = orderCode;

        // System.out.println("Nhập mã sản phẩm: ");
        // this.productCode = scanner.nextLine();

        System.out.print("Nhap ma khach hang: ");
        this.customer = kt.kiemtraMakhachhang();

        System.out.print("Nhap ma nhan vien phu trach: ");
        this.employee = kt.kiemtraManhanvien();

        // System.out.println("Danh sach san pham: ");
        // gh.inTenSPvaDonGia();
        // System.out.println("Nhập số lượng sản phẩm: ");
        // this.quantity = kt.KiemTraNhapSoTuNhien();

        // System.out.println("Nhập tổng giá trị đơn hàng: ");
        // this.totalValue = kt.KiemTraNhapSoNguyen();

        System.out.println("Xac nhan thanh toan (true/false): ");
        checkpaymentConfirmed();
        System.out.println("Xan nhan don hang (true/false): ");
        checkorderConfirmed();
        checkStatus();
    }

    // Phương thức xuất thông tin đơn hàng
    public void displayOrderInfo() {
        LocalDate orderDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------THÔNG TIN ĐƠN HÀNG-------------------------");
        System.out.println("Ma don hang: " + orderCode);
        System.out.println("Ma khach hang: " + customer);
        System.out.println("Ma nhan vien: " + employee);
        System.out.println("Ngay tao don hang: " + orderDate.format(formatter));
        System.out.println("Danh sach san pham: ");
        gh.gioHangSize();
        gh.inTenSPvaDonGia();
        System.out.println("So luong san pham: " + quantity);
        System.out.println("Tong gia tri don hang: " + totalValue);
        System.out.println("Xac nhan thanh toan: " + paymentConfirmed);
        System.out.println("Xac nhan don hang: " + orderConfirmed);
        checkStatus();
        System.out.println("Trang thai don hang: " + status);
    }

    public void addOrderInfoList() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String formattedDate = orderDate.format(formatter);
        String[] orderInfo = { orderCode, employee, productCode, formattedDate };
        List<String[]> orderInfoList = new ArrayList<>();
        orderInfoList.add(orderInfo);
    }

    // Thêm thông tin đơn hàng vào tệp tin "Ds đơn hàng"
    public void writefile1() {
        String fileName = "project_lthdt/src/ORDER/dsdonhang.txt";
        try {
            Path filePath = Path.of(fileName);
            FileWriter writer = new FileWriter(filePath.toString());
            writer.write("Mã đơn hàng: " + orderCode + "\n");
            writer.write("Mã nhân viên: " + employee + "\n");
            writer.write("Ngày đặt hàng: " + orderDate + "\n");
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi tệp tin.");
        }
    }

    // Thêm thông tin đơn hàng vào tệp tin "Ds sản phẩm đơn hàng"
    public void writefile2() {
        try {
            String fileName2 = "project_lthdt/src/ORDER/dssanphamdonhang.txt";
            Path filePath2 = Path.of(fileName2);
            FileWriter writer = new FileWriter(filePath2.toString());
            writer.write("Mã đơn hàng: " + orderCode + "\n");
            writer.write("Mã sản phẩm: " + productCode + "\n");
            // Ghi thông tin khác về sản phẩm đơn hàng tại đây
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi tệp tin.");
        }
    }

    // Phương thức ghi đè toString()
    @Override
    public String toString() {
        return "Order{" +
                "orderCode='" + orderCode + '\'' +
                ", customer=" + customer +
                ", employee=" + employee +
                ", orderDate=" + orderDate +
                ", sanPhamList=" + sanPhamList +
                ", quantity=" + quantity +
                ", totalValue=" + totalValue +
                ", paymentConfirmed=" + paymentConfirmed +
                ", orderConfirmed=" + orderConfirmed +
                ", status='" + status + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.inputOrderInfo();
        order.displayOrderInfo();
    }
}