package PERSON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import MAIN.Kiemtra;

public class CustomerList implements Iterable<Customer> {
    private ArrayList<Customer> Customers;
    Kiemtra kt = new Kiemtra();

    public CustomerList() {

        this.Customers = new ArrayList<>();
    }

    // đọc file C:\\Users\\admin\\OneDrive\\Tài liệu\\GitHub\\DOAN_LTHDT\\
    public void readFile() {
        String fileName = "project_lthdt\\src\\PERSON\\danhsachkhachhang.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean fileIsEmpty = true;
            while ((line = reader.readLine()) != null) {
                Customer.countCus++;
                fileIsEmpty = false;

                String[] customerData = line.split(" ");
                if (customerData.length >= 12) {
                    String fullname = customerData[0];
                    String birthday = customerData[1];
                    String phone = customerData[2];
                    String email = customerData[3];
                    String gender = customerData[4];

                    String so = customerData[5];
                    String duong = customerData[6];
                    String quan = customerData[7];
                    String thanhpho = customerData[8];
                    Address address = new Address(so, duong, quan, thanhpho);
                    String Customerid = customerData[9];
                    String membership = customerData[10];
                    int loyalpoint = Integer.parseInt(customerData[11]);
                    Customer Customer = new Customer(fullname, birthday, phone, email, gender, address, Customerid,
                            membership, loyalpoint);

                    Customers.add(Customer);
                }
            }
            if (fileIsEmpty) {
                this.defaultCustomers();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Customer customer) {
        Customers.add(customer);
    }

    public void displayInfo() {
        for (Customer customer : Customers) {
            System.out.println("Customer ID: " + customer.getCustomerid()); // Sử dụng phương thức getter
            System.out.println("Name: " + customer.getFullname());
            System.out.println("Birthdate: " + customer.getBirthday());
            System.out.println("Phone number: " + customer.getPhonenumber());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Gender: " + customer.getGender());
            System.out.println("Address: " + customer.getAddress().toString());
            System.out.println("---------------------------------\n");
        }
    }

    // public void removeCustomerById(String customerId) {
    // Customer customerToRemove = null;
    // for (Customer customer : Customers) {
    // if (customer.getCustomerid().equals(customerId)) {
    // customerToRemove = customer;
    // break;
    // }
    // }

    // if (customerToRemove != null) {
    // Customers.remove(customerToRemove);
    // writeFile(); // Cập nhật file sau khi xóa khách hàng
    // } else {
    // System.out.println("Khong tim thay khach hang voi ID : " + customerId);
    // }
    // }

    public void defaultCustomers() {

        Address address1 = new Address("1", "Duong 1", "Quan 1", "TP HCM");
        Customer customer1 = new Customer("Nguyen Van An", "01/01/1990", "1234567890", "cusA@example.com", "Nam",
                address1,
                "CUS001", "silver", 100);
        Customers.add(customer1);

        Address address2 = new Address("2", "Duong 2", "Quan 2", "TP HCM");
        Customer customer2 = new Customer("phan thanh loc", "02/02/2004", "1234567890", "loc@gmail.com", "Nam",
                address2, "CUS002", "gold", 200);
        Customers.add(customer2);

        Address address3 = new Address("3", "Duong 3", "Quan 3", "TP HCM");
        Customer customer3 = new Customer("3", "03/03/2003", "0123456789", "3@gmail.com", "Nam", address3, "CUS003",
                "gold", 200);
        Customers.add(customer3);
        Address address4 = new Address("4", "Duong 4", "Quan 4", "TP HCM");
        Customer customer4 = new Customer("3", "03/03/2003", "0123456789", "3@gmail.com", "Nam", address4, "CUS003",
                "gold", 200);
        Customers.add(customer4);
        Address address5 = new Address("5", "Duong 5", "Quan 5", "TP HCM");
        Customer customer5 = new Customer("3", "03/03/2003", "0123456789", "3@gmail.com", "Nam", address5, "CUS003",
                "gold", 200);
        Customers.add(customer5);
    }

    public void findCustomerID() {
        System.out.println("Nhap vao ma khach hang:");
        String makh = kt.kiemtraMakhachhang();
        for (Customer cus : Customers) {
            if (cus.getCustomerid().equals(makh)) {
                System.out.println("Customer ID: " + cus.Customerid);
                System.out.println("Name: " + cus.getFullname());
                System.out.println("Birthdate: " + cus.getBirthday());
                System.out.println("Phone number: " + cus.getPhonenumber());
                System.out.println("Email: " + cus.getEmail());
                System.out.println("Gender: " + cus.getGender());
                System.out.println("Address: " + cus.getAddress().toString());

                System.out.println("---------------------------------\n");
            }
        }
    }

    public void findCusomerName() {
        System.out.println("Nhap vao ten khach hang:");
        String tenkh = kt.NhapTen();
        for (Customer cus : Customers) {
            if (cus.getFullname().equals(tenkh)) {
                System.out.println("Customer ID: " + cus.Customerid);
                System.out.println("Name: " + cus.getFullname());
                System.out.println("Birthdate: " + cus.getBirthday());
                System.out.println("Phone number: " + cus.getPhonenumber());
                System.out.println("Email: " + cus.getEmail());
                System.out.println("Gender: " + cus.getGender());
                System.out.println("Address: " + cus.getAddress().toString());

                System.out.println("---------------------------------\n");
            }
        }
    }

    public void writeFile() {
        String fileName = "project_lthdt\\src\\PERSON\\danhsachkhachhang.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Customer customer : Customers) {
                writer.write(
                        customer.getFullname() + "," + customer.getBirthday() + "," + customer.getPhonenumber() + "," +
                                customer.getEmail() + "," + customer.getGender() + "," + customer.getAddress().getSo()
                                + "," + customer.getAddress().getDuong()
                                + "," + customer.getAddress().getQuan() + "," + customer.getAddress().getThanhpho()
                                + "," + customer.Customerid);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Customer> getListCustomer() {
        return Customers;
    }

    @Override
    public Iterator<Customer> iterator() {
        return new Iterator<Customer>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < Customers.size() && Customers.get(currentIndex) != null;
            }

            @Override
            public Customer next() {
                return Customers.get(currentIndex++);
            }
        };
    }

    public static void main(String[] args) {
        CustomerList CL = new CustomerList();
        CL.readFile();
        CL.writeFile();
    }

}
