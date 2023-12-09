package PERSON;

// import java.util.Scanner;

import java.util.Scanner;
import MAIN.Kiemtra;
public class Address {
    private String so;
    private String duong;
    private String quan;
    private String thanhpho;
    Scanner input =new Scanner(System.in);
    Kiemtra kt =new Kiemtra();
 public Address(String so, String duong, String quan, String thanhpho) {
        this.so = so;
        this.duong = duong;
        this.quan = quan;
        this.thanhpho = thanhpho;
        
    }
 public Address()
 {
     so=null;
     duong= null;
     quan=null;
     thanhpho=null;
 }
    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getDuong() {
        return duong;
    }

    public void setDuong(String duong) {
        this.duong = duong;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getThanhpho() {
        return thanhpho;
    }

    public void setThanhpho(String thanhpho) {
        this.thanhpho = thanhpho;
    }

    public void Nhap()
    {
        System.out.println("Nhap so nha");
        this.so=kt.nhapChuoi();
        System.out.println("Nhap duong");
        this.duong=kt.nhapChuoi();
        System.out.println("Nhap quan");
        this.quan=kt.nhapChuoi();
        System.out.println("Nhap thanh pho");
        this.thanhpho=kt.nhapChuoi();
    }
    
    
    @Override
    public String toString() {
        return "Address{" + "so=" + so + ", duong=" + duong + ", quan=" + quan + ", thanhpho=" + thanhpho + '}';
    }

   
    
}