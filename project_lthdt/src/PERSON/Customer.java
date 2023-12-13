package PERSON;

import MAIN.Kiemtra;

public class Customer extends person {
    public static int countCus=1;
    public String Customerid;
    public String membership;
    public int loyalpoint;
    Kiemtra kt = new Kiemtra();
    public Customer(String fullname, String birthday, String string, String email, String gender, Address address,
            String customerid, String membership, int loyalpoint) {
        super(fullname, birthday, string, email, gender, address);
        this.Customerid = customerid;
        
    }
    
    public Customer(){
        super();
        this.Customerid=null;
      
    }
    public String getCustomerid() {
        return Customerid;
    }
    public void setCustomerid(String customerid) {
        Customerid = customerid;
    }
    public String getInfor(){
        return  "Customer Id: "+this.Customerid+
                "\nName: "+ this.getFullname()+
                "\nDate of birth: "+this.getBirthday()+
                "\nPhone: "+this.getPhonenumber()+
                "\nEmail: "+this.getEmail()+
                "\nGender: "+this.getGender()+
                "\nAddress: "+this.getAddress().toString();
    }
    public void addLoyaltyPoint(int points)
    {
        this.loyalpoint+=points;
    }
    
    @Override
    public void Nhap() {
        System.out.println("Nhap ten:");
        this.fullname=kt.NhapTen();
        System.out.println("Nhap ngay sinh dang d/m/y:");
        this.birthday=kt.nhapNgay();
        System.out.println("Nhap sdt:");
        this.phonenumber=kt.kiemtraNhapsdt();
        System.out.println("Nhap email:");
        this.email=kt.nhapEmail();
        System.out.println("Nhap gioi tinh:");
        this.gender=kt.ktNhapGioiTinh();
        address.Nhap();
        String createcus = String.format("%03d", (countCus));
        this.setCustomerid("CUS"+ createcus);
        countCus++;
    }
    @Override
    public void Xuat()
    {
    System.out.println("Ten:"+this.fullname);
    System.out.println("Ngay sinh :"+this.birthday);
    System.out.println("Sdt:"+this.phonenumber);
    System.out.println("Email:"+this.email);
    System.out.println("Gioi tinh: "+this.gender);
    System.out.println("Dia chi: "+this.address.toString());

    }
    public static void main(String[] args) {
        Customer ps=new Customer();
        CustomerList lps =new CustomerList();
        ps.Nhap();
        lps.add(ps);
        // lps.removeCustomerById(ps.Customerid);
        // lps.readFile();
        lps.writeFile();
    }
}
