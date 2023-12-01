package project_lthdt.PERSON;

public class person {
    protected String fullname;
    protected String birthday;
    protected String phonenumber;
    protected String email;
    protected String gender;
    protected Address address =new Address();


public person(String fullname, String birthday, String phonenumber, String email, String gender, Address address) {
    this.fullname = fullname;
    this.birthday = birthday;
    this.phonenumber = phonenumber;
    this.email = email;
    this.gender = gender;
    this.address = address;
}
public person(){
    this.fullname="";
    this.birthday="";
    this.phonenumber="";
    this.email="";
    this.gender="";

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
    setFullname(fullname);
    System.out.println("Nhap ngay sinhdang d/m/y:");
    setBirthday(birthday);
    System.out.println("Nhap sdt:");
    setPhonenumber(phonenumber);
    System.out.println("Nhap email:");
    setEmail(email);
    System.out.println("Nhap gioi tinh:");
    setGender(gender);
    
    
}

}