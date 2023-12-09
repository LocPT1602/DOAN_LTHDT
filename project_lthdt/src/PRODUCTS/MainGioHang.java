package PRODUCTS;

import java.util.Scanner;

public class MainGioHang {
    DanhSachGioHang dsGioHang = new DanhSachGioHang();

    public void menuGH() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("MENU-------------------------------");
            System.out.println(
                    "1. In danh sach gio hang.\n"
                            + "2. In Gio hang theo ma.\n"
                            + "3. Them gio hang.\n"
                            + "4. Lay so gio hang .\n"
                            + "5. Xoa gio hang.\n"
                            + "6. Doc du lieu tu file.\n"
                            + "7. Ghi du lieu xuong file.\n");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: {
                    dsGioHang.inDanhSachGioHang();
                    break;
                }
                case 2: {
                    System.out.println("Nhap ma gio hang");
                    dsGioHang.layGHtheoMa(sc.nextLine());
                    break;
                }
                case 3: {

                    break;
                }
                case 4: {
                    dsGioHang.laySize();
                    break;
                }
                case 5: {
                    System.out.println("Nhap vi tri gio hang");
                    dsGioHang.xoaGH(sc.nextInt());
                    break;
                }
                case 6: {
                    dsGioHang.docDataTuFile();
                    break;
                }
                case 7: {
                    dsGioHang.ghiDataXuongFile();
                    break;
                }
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        MainGioHang mainGioHang = new MainGioHang();
        mainGioHang.menuGH();
    }
}
