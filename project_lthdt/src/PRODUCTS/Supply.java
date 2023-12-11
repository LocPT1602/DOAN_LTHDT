package PRODUCTS;

import java.util.Scanner;

import MAIN.Kiemtra;

public class Supply extends SanPham {
    Kiemtra kt = new Kiemtra();
    Kho kho = new Kho();

    public Supply() {
        this.LSP = "Supply";
    }

    public Supply(String maSP, String tenSP, int donGia) {
        super(maSP, tenSP, donGia);
        this.LSP = "Supply";
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
        System.out.println(
                "     " + this.LSP + "          " + this.maSP + "           " + this.tenSP + "             " + this.donGia + "            " + this.SoLuong
                        + " \n");
    }
}
