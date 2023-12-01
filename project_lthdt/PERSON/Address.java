package project_lthdt.PERSON;

public class Address {
    private String so;
    private String duong;
    private String quan;
    private String thanhpho;
    
public Address(String so, String duong, String quan, String thanhpho) {
        this.so = so;
        this.duong = duong;
        this.quan = quan;
        this.thanhpho = thanhpho;
    }
public Address(){
    this.so="";
    this.duong="";
    this.quan="";
    this.thanhpho="";
}

}