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
    Scanner input = new Scanner(System.in);
    Kiemtra kt = new Kiemtra();

    public Employeelist() {
        this.employees = new ArrayList<>();

    }

    public void Nhap() {
        Employee newEmployee = new Employee();
        newEmployee.Nhap();
        employees.add(newEmployee);

    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void Xoa() {
        System.out.println("Nhap vao ma nhan vien muon xoa!");
        String idDelete = kt.kiemtraManhanvien();
        

        for (Employee employee : employees) {
            if (employee.getEmployeeid().equals(idDelete)) {
                employees.remove(employee);
                break;
            }

        }
    }

    public void readEmployeeFile() {
        String fileName = "project_lthdt\\src\\PERSON\\danhsachNV.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean fileIsEmpty = true;
            while ((line = reader.readLine()) != null) {
                Employee.employeeIDcount++;
                fileIsEmpty = false;
                String[] employeeData = line.split(",");
                if (employeeData.length >= 13) {
                    Employee.employeeIDcount++;
                    String fullname = employeeData[0];
                    String birthday = employeeData[1];
                    String phone = employeeData[2];
                    String email = employeeData[3];
                    String gender = employeeData[4];

                    // String [] addressinfor=employeeData[5].split(",");

                    String so = employeeData[5];
                    String duong = employeeData[6];
                    String quan = employeeData[7];
                    String thanhpho = employeeData[8];
                    Address address = new Address(so, duong, quan, thanhpho);

                    String employeeid = employeeData[9];
                    String position = employeeData[10];
                    Double salary = Double.parseDouble(employeeData[11]);
                    String date = employeeData[12];
                    Employee employee = new Employee(fullname, birthday, phone, email, gender, address, employeeid,
                            position, salary, date);
                    employees.add(employee);
                }
            }
            if (fileIsEmpty) {

                this.initializeEmployees();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void findEmployeeID(){
        System.out.println("Nhap vao ma nhan vien:");
        String manv = kt.kiemtraManhanvien();
        for(Employee nv:employees){
            if(nv.getEmployeeid().equals(manv)){
                System.out.println("Employee ID: " + nv.getEmployeeid());
                System.out.println("Name: " + nv.getFullname());
                System.out.println("Birthdate: " + nv.getBirthday());
                System.out.println("Phone number: " + nv.getPhonenumber());
                System.out.println("Email: " + nv.getEmail());
                System.out.println("Gender: " + nv.getGender());
                System.out.println("Address: " + nv.getAddress().toString());
                System.out.println("Position: " + nv.getPosition());
                System.out.println("Salary: " + nv.getSalary());
                System.out.println("---------------------------------");
            }
        }
    }

    public void findEmpplyeeName(){
        System.out.println("Nhap vao ten nhan vien can tim: ");
        String tennv = kt.NhapTen();
        for(Employee nv:employees){
            if(nv.getFullname().equals(tennv)){
                System.out.println("Employee ID: " + nv.getEmployeeid());
                System.out.println("Name: " + nv.getFullname());
                System.out.println("Birthdate: " + nv.getBirthday());
                System.out.println("Phone number: " + nv.getPhonenumber());
                System.out.println("Email: " + nv.getEmail());
                System.out.println("Gender: " + nv.getGender());
                System.out.println("Address: " + nv.getAddress().toString());
                System.out.println("Position: " + nv.getPosition());
                System.out.println("Salary: " + nv.getSalary());
                System.out.println("---------------------------------");
            }
        }
    }

    public void writeEmployeeFile() {
        String fileName = "project_lthdt\\src\\PERSON\\danhsachNV.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Employee employee : employees) {
                writer.write(employee.getFullname() + "," + employee.getBirthday() + "," + employee.getPhonenumber()
                        + "," + employee.getEmail() + "," + employee.getGender() + "," + employee.getDate()
                        + employee.getAddress() + "," + employee.getEmployeeid()
                        + "," + employee.getPosition() + "," + employee.getSalary());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Trong lớp Employeelist
    public void initializeEmployees() {

        Address address1 = new Address("1", "Duong 1", "Quan 1", "TP HCM");
        Employee employee1 = new Employee("Nguyen Van Anh", "01/01/1990", "0123456789", "nvA@example.com", "nam",
                address1, "EMP001", "Quan ly", 1000, "02/02/2004");
        employees.add(employee1);
        Address address2 = new Address("2", "Duong 2", "Quan 2", "TP HCM");
        Employee employee2 = new Employee("Nguyen Van Anh", "01/01/1990", "0123456789", "nvA@example.com", "nam",
                address2,"EMP002", "Quan ly", 1000, "02/02/2004");
        employees.add(employee2);
        Address address3 = new Address("3", "Duong 3", "Quan 3", "TP HCM");
        Employee employee3 = new Employee("Nguyen Van Anh", "01/01/1990", "0123456789", "nvA@example.com", "nam",
                address3, "EMP003", "Quan ly", 1000, "02/02/2004");
        employees.add(employee3);
        Address address4 = new Address("4", "Duong 4", "Quan 4", "TP HCM");
        Employee employee4 = new Employee("Nguyen Van Anh", "01/01/1990", "0123456789", "nvA@example.com", "nam",
                address4, "EMP004", "Quan ly", 1000, "02/02/2004");
        employees.add(employee4);
        Address address5 = new Address("5", "Duong 5", "Quan 5", "TP HCM");
        Employee employee5 = new Employee("Nguyen Van Anh", "01/01/1990", "0123456789", "nvA@example.com", "nam",
                address5, "EMP005", "Quan ly", 1000, "02/02/2004");
        employees.add(employee5);
    }

    public ArrayList<Employee> getEmployeelist() {
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
            System.out.println("Employee ID: " + employee.getEmployeeid());
            System.out.println("Name: " + employee.getFullname());
            System.out.println("Birthdate: " + employee.getBirthday());
            System.out.println("Phone number: " + employee.getPhonenumber());
            System.out.println("Email: " + employee.getEmail());
            System.out.println("Gender: " + employee.getGender());
            System.out.println("Address: " + employee.getAddress().toString());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("---------------------------------");
        }
    }
    public static void main(String[] args) {
        Employeelist le=new Employeelist();
       le.readEmployeeFile();
       le.writeEmployeeFile();
        
    }
}
