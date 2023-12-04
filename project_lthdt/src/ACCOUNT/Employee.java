
import java.util.Scanner;
<<<<<<< HEAD
import PERSON.CustomerList;
import PRODUCTS.MainSanPham;
import PRODUCTS.Kho;
=======
>>>>>>> parent of ca08ecf (m)

public class Employee extends account {
    Scanner sc = new Scanner(System.in);
<<<<<<< HEAD
    CustomerList cusList = new CustomerList();
    MainSanPham mainSP = new MainSanPham();
=======
>>>>>>> parent of ca08ecf (m)

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
        mainSP.menuProduct();
    }

    public void EmployeeManeger() {
        int exit, choose;
        do {
            System.out.println("------------------------------");
            System.out.println("1 : Tao hoa don              |");
            System.out.println("2 : Tim san pham             |");
            System.out.println("3 : Thong tin khach hang     |");
            System.out.println("4 : Hoa don                  |");
            System.out.println("5 : Them nha cung cap        |");
            System.out.println("0 : Thoat                    |");
            System.out.println("------------------------------");
            System.out.print("Nhap lua chon : ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:

                    break;
                case 2:
                    FindProduct();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    AddSupplier();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
            System.out.println("Press : 1 to continue");
            exit = sc.nextInt();
        } while (exit == 1);
    }
}
