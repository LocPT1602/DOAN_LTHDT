package ORDER;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class BillDetail  {
    private int billDetailCode; // Mã chi tiết hóa đơn
    private int customerCode; // Mã khách hàng
    private int employeeCode; // Mã nhân viên
    private Bill bill; // Hóa đơn
    private String paymentMethod; // Phương thức thanh toán
    private int quantity; // Số lượng
    private LocalDate billDate; // Ngày trên hóa đơn

    public BillDetail() {
    }

    public BillDetail(int billDetailCode, int customerCode, int employeeCode, Bill bill, String paymentMethod, int quantity, LocalDate billDate) {
        this.billDetailCode = billDetailCode;
        this.customerCode = customerCode;
        this.employeeCode = employeeCode;
        this.bill = bill;
        this.paymentMethod = paymentMethod;
        this.quantity = quantity;
        this.billDate = billDate;
    }

     //Get và Set
    public int getBillDetailCode() {
        return billDetailCode;
    }

    public void setBillDetailCode(int billDetailCode) {
        this.billDetailCode = billDetailCode;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
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

    // Phương thức tính tổng giá trị hóa đơn
    public double calculateTotalAmount() {
        double totalAmount = bill.getProductPrice() * quantity;
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
        return billDetail;
    }

    // Phương thức ghi thông tin hóa đơn vào tập tin văn bản
    public void writeToFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(getBillDetail());
            writer.close();
            System.out.println("Thông tin hóa đơn đã được ghi vào tập tin: " + fileName);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi vào tập tin: " + fileName);
            e.printStackTrace();
        }
    }
 public static void main(String[] args) {
        BillDetail billDetail = new BillDetail();
        billDetail.setBillDetailCode(1);
        billDetail.setCustomerCode(123);
        billDetail.setEmployeeCode(456);

        // Tạo đối tượng Bill và gán vào biến bill
        Bill bill = new Bill();
        bill.setBillCode("ABC123");
        bill.setProductPrice(10.0);

        billDetail.setBill(bill);
        billDetail.setPaymentMethod("Credit Card");
        billDetail.setQuantity(5);
        billDetail.setBillDate(LocalDate.now());

        billDetail.writeToFile("billdetail.txt");
    }
}