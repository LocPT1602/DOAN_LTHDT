package PAYMENTMETHOD;


public class Payment {
    private int sotien;
	private String phuongthuc;
	private String trangthai = "Pending";
	Scanner sc = new Scanner (System.in);
	
	public Payment() {
		this.sotien = 0;
		this.phuongthuc = null;
		this.trangthai = "Pending";
	}
	public Payment(int sotien, String phuongthuc, String trangthai) {
		this.sotien = sotien;
		this.phuongthuc = phuongthuc;
		this.trangthai = trangthai;
	}
	public int getSotien() {
		return sotien;
	}
	public void setSotien(int sotien) {
		this.sotien = sotien;
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
	@Override
	public void Nhap() {
		super.Nhap();
		System.out.println("Cap nhat gia tri thanh toan: ");
	}
	@Override
	public String toString() {
		return "So tien=" + sotien + 
				"\nPhuong thuc=" + phuongthuc + 
				"\nTrang thai=" + trangthai ;
	}
}
