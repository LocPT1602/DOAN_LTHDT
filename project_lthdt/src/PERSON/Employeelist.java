package PERSON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import MAIN.Kiemtra;
public class Employeelist implements Iterable<Employee> {
    private ArrayList<Employee> employees;
    Scanner input=new Scanner(System.in);
    Kiemtra kt =new Kiemtra();

    public Employeelist(){
        this.employees=new ArrayList<>();
        
    }
    public void Nhap()
    {
        Employee newEmployee= new Employee();
        newEmployee.Nhap();
        employees.add(newEmployee);

    }
    public void add(Employee employee) {
        employees.add(employee);
    }
    public void Xoa()
    {   System.out.print("Nhap vao ma nhan vien muon xoa!");
        String idDelete= kt.kiemtraManhanvien();
        Iterator<Employee> iterator = employees.iterator();

        for(Employee employee:employees)
        {if( employee.getEmployeeid().equals(idDelete))
                {
                    employees.remove(employee);
                    break;
                }
            
        }
    }
    public void readEmployeeFile() 
    {   String fileName="project_lthdt\\src\\PERSON\\danhsachNV.txt";
        try(BufferedReader reader= new BufferedReader(new FileReader(fileName)))
        {
            String line;
            boolean fileIsEmpty = true;
            while((line=reader.readLine())!=null)
            {   fileIsEmpty=false;
                String [] employeeData=line.split(",");
                String fullname=employeeData[0];
                String  birthday=employeeData[1];
                String phone=employeeData[2];
                String email=employeeData[3];
                String gender= employeeData[4];
                
                // String [] addressinfor=employeeData[5].split(",");
                
                String so=employeeData[5];
                String duong=employeeData[6];
                String quan=employeeData[7];
                String thanhpho=employeeData[8];
                Address address=new Address(so,duong, quan, thanhpho);
                
                String employeeid=employeeData[9];
                String position=employeeData[10];
                Double salary=Double.parseDouble(employeeData[11]);
                String date=employeeData[12];
                Employee employee  =new Employee(fullname,birthday,phone,email,gender,address,employeeid,position,salary,date);
                employees.add(employee);
               
            }
             if (fileIsEmpty) {
                    this.initializeEmployees();
                 }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void writeEmployeeFile() {
        String fileName="project_lthdt\\src\\PERSON\\fileghiNV.txt";
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(fileName,true)))
        {
           for(Employee employee:employees)
           {
               writer.write(employee.getFullname( )+ "," + employee.getBirthday()+","+employee.getPhonenumber()+","+employee.getEmail()+","+employee.getGender()+","+employee.getDate()+employee.getAddress()+","+employee.getEmployeeid()
                       +","+employee.getPosition()+","+employee.getSalary());
               writer.newLine();
           }
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
     // Trong lớp Employeelist
public void initializeEmployees() {
    
    Address address1 = new Address("1", "Duong 1", "Quan 1", "TP HCM");
    Employee employee1 = new Employee("Nguyen Van Anh", "01/01/1990", "0123456789", "nvA@example.com", "nam", address1, "EMP0001", "Quan ly", 1000, "02/02/2004");
    employees.add(employee1);
    Address address2 = new Address("2", "Duong 2", "Quan 2", "TP HCM");
    Employee employee2 = new Employee();
    employees.add(employee2);
    Address address3 = new Address("3", "Duong 3", "Quan 3", "TP HCM");
    Employee employee3 = new Employee();
    employees.add(employee3);
    Address address4 = new Address("4", "Duong 4", "Quan 4", "TP HCM");
    Employee employee4 = new Employee();
    employees.add(employee4);
    Address address5 = new Address("5", "Duong 5", "Quan 5", "TP HCM");
    Employee employee5 = new Employee();
    employees.add(employee5);
}
    
    public ArrayList<Employee> getEmployeelist(){
        return employees;
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < employees.size() && employees.get(currentIndex) != null;
            }

            @Override
            public Employee next() {
                return employees.get(currentIndex++);
            }
        };
    }
    public void displayInfo() {
        for (Employee employee : employees) {
            System.out.print("Employee ID: " + employee.getEmployeeid());
            System.out.print("Name: " + employee.getFullname());
            System.out.print("Birthdate: " + employee.getBirthday());
            System.out.print("Phone number: " + employee.getPhonenumber());
            System.out.print("Email: " + employee.getEmail());
            System.out.print("Gender: " + employee.getGender());
            System.out.print("Address: " + employee.getAddress().toString());
            System.out.print("Position: " + employee.getPosition());
            System.out.print("Salary: " + employee.getSalary());
            System.out.print("---------------------------------");
        }
    }
}


