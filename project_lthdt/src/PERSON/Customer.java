package PERSON;

public class Customer extends person {
    public String Customerid;
    public String membership;
    public int loyalpoint;
    public Customer(String fullname, String birthday, String string, String email, String gender, Address address1,
            String customerid, String membership, int i) {
        super(fullname, birthday, string, email, gender, address1);
        Customerid = customerid;
        this.membership = membership;
        this.loyalpoint = i;
    }
    public Customer(String customerid, String membership, int loyalpoint) {
        Customerid = customerid;
        this.membership = membership;
        this.loyalpoint = loyalpoint;
    }
    public Customer(){
        this.Customerid=null;
        this.membership=null;
        this.loyalpoint=0;
    }
    public String getCustomerid() {
        return Customerid;
    }
    public void setCustomerid(String customerid) {
        Customerid = customerid;
    }
    public String getMembership() {
        return membership;
    }
    public void setMembership(String membership) {
        this.membership = membership;
    }
    public int getLoyalpoint() {
        return loyalpoint;
    }
    public void setLoyalpoint(int loyalpoint) {
        this.loyalpoint = loyalpoint;
    }
    public String getInfor(){
        return  "Customer Id: "+this.Customerid+
                "\nName: "+ this.getFullname()+
                "\nDate of birth: "+this.getBirthday()+
                "\nPhone: "+this.getPhonenumber()+
                "\nEmail: "+this.getEmail()+
                "\nGender: "+this.getGender()+
                "\nAddress: "+this.getAddress().toString()+
                "\nMembership:"+this.getMembership()+
                "\nLoyalty point: "+this.getLoyalpoint();
    }
    public void addLoyaltyPoint(int points)
    {
        this.loyalpoint+=points;
    }
    @Override
    public void Nhap()
    {
        super.Nhap();
        System.out.println("Nhap vao ma khach hang:");
        this.Customerid=kt.kiemtraMakhachhang(); 
        System.out.println("Nhap vao Membership:");
        this.membership=kt.nhapChuoi();
        System.out.println("Nhap vao diem loyalpoint:");
        this.loyalpoint=kt.KiemTraNhapSoTuNhien();
    }
    public static void main(String[] args) {
        Customer ps=new Customer();
        CustomerList lps =new CustomerList();
        ps.Nhap();
        lps.add(ps);
        lps.readFile();
        lps.writeFile();
    }
}
