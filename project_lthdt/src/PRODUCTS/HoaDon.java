package PRODUCTS;
import PERSON.Employee;
import PERSON.Customer;
import PERSON.Employeelist;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class HoaDon{
    private Date d;
    private int maHD;
    private GioHang gioHang;
    
    private Customer khachHang;
    private Employee nhanVien;
    
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd H:m:s");
    
    Scanner sc = new Scanner(System.in);
    
    public HoaDon(){
        // this.d = new Date(System.currentTimeMillis());
    	
    };
    public HoaDon(GioHang gioHang){
        this.d = new Date(System.currentTimeMillis());
        
        this.maHD *= this.maHD < 0 ? -1 : 1;
        this.gioHang = gioHang;
       
    }
    public HoaDon(Date d, GioHang gioHan){
        this.d = d;
        this.gioHang = gioHang;
       
    }

    public int getMaHD(){
        return this.maHD;
    }
    public GioHang getGioHang(){
        return this.gioHang;
    }

    public static int apDungUuDai(int tong, double giaTriKM){
        return (int) (tong - tong*giaTriKM);
    }
    
    public void xuat(){
    	System.out.println("----Hoa don----");
        System.out.println("Ma hoa don: "+ this.maHD);
        System.out.println("Thoi gian: "+ df.format(this.d));
        System.out.println("================= HOA DON =================");
        gioHang.inTenSPvaDonGia();
        System.out.println("===========================================");
        System.out.println("Tong tien : "+ gioHang.tinhTien());
        //System.out.println("Chiu trach nhiem hoa don: ");
        System.out.println();
        //System.out.println("Cam on quy khach "+ this.khachHang.getCustomerid()+ " da mua san pham cua chung toi.\n");
        
    }
    public void nhap() {
    	
    	System.out.println("nhap Ma hoa don: ");
    	this.setMaHD(sc.nextInt());
    	GioHang gh = new GioHang();
    	Employee nv = new Employee();
    	System.out.println("nhap id nhan vien phu trach : ");
    	String stt = sc.nextLine();   
    	nv.setEmployeeid(stt);
    	int coic;
    	System.out.println("nhap ma san pham vao hoa don: " +"\n chon 0 de ngung nhap ma \n");
    	do {
    	String str = sc.nextLine();
    	gh.themVaoGio(str);
    	System.out.println("\n chon 0 de ngung nhap ma \n");
    	coic = sc.nextInt();
    	}while(coic != 0);
    }
    public Customer getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(Customer khachHang) {
		this.khachHang = khachHang;
	}
	public Employee getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(Employee nhanVien) {
		this.nhanVien = nhanVien;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	public void setGioHang(GioHang gioHang) {
		this.gioHang = gioHang;
	}
	@Override
    public String toString(){
        return this.maHD+ ", "+ df.format(d)+ ", "+this.gioHang.getMaGH()+"\n";
    }
}
