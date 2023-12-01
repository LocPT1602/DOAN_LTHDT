package ACCOUNT;

import java.util.Scanner;

public class Employee extends Account {
    Scanner sc = new Scanner(System.in);

    public Employee() {
        super();
    }

    public Employee(String password, String username, String confirm) {

    }

    public void CreateBill() {

    }

    public void InforCustomers() {

    }

    public void FindProduct() {

    }

    public void AddSupplier() {

    }

    public void EmployeeManeger() {
        int exit, choose;
        do {
            System.out.println("------------------------------");
            System.out.println("1 : Tạo hóa đơn              |");
            System.out.println("2 : Tìm sản phẩm             |");
            System.out.println("3 : Thông tin khách hàng     |");
            System.out.println("4 : Hóa đơn                  |");
            System.out.println("5 : Thêm nhà cung cấp        |");
            System.out.println("0 : Thoát                    |");
            System.out.println("------------------------------");
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
                case 0:
                    break;
                default:
                    break;
            }
            System.out.println("Nhấn 0 để thoát khỏi hoàn toàn !");
            exit = sc.nextInt();
        } while (exit == 0);
    }
}
