package ORDER;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class BillDetail {
    private int billDetailCode; // Mã chi tiết hóa đơn
    private int customerCode; // Mã khách hàng
    private int employeeCode; // Mã nhân viên
    private bill bill; // Hóa đơn
    private String paymentMethod; // Phương thức thanh toán
    private int quantity; // Số lượng
    private LocalDate billDate; // Ngày trên hóa đơn

    // Constructors
    public BillDetail() {
    }

    public BillDetail(int billDetailCode, int customerCode, int employeeCode, bill bill, String paymentMethod, int quantity, LocalDate billDate) {
        this.billDetailCode = billDetailCode;
        this.customerCode = customerCode;
        this.employeeCode = employeeCode;
        this.bill = bill;
        this.paymentMethod = paymentMethod;
        this.quantity = quantity;
        this.billDate = billDate;
    }

    // Getters and Setters
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
    double[] productPrices = {10.0, 20.0, 30.0};
    
    // Kiểm tra số lượng đơn hàng và mảng bills có cùng kích thước hay không
    if (billCodes.length == productPrices.length && billCodes.length == bills.length) {
        // Lấy thông tin từng đơn hàng và gán vào mảng bills
        for (int i = 0; i < bills.length; i++) {
            bill bill = new bill();
            bill.setBillCode("BILL-" + billCodes[i]);
            bill.setProductPrice(productPrices[i]);
            
            bills[i] = bill;
        }
    } else {
        System.out.println("Số lượng đơn hàng không khớp với kích thước của mảng bills.");
    }
}

    public static void main(String[] args) {
        BillDetail billDetail = new BillDetail();
        String fileName = "project_lthdt\\src\\ORDER\\billdetail.txt";
        billDetail.setBillDetailCode(1);
        billDetail.setCustomerCode(123);
        billDetail.setEmployeeCode(456);

        // Tạo đối tượng Bill và gán vào biến bill
        bill bill = new bill();
        bill.setBillCode("ABC123");
        bill.setProductPrice(10.0);

        billDetail.setBill(bill);
        billDetail.setPaymentMethod("Credit Card");
        billDetail.setQuantity(90);
        billDetail.setBillDate(LocalDate.now());
        billDetail.getBillDetail();
        billDetail.writeToFile(fileName);
    }
}