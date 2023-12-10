package PRODUCTS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;
import MAIN.Kiemtra;

public class Kho implements iReaderWriter {
    ArrayList<SanPham> khoHang;
    Scanner sc = new Scanner(System.in);
    Kiemtra kt = new Kiemtra();

    public Kho() {
        khoHang = new ArrayList<>();
    }

    // Thêm vào kho
    public void themVaoKho() {
        int lc = 0;

        do {
            System.out.println("Chon san pham muon them: ");
            System.out.println(
                    "1. Paper.\n"
                            + "2. Pen.\n"
                            + "3. Supply.\n"
                            + "0. Thoát");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            if (lc == 1) {
                SanPham sp = new Paper();
                sp.nhap();
                this.khoHang.add(sp);
            } else if (lc == 2) {
                SanPham sw = new Pen();
                sw.nhap();
                this.khoHang.add(sw);
            } else if (lc == 3) {
                SanPham tb = new Supply();
                tb.nhap();
                this.khoHang.add(tb);
            }
        } while (lc != 0);
    }

    // các hàm xóa
    public void xoaSP(int vitri) {
        this.khoHang.remove(vitri);
    }

    public void xoaSP(String maSP) {
        for (SanPham sanPham : khoHang) {
            if (sanPham.getMaSP().equals(maSP)) {
                this.khoHang.remove(sanPham);
            }
        }
    }

    public void clearKho() {
        this.khoHang.clear();
        System.out.println("Kho da duoc don dep!.");
    }

    // Các hàm in
    public void inKho() {
        System.out.println("----------------------------------------Kho--------------------------------------");
        for (SanPham sanPham : khoHang) {
            sanPham.xuat();
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    public void inPaper() {
        System.out.println("------------ Cac san pham la Paper ------------");
        for (SanPham sanPham : khoHang) {
            if (sanPham.getLSP().equals("Paper")) {
                sanPham.xuat();
            }
        }
        System.out.println("----------------------------------------------------");
    }

    public void inPen() {
        System.out.println("------------ Cac san pham la Pen ------------");
        for (SanPham sanPham : khoHang) {
            if (sanPham.getLSP().equals("Pen")) {
                sanPham.xuat();
            }
        }
        System.out.println("----------------------------------------------------");
    }

    public void inSupply() {
        System.out.println("-------------- Cac san pham la Supply --------------");
        for (SanPham sanPham : khoHang) {
            if (sanPham.getLSP().equals("Supply")) {
                sanPham.xuat();
            }
        }
        System.out.println("----------------------------------------------------");
    }

    // Các hàm tìm kiếm
    public void timkiemSanPham(String maOrten) {
        for (SanPham sanPham : khoHang) {
            if (sanPham.getMaSP().equals(maOrten) || sanPham.getTenSP().indexOf(maOrten) >= 0) {
                sanPham.xuat();
            }
        }
    }

    public void timkiemSanPham(int min, int max) {
        for (SanPham sanPham : khoHang) {
            if (sanPham.getDonGia() >= min && sanPham.getDonGia() <= max) {
                sanPham.xuat();
            }
        }
    }

    public void timkiemSanPhamThapDenCao() {
        Collections.sort(this.khoHang, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return Integer.compare(sp1.getDonGia(), sp2.getDonGia());
            }
        });
    }

    public void timkiemSanPhamCaoDenThap() {
        Collections.sort(this.khoHang, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return Integer.compare(sp2.getDonGia(), sp1.getDonGia());
            }
        });
    }

    public SanPham laySPtheoMa(String maSP) {
        for (SanPham sanPham : khoHang) {
            if (sanPham.getMaSP().equals(maSP)) {
                if (sanPham.getLSP().equals("Paper")) {
                    SanPham sp = new Paper();
                    sp = (Paper) sanPham;
                    return sp;
                } else if (sanPham.getLSP().equals("Pen")) {
                    SanPham sw = new Pen();
                    sw = (Pen) sanPham;
                    return sw;
                } else if (sanPham.getLSP().equals("Supply")) {
                    SanPham tb = new Supply();
                    tb = (Supply) sanPham;
                    return tb;
                }
            }
        }
        System.out.println("San pham ko ton tai");
        return null;
    }

    // Ghi dữ liệu lên file
    @Override
    public void ghiDataXuongFile() {
        try {
            FileWriter fw = new FileWriter("dataSanPham.txt");
            for (SanPham sp : this.khoHang) {
                fw.write(sp.toString() + "\n");
            }
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // Đọc dữ liệu từ file
    @Override
    public void docDataTuFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("dataSanPham.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String LSP = parts[0].trim();
                String maSP = parts[1].trim();
                String tenSP = parts[2].trim();
                int donGia = Integer.parseInt(parts[3].trim());
                if (LSP.equals("Paper")) {
                    this.khoHang.add(new Paper(maSP, tenSP, donGia));
                } else if (LSP.equals("Pen")) {
                    this.khoHang.add(new Pen(maSP, tenSP, donGia));
                } else if (LSP.equals("Supply")) {
                    this.khoHang.add(new Supply(maSP, tenSP, donGia));
                }
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
