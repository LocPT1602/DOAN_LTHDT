package PAYMENTMETHOD;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class cashPayment extends Payment {
	private int sotien;
	private double tienthua;


	Scanner sc = new Scanner(System.in);
	public cashPayment(){
		this.sotien = 0;
		this.tienthua = 0;
	}
	public cashPayment(int sotien, double tienthua){
		this.sotien = sotien;
		this.tienthua = tienthua;

	}


	public double getSotien() {
		return sotien;
	}

	public void setSotien(int sotien) {
		this.sotien = sotien;
	}

	public double getTienthua() {
		return tienthua;
	}

	public void setTienthua(double sotien) {
		this.tienthua = sotien - getTongtien() ;
	}

	@Override
	public void Nhap() {
		super.Nhap();
		System.out.println("Nhap so tien thanh toan bang tien mat: ");
		this.sotien = sc.nextInt();
		setTienthua(sotien);
	}

	@Override
	public String toString() {
		setTrangthai("Completed");
		return 
				"\nDa nhan: " + getSotien() + 
				"\nTien thua: " + getTienthua() +
				"\nTrang thai: " + getTrangthai();
	}
	public String getcashPaymentDetail() {
		setPhuongthuc("Tien mat");
		return  "Phuong thuc thanh toan: " + getPhuongthuc() +
				"\nDa nhan: " + getSotien() + 
				"\nTien thua: " + getTienthua();
	}
	public void writeCashToFile() {
		String filename = "project_lthdt/src/PAYMENTMETHOD/inbill.txt";
		try (FileWriter fw = new FileWriter(filename)){
			fw.write(getcashPaymentDetail());
			System.out.println("Thong tin da duoc ghi.");
		} catch (IOException e) {
			System.out.println("Thong tin chua duoc ghi do loi.");
			e.printStackTrace();
		}
	}
	@Override
	public void ghiXuongFile() {
		writeCashToFile();
	}
}
