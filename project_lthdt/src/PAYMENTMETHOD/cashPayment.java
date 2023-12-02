package PAYMENTMETHOD;

import java.util.Scanner;

<<<<<<< HEAD
public class cashPayment extends Payment {
	private String tenthungan;
	private int sotien;
	private int tienthua;
=======
public class cashPayment extends Payment{
		private String tenthungan;
		private int sotien;
		private int tienthua;
>>>>>>> 5319589781a6e31c65c1ebd241dc8fa068cca63a

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
		System.out.println("Nhap so tien thanh toan bang tien mat: ");
		this.sotien = sc.nextInt();
	}

	@Override
	public String toString() {
		return "tenthungan=" + tenthungan +
				"\n sotien=" + sotien +
				"\ntienthua=" + tienthua;
	}
}
