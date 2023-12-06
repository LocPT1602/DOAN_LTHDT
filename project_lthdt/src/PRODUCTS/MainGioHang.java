package PRODUCTS;

import java.util.Scanner;

public class MainGioHang {
    public static void main(String[] args) {
        DanhSachGioHang dsGioHang = new DanhSachGioHang();
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("MENU-------------------------------");
            System.out.println(
                    "1. In danh sach gio hang.\n"
                +   "2. In Gio hang theo ma.\n"
                +   "3. Them gio hang.\n"
                +   "4. Xoa gio hang.\n"
                +   "5. Doc du lieu tu file.\n"
                +   "6. Ghi du lieu xuong file.\n"
            );
        choice = sc.nextInt();

        switch(choice) {
        case 1: 
        {
            dsGioHang.inDanhSachGioHang();
            break;
        }
        case 2:
        {
        	System.out.println("Nhap ma gio hang");
        	dsGioHang.layGHtheoMa(sc.nextLine());
        	break;
        }
        case 3:
        {
        	
        	break;
        }
        case 4:
        {
        	System.out.println("Nhap vi tri gio hang");
        	dsGioHang.xoaGH(sc.nextInt());
        	break;
        }
        case 5:
        {
            dsGioHang.docDataTuFile();
            break;
        }
        case 6:
        {
            dsGioHang.ghiDataXuongFile();
            break;
        }
        }
        }while(choice != 0); 
}
}

