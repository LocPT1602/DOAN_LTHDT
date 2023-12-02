package PERSON;
import MAIN.Kiemtra;
public class Employee extends person {
    public String employeeid;
    public String position;
    public double salary;
    public String date;
    public Employee(String fullname, String birthday, String phonenumber, String email, String gender, Address address,
            String employeeid, String position, double salary, String date) {
        super(fullname, birthday, phonenumber, email, gender, address);
        this.employeeid = employeeid;
        this.position = position;
        this.salary = salary;
        this.date = date;
    }
    public Employee(String employeeid, String position, int salary, String date) {
        this.employeeid = employeeid;
        this.position = position;
        this.salary = salary;
        this.date = date;
    }
    public Employee(){
        this.employeeid=null;
        this.position=null;
        this.salary=0;
        this.date=null;

    }
    public String getEmployeeid() {
        return employeeid;
    }
    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public void Nhap() {
        super.Nhap();
        System.out.println("Nhap vao employeeid:");
        this.employeeid=kt.kiemtraManhanvien();
        System.out.println("Nhap vao  chuc vu :");
        this.position=kt.nhapChuoi();
        System.out.println("Nhap vao luong");
        this.salary=kt.nhapDoubleDuong();
        System.out.println("Nhap vao ngay vao lam (d/m/y): ");
        this.date=kt.nhapNgay();
    }
    public String getInfor()
    {return  "Employee id: "+this.getEmployeeid()+
            "/nPosition: "+this.getPosition()+
            "\nName: "+this.getFullname()+
            "\nDateBirth: "+this.getPhonenumber()+
            "\nEmail: "+this.getEmail()+
            "\nGender: "+this.getGender()+
            "\nAddress: "+this.getAddress().toString()+
            "\nSalary: "+this.getSalary()+
            "\nEmloymentDate: "+this.getDate();
        
    }
    public int getNamlam()
    {
        int namvao=Integer.parseInt(date.substring(0,4));
        int namhientai=java.time.Year.now().getValue();
        return namhientai-namvao;
    }
    public static void main(String[] args) {
        Employeelist empl =new Employeelist();
        Employee emp= new Employee();
        emp.Nhap();
        empl.add(emp);
        empl.readEmployeeFile();
        empl.writeEmployeeFile();
    }
}
