package PAYMENTMETHOD;
import ORDER.*;
public class Payment {
	private double sotien;
	protected double tongtien;
	private String phuongthuc;
	private String trangthai = "Pending";
	Order o = new Order();
	public Payment() {
		this.sotien = 0;
		this.phuongthuc = null;
		this.trangthai = "Pending";
		
	}

	public Payment(int sotien, String phuongthuc, String trangthai, Order o) {
		this.sotien = sotien;
		this.phuongthuc = phuongthuc;
		this.trangthai = trangthai;
		this.o = o;
	}

	public double getSotien() {
		return sotien;
	}

	public void setSotien(int sotien) {
		this.sotien = sotien;
	}
	public double getTongtien(){
		return o.tinhTongSoTien();
	}
	public void setTongtien(double tongtien){
		this.tongtien = tongtien;
	}
	public String getPhuongthuc() {
		return phuongthuc;
	}

	public void setPhuongthuc(String phuongthuc) {
		this.phuongthuc = phuongthuc;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	
	public void Nhap() {
		System.out.println(getTrangthai() + "...");
	}

	@Override
	public String toString() {
		return"\nPhuong thuc: " + phuongthuc ;
				
	}

	public void ghiXuongFile() {
		
		
	}
}
