package PRODUCTS;

import java.util.ArrayList;


public class GioHang{
    private ArrayList<SanPham> gioHang;
    private String maGH;
    private Kho kho = new Kho();

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
    
    public void themVaoGio(SanPham sp){
    kho.laySPtheoMa(sp.maSP);
    if(kho.laySPtheoMa(sp.maSP)==null)
    {
    	return;
    }
    this.gioHang.add(sp);
    }
    public void themVaoGio(String maSP){
        this.gioHang.add(kho.laySPtheoMa(maSP));
    }
   
    public void inGioHang(){
        System.out.println("========== GIO HANG =========="+" "+this.maGH);
        if(this.gioHang.isEmpty())
        {
        	System.out.println("Gio hang dang trong!");
        	return;
        }
        
        for (SanPham sanPham : this.gioHang) {
        	if(kho.laySPtheoMa(sanPham.getMaSP()) == null)
        	return;
            sanPham.xuat();
        }
        System.out.println("==============================");
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
