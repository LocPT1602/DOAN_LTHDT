package PAYMENTMETHOD;

import java.util.Scanner;

public class creditcardPayment extends Payment {
	private String sothe, tenthe;
	Scanner sc = new Scanner(System.in);

	public String getSothe() {
		return sothe;
	}

	public void setSothe(String sothe) {
		this.sothe = sothe;
	}

	public String getTenthe() {
		return tenthe;
	}

	public void setTenthe(String tenthe) {
		this.tenthe = tenthe;
	}

	@Override
	public void Nhap() {
		super.Nhap();
		System.out.println("Nhap thong tin the: ");
		System.out.println("Nhap mat khau: ");
		String matkhau = sc.nextLine();
		System.out.println("Nhap ten chu the: ");
		String tenchuthe = sc.nextLine();
	}

	@Override
	public String toString() {
		return "sothe=" + sothe +
				"\ntenthe=" + tenthe;
	}
}