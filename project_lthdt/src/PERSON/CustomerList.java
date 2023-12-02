package PERSON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerList {
    private ArrayList<Customer> Customers;

    public CustomerList() {

        this.Customers = new ArrayList<>();
    }

    // đọc file C:\\Users\\admin\\OneDrive\\Tài liệu\\GitHub\\DOAN_LTHDT\\
    public void readFile() {
        String fileName = "D:\\Năm hai\\DoAnLTHDT\\project_lthdt\\src\\PERSON\\danhsachkhachhang.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean fileIsEmpty = true;
            while ((line = reader.readLine()) != null) {
                fileIsEmpty = false;

                String[] customerData = line.split(",");
                String fullname = customerData[0];
                String birthday = customerData[1];
                String phone = customerData[2];
                String email = customerData[3];
                String gender = customerData[4];
                // String []addressInfor=customerData[5].split(",");

                String so = customerData[5];
                ;
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

    private void defaultCustomers() {

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
        Customer customer4 = new Customer("3", "03/03/2003", "0123456789", "3@gmail.com", "Nam", address3, "CUS003",
                "gold", 200);
        Customers.add(customer4);
        Address address5 = new Address("5", "Duong 5", "Quan 5", "TP HCM");
        Customer customer5 = new Customer("3", "03/03/2003", "0123456789", "3@gmail.com", "Nam", address3, "CUS003",
                "gold", 200);
        Customers.add(customer5);
    }

    public void writeFile() {
        String fileName = "project_lthdt\\src\\PERSON\\fileghiKH.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // Ghi header của bảng
            String header = String.format(
                    "%-20s %-12s %-15s %-25s %-10s %-30s %-10s %-15s %-15s",
                    "Fullname", "Birthday", "Phone", "Email", "Gender", "Address", "Customer ID", "Membership",
                    "Loyal Points");
            writer.write(header);
            writer.newLine();

            // Ghi dữ liệu khách hàng
            for (Customer customer : Customers) {
                String line = String.format(
                        "%-20s %-12s %-15s %-25s %-10s %-30s %-10s %-15s %-15d",
                        customer.getFullname(), customer.getBirthday(), customer.getPhonenumber(), customer.getEmail(),
                        customer.getGender(), customer.getAddress(), customer.Customerid, customer.getMembership(),
                        customer.getLoyalpoint());
                writer.write(line);
                writer.newLine();
            }
            writer.newLine(); // Dòng trống giữa các bảng
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Customer> getListCustomer() {
        return Customers;
    }

}
