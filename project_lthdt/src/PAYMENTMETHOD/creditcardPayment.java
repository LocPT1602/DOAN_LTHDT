package PAYMENTMETHOD;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class creditcardPayment extends Payment {
	private String sothe, tenthe;
	private String matkhau, tenchuthe;
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
	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getTenchuthe() {
		return tenchuthe;
	}

	public void setTenchuthe(String tenchuthe) {
		this.tenchuthe = tenchuthe;
	}

	@Override
	public void Nhap() {
		super.Nhap();
		System.out.println("Nhap thong tin the: ");
		System.out.println("Nhap so the: ");
		this.sothe = sc.nextLine();
		System.out.println("Nhap ten the: ");
		this.tenthe = sc.nextLine();
		System.out.println("Nhap mat khau: ");
		this.matkhau = sc.nextLine();
		System.out.println("Nhap ten chu the: ");
		this.tenchuthe = sc.nextLine();
	}

	@Override
	public String toString() {
		setTrangthai("Completed");
		return "So the: " + sothe + 
				"\nTen the: " + tenthe + 
				"\nTen chu the: " + tenchuthe +
				"\nTrangthai: " + getTrangthai() ;
	}
	public String getcreditcardPaymentDetail() {
		setPhuongthuc("Credit card");
		return  "Phuong thuc thanh toan: " + getPhuongthuc() +
				"\nSo the: " + sothe + 
				"\nTen the: " + tenthe + 
				"\nTen chu the: " + tenchuthe;
	}
	public void writeMoneyToFile() {
		String filename = "project_lthdt/src/PAYMENTMETHOD/inbill.txt";
		try (FileWriter fw = new FileWriter(filename)){
			fw.write(getcreditcardPaymentDetail());
			System.out.println("Thong tin da duoc ghi.");
		} catch (IOException e) {
			System.out.println("Thong tin chua duoc ghi do loi.");
			e.printStackTrace();
		}
	}
	@Override
	public void ghiXuongFile() {
		writeMoneyToFile();
	}
}
