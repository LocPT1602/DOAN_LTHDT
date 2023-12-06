package ORDER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import PRODUCTS.SanPham;
import MAIN.Kiemtra;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
    String formattedDate = orderDate.format(formatter);
    public Order(String orderCode, String customer, String employee, LocalDate orderDate, List<SanPham> sanPhamList, int quantity, double totalValue, boolean paymentConfirmed, boolean orderConfirmed, String status) {
        this.orderCode = orderCode;
        this.customer = customer;
        this.employee = employee;
        this.orderDate = orderDate;
        this.sanPhamList = sanPhamList;
        this.quantity = quantity;
        this.totalValue = totalValue;
        this.paymentConfirmed = paymentConfirmed;
        this.orderConfirmed = orderConfirmed;
        this.status = "Chưa xác nhận";
    }

    public Order() {
        this.orderDate = LocalDate.now();
        this.sanPhamList = new ArrayList<>();
        this.quantity = 0;
        this.totalValue = 0;
        this.paymentConfirmed = false;
        this.orderConfirmed = false;
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

    // Phương thức nhập thông tin đơn hàng
    public void inputOrderInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã đơn hàng: ");
        this.orderCode = scanner.nextLine();

        System.out.println("Nhập mã sản phẩm: ");
        this.productCode = scanner.nextLine();

        System.out.println("Nhập mã khách hàng: ");
        this.customer = kt.kiemtraMakhachhang();

        System.out.println("Nhập mã nhân viên: ");
        this.employee = kt.kiemtraManhanvien();

        System.out.println("Nhập ngày đặt hàng (yyyy-MM-dd): ");
        String orderDateStr = kt.nhapNgay();
        this.orderDate = LocalDate.parse(orderDateStr);
        System.out.println("Danh sách sản phẩm: ");
        gh.inTenSPvaDonGia();
        System.out.println("Nhập số lượng sản phẩm: ");
        this.quantity = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng new line

        System.out.println("Nhập tổng giá trị đơn hàng: ");
        this.totalValue = scanner.nextDouble();
        scanner.nextLine(); // Đọc bỏ dòng new line

        System.out.println("Xác nhận thanh toán (true/false): ");
        this.paymentConfirmed = scanner.nextBoolean();
        scanner.nextLine(); // Đọc bỏ dòng new line

        System.out.println("Xác nhận đơn hàng (true/false): ");
        this.orderConfirmed = scanner.nextBoolean();
        scanner.nextLine(); // Đọc bỏ dòng new line
        while(this.status == "Đã xác nhận"){
        if(this.orderConfirmed==true&&this.paymentConfirmed==true){
            this.status = "Đã xác nhận";
        }
        else if(this.orderConfirmed==true&&this.paymentConfirmed==false){
            this.status = "Chưa xác nhận";
            System.out.println("Chọn lại xác nhận thanh toán (true/false)");
            this.paymentConfirmed = scanner.nextBoolean();
        }
        else if(this.orderConfirmed==false&&this.paymentConfirmed==true){
            this.status = "Chưa xác nhận";
            System.out.println("Chọn lại xác nhận đơn hàng (true/false)");
            this.orderConfirmed = scanner.nextBoolean();

        }
    }}

    // Phương thức xuất thông tin đơn hàng
    public void displayOrderInfo() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------THÔNG TIN ĐƠN HÀNG-------------------------");
        System.out.println("Mã đơn hàng: " + orderCode);
        System.out.println("Mã khách hàng: " + customer);
        System.out.println("Mã nhân viên: " + employee);
        System.out.println("Ngày đặt hàng: " + orderDate);
        System.out.println("Danh sách sản phẩm: ");
        gh.inTenSPvaDonGia();
        System.out.println("Số lượng sản phẩm: " + quantity);
        System.out.println("Tổng giá trị đơn hàng: " + totalValue);
        System.out.println("Xác nhận thanh toán: " + paymentConfirmed);
        System.out.println("Xác nhận đơn hàng: " + orderConfirmed);
        System.out.println("Trạng thái đơn hàng: " + status);
    }
    public void addOrderInfoList(){
    String[] orderInfo = {orderCode, employee, productCode, formattedDate};
List<String[]> orderInfoList = new ArrayList<>();
orderInfoList.add(orderInfo);
    }
        // Thêm thông tin đơn hàng vào tệp tin "Ds đơn hàng"
        public void writefile1(){
            String fileName = "project_lthdt\\src\\ORDER\\dsdonhang.txt";
        try {
            FileWriter writer = new FileWriter(fileName);
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
        public void writefile2(){
        try {
            String fileName2="project_lthdt\\src\\ORDER\\dssanphamdonhang.txt";
            FileWriter writer = new FileWriter(fileName2);
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
                ", orderDate=" + formattedDate +
                ", sanPhamList=" + sanPhamList +
                ", quantity=" + quantity +
                ", totalValue=" + totalValue +
                ", paymentConfirmed=" + paymentConfirmed +
                ", orderConfirmed=" + orderConfirmed +
                ", status='" + status + '\'' +
                '}';
    }
}