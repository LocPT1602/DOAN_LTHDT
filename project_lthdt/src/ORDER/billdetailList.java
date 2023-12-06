package ORDER;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import PERSON.Customer;
import ORDER.*;
public class billdetailList {
    private List<BillDetail> billDetails; // Danh sách các chi tiết hóa đơn
    private int maxSize; // Kích thước tối đa

    public billdetailList() {
        this.billDetails = new ArrayList<>();
        maxSize = 100;
    }

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
            System.out.println("Thêm chi tiết hóa đơn thành công.");
        } else {
            System.out.println("Đã đạt đến kích thước tối đa của danh sách. Không thể thêm chi tiết hóa đơn mới.");
        }
    }

    public void displayBillDetails() {
        if (billDetails.isEmpty()) {
            System.out.println("Danh sách chi tiết hóa đơn trống.");
        } else {
            System.out.println("Các chi tiết hóa đơn trong danh sách:");
            for (BillDetail billDetail : billDetails) {
                System.out.println(billDetail);
            }
        }
    }

    public void addBillDetailFromOrder(Order order) {
        order.setOrderCode(order.getOrderCode());
        order.setCustomerCode(order.getCustomerCode());
        order.setEmployeeCode(order.getEmployeeCode());
        order.setOrderDate(order.getOrderDate());
        order.setSanPhamList(order.getSanPhamList());
        order.setQuantity(order.getQuantity());
        order.setTotalValue(order.getTotalValue());
    }
    
    public BillDetail findBillDetailByCode(String billDetailCode) {
        for (BillDetail billDetail : billDetails) {
            if (billDetail.getBillDetailCode() == billDetailCode) {
                return billDetail;
            }
        }
        return null; // Trả về null nếu không tìm thấy chi tiết hóa đơn phù hợp
    }

    public void removeBillDetailByCode(String billDetailCode) {
        BillDetail billDetailToRemove = findBillDetailByCode(billDetailCode);
        
        // for (BillDetail BillDetail: billDetails) {
        //     if (billDetails.getBillDetailCode().equals(billDetailCode)) {
        //         billDetailToRemove = this.BillDetail;
        //         break;
        //     }
        // }
        if (billDetailToRemove != null) {
            billDetails.remove(billDetailToRemove);
            System.out.println("Đã xóa chi tiết hóa đơn có ID " + billDetailCode + ".");
        } else {
            System.out.println("Không tìm thấy chi tiết hóa đơn có ID " + billDetailCode + " trong danh sách.");
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
            System.out.println("Đã ghi các chi tiết hóa đơn vào tệp: " + fileName);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi vào tệp: " + fileName);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Tạo một đối tượng order
        
    }
}
