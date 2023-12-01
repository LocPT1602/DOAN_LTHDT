package PAYMENTMETHOD;


public class payment {
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
	public class creditcardPayment extends Payment {
		private String sothe, tenthe;

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
