package ORDER;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import PRODUCTS.SanPham;

public class BillDetail {
    private String billDetailCode; // Mã chi tiết hóa đơn
    private String customerCode; // Mã khách hàng
    private String employeeCode; // Mã nhân viên
    private bill bill; // Hóa đơn
    protected SanPham donGia;
    private String paymentMethod; // Phương thức thanh toán
    private int quantity; // Số lượng
    private LocalDate billDate; // Ngày trên hóa đơn

    // Constructors
    public BillDetail() {
        this.billDetailCode="";
        this.customerCode="";
        this.employeeCode="";
        this.paymentMethod="";
        
    }

    public BillDetail(String billDetailCode, String customerCode, String employeeCode, bill bill, String paymentMethod, int quantity, LocalDate billDate, SanPham donGia) {
        this.billDetailCode = billDetailCode;
        this.customerCode = customerCode;
        this.employeeCode = employeeCode;
        this.bill = bill;
        this.paymentMethod = paymentMethod;
        this.quantity = quantity;
        this.billDate = billDate;
        this.donGia=donGia;
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

    public bill getBill() {
        return bill;
    }

    public void setBill(bill bill) {
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

    public SanPham getDonGia(){
        return this.donGia;
    }
    public void setDonGia(SanPham donGia) {
        this.donGia = donGia;
    }
    // Phương thức tính tổng giá trị hóa đơn
    public double calculateTotalAmount() {
        double totalAmount = SanPham.getDonGia() * quantity;
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
    // Phương thức ghi thông tin hóa đơn vào tập tin văn bản
    public void writeToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(getBillDetail());
            System.out.println("Thông tin hóa đơn đã được ghi vào tập tin: " + fileName);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi vào tập tin: " + fileName);
            e.printStackTrace();
        }
    }

   // Phương thức lấy thông tin đơn hàng và gán vào mảng bill
public void getInfo(bill[] bills) {
    // Lấy thông tin đơn hàng từ nguồn dữ liệu hoặc các tham số truyền vào
    // Ví dụ: giả sử có danh sách mã hóa đơn và giá sản phẩm
    
    int[] billCodes = {1, 2, 3};
    double[] donGia = {10.0, 20.0, 30.0};
    
    // Kiểm tra số lượng đơn hàng và mảng bills có cùng kích thước hay không
    if (billCodes.length == donGia.length && billCodes.length == bills.length) {
        // Lấy thông tin từng đơn hàng và gán vào mảng bills
        for (int i = 0; i < bills.length; i++) {
            bill bill = new bill();
            bill.setBillCode("BILL-" + billCodes[i]);
            bill.setdonGia( donGia[i]);
            
            bills[i] = bill;
        }
    } else {
        System.out.println("Số lượng đơn hàng không khớp với kích thước của mảng bills.");
    }
}

    public static void main(String[] args) {
        BillDetail billDetail = new BillDetail();
        String fileName = "project_lthdt\\src\\ORDER\\billdetail.txt";
        billDetail.setBillDetailCode(null);
        billDetail.setCustomerCode(null);
        billDetail.setEmployeeCode(null);

        // Tạo đối tượng Bill và gán vào biến bill
        bill bill = new bill();
        bill.setBillCode("ABC123");
        bill.setdonGia(10);

        billDetail.setBill(bill);
        billDetail.setPaymentMethod("Credit Card");
        billDetail.setQuantity(90);
        billDetail.setBillDate(LocalDate.now());
        billDetail.getBillDetail();
        billDetail.writeToFile(fileName);
    }
}