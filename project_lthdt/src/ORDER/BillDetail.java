package ORDER;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import PAYMENTMETHOD.*;
// import PERSON.*;
import PRODUCTS.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BillDetail {
    Scanner scanner = new Scanner(System.in);

    private String billDetailCode; // Mã chi tiết hóa đơn
    private Order customer; // Mã khách hàng
    private Order employee; // Mã nhân viên
    private ArrayList<SanPham> billList;
    private Payment paymentMethod; // Phương thức thanh toán
    private int quantityBill; // Số lượng
    private LocalDate billDate; // Ngày trên hóa đơn
    private int counter = 1;
    HoaDon hoaDon = new HoaDon();
    GioHang gh = new GioHang();
    Order order = new Order();

    private String generateInvoiceDetailCode() {
        // Định dạng mã chi tiết hóa đơn thành chuỗi có độ dài 4 chữ số
        String billDetailCode = String.format("%04d", counter);
        // Tăng giá trị của biến đếm lên 1 cho lần tạo mã tiếp theo
        counter++;
        // Trả về mã chi tiết hóa đơn đã được tạo
        return billDetailCode;
    }

    // Constructors

    public BillDetail() {
        this.billDetailCode = generateInvoiceDetailCode();
        this.billList = new ArrayList<>();
    }

    public BillDetail(String billDetailCode, Order customer, Order employee, Payment paymentMethod,
            int quantityBill, LocalDate billDate) {
        this.billDetailCode = billDetailCode;
        this.customer = customer;
        this.employee = employee;
        this.billDate = billDate;
        this.paymentMethod = paymentMethod;
        this.quantityBill = billList.size();
        this.billDate = LocalDate.now();
    }

    // Getters and Setters
    public String getBillDetailCode() {
        return billDetailCode;
    }

    public void setBillDetailCode(String billDetailCode) {
        this.billDetailCode = billDetailCode;
    }

    public Order getCustomer() {
        return customer;
    }

    public void setCustomer(Order customer) {
        this.customer = customer;
    }

    public Order getEmployee() {
        return employee;
    }

    public void setEmployee(Order employee) {
        this.employee = employee;
    }

    public ArrayList<SanPham> getBillList() {
        return billList;
    }

    public void setBillList(ArrayList<SanPham> billList) {
        this.billList = billList;
    }

    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getQuantityBill() {
        return quantityBill;
    }

    public void setQuantityBill(int quantityBill) {
        this.quantityBill = quantityBill;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    // Phương thức tính tổng giá trị hóa đơn
    public double calculateTotalAmount() {
        double totalAmount = 0;
        for (SanPham sanPham : billList) {
            totalAmount += sanPham.getDonGia();
        }
        return totalAmount;
    }

    // Phương thức lấy thông tin hóa đơn chi tiết
    public void getBillDetail() {
        Random random = new Random();
        int randomNumbers = random.nextInt(1000);
        String formattedRandomNumbers = String.format("%03d", randomNumbers);
        String billDetailCode = "MHD" + formattedRandomNumbers;

        this.billDetailCode = billDetailCode;
        LocalDate billDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("----------Chi tiết hóa đơn:------------");
        System.out.println("Mã chi tiết hóa đơn: " + this.billDetailCode);
        System.out.println("Mã khách hàng: " + order.getCustomer());
        System.out.println("Mã nhân viên: " + order.getEmployee());
        System.out.println("Mã hóa đơn: " + hoaDon.getMaHD());
        System.out.println("Danh sách Sản phẩm: ");
        gh.inTenSPvaDonGia();
        // System.out.println("Phương thức thanh toán: " +
        // paymentMethod.getPhuongthuc());
        System.out.println("Ngày hóa đơn: " + billDate.format(formatter));
        System.out.println("Tổng giá trị: " + calculateTotalAmount());

    }

    // Phương thức ghi thông tin hóa đơn vào tập tin văn bản
    public void writeToFile() {
        LocalDate billDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fileName = "project_lthdt/src/ORDER/Billdetail.txt";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("----------Chi tiết hóa đơn:------------\n");
            sb.append("Mã chi tiết hóa đơn: ").append(this.billDetailCode).append("\n");
            sb.append("Mã khách hàng: ").append(order.getCustomer()).append("\n");
            sb.append("Mã nhân viên: ").append(order.getEmployee()).append("\n");
            sb.append("Mã hóa đơn: ").append(hoaDon.getMaHD()).append("\n");
            sb.append("Danh sách Sản phẩm: \n");
            for (SanPham sanPham : billList) {
                sb.append(sanPham.getTenSP()).append(" | ").append(sanPham.getDonGia()).append("\n");
            }
            // sb.append("Phương thức thanh toán:
            // ").append(paymentMethod.getPhuongthuc()).append("\n");
            sb.append("Ngày hóa đơn: ").append(billDate.format(formatter)).append("\n");
            sb.append("Tổng giá trị: ").append(calculateTotalAmount()).append("\n");

            FileWriter writer = new FileWriter(fileName);
            writer.write(sb.toString());
            writer.close();
            System.out.println("Thông tin hóa đơn đã được ghi vào tập tin: " + fileName);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi vào tập tin: " + fileName);
            e.printStackTrace();
        }
    }

    // public void getinformation() {

    // }
    public void readProductData() {
        String fileName = "datasanpham.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                String productName = data[3];
                String productCode = data[1];
                double price = Double.parseDouble(data[3]);

                // In thông tin sản phẩm
                System.out.println("Tên sản phẩm: " + productName);
                System.out.println("Mã sản phẩm: " + productCode);
                System.out.println("Giá: " + price);
                System.out.println("------------------");
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc file: " + fileName);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BillDetail billDetail = new BillDetail();
        Order order = new Order();
        order.inputOrderInfo();
        order.displayOrderInfo();
        billDetail.getBillDetail();
        billDetail.writeToFile();
        billDetail.readProductData();
    }
}