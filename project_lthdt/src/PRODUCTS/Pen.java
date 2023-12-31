package PRODUCTS;

import java.util.Scanner;
import MAIN.Kiemtra;

public class Pen extends SanPham {
    Kiemtra kt = new Kiemtra();
    private Kho kho = new Kho();

    public Pen() {
        this.LSP = "Pen";
    }

    public Pen(String maSP, String tenSP, int donGia,int SoLuong) {
        super(maSP, tenSP, donGia,SoLuong);
        this.LSP = "Pen";
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void tinhNang() {
    }

    public boolean ktmasp(String maxp) {
        kho.docDataTuFile();
        for (SanPham sp : kho.khoHang) {
            if (sp.getMaSP().equals(maxp)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void nhap() {
        System.out.print("Nhap vao ma san pham: ");
        String maxp = kt.kiemtraMaSanpham();
        if(ktmasp(maxp) != true)
        do {
            System.out.print("Ma san pham da bi trung !!");
            System.out.print("Nhap lai ma san pham: ");
            maxp = kt.kiemtraMaSanpham();
        } while (ktmasp(maxp) != true);
        this.maSP = maxp;
        System.out.print("Nhap vao ten san pham: ");
        this.tenSP = sc.nextLine();
        System.out.print("Nhap vao gia cua san pham: ");
        this.donGia = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap vao so luong cua san pham: ");
        this.SoLuong = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void xuat() {
        System.out.printf("%-13s%-13s%-21s%-26d%-13d\n",this.LSP,this.maSP,this.tenSP,this.donGia,this.SoLuong);
    }
}
