package PRODUCTS;

import java.util.Scanner;
import MAIN.Kiemtra;

public class Pen extends SanPham {
    Kiemtra kt = new Kiemtra();
    private Kho kho = new Kho();
    public Pen() {
        this.LSP = "Pen";
    }

    public Pen(String maSP, String tenSP, int donGia) {
        super(maSP, tenSP, donGia);
        this.LSP = "Pen";
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void tinhNang() {
    }
    @Override
    public void nhap() {
        System.out.print("\nNhap vao ma san pham: ");
        this.maSP = kt.kiemtraMaSanpham();
        System.out.print("\nNhap vao ten san pham: ");
        this.tenSP = sc.nextLine();
        System.out.print("\nNhap vao gia cua san pham: ");
        this.donGia = kt.KiemTraNhapSoNguyen();
    }

    @Override
    public void xuat() {
        System.out.println(
                "LSP: " + this.LSP + " | maSP: " + this.maSP + " | tenSP: " + this.tenSP + " | donGia: " + this.donGia
                        + "\n"

        );
    }
}
