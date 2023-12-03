package PRODUCTS;

import java.io.File;
import java.util.Scanner;

public class MainSanPham {
    Kho khoHang = new Kho();

    public void menuProduct() {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        File f = new File("dataSanPham.txt");

        do {
            System.out.println("MENU-------------------------------");
            System.out.println(
                    "1. Them vao kho.\n"
                            + "2. Xoa san pham khoi kho.\n"
                            + "3. Tim kiem san pham theo maSP.\n"
                            + "4. Don dep kho.\n"
                            + "5. In toan bo kho.\n"
                            + "6. Ghi du lieu xuong file.\n"
                            + "7. Doc du lieu tu file.\n");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                khoHang.themVaoKho();
            } else if (choice == 2) {
                System.out.println("Nhap vao vi tri muon xoa: ");
                // String maSP = sc.nextLine();
                khoHang.xoaSP(sc.nextInt());
            } else if (choice == 3) {
                System.out.println("Nhap vao maSP muon tim: ");
                khoHang.timkiemSanPham(sc.nextLine());
            } else if (choice == 4) {
                khoHang.clearKho();
            } else if (choice == 5) {
                khoHang.inKho();
            } else if (choice == 6) {
                khoHang.ghiDataXuongFile();
            } else if (choice == 7) {
                khoHang.docDataTuFile();
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
    }
}
