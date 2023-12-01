package MAIN;

import java.util.Scanner;


public class Kiemtra {
    Scanner input= new Scanner(System.in);
    public String KiemTraNhapTen() {
        String DauVao;
        while (true) {
            DauVao = input.nextLine();
            if (DauVao.matches("[\\pL\\pMn*\\s*]+")) {
                DauVao = DauVao.trim();
                DauVao = DauVao.replaceAll("\\s+", " ");
                DauVao = DauVao.toLowerCase();
                String[] Chuoi = DauVao.split(" ");
                DauVao = "";
                for (int i = 0; i < Chuoi.length; i++) {
                    DauVao += String.valueOf(Chuoi[i].charAt(0)).toUpperCase() + Chuoi[i].substring(1);
                    if (i < Chuoi.length - 1) {
                        DauVao += " ";
                    }
                }
                return DauVao;
            } else {
                System.out.print("Nhap khong hop le ! moi nhap lai: ");
            }

        }
    }
    public String kiemtraNhapsdt(){
        String dauvao;
        while(true){
            dauvao =input.nextLine();
            if(dauvao.matches("\\d{10}"))
            {
                return dauvao;

            }
            else{
                System.out.println("Nhap sai vui long nhap lai  sdt co 10 so!!!");
            }
        }
    }
    public String nhapEmail() {
        String dauvao;
        while (true) {
           
            dauvao = input.nextLine();

            // Kiểm tra xem chuỗi nhập vào có đúng định dạng email hay không
            if (kiemTraEmail(dauvao)) {
                return dauvao;
            } else {
                System.out.println("Dia chi email khong hop le! Nhap lai.");
            }
        }
    }
    public boolean kiemTraEmail(String email) {
        // Biểu thức chính quy để kiểm tra địa chỉ email
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }
    public String nhapNgay() {
        String ngaySinh;
        while (true) {
           
            ngaySinh = input.nextLine();

            // Kiểm tra xem chuỗi nhập vào có đúng định dạng ngày sinh hay không
            if (kiemTraNgaySinh(ngaySinh)) {
                return ngaySinh;
            } else {
                System.out.println("ngay khong hop le! Nhap lai.");
            }
        }
    }
    public boolean kiemTraNgaySinh(String ngaySinh) {
        // Biểu thức chính quy để kiểm tra định dạng ngày sinh d/m/y
        String regex = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/(19|20)\\d\\d$";
        return ngaySinh.matches(regex);
    }
    public String ktNhapGioiTinh()
    {
        String dauvao;
        while(true)
        {
            dauvao=input.nextLine();
            dauvao.toLowerCase();
            if(dauvao.matches("nam") ||dauvao.matches("nu")||dauvao.matches("Khac"))
            {
                return dauvao;

            }else
            {
                System.out.println("Nhap khong hop le! Nhap lai: ");

            }
        }
    }
    public String nhapChuoi() {
        String chuoi;
        while (true) {
           
            chuoi = input.nextLine();

           
            if (kiemTraChuoi(chuoi)) {
                return chuoi;
            } else {
                System.out.println("Nhap khong hop le.Nhap lai");
            }
        }
    }
    public boolean kiemTraChuoi(String chuoi) {
        // Biểu thức chính quy để kiểm tra tiêu chí của chuỗi
        // Đây chỉ là một ví dụ, bạn cần thay đổi nó theo yêu cầu cụ thể của bạn.
        String regex = "^[a-zA-Z0-9_\\s]+$";
        return chuoi.matches(regex);
    }
}

