package PRODUCTS;

import java.util.ArrayList;
import java.util.Scanner;


public class GioHang{
    private ArrayList<SanPham> gioHang;
    private String maGH;
    private Kho kho = new Kho();

    Scanner sc = new Scanner(System.in);
    
    public GioHang(){
        this.gioHang = new ArrayList<>();
        this.maGH = "GH";
        this.kho.docDataTuFile();
    }

    public ArrayList<SanPham> getDanhSachSP() {
        return gioHang;
    }
    public String getMaGH(){
        return this.maGH;
    }

    public void setMaGH(int sizeDSGio){
        this.maGH = "GH"+ sizeDSGio;
    }
    public void setDanhSachSP(ArrayList<SanPham> gioHang) {
        this.gioHang = gioHang;
    }
    public void themVaoGio(String maSP){
    	while (true) {
    		System.out.println("Nhap vao ma san pham: ");
            maSP = sc.nextLine();
        	for(SanPham sanPham : kho.khoHang) {
            if (maSP.matches(sanPham.maSP)) {
            	this.gioHang.add(kho.laySPtheoMa(maSP));
            	return;
            } else {
                System.out.println("Nhap sai vui long nhap lai Ma SP!!");
            }}
        }
    }
    public void themVaoGion(){
    	while (true) {
    		System.out.println("Nhap vao ma san pham: ");
            String maSP = sc.nextLine();
        	for(SanPham sanPham : kho.khoHang) {
            if (maSP.matches(sanPham.maSP)) {
            	this.gioHang.add(kho.laySPtheoMa(maSP));
            	return;
            } else {
                System.out.println("Nhap sai vui long nhap lai Ma SP!!");
            }}
        }
    }
   
   
    public void inTenSPvaDonGia(){
        for (SanPham sanPham : gioHang) {
            System.out.println(sanPham.getTenSP()+ "    |   "+ sanPham.getDonGia());
        
    }
    }

    public void xoaKhoiGioHang(int vitri){
        if(vitri >= 0 && vitri < gioHang.size()){
            this.gioHang.remove(vitri);
        }
        else{
            System.out.println("Vi tri ban nhap vao la so am hoac vi tri lon hon so luong trong gio hang.");
        }
    }
    public void xoaKhoiGioHang(String maSP){
        for (SanPham sanPham : gioHang) {
            if(sanPham.getMaSP().equals(maSP)){
                this.gioHang.remove(sanPham);
                System.out.println("Da xoa san pham co ma | "+maSP+" | trong gio.");
            }
        }
    }
    public void xoaTatCa(){
        this.gioHang.clear();
    }

    public int tinhTien(){
        int tong = 0;
        for (SanPham sanPham : gioHang) {
            tong += sanPham.getDonGia();
        }
        return tong;
    }
    public int gioHangSize(){
        int count = 0;
        for (SanPham sanPham : gioHang) {
            count++;
        }
        return count;
    }

    public String layAllMaSP(){
        String allMaSP = "";
        for (SanPham sanPham : gioHang) {
            allMaSP += ", "+ sanPham.getMaSP();
        }
        return allMaSP;
    }
    public void inGioHang(){
        System.out.println("========== GIO HANG =========="+" "+this.maGH);
        if(this.gioHang.isEmpty())
        {
        	System.out.println("Gio hang dang trong!");
        	return;
        }
        
        for (SanPham sanPham : this.gioHang) {
            sanPham.xuat();
        }
        System.out.println("==============================");
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
    public String toString(){
        return this.maGH+ this.layAllMaSP()+ "\n";
    }
}
