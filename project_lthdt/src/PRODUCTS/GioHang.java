package PRODUCTS;

import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import MAIN.Kiemtra;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class GioHang {
    public ArrayList<SanPham> gioHang;
    private String maGH;
    private Kho kho = new Kho();
    private Kiemtra kt = new Kiemtra();
    Scanner sc = new Scanner(System.in);

    public GioHang() {
        this.gioHang = new ArrayList<>();
        this.maGH = "GH";
        this.kho.docDataTuFile();
    }

    public ArrayList<SanPham> getDanhSachSP() {
        return gioHang;
    }

    public String getMaGH() {
        return this.maGH;
    }

    public void setMaGH(int sizeDSGio) {
        this.maGH = "GH" + sizeDSGio;
    }

    public void setDanhSachSP(ArrayList<SanPham> gioHang) {
        this.gioHang = gioHang;
    }

    public void themVaoGio(String maSP) {
        while (true) {
            for (SanPham sanPham : kho.khoHang) {
                if (maSP.matches(sanPham.maSP)) {
                    this.gioHang.add(kho.laySPtheoMa(maSP));
                    return;
                }
            }
        }
    }

    public void themVaoGion() {
        while (true) {
            System.out.print("Nhap vao ma san pham: ");
            String maSP = sc.nextLine();
            for(SanPham sanPham : gioHang){
                if (maSP.matches(sanPham.maSP)) {
                    if(kho.laySPtheoMa(maSP).getSoLuong() == 0){
                    System.out.println("San pham da het hang!! ");
                    return;
                    }
                    System.out.print("Nhap vao so luong san pham: ");
                    sanPham.SoLuong = sanPham.getSoLuong() + kt.KiemTraNhapSoTuNhien();
                    return;
                }
            }
            for (SanPham sanPham : kho.khoHang) {
                if (maSP.matches(sanPham.maSP)) {
                    if(kho.laySPtheoMa(maSP).getSoLuong() == 0){
                    System.out.println("San pham da het hang!! ");
                    return;
                    }
                    System.out.print("Nhap vao so luong san pham: ");
                    sanPham.SoLuong = kt.KiemTraNhapSoTuNhien();;
                    this.gioHang.add(kho.laySPtheoMa(maSP));
                    return;
                }
                
            }
            System.out.println("Ma san pham khong ton tai");
        }
    }

    public void ghiTenSPvaDonGiaVaoFile() {
        try {
            FileWriter writer = new FileWriter("danhsachspdadat.txt");
            String line1 =(String.format("%-24s%-24s%-24s\n","Ten SP","Don gia","So Luong"));
            writer.write(line1);
            for (SanPham sanPham : this.gioHang) {
                String line = (String.format("%-24s%-24s%-24d\n",sanPham.getTenSP()+"|",sanPham.getDonGia()+"|",sanPham.getSoLuong()));
                writer.write(line);

            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi thông tin vào file.");
            e.printStackTrace();
        }
    }

    public void inTenSPvaDonGia() {

        for (SanPham sanPham : this.gioHang) {
            sanPham.xuat();
        }
    }

    public void xoaKhoiGioHang(int vitri) {
        if (vitri >= 0 && vitri < gioHang.size()) {
            this.gioHang.remove(vitri);
        } else {
            System.out.println("Vi tri ban nhap vao la so am hoac vi tri lon hon so luong trong gio hang.");
        }
    }

    public void xoaKhoiGioHang(String maSP) {
        for (SanPham sanPham : gioHang) {
            if (sanPham.getMaSP().equals(maSP)) {
                this.gioHang.remove(sanPham);
                System.out.println("Da xoa san pham co ma | " + maSP + " | trong gio.");
                return;
            }
        }
    }

    public void xoaTatCa() {
        this.gioHang.clear();
    }

    public int tinhTien() {
        int tong = 0;
        for (SanPham sanPham : gioHang) {
            tong += sanPham.getDonGia() * sanPham.getSoLuong();
        }
        return tong;
    }

    public int gioHangSize() {
        int count = 0;
        for (SanPham sanPham : gioHang) {
            count++;
        }
        return count;
    }

    public String layAllMaSP() {
        String allMaSP = "";
        for (SanPham sanPham : gioHang) {
            allMaSP += ", " + sanPham.getMaSP();
        }
        return allMaSP;
    }

    public void inGioHang() {
        System.out.println("===================== GIO HANG =====================");
        if (this.gioHang.isEmpty()) {
            System.out.println("Gio hang dang trong!");
            return;
        }
        System.out.printf("%-12s%-20s%-12s%-25s%-12s\n","|LSP|","|maSP|","|tenSP|","|donGia|","|So Luong|");

        for (SanPham sanPham : this.gioHang) {
            sanPham.xuat();

        }
        System.out.println("====================================================");
    }

    public boolean KtraGH() {
        if (this.gioHang.isEmpty()) {
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gioHang == null) ? 0 : gioHang.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GioHang other = (GioHang) obj;
        if (gioHang == null) {
            if (other.gioHang != null)
                return false;
        } else if (!gioHang.equals(other.gioHang))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.maGH + this.layAllMaSP() + "\n";
    }
}
