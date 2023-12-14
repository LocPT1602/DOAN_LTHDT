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
    private Order orderCode; // Ma hoa don
    private ArrayList<SanPham> billList;
    private Payment paymentMethod; // Phương thức thanh toán
    private int quantityBill; // Số lượng
    private LocalDateTime billDate; // Ngày trên hóa đơn
    private int counter = 1;
    // HoaDon hoaDon = new HoaDon();
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

    public BillDetail(String billDetailCode, Order customer, Order employee, Order orderCode, Payment paymentMethod,
            int quantityBill, LocalDateTime billDate) {
        this.billDetailCode = billDetailCode;
        this.customer = customer;
        this.employee = employee;
        this.billDate = billDate;
        this.paymentMethod = paymentMethod;
        this.quantityBill = quantityBill;
        this.orderCode = orderCode;
    }

    // Getters and Setters

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return this.order;
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
        this.customer = order;
    }

    public Order getEmployee() {
        return employee;
    }

    public void setEmployee(Order employee) {
        this.employee = employee;
    }

    public Order getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Order orderCode) {
        this.orderCode = orderCode;
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
            // System.out.println("Mã hóa đơn: " + hoaDon.getMaHD());
            while ((line = reader.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                System.out.println(line);

            }
            order.docFileInBill();
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
        String sourceFilePath = "ghiorder.txt";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append("--------------------Chi tiết hóa đơn-----------------------\n");
            sb.append("Mã chi tiết hóa đơn: ").append(this.billDetailCode).append("\n");

            List<String> lines = Files.readAllLines(Path.of(sourceFilePath));

            for (String line : lines) {
                if (!line.contains("THONG TIN DON HANG")) {
                    sb.append(line).append("\n");
                }
            }
        
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(sb.toString());
            writer.close();
            System.out.println("Hóa đơn đã được tạo và lưu vào tập tin Billdetail.txt");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi vào tập tin: " + fileName);
            e.printStackTrace();
        }
    }

    public void deleteBillDetail() {
        String fileName = "project_lthdt/src/ORDER/Billdetail.txt";
        boolean foundBillDetail = false;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Nhập mã chi tiết hóa đơn cần xoá (nhập 'x' để thoát): \n");
                billDetailCode = scanner.nextLine();
                if (billDetailCode.equalsIgnoreCase("x")) {
                    System.out.println("Thoát khỏi chương trình xoá chi tiết hóa đơn.");
                    return;
                }

                List<String> lines = Files.readAllLines(Path.of(fileName));
                List<String> updatedLines = new ArrayList<>();

                boolean isDeleting = false;
                boolean foundStartLine = false;

                for (String line : lines) {
                    if (line.contains("--------------------Chi tiết hóa đơn-----------------------")) {
                        foundStartLine = true;
                        updatedLines.add(line);
                        continue;
                    }

                    if (foundStartLine) {
                        if (!isDeleting && line.contains("Mã chi tiết hóa đơn: " + billDetailCode)) {
                            isDeleting = true;
                            foundBillDetail = true;
                            continue;
                        }

                        if (isDeleting
                                && line.contains("--------------------------------------------------------------")) {
                            isDeleting = false;
                            continue;
                        }
                    }

                    updatedLines.add(line);
                }

                if (foundBillDetail) {
                    Files.write(Path.of(fileName), updatedLines, StandardOpenOption.TRUNCATE_EXISTING);
                    System.out.println("Chi tiết hóa đơn đã được xoá thành công!\n");
                } else {
                    System.out.println("Mã chi tiết hóa đơn không tồn tại! Vui lòng nhập lại!\n");
                    // billDetailCode = scanner.nextLine();
                }
            } catch (IOException e) {
                System.out.println("Đã xảy ra lỗi khi xoá chi tiết hóa đơn.\n");
                e.printStackTrace();
            }
        } while (!foundBillDetail);
    }

    public void searchBillByBillDetailCode() {
        String fileName = "project_lthdt/src/ORDER/Billdetail.txt";
        boolean foundBill = false;
    
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập mã chi tiết hóa đơn cần tìm kiếm (nhập 'x' để thoát): ");
            String billDetailCode = scanner.nextLine();
    
            if (billDetailCode.equalsIgnoreCase("x")) {
                System.out.println("Thoát khỏi chương trình tìm kiếm hóa đơn.\n");
                return;
            }
    
            List<String> lines = Files.readAllLines(Path.of(fileName));
    
            boolean isSearching = false;
            StringBuilder billInfo = new StringBuilder();
    
            for (String line : lines) {
                if (line.contains("--------------------Chi tiết hóa đơn-----------------------")) {
                    isSearching = true;
                    billInfo = new StringBuilder();
                    billInfo.append(line).append("\n");
                    continue;
                }
    
                if (isSearching) {
                    billInfo.append(line).append("\n");
    
                    if (line.contains("Mã chi tiết hóa đơn: " + billDetailCode)) {
                        foundBill = true;
                    }
    
                    if (line.contains("--------------------------------------------------------------")) {
                        isSearching = false;
                        if (foundBill) {
                            System.out.println("Đây là chi tiết hóa đơn có mã " + billDetailCode + ":");
                            System.out.println(billInfo);
                            break; //Thêm break ở đây để chỉ in ra chi tiết của hóa đơn đầu tiên tìm thấy
                        }
                    }
                }
            }
    
            if (!foundBill) {
                System.out.println("Mã chi tiết hóa đơn không tồn tại!\n");
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi tìm kiếm hóa đơn!\n");
            e.printStackTrace();
        }
    }

    public void xuatAllBillDetail() {
        String fileName = "project_lthdt/src/ORDER/Billdetail.txt";
    
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi xuất tệp Billdetail.txt!");
            e.printStackTrace();
        }
    }

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
        // HoaDon hd = new HoaDon();
        // hd.nhap();
        // order.inputOrderInfo();
        // order.displayOrderInfo();
        // billDetail.getBillDetail();
        billDetail.writeToFile();
        // billDetail.searchBillByBillDetailCode();
        // billDetail.deleteBillDetail();
        // billDetail.xuatAllBillDetail(); 
        // billDetail.readProductData();
    }
}