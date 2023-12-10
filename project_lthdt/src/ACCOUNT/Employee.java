
import java.util.Scanner;
import PERSON.CustomerList;
import PRODUCTS.MainSanPham;
// import PRODUCTS.Kho;
import ORDER.BillDetail;
import ORDER.Order;
import PRODUCTS.MainGioHang;
import PRODUCTS.MainTestMuahang;

public class Employee extends Account {
    Scanner sc = new Scanner(System.in);
    CustomerList cusList = new CustomerList();
    MainSanPham mainSP = new MainSanPham();
    BillDetail billdetail = new BillDetail(null);
    Order order = new Order();
    MainGioHang mainGh = new MainGioHang();
    MainTestMuahang mainMh = new MainTestMuahang();

    public Employee() {
        super();
    }

    public Employee(String password, String username, String confirm) {

    }

    public void CreateBill() {
        billdetail.getBillDetail();
        billdetail.writeToFile();
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

    public void menuStorage() {
        mainSP.menuProduct();
    }

    public void AddSupplier() {
        mainSP.menuProduct();
    }

    public void createOrder() {
        // mainGh.menuGH();
        mainMh.menuMh();
        // order.inputOrderInfo();
        // order.displayOrderInfo();
    }

    public void EmployeeManeger() {
        int exit, choose;
        do {
            System.out.println("+----------EMPLOYEE----------+");
            System.out.println("1 : Tao hoa don              |");
            System.out.println("2 : Kho - Storage            |");
            System.out.println("3 : Thong tin khach hang     |");
            System.out.println("4 : Tao don hang             |");
            System.out.println("5 : Them nha cung cap        |");
            System.out.println("0 : Thoat                    |");
            System.out.println("+----------------------------+");
            System.out.print("Nhap lua chon : ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    CreateBill();
                    break;
                case 2:
                    menuStorage();
                    break;
                case 3:
                    InforCustomers();
                    break;
                case 4:
                    createOrder();
                    break;
                case 5:
                    AddSupplier();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
            System.out.println("Press : 1 to continue || 0 to exit (EMPLOYEE)");
            exit = sc.nextInt();
        } while (exit == 1);
    }

    public static void main(String[] args) {
        Employee empl = new Employee();
        empl.EmployeeManeger();
    }
}
