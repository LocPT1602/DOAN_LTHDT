package ORDER;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import PRODUCTS.SanPham;
import MAIN.Kiemtra;
import java.nio.file.Files;
import java.nio.file.Path;
import PRODUCTS.GioHang;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Order {
    private String orderCode; // Mã đơn hàng
    private String customer; // Mã khách hàng
    private String employee; // Mã nhân viên
    private String productCode; // Mã sản phẩm
    private LocalDateTime orderDate; // Ngày đặt hàng
    private List<SanPham> sanPhamList; // Danh sách sản phẩm
    private int quantity; // Số lượng sản phẩm
    private double totalValue; // Tổng giá trị đơn hàng
    private boolean paymentConfirmed; // Xác nhận thanh toán
    private boolean orderConfirmed; // Xác nhận đơn hàng
    private String status; // Trạng thái đơn hàng
    Kiemtra kt = new Kiemtra();
    GioHang gioHang = new GioHang();
    Scanner scanner = new Scanner(System.in);

    public Order(String orderCode, String customer, String employee, LocalDateTime orderDate, List<SanPham> sanPhamList,
            int quantity, double totalValue, boolean paymentConfirmed, boolean orderConfirmed, String status) {
        this.orderCode = orderCode;
        this.customer = customer;
        this.employee = employee;
        this.orderDate = LocalDateTime.now();
        this.sanPhamList = sanPhamList;
        this.quantity = quantity;
        this.totalValue = totalValue;
        this.paymentConfirmed = paymentConfirmed;
        this.orderConfirmed = orderConfirmed;
        this.status = status;
    }

    public Order() {
        this.orderDate = LocalDateTime.now();
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

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
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

    public void checkorderConfirmedTrue() {
        boolean validOrderConfirmed = false;
        while (!validOrderConfirmed) {
            String orderConfirmedInput = scanner.nextLine();
            if (orderConfirmedInput.equalsIgnoreCase("true")) {
                validOrderConfirmed = true;
                orderConfirmed = Boolean.parseBoolean(orderConfirmedInput);
            } else {
                System.out.println("Vui lòng nhập lại (true): để hoàn tất!");
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

    public void checkpaymentConfirmedTrue() {
        boolean validPaymentConfirmed = false;
        while (!validPaymentConfirmed) {
            String paymentConfirmedInput = scanner.nextLine();
            if (paymentConfirmedInput.equalsIgnoreCase("true")) {
                validPaymentConfirmed = true;
                paymentConfirmed = Boolean.parseBoolean(paymentConfirmedInput);
            } else {
                System.out.println("Vui lòng nhập lại (true): để hoàn tất!");
            }
        }
    }

    public void checkStatus() {
        System.out.println("Xác nhận thanh toán (true/false): ");
        checkpaymentConfirmed();
        System.out.println("Xác nhận đơn hàng (true/false): ");
        checkorderConfirmed();

        if (orderConfirmed && paymentConfirmed) {
            status = "Đã xác nhận";
        } else {
            if (!orderConfirmed && !paymentConfirmed) {
                System.out.println("Bạn chưa xác nhận đơn hàng! Chọn lại xác nhận đơn hàng (true)");
                checkorderConfirmedTrue();
                System.out.println("Bạn chưa xác nhận thanh toán! Chọn lại xác nhận thanh toán (true)");
                checkpaymentConfirmedTrue();
                status = "Đã xác nhận";

            } else if (!orderConfirmed) {
                System.out.println("Bạn chưa xác nhận đơn hàng! Chọn lại xác nhận đơn hàng (true)");
                checkorderConfirmedTrue();
                status = "Đã xác nhận";

            } else if (!paymentConfirmed) {
                System.out.println("Bạn chưa xác nhận thanh toán! Chọn lại xác nhận thanh toán (true)");
                checkpaymentConfirmedTrue();
                status = "Đã xác nhận";
            }
        }
    }

    public void docFileDanhsachspdadat() {
        try {
            FileReader fileReader = new FileReader("danhsachspdadat.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file.");
            e.printStackTrace();
        }
    }

    public int tinhSoLuongSanPham() {
        quantity = 0;
        try {
            FileReader fileReader = new FileReader("danhsachspdadat.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.readLine() != null) {
                quantity++;
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file.");
            e.printStackTrace();
        }

        return quantity;
    }

    public double tinhTongSoTien() {
        totalValue = 0;
        try {
            FileReader fileReader = new FileReader("danhsachspdadat.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    double donGia = Double.parseDouble(parts[1].trim());
                    totalValue += donGia;
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file.");
            e.printStackTrace();
        }

        return totalValue;
    }
    public void generateOrderCode() {
     Random random = new Random();
        int randomNumbers = random.nextInt(1000);
        String formattedRandomNumbers = String.format("%03d", randomNumbers);
        this.orderCode = "MDH" + formattedRandomNumbers;
    }
    // Phương thức nhập thông tin đơn hàng
    public void inputOrderInfo() {
        Scanner scanner = new Scanner(System.in);
        generateOrderCode();
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
        checkStatus();
    }

    // Phương thức xuất thông tin đơn hàng
    public void displayOrderInfo() {
        LocalDateTime orderDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy   HH:mm:ss");
        System.out.println("--------------------THONG TIN DON HANG------------------------");
        System.out.println("Ma don hang: " + orderCode);
        System.out.println("Ma khach hang: " + customer);
        System.out.println("Ma nhan vien phu trach: " + employee);
        System.out.println("Ngay tao don hang: " + orderDate.format(formatter));
        System.out.println("Danh sach san pham: ");
        gioHang.gioHangSize();
        docFileDanhsachspdadat();
        tinhSoLuongSanPham();
        tinhTongSoTien();
        System.out.println("So luong san pham: " + quantity);
        System.out.println("Tong gia tri don hang: " + totalValue);
        System.out.println("Xac nhan thanh toan: " + paymentConfirmed);
        System.out.println("Xac nhan don hang: " + orderConfirmed);
        System.out.println("Trang thai don hang: " + status);
        System.out.println("--------------------------------------------------------------");
    }

    public void ghiFileOrder() {
        String fileName = "ghiorder.txt";

        try {
            FileWriter writer = new FileWriter(fileName);

            StringBuilder sb = new StringBuilder();
            LocalDateTime orderDate = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy   HH:mm:ss");
            String sourceFilePath = "danhsachspdadat.txt";
            sb.append("--------------------THONG TIN DON HANG------------------------\n");
            generateOrderCode();
            sb.append("Ma don hang: ").append(orderCode).append("\n");
            sb.append("Ma khach hang: ").append(customer).append("\n");
            sb.append("Ma nhan vien phu trach: ").append(employee).append("\n");
            sb.append("Ngay tao don hang: ").append(orderDate.format(formatter)).append("\n");
            sb.append("Danh sach san pham: \n");
            sb.append("\n");
            gioHang.gioHangSize();
            List<String> lines = Files.readAllLines(Path.of(sourceFilePath));

            sb.append(String.join("\n", lines)).append("\n");
            sb.append("\n");
            tinhSoLuongSanPham();
            tinhTongSoTien();
            sb.append("So luong san pham: ").append(quantity).append("\n");
            sb.append("Tong gia tri don hang: ").append(totalValue).append("\n");
            sb.append("Xac nhan thanh toan: ").append(paymentConfirmed).append("\n");
            sb.append("Xac nhan don hang: ").append(orderConfirmed).append("\n");
            sb.append("Trang thai don hang: ").append(status).append("\n");
            sb.append("--------------------------------------------------------------\n");

            String orderInfo = sb.toString();

            writer.write(orderInfo);
            writer.close();

            System.out.println("Đã ghi thông tin đơn hàng vào file " + fileName);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi file.");
            e.printStackTrace();
        }
    }

    public void addOrderInfoList() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy   HH:mm:ss");
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
            try {
                FileReader fileReader = new FileReader("danhsachspdadat.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    writer.write(line);
                }
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Lỗi khi đọc file.");
                e.printStackTrace();
            }
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
        order.ghiFileOrder();
    }
}
