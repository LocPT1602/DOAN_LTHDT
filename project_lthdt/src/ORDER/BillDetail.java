package ORDER;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import PAYMENTMETHOD.*;
import PERSON.*;
import PRODUCTS.*;
import java.util.ArrayList;
import java.util.List;

public class BillDetail {
    private String billDetailCode; // Mã chi tiết hóa đơn
    private Customer customer; // Mã khách hàng
    private Employee employee; // Mã nhân viên
    private ArrayList<SanPham> billList;
    private Payment paymentMethod; // Phương thức thanh toán
    private int quantityBill; // Số lượng
    private LocalDate billDate; // Ngày trên hóa đơn
    HoaDon hoaDon = new HoaDon();
    GioHang gh = new GioHang();
    private String generateInvoiceDetailCode() {
        // Định dạng mã chi tiết hóa đơn thành chuỗi có độ dài 4 chữ số
        String billDetailCode = String.format("%04d", counter);
        // Tăng giá trị của biến đếm lên 1 cho lần tạo mã tiếp theo
        counter++;
        // Trả về mã chi tiết hóa đơn đã được tạo
        return billDetailCode;
    }

    // Constructors
    private static int counter = 1;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
    String formattedDate = billDate.format(formatter);

    public BillDetail() {
        this.billDetailCode = generateInvoiceDetailCode();
        this.billList = new ArrayList<>();
    }

    public BillDetail(String billDetailCode, Customer customer, Employee employee, Payment paymentMethod,
            int quantityBill, LocalDate billDate) {
        this.billDetailCode = billDetailCode;
        this.customer = customer;
        this.employee = employee;
        this.billDate = billDate;
        this.paymentMethod = paymentMethod;
        this.quantityBill = billList.size();
        this.billDate = billDate;
    }

    // Getters and Setters
    public String getBillDetailCode() {
        return billDetailCode;
    }

    public void setBillDetailCode(String billDetailCode) {
        this.billDetailCode = billDetailCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
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
        System.out.println("----------Chi tiết hóa đơn:------------" );
        System.out.println("Mã chi tiết hóa đơn: " + this.billDetailCode);
        System.out.println("Mã khách hàng: " + customer.getCustomerid());
        System.out.println("Mã nhân viên: " + employee.getEmployeeid());
        System.out.println("Mã hóa đơn: " + hoaDon.getMaHD());
        System.out.println("Danh sách Sản phẩm: " );
        gh.inTenSPvaDonGia();
        System.out.println("Phương thức thanh toán: " + paymentMethod.getPhuongthuc());
        System.out.println("Ngày hóa đơn: " + formattedDate);
        System.out.println("Tổng giá trị: " + calculateTotalAmount());
        
    }

    // Phương thức ghi thông tin hóa đơn vào tập tin văn bản
    // Phương thức ghi thông tin hóa đơn vào tập tin văn bản
public void writeToFile() {
    String fileName = "project_lthdt\\src\\ORDER\\Billdetail.txt";
    try (FileWriter writer = new FileWriter(fileName)) {
        StringBuilder sb = new StringBuilder();
        sb.append("----------Chi tiết hóa đơn:------------\n");
        sb.append("Mã chi tiết hóa đơn: ").append(this.billDetailCode).append("\n");
        sb.append("Mã khách hàng: ").append(customer.getCustomerid()).append("\n");
        sb.append("Mã nhân viên: ").append(employee.getEmployeeid()).append("\n");
        sb.append("Mã hóa đơn: ").append(hoaDon.getMaHD()).append("\n");
        sb.append("Danh sách Sản phẩm: \n");
        for (SanPham sanPham : billList) {
            sb.append(sanPham.getTenSP()).append(" | ").append(sanPham.getDonGia()).append("\n");
        }
        sb.append("Phương thức thanh toán: ").append(paymentMethod.getPhuongthuc()).append("\n");
        sb.append("Ngày hóa đơn: ").append(formattedDate).append("\n");
        sb.append("Tổng giá trị: ").append(calculateTotalAmount()).append("\n");

        writer.write(sb.toString());
        System.out.println("Thông tin hóa đơn đã được ghi vào tập tin: " + fileName);
    } catch (IOException e) {
        System.out.println("Đã xảy ra lỗi khi ghi vào tập tin: " + fileName);
        e.printStackTrace();
    }
}

    // public void getinformation() {

    // }

    public static void main(String[] args) {
        // BillDetail billDetail = new BillDetail();
        // billDetail.getBillDetail();
        // billDetail.writeToFile();
    }
}