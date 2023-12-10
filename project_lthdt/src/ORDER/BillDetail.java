package ORDER;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import PAYMENTMETHOD.*;
// import PERSON.*;
import PRODUCTS.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class BillDetail {
    Scanner scanner = new Scanner(System.in);

    private String billDetailCode; // Mã chi tiết hóa đơn
    private Order customer; // Mã khách hàng
    private Order employee; // Mã nhân viên
    private ArrayList<SanPham> billList;
    private Payment paymentMethod; // Phương thức thanh toán
    private int quantityBill; // Số lượng
    private LocalDateTime billDate; // Ngày trên hóa đơn
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

    public BillDetail(Order order) {
        this.billDetailCode = generateInvoiceDetailCode();
        this.billList = new ArrayList<>();
        this.order = order;
    }

    public BillDetail(String billDetailCode, Order customer, Order employee, Payment paymentMethod,
            int quantityBill, LocalDateTime billDate) {
        this.billDetailCode = billDetailCode;
        this.customer = customer;
        this.employee = employee;
        this.billDate = billDate;
        this.paymentMethod = paymentMethod;
        this.quantityBill = quantityBill;
    }

    // Getters and Setters

    public void setOrder(Order order) {
        this.order = order;
    }

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

    public LocalDateTime getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDateTime billDate) {
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
        String fileName = "ghiorder.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean skipHeader = true;
            System.out.println("-----------------Thông tin chi tiết hóa đơn----------------------");
            generateBillDetailCode();
            System.out.println("Mã chi tiết hóa đơn: " + billDetailCode);
            while ((line = reader.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                System.out.println(line);

            }

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc file.");
            e.printStackTrace();
        }
    }

    public void generateBillDetailCode() {
        Random random = new Random();
        int randomNumbers = random.nextInt(1000);
        String formattedRandomNumbers = String.format("%03d", randomNumbers);
        billDetailCode = "MHD" + formattedRandomNumbers;
    }

    // Phương thức ghi thông tin hóa đơn vào tập tin văn bản
    public void writeToFile() {
        LocalDateTime billDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");
        String fileName = "project_lthdt/src/ORDER/Billdetail.txt";
        String sourceFilePath = "danhsachspdadat.txt";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append("----------Chi tiết hóa đơn------------\n");
            sb.append("Mã chi tiết hóa đơn: ").append(this.billDetailCode).append("\n");
            sb.append("Mã khách hàng: ").append(order.getCustomer()).append("\n");
            sb.append("Mã nhân viên phụ trách: ").append(order.getEmployee()).append("\n");
            sb.append("Danh sách Sản phẩm: \n");
            gh.gioHangSize();
            order.tinhSoLuongSanPham();
            order.tinhTongSoTien();

            List<String> lines = Files.readAllLines(Path.of(sourceFilePath));

            sb.append(String.join("\n", lines)).append("\n");
            sb.append("Tổng số lượng sản phẩm: ").append(order.getQuantity()).append("\n");
            sb.append("Ngày hóa đơn: ").append(billDate.format(formatter)).append("\n");
            sb.append("Tình trạng đơn hàng: ").append(order.getStatus()).append("\n");
            sb.append("Tổng giá trị đơn hàng: ").append(order.getTotalValue()).append("\n");

            FileWriter writer = new FileWriter(fileName, true);
            writer.write(sb.toString());
            writer.close();
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
                System.out.println("\n");
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
        Order order = new Order();
        BillDetail billDetail = new BillDetail(order);
        order.inputOrderInfo();
        order.displayOrderInfo();
        billDetail.getBillDetail();
        billDetail.writeToFile();
        billDetail.readProductData();
    }
}