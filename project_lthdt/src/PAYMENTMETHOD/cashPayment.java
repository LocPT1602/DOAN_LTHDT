package PAYMENTMETHOD;

import java.util.Scanner;

public class cashPayment extends payment {
	private String tenthungan;
	private int sotien;
	private int tienthua;

	Scanner sc = new Scanner(System.in);

	public String getTenthungan() {
		return tenthungan;
	}

	public void setTenthungan(String tenthungan) {
		this.tenthungan = tenthungan;
	}

	public int getSotien() {
		return sotien;
	}

	public void setSotien(int sotien) {
		this.sotien = sotien;
	}

	public int getTienthua() {
		return tienthua;
	}

	public void setTienthua(int tienthua) {
		this.tienthua = tienthua;
	}

	@Override
	public void Nhap() {
		super.Nhap();
		System.out.println("Nhap ten thu ngan: ");
		this.tenthungan = sc.nextLine();
		System.out.println("Nhap so tien thanh toan bang tien mat: ");
		this.sotien = sc.nextInt();
		System.out.println("Nhap so tien thua: ");
		this.tienthua = sc.nextInt();
	}

	@Override
	public String toString() {
		setTrangthai("Completed");
		return "Ten thu ngan: " + getTenthungan() + 
				"\nSo tien: " + getSotien() + 
				"\nTien thua: " + getTienthua() +
				"\nTrang thai: " + getTrangthai();
	}
}
