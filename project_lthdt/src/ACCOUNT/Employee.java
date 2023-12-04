
import java.util.Scanner;
import PERSON.CustomerList;
import PRODUCTS.MainSanPham;
import PRODUCTS.Kho;

public class Employee extends Account {
    Scanner sc = new Scanner(System.in);
    CustomerList cusList = new CustomerList();
    MainSanPham mainSP = new MainSanPham();

    public Employee() {
        super();
    }

    public Employee(String password, String username, String confirm) {

    }

    public void CreateBill() {

    }

    public void InforCustomers() {
        int exit;
        do {
            System.out.println("-----------------------------+");
            System.out.println("1 : Xem thong tin Customers  |");
            System.out.println("2 : xoa thong tin            |");
            System.out.println("3 : Them thong tin           |");
            System.out.println("0 : Thoat                    |");
            System.out.println("-----------------------------+");
            int chon = sc.nextInt();
            System.out.println();
            switch (chon) {
                case 1:
                    cusList.readFile();
                    cusList.getListCustomer();
                    break;
                // case 2:
                // cusList.Xoa();
                // break;
                // case 3:
                // cusList.Nhap();
                // break;
                case 0:

                    break;

                default:
                    break;
            }
            System.out.println("Press : 0 to exit || 1 to continue");
            exit = sc.nextInt();
        } while (exit != 0 || exit == 1);
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
                    InforCustomers();
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
