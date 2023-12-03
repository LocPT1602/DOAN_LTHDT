
import java.io.IOException;
import java.util.Scanner;
import PERSON.CustomerList;
import PERSON.Employeelist;
import ORDER.billdetailList;
import PRODUCTS.MainSanPham;
import PRODUCTS.Kho;
import MAIN.Kiemtra;

public class Admin extends Account {
    Scanner sc = new Scanner(System.in);
    int choose;
    String idToDelete;
    ListAccount list = new ListAccount();
    CustomerList cusList = new CustomerList();
    Employeelist empList = new Employeelist();
    billdetailList billList = new billdetailList();
    MainSanPham mainSP = new MainSanPham();
    Kho khoHang = new Kho();
    Kiemtra kt = new Kiemtra();

    public Admin() {
        super();
    }

    public Admin(String password, String username, String confirm) {
        super(password, username, confirm);
    }

    public void AddEmplAccount() {
        System.out.print("Nhap ten tai khoan : ");
        setUsername();
        while (kt.ktraSpace(username)) {
            System.out.println("ten tai khoan khong duoc chua khoang trang");
            setUsername();
        }
        System.out.print("Nhap mat khau : ");
        setPassword();
        while (kt.ktraSpace(password)) {
            System.out.println("Mat khau khong duoc chua khoang trang");
            setPassword();
        }
        Account newAccount = new Account(password, username, "");

        if (list.containsAccount(username) != true) {
            try {
                list.addAccount(newAccount);
                list.printAcc();
                list.writeAccount();
                System.out.println("Da ghi vao file thanh cong !");
            } catch (IOException e) {
                e.printStackTrace();
                // Xử lý ngoại lệ tại đây nếu cần thiết
            }
        } else {
            System.out.println("Ten tai khoan da ton tai !");
        }

    }

    public void DeleteEmplAccount() {
        sc.nextLine();
        System.out.print("Nhap ten tai khoan can xoa: ");
        String usernameToDelete = sc.nextLine().trim();

        // Kiểm tra tên tài khoản có tồn tại hay không
        if (list.containsAccount(usernameToDelete)) {
            try {
                list.deleteAccount(usernameToDelete);
                list.printAcc();
            } catch (IOException e) {
                e.printStackTrace();
                // Xử lý ngoại lệ tại đây nếu cần thiết
            }
        } else {
            System.out.println("Tài khoản không tồn tại. Vui lòng kiểm tra lại.");
        }
    }

    public void DeteteProduct() {

    }

    public void AddProduct() {

    }

    public void CreateBill() {

    }

    public void InforEmployee() {
        int exit;
        do {
            System.out.println("-----------------------------+");
            System.out.println("1 : Xem thong tin ca nhan    |");
            System.out.println("2 : xoa thong tin            |");
            System.out.println("3 : Them thong tin           |");
            System.out.println("0 : Thoat                    |");
            System.out.println("-----------------------------+");
            int chon = sc.nextInt();
            System.out.println();
            switch (chon) {
                case 1:
                    empList.displayInfo();
                    break;
                case 2:
                    empList.Xoa();
                    break;
                case 3:
                    empList.Nhap();
                    break;
                case 0:

                    break;

                default:
                    break;
            }
            System.out.println("Press : 0 to exit || 1 to continue");
            exit = sc.nextInt();
        } while (exit != 0 || exit == 1);
    }

    public void InforCustomers() {
        int exit;
        do {
            System.out.println("-----------------------------+");
            System.out.println("1 : Xem thong tin Customers  |");
            System.out.println("2 : xoa thong tin Customers  |");
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
                case 2:
                    System.out.print("Nhap Id can xoa : ");
                    idToDelete = sc.nextLine();
                    cusList.removeCustomerById(idToDelete);
                    break;
                // case 3:
                // cusList.Nhap();
                // break;
                case 0:

                    break;

                default:
                    break;
            }
            System.out.println("Press : 1 to continue");
            exit = sc.nextInt();
        } while (exit == 1);
    }

    public void AddSupplier() {
        mainSP.menuProduct();
    }

    public void Bill() {
        billList.displayBillDetails();
    }

    public void AdminManeger() {
        int exit;
        do {
            System.out.println("---------------------------------+");
            System.out.println("1 : Xoa san Pham                 |");
            System.out.println("2 : Them san pham                |");
            System.out.println("3 : Tao hoa don                  |");
            System.out.println("4 : Thong tin nhan vien          |");
            System.out.println("5 : Thong tin khach hang         |");
            System.out.println("6 : Hoa don                      |");
            System.out.println("7 : Them nha cung cap            |");
            System.out.println("8 : Them tai khoan nhan vien     |");
            System.out.println("9 : Xoa tai khoan nhan vien      |");
            System.out.println("0 : Thoat                        |");
            System.out.println("---------------------------------+");
            System.out.print("Nhap lua chon: ");
            choose = sc.nextInt();

            if (choose < 0 || choose > 9) {
                System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }

            switch (choose) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    InforEmployee();
                    break;
                case 5:
                    InforCustomers();
                    break;
                case 6:

                    break;
                case 7:
                    AddSupplier();
                    break;
                case 8:
                    AddEmplAccount();
                    break;
                case 9:
                    DeleteEmplAccount();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
            System.out.println("Press : 1 to continue ");
            exit = sc.nextInt();
        } while (exit == 1);
    }

    public void readFile() {
        try {
            list.readAccount();
            cusList.defaultCustomers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Admin ad = new Admin();
        ad.readFile();
        ad.AdminManeger();
    }

}
