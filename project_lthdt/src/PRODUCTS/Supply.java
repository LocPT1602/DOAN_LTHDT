package PRODUCTS;

import java.util.Scanner;

import MAIN.Kiemtra;

public class Supply extends SanPham {
	Kiemtra kt = new Kiemtra();
	
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
    @Override
    public void nhap() {
    	System.out.print("\nNhap vao ma san pham: ");
        this.maSP = kt.kiemtraMaSanpham();
        System.out.print("\nNhap vao ten san pham: ");
        this.tenSP = sc.nextLine();
        System.out.print("\nNhap vao gia cua san pham: ");
        this.donGia = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void xuat() {
        System.out.println(
                "LSP: " + this.LSP + " | maSP: " + this.maSP + " | tenSP: " + this.tenSP + " | donGia: " + this.donGia
                        + "\n"

        );
    }
}
