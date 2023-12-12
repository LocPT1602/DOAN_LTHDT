
package PAYMENTMETHOD;

import java.util.Scanner;
import MAIN.Kiemtra;
public class PaymentMenu {
	private Payment[] mangtt;
	
	Scanner sc = new Scanner(System.in);
	Kiemtra kt = new Kiemtra();
	

	public PaymentMenu(int size) {
		this.mangtt = new Payment[size];
	}

	public void Menu(int c) {
		switch (c) {
			case 1:
				mangtt[0] = new Payment();
				mangtt[0].setPhuongthuc("Thanh toan bang tien mat");
				System.out.println(mangtt[0].getPhuongthuc());
				mangtt[0] = new cashPayment();
				mangtt[0].Nhap();
				System.out.println(mangtt[0].toString());
				mangtt[0].ghiXuongFile();
				break;
			case 2:
				mangtt[1] = new Payment();
				mangtt[1].setPhuongthuc("Thanh toan bang the");
				System.out.println(mangtt[1].getPhuongthuc());
				mangtt[1] = new creditcardPayment();
				mangtt[1].Nhap();
				System.out.println(mangtt[1].toString());
				mangtt[1].ghiXuongFile();
				break;
			default:
				System.out.println("Yeu cau khong hop le. Vui long nhap lai");
		}
	}

	public void selectPaymentmethod() {
			System.out.println("Chon phuong thuc thanh toan: ");
			System.out.println("So 1: Thanh toan bang tien mat");
			System.out.println("So 2: Thanh toan bang the");
			int c = kt.KiemTraNhapSoTuNhien();
			if (c == 1 || c == 2) {
				Menu(c);
			} else {
				System.out.println("Phuong thuc khong ton tai.");
			}
			
	}

	public static void main(String[] args) {
		PaymentMenu pmm = new PaymentMenu(2);
		pmm.selectPaymentmethod();
	}
}
