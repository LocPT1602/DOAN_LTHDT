package ORDER;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
<<<<<<< HEAD
=======
import java.util.Scanner;
>>>>>>> parent of 34d247d (mdsgajs)

public class BillDetail {
    private int billDetailCode; // Mã chi tiết hóa đơn
    private int customerCode; // Mã khách hàng
    private int employeeCode; // Mã nhân viên
    private bill bill; // Hóa đơn
    private String paymentMethod; // Phương thức thanh toán
    private int quantity; // Số lượng
    private LocalDate billDate; // Ngày trên hóa đơn
    Scanner sc = new Scanner(System.in);

    public BillDetail() {
<<<<<<< HEAD
    }

    public BillDetail(int billDetailCode, int customerCode, int employeeCode, bill bill, String paymentMethod, int quantity, LocalDate billDate) {
=======
        this.billDetailCode = 0;
        this.customerCode = 0;
        this.employeeCode = 0;
        this.paymentMethod = " ";
        this.quantity = 0;
        this.billDate = null;
    }

    public BillDetail(int billDetailCode, int customerCode, int employeeCode, bill bill, String paymentMethod,
            int quantity, LocalDate billDate) {
>>>>>>> parent of 34d247d (mdsgajs)
        this.billDetailCode = billDetailCode;
        this.customerCode = customerCode;
        this.employeeCode = employeeCode;
        this.bill = bill;
        this.paymentMethod = paymentMethod;
        this.quantity = quantity;
        this.billDate = billDate;
    }

<<<<<<< HEAD
    // Getters and Setters
=======
    // Get và Set
>>>>>>> parent of 34d247d (mdsgajs)
    public int getBillDetailCode() {
        return billDetailCode;
    }

    public void setBillDetailCode(int billDetailCode) {
<<<<<<< HEAD
        this.billDetailCode = billDetailCode;
=======
        billDetailCode = sc.nextInt();
>>>>>>> parent of 34d247d (mdsgajs)
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
<<<<<<< HEAD
        this.customerCode = customerCode;
=======
        this.customerCode = sc.nextInt();
>>>>>>> parent of 34d247d (mdsgajs)
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
<<<<<<< HEAD
        this.employeeCode = employeeCode;
=======
        this.employeeCode = sc.nextInt();
>>>>>>> parent of 34d247d (mdsgajs)
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
        this.paymentMethod = sc.nextLine();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = sc.nextInt();
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = LocalDate.now();
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
    public void writeToFile(String fileName, String billDetail) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(billDetail);
            writer.close();
            System.out.println("Thông tin hóa đơn đã được ghi vào tập tin: " + fileName);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi vào tập tin: " + fileName);
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
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
=======
    public static void main(String[] args) {
        BillDetail billDetail = new BillDetail();
>>>>>>> parent of 34d247d (mdsgajs)
        billDetail.setBillDetailCode(1);
        billDetail.setCustomerCode(123);
        billDetail.setEmployeeCode(456);

        // Tạo đối tượng Bill và gán vào biến bill
        bill bill = new bill();
        bill.setBillCode("ABC123");
        bill.setProductPrice(10.0);
<<<<<<< HEAD

=======
        String fileName = "billdetail.txt";
>>>>>>> parent of 34d247d (mdsgajs)
        billDetail.setBill(bill);
        billDetail.setPaymentMethod("Credit Card");
        billDetail.setQuantity(5);
        billDetail.setBillDate(LocalDate.now());

        billDetail.writeToFile("billdetail.txt", billDetail.toString());
    }
}
