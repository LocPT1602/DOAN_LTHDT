package ACCOUNT;

import java.util.Scanner;

public class Admin extends Account {
    Scanner sc = new Scanner(System.in);
    int choose;

    public Admin() {
        super();
    }

    public Admin(String password, String username, String confirm) {

    }

    public void DeteteProduct() {

    }

    public void AddProduct() {

    }

    public void CreateBill() {

    }

    public void InforEmployee() {

    }

    public void InforCustomers() {

    }

    public void AddSupplier() {

    }

    public void Bill() {

    }

    public void AdminManeger() {
        int exit;
        do {
            System.out.println();
            System.out.println("1 : Xóa sản Phẩm ");
            System.out.println("2 : Thêm sản phẩm ");
            System.out.println("3 : Tạo hóa đơn");
            System.out.println("4 : Thông tin nhân viên");
            System.out.println("5 : Thông tin khách hàng");
            System.out.println("6 : Hóa đơn");
            System.out.println("7 : Thêm nhà cung cấp");
            System.out.println("0 : Thoát");
            System.out.println("----------------------------------");
            System.out.print("Nhập lựa chọn : ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 0:
                    break;
                default:
                    break;
            }
            System.out.println("Nhấn 0 để thoát khỏi hoàn toàn !");
            exit = sc.nextInt();
        } while (exit == 0);
    }

    public static void main(String[] args) {
    }

}
