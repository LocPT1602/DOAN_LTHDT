
import java.io.IOException;
import java.util.Scanner;
import PERSON.CustomerList;
import PERSON.Employeelist;
import ORDER.billdetailList;
import PRODUCTS.MainSanPham;
import PRODUCTS.Kho;
import MAIN.Kiemtra;
import ORDER.BillDetail;

public class Admin extends Account {
    Scanner sc = new Scanner(System.in);
    int choose;
    String idToDelete;
    ListAccount list = new ListAccount();
    CustomerList cusList = new CustomerList();
    Employeelist empList = new Employeelist();
    billdetailList billList = new billdetailList();
    BillDetail billdetail = new BillDetail(null);
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
        System.out.print("Nhap ten tai khoan: ");
        username = kt.kiemtraTenTK();

        if (list.containsAccount(username) == true) {
            do {
                System.out.println("Ten tai khoan da ton tai !");
                System.out.print("Nhap lai ten dang nhap: ");
                username = kt.kiemtraTenTK();
            } while (list.containsAccount(username) == true);
        }
        System.out.print("Nhap mat khau: ");
        setPassword();
        while (kt.ktraSpace(password)) {
            System.out.println("Mat khau khong duoc chua khoang trang");
            System.out.print("Nhap lai: ");
            setPassword();
        }
        Account newAccount = new Account(password, username, "");
        try {
            list.addAccount(newAccount);
            // list.printAcc();
            list.writeAccount();
            System.out.println("Da ghi vao file thanh cong !");
        } catch (IOException e) {
            e.printStackTrace();
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
                // list.printAcc();
            } catch (IOException e) {
                e.printStackTrace();
                // Xử lý ngoại lệ tại đây nếu cần thiết
            }
        } else {
            System.out.println("Tài khoản không tồn tại. Vui lòng kiểm tra lại.");
        }
    }

    public void allAccount() {
        list.printAcc();
    }

    public void DeteteProduct() {

    }

    public void AddProduct() {

    }

    public void CreateBill() {
        billdetail.getBillDetail();
        billdetail.writeToFile();
    }

    public void InforEmployee() {
        int chon;
        do {
            System.out.println("-----------InforEmp----------+");
            System.out.println("1 : Xem thong tin Employee   |");
            System.out.println("2 : xoa thong tin Employee   |");
            System.out.println("3 : Them thong tin Employe   |");
            System.out.println("0 : Thoat                    |");
            System.out.println("-----------------------------+");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    empList.displayInfo();
                    break;
                case 2:
                    empList.Xoa();
                    break;
                case 3:
                    Employee emp =new Employee();
                    emp.Nhap();
                    break;
                case 0:
                    chon = 0;
                    break;

                default:
                    break;
            }

        } while (chon != 0);
    }

    public void InforCustomers() {
        // int exit;
        int chon;
        do {
            System.out.println("-----------InforCus----------+");
            System.out.println("1 : Xem thong tin Customers  |");
            System.out.println("2 : xoa thong tin Customers  |");
            System.out.println("3 : Them thong tin Customers |");
            System.out.println("0 : Thoat                    |");
            System.out.println("-----------------------------+");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    cusList.readFile();
                    cusList.getListCustomer();
                    break;
                case 2:
                    System.out.print("Nhap Id can xoa : ");
                    idToDelete = sc.nextLine();
                    // cusList.removeCustomerById(idToDelete);
                    break;
                // case 3:
                // cusList.Nhap();
                // break;
                case 0:
                    chon = 0;
                    break;

                default:
                    break;
            }
        } while (chon != 0);
    }

    public void menuStorage() {
        mainSP.menuProduct();
    }

    public void Bill() {
        billList.displayBillDetails();
    }

    public void AdminManeger() {
        int exit;
        do {
            System.out.println("---------------ADMIN-------------+");
            System.out.println("1 : Tao hoa don                  |");
            System.out.println("2 : Thong tin nhan vien          |");
            System.out.println("3 : Thong tin khach hang         |");
            System.out.println("4 : Xem hoa don                  |");
            System.out.println("5 : Kho - storage                |");
            System.out.println("6 : Them tai khoan nhan vien     |");
            System.out.println("7 : Xoa tai khoan nhan vien      |");
            System.out.println("8 : Xem Account                  |");
            System.out.println("0 : Thoat                        |");
            System.out.println("---------------------------------+");
            System.out.print("Nhap lua chon: ");
            choose = sc.nextInt();

            if (choose < 0 || choose > 9) {
                System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }

            switch (choose) {
                case 1:
                    try {
                        if (list.isFileEmpty()) {
                            System.out.println("Don hang trong. Moi ban tao don hang truoc khi tao hoa don!");
                        } else {
                            CreateBill();
                        }
                        list.deleteFileghiorder();
                    } catch (Exception e) {
                    }
                    break;
                case 2:
                    InforEmployee();
                    break;
                case 3:
                    InforCustomers();
                    break;
                case 4:
                    billdetail.searchBillByBillDetailCode();
                    break;
                case 5:
                    menuStorage();
                    break;
                case 6:
                    AddEmplAccount();
                    break;
                case 7:
                    DeleteEmplAccount();
                    break;
                case 8:
                    allAccount();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
            System.out.println("Press : 0 to exit || 1 to continue (ADMIN) ");
            exit = sc.nextInt();
        } while (exit == 1);
    }

    public void readFile() {
        try {
            list.readAccount();
            empList.readEmployeeFile();
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
