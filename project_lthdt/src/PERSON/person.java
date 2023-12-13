package PERSON;

import MAIN.Kiemtra;

public abstract class person {
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

public abstract void Nhap();
public abstract void Xuat();

@Override
public String toString() {
    return "person [fullname=" + fullname + ", birthday=" + birthday + ", phonenumber=" + phonenumber + ", email="
            + email + ", gender=" + gender + ", address=" + address + "]";
}
}