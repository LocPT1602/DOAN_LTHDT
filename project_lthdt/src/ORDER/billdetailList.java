package ORDER;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
<<<<<<< HEAD
import ORDER.order;

=======
import ORDER.BillDetail;
>>>>>>> parent of 34d247d (mdsgajs)
public class billdetailList {
    private List<BillDetail> billDetails; // Danh sách các chi tiết hóa đơn
    private int maxSize; // Kích thước tối đa
    order order = new order();

    public billdetailList() {
        billDetails = new ArrayList<>();
        maxSize = 100;
    }
Scanner scanner = new Scanner(System.in);
    public int getSize() {
        return billDetails.size(); // Trả về kích thước hiện tại của danh sách
    }

    public int getMaxSize() {
        return maxSize; // Trả về kích thước tối đa
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize; // Thiết lập kích thước tối đa
    }

    public void addBillDetail(BillDetail billDetail) {
        if (billDetails.size() < maxSize) {
            billDetails.add(billDetail);
            System.out.println("Thêm chi tiết hóa đơn thành công."); // Đầu ra: Thêm chi tiết hóa đơn thành công.
        } else {
            System.out.println("Đã đạt đến kích thước tối đa của danh sách. Không thể thêm chi tiết hóa đơn mới."); // Đầu ra: Đã đạt đến kích thước tối đa của danh sách. Không thể thêm chi tiết hóa đơn mới.
        }
    }

    public void displayBillDetails() {
        if (billDetails.isEmpty()) {
            System.out.println("Danh sách chi tiết hóa đơn trống."); // Đầu ra: Danh sách chi tiết hóa đơn trống.
        } else {
            System.out.println("Các chi tiết hóa đơn trong danh sách:"); // Đầu ra: Các chi tiết hóa đơn trong danh sách:
            for (BillDetail billDetail : billDetails) {
                System.out.println(billDetail); // Đầu ra: Chi tiết hóa đơn
            }
        }
    }

<<<<<<< HEAD
    public void addBillDetailFromOrder(order  orderObj) {
        order.setorderCode(orderObj.getorderCode());
        order.setCustomerCode(orderObj.getCustomerCode());
        order.setEmployeeCode(orderObj.getEmployeeCode());
        order.setorderDate(orderObj.getorderDate());
        order.setSanPhamList(orderObj.getSanPhamList());
        order.setQuantity(orderObj.getQuantity());
        order.setTotalValue(orderObj.getTotalValue());
    }
    
=======
    public void addBillDetailFromOrder(order order) {
        BillDetail billDetail = new BillDetail();
        // Thiết lập các thuộc tính của billDetail từ BillDetail
        billDetail.setBillDetailCode(billDetail.getBillDetailCode());
        billDetail.setCustomerCode(billDetail.getCustomerCode());
        billDetail.setEmployeeCode(billDetail.getEmployeeCode());
        billDetail.setBill(billDetail.getBill());
        billDetail.setPaymentMethod(billDetail.getPaymentMethod());
        billDetail.setQuantity(billDetail.getQuantity());
        billDetail.setBillDate(billDetail.getBillDate());
        // ...
    
        addBillDetail(billDetail);
    }
    
   
>>>>>>> parent of 34d247d (mdsgajs)
    public BillDetail findBillDetailByCode(int billDetailCode) {
        for (BillDetail billDetail : billDetails) {
            if (billDetail.getBillDetailCode() == billDetailCode) {
                return billDetail;
            }
        }
        return null; // Trả về null nếu không tìm thấy chi tiết hóa đơn phù hợp
    }

<<<<<<< HEAD
    public void removeBillDetailByCode(int billDetailCode) {
=======
    public void removeBillDetailById(int billDetailCode) {
>>>>>>> parent of 34d247d (mdsgajs)
        BillDetail billDetailToRemove = findBillDetailByCode(billDetailCode);
        if (billDetailToRemove != null) {
            billDetails.remove(billDetailToRemove);
            System.out.println("Đã xóa chi tiết hóa đơn có ID " + billDetailCode + "."); // Đầu ra: Đã xóa chi tiết hóa đơn có ID {id}.
        } else {
            System.out.println("Không tìm thấy chi tiết hóa đơn có ID " + billDetailCode + " trong danh sách."); // Đầu ra: Không tìm thấy chi tiết hóa đơn có ID {id} trong danh sách.
        }
    }

    public void writeToFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (BillDetail billDetail : billDetails) {
                writer.write(billDetail.toString());
                writer.write("\n");
            }
            writer.close();
            System.out.println("Đã ghi các chi tiết hóa đơn vào tệp: " + fileName); // Đầu ra: Đã ghi các chi tiết hóa đơn vào tệp: {fileName}
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi vào tệp: " + fileName); // Đầu ra: Đã xảy ra lỗi khi ghi vào tệp: {fileName}
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    billdetailList billdetailList = new billdetailList();
   
}
    }
