package PAYMENTMETHOD;

public class cashPayment extends payment{
		private String tenthungan;
		private int sotien;
		private int tienthua;
		
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
