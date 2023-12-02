
import java.io.IOException;
import java.util.Scanner;

public class Admin extends Account {
    Scanner sc = new Scanner(System.in);
    int choose;
    ListAccount list = new ListAccount();

    public Admin() {
        super();
    }

    public Admin(String password, String username, String confirm) {
        super(password, username, confirm);
    }

    public void AddEmplAccount() {
        System.out.print("Nhap ten tai khoan : ");
        setUsername();
        System.out.print("Nhap mat khau : ");
        setPassword();
        Account newAccount = new Account(password, username, "");

        if (list.containsAccount(username) != true) {
            try {
                list.loadDataFromFile();
                list.addAccount(newAccount);
                list.printAcc();
                list.writeAccount();
                System.out.println("Da ghi vao file thanh cong");
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
                list.loadDataFromFile();
                list.deleteAccount(usernameToDelete);
                list.printAcc();
            } catch (IOException e) {
                e.printStackTrace();
                // Xử lý ngoại lệ tại đây nếu cần thiết
            }
        } else {
            System.out.println("Tai khoan khong ton tai. Vui long kiem tra lai.");
        }
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
            System.out.println("---------------------------------+");
            System.out.println("1 : Xoa san pham                 |");
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
            System.out.print("Nhap lua chon : ");
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

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

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
            System.out.println("Nhan 0 de ket thuc !");
            exit = sc.nextInt();
        } while (exit != 0);
    }

    public static void main(String[] args) {
        Admin ad = new Admin();
        ad.AdminManeger();
    }

}
