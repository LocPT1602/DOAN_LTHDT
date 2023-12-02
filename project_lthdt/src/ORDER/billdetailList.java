package ORDER;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class billdetailList {
    private List<BillDetail> billDetails; // Danh sách các chi tiết hóa đơn
    private int maxSize; // Kích thước tối đa

    public billdetailList() {
        billDetails = new ArrayList<>();
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

    public void addBillDetailFromorder(order order) {
        BillDetail billDetail = new BillDetail();
        // Thiết lập các thuộc tính của billDetail từ order
        // ...

        addBillDetail(billDetail);
    }

    public BillDetail findBillDetailById(int id) {
        for (BillDetail billDetail : billDetails) {
            if (billDetail.getBillDetailCode() == id) {
                return billDetail;
            }
        }
        return null; // Trả về null nếu không tìm thấy chi tiết hóa đơn phù hợp
    }

    public void removeBillDetailById(int id) {
        BillDetail billDetailToRemove = findBillDetailById(id);
        if (billDetailToRemove != null) {
            billDetails.remove(billDetailToRemove);
            System.out.println("Đã xóa chi tiết hóa đơn có ID " + id + "."); // Đầu ra: Đã xóa chi tiết hóa đơn có ID {id}.
        } else {
            System.out.println("Không tìm thấy chi tiết hóa đơn có ID " + id + " trong danh sách."); // Đầu ra: Không tìm thấy chi tiết hóa đơn có ID {id} trong danh sách.
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
    // Thêm các chi tiết hóa đơn
    // ...

    billdetailList.displayBillDetails();

    // Thêm chi tiết hóa đơn từ một đơn hàng
    order order = new order();
   
    billdetailList.addBillDetailFromorder(order);
}
    }
