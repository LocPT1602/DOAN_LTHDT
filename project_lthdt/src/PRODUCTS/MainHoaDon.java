package PRODUCTS;

import java.util.Date;
import java.util.Scanner;

public class MainHoaDon {
    public static void main(String[] args) {
        DanhSachHoaDon dsHD = new DanhSachHoaDon();

        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("MENU-------------------------------");
            System.out.println(
                    "1. In danh sach don hang.\n"
                
                +   "3. Xoa don hang.\n"
                +   "4. Doc du lieu tu file.\n"
                +   "5. Ghi du lieu xuong file.\n"
            );
        choice = sc.nextInt();
        sc.nextLine();
        switch(choice) {
        case 1: 
        {
            dsHD.xuat();
            break;
        }
        case 3:
        {
        	
;        	dsHD.xoaKhoiDanhSachn();
        	break;
        }
        case 4:
        {
        	dsHD.docDataTuFile();
        	break;
        }
        case 5:
        {
        	dsHD.ghiDataXuongFile();
            break;
        }
        }
        }while(choice != 0); 
        // GioHang gH = new GioHang(0);
        // gH.themVaoGio("SP5");
        // gH.themVaoGio("SW5");
        // gH.themVaoGio("Tb5");
        // GioHang gH2 = new GioHang(1);
        // gH2.themVaoGio("SP6");
        // gH2.themVaoGio("SP2");
        // gH2.themVaoGio("SP3");
        // gH2.themVaoGio("SP4");

        // DanhSachKhachHang dsKH = new DanhSachKhachHang();
        // KhachHang kH = new KhachHang("HPD", "TP.HCM", "09090990");
        // KhachHang kH2 = new KhachHang("QHK", "TP.HCM", "0899889898");
        // dsKH.themKhachHang(kH);
        // dsKH.themKhachHang(kH2);
        // dsKH.ghiDataXuongFile();

        

        // // DanhSachNhanVien dsNV = new DanhSachNhanVien();
        // NhanVien nV = new BanHang("BH1", "Nguyen Van A", "01/01/2004", "TP.HCM");
        // NhanVien nV2 = new BanHang("QL1", "Trinh Thi B", "01/01/2004", "TP.HCM");
        // // dsNV.themNhanVien(nV);
        // // dsNV.ghiDataXuongFile();

        // // Date d = new Date(System.currentTimeMillis());
        
        // HoaDon hD = new HoaDon(gH, kH, nV);
        // HoaDon hD2 = new HoaDon(gH2, kH2, nV2);
        // dsHD.themVaoDanhSach(hD);
        // dsHD.themVaoDanhSach(hD2);
        // dsHD.ghiDataXuongFile();

       
    }
}
