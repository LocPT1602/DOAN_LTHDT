package PRODUCTS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.ParseException;


public class DanhSachHoaDon implements iReaderWriter{
    private ArrayList<HoaDon> dsHD;
    Scanner sc = new Scanner(System.in);
    public DanhSachHoaDon(){
        this.dsHD = new ArrayList<>();

    }
    
    public void themVaoDanhSach(HoaDon hd){
        this.dsHD.add(hd);
    }
    public void xoaKhoiDanhSach(int maHD){
        for (HoaDon hoaDon : dsHD) {
            if(hoaDon.getMaHD() == maHD){
                this.dsHD.remove(hoaDon);
                return;
            }
        }
        System.out.println("Khong ton tai hoa don nay.");
    }
    public void xoaKhoiDanhSachn(){
    	while (true) {
    		System.out.println("Nhap vao ma hoa don: ");
            int maHD = sc.nextInt();
        	for(HoaDon hD : dsHD) {
        		if(hD.getMaHD() == maHD){
                    this.dsHD.remove(hD);
                    return;
            } else {
            	System.out.println("Khong ton tai hoa don nay.");
            }}
        }
    }
    

    public void xuat(){
        for (HoaDon hoaDon : dsHD) {
            hoaDon.xuat();
        }
    }

    @Override
    public void ghiDataXuongFile(){
        try {
            FileWriter fw = new FileWriter("dataHoaDon.txt");
            for (HoaDon hoaDon : dsHD) {
                fw.write(hoaDon.toString());
            }
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    @Override
    public void docDataTuFile(){
        Kho kho = new Kho();
        kho.docDataTuFile();
        DanhSachGioHang dsGH = new DanhSachGioHang();
        dsGH.docDataTuFile();

        try {
            BufferedReader br = new BufferedReader(new FileReader("dataHoaDon.txt"));
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                String maHD = parts[0].trim();
                Date d = new SimpleDateFormat("yyyy-MM-dd H:m:s").parse(parts[1].trim());
                String maGH = parts[2].trim();
                //int khachHangHash = Integer.parseInt(parts[3].trim());
                //String maKM = parts[4].trim();
                //String maNV = parts[5].trim();
                
                GioHang gioHang = dsGH.layGHtheoMa(maGH);
                

                this.themVaoDanhSach(new HoaDon(gioHang));
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
