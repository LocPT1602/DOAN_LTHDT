package PRODUCTS;

import java.util.Scanner;
import MAIN.Kiemtra;

public class Paper extends SanPham {
    Kiemtra kt = new Kiemtra();
    private Kho kho = new Kho();
    public Paper() {
        this.LSP = "Paper";
    }

    public Paper(String maSP, String tenSP, int donGia) {
        super(maSP, tenSP, donGia);
        this.LSP = "Paper";
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void tinhNang() {
    }

    
    public boolean ktmasp(String maxp) {
    	kho.docDataTuFile();
            for (SanPham sp : kho.khoHang) 
            {
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
        if(ktmasp(maxp) == true) {
        	this.maSP = maxp;
        }
        else {
        	System.out.print("Ma san pham nhap sai!!");
        	this.nhap();
        }
        System.out.print("\nNhap vao ten san pham: ");
        this.tenSP = sc.nextLine();
        System.out.print("\nNhap vao gia cua san pham: ");
        this.donGia = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void xuat() {
        System.out.println(
                "LSP: " + this.LSP + " | maSP: " + this.maSP + " | tenSP: " + this.tenSP + " | donGia: " + this.donGia
                        + "\n");
    }

}
