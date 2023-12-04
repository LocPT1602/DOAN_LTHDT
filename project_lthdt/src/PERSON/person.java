package PERSON;

import MAIN.Kiemtra;

public class person {
    protected String fullname;
    protected String birthday;
    protected String phonenumber;
    protected String email;
    protected String gender;
    protected Address address = new Address();
    Kiemtra kt = new Kiemtra();

    public person(String fullname, String birthday, String phonenumber, String email, String gender, Address address) {
        this.fullname = fullname;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
        this.email = email;
        this.gender = gender;
        this.address = address;
    }

    public person() {
        this.fullname = "";
        this.birthday = "";
        this.phonenumber = "";
        this.email = "";
        this.gender = "";

}
public String getFullname() {
    return fullname;
}
public void setFullname(String fullname) {
    this.fullname = fullname;
}
public String getBirthday() {
    return birthday;
}
public void setBirthday(String birthday) {
    this.birthday = birthday;
}
public String getPhonenumber() {
    return phonenumber;
}
public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getGender() {
    return gender;
}
public void setGender(String gender) {
    this.gender = gender;
}
public Address getAddress() {
    return address;
}
public void setAddress(Address address) {
    this.address = address;
}
// hàm lấy tuổi
public  int getAge(){
    int birthyear=Integer.parseInt(birthday.substring(0),4);
    int currentyear=java.time.Year.now().getValue();
    return currentyear-birthyear;
}
public void Nhap() {
    System.out.println("Nhap ten:");
    this.fullname=kt.KiemTraNhapTen();
    System.out.println("Nhap ngay sinhdang dd/mm/yyyy:");
    this.birthday=kt.nhapNgay();
    System.out.println("Nhap sdt:");
    this.phonenumber=kt.kiemtraNhapsdt();
    System.out.println("Nhap email:");
    this.email=kt.nhapEmail();
    System.out.println("Nhap gioi tinh:");
    this.gender=kt.ktNhapGioiTinh();
    address.Nhap();
    
}
public void Xuat() {
    System.out.println("Ten:"+this.fullname);
    System.out.println("Ngay sinh :"+this.birthday);
    System.out.println("Sdt:"+this.phonenumber);
    System.out.println("Email:"+this.email);
    System.out.println("Gioi tinh: "+this.gender);
    System.out.println("Dia chi: "+this.address.toString());
}
@Override
public String toString() {
    return "person [fullname=" + fullname + ", birthday=" + birthday + ", phonenumber=" + phonenumber + ", email="
            + email + ", gender=" + gender + ", address=" + address + "]";
}
public static void main(String[] args) {
    person ps = new person();
    ps.Nhap();
}
}