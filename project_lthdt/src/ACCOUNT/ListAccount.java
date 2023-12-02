
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import MAIN.Kiemtra;

class ListAccount implements Iterable<account> {
    private ArrayList<account> accounts;
    private int n;
    Scanner sc = new Scanner(System.in);

    public ListAccount() {
        accounts = new ArrayList<>();
        n = 0;
    }

    public void addAccount(account account) {
        accounts.add(account);
        n++;
    }

    // Thêm phương thức kiểm tra xem một tài khoản có tồn tại trong danh sách không
    public boolean containsAccount(String username) {
        for (account account : accounts) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void readAccount() throws IOException {
        // Thay đổi đường dẫn tới file thực tế trên hệ thống của bạn
        String filePath = "D:\\Năm hai\\DoAnLTHDT\\project_lthdt\\src\\ACCOUNT\\ListAccount.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                // Xử lý dòng đọc từ file và tạo đối tượng Account
                // Thêm tài khoản vào danh sách
                // ...
            }
        }
    }

    public void printAcc() {
        for (account account : accounts) {
            System.out.println("tai khoan la : " + account.username);
            System.out.println("mau khau la : " + account.password);
        }
    }

    public void deleteAccount(String username) throws IOException {
        Iterator<account> iterator = accounts.iterator();

        while (iterator.hasNext()) {
            account account = iterator.next();
            if (account.getUsername().equals(username)) {
                iterator.remove();
                break; // Break once the account is found and removed
            }
        }

        writeAccount();
        System.out.println("Đã xóa tài khoản thành công.");
    }

    public void writeAccount() throws IOException {
        String filePath = "D:\\Năm hai\\DoAnLTHDT\\project_lthdt\\src\\ACCOUNT\\ListAccount.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            for (account account : accounts) {
                writer.newLine();
                writer.write(account.getUsername() + " " + account.getPassword());
                writer.newLine();
            }
        }
    }

    @Override
    public Iterator<account> iterator() {
        return accounts.iterator();
    }

    // Đoạn mã kiểm thử trong hàm main
    public static void main(String[] args) {
        ListAccount listAccount = new ListAccount();

        try {
            // Đọc danh sách tài khoản từ file
            // listAccount.readAccount();
            listAccount.printAcc();

            // // In danh sách tài khoản ra màn hình
            // listAccount.printAcc();

            // // Xóa một tài khoản
            // listAccount.deleteAccount("usernameToDelete");

            // Ghi danh sách tài khoản vào file
            listAccount.writeAccount();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}