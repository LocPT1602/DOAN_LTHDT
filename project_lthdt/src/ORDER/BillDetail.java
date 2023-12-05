package ORDER;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import PRODUCTS.SanPham;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class BillDetail {
    private String billDetailCode; // Mã chi tiết hóa đơn
    private String customerCode; // Mã khách hàng
    private String employeeCode; // Mã nhân viên
    private Bill bill; // Hóa đơn
    protected SanPham donGia;
    private String paymentMethod; // Phương thức thanh toán
    private int quantity; // Số lượng
    private LocalDate billDate; // Ngày trên hóa đơn

    // Constructors
    public BillDetail() {
        this.billDetailCode = "";
        this.customerCode = "";
        this.employeeCode = "";
        this.paymentMethod = "";
    }

    public BillDetail(String customerCode, String employeeCode, Bill bill, String paymentMethod, int quantity, SanPham donGia) {
        this.billDetailCode = generateBillDetailCode();
        this.customerCode = customerCode;
        this.employeeCode = employeeCode;
        this.bill = bill;
        this.paymentMethod = paymentMethod;
        this.quantity = quantity;
        this.billDate = LocalDate.now();
        this.donGia = donGia;
    }

    // Getters and Setters
    public String getBillDetailCode() {
        return billDetailCode;
    }

    public void setBillDetailCode(String billDetailCode) {
        this.billDetailCode = billDetailCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public SanPham getDonGia() {
        return this.donGia;
    }

    public void setDonGia(SanPham donGia) {
        this.donGia = donGia;
    }

    // Phương thức tính tổng giá trị hóa đơn
    public double calculateTotalAmount() {
        double totalAmount = donGia.getGia() * quantity;
        return totalAmount;
    }

    // Phương thức lấy thông tin hóa đơn chi tiết
    public String getBillDetail() {
        String billDetail = "Chi tiết hóa đơn:\n" +
                "Mã chi tiết hóa đơn: " + billDetailCode + "\n" +
                "Mã khách hàng: " + customerCode + "\n" +
                "Mã nhân viên: " + employeeCode + "\n" +
                "Mã hóa đơn: " + bill.getBillCode() + "\n" +
                "Phương thức thanh toán: " + paymentMethod + "\n" +
                "Số lượng: " + quantity + "\n" +
                "Ngày hóa đơn: " + billDate + "\n" +
                "Tổng giá trị: " + calculateTotalAmount();
        System.out.println(billDetail);
        return billDetail;
    }
    

    // Phương thức lấy thông tin đơn hàng và gán vào mảng bill
    public void getInfo(Bill[] bills) {
        // Ví dụ: Giả sử chúng ta có mtột một danh sách mã hóa đơn và giá sản phẩm
        int[] billCodes = {1, 2, 3};
        double[] donGia = {10.0, 20.0, 30.0};

        // Kiểm tra số lượng hóa đơn và độ dài của mảng có khớp nhau hay không
        if (bills.length != billCodes.length || bills.length != donGia.length) {
            System.out.println("Số lượng hóa đơn không khớp với độ dài của mảng");
            return;
        }

        for (int i = 0; i < bills.length; i++) {
            SanPham sanPham = new SanPham();
            sanPham.settenSP("Sản phẩm " + (i + 1));
            sanPham.setdonGia(donGia[i]);
            bills[i].addSanPham(sanPham);
        }
    }

    // Phương thức tự động tạo mã chi tiết hóa đơn
    private String generateBillDetailCode() {
        // Thực hiện logic để tạo mã chi tiết hóa đơn tại đây
        // Ví dụ: Mã tự động chạy từ 0001 và mỗi lần tạo sẽ tăng thêm 1
        // Bạn có thể thay đổi logic tạo mã phù hợp với yêu cầu của bạn
        // Trong ví dụ này, ta sẽ sử dụng một biến đếm để tạo mã
        // và đảm bảo mã luôn có 4 chữ số bằng cách thêm các số 0 vào đầu nếu cần
        int count = 1; // Bắt đầu từ 1
        String formattedCount = String.format("%04d", count); // Định dạng mã với 4 chữ số
        String billDetailCode = "CTHD" + formattedCount;
        // Tăng biến đếm để chuẩn bị cho lần tạo tiếp theo
        count++;
        return billDetailCode;
    }
 // Phương thức ghi thông tin hóa đơn chi tiết vào tập tin "listbilldetail"
 public void writeToFile(String fileName) {
    try (FileWriter writer = new FileWriter(fileName, true)) {
        writer.write(getBillDetail() + "\n");
        System.out.println("Thông tin hóa đơn đã được ghi vào tập tin: " + fileName);
    } catch (IOException e) {
        System.out.println("Đã xảy ra lỗi khi ghi vào tập tin: " + fileName);
        e.printStackTrace();
    }
}

// Phương thức cập nhật số lượng sản phẩm trong tập tin "kho"
public void updateFileKho(String fileName, String productName, int updatedQuantity) {
    try {
        List<String> lines = Files.readAllLines(Paths.get(fileName));

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");

            if (parts.length >= 2 && parts[0].trim().equals(productName)) {
                parts[1] = Integer.toString(updatedQuantity);
                line = String.join(",", parts);
                lines.set(i, line);
                break;
            }
        }

        Files.write(Paths.get(fileName), lines);
        System.out.println("Đã cập nhật số lượng sản phẩm trong tập tin: " + fileName);
    } catch (IOException e) {
        System.out.println("Đã xảy ra lỗi khi cập nhật số lượng sản phẩm trong tập tin: " + fileName);
        e.printStackTrace();
    }
}
}
