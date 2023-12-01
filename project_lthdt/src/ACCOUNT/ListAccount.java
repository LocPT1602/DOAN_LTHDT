

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import MAIN.Kiemtra;

class ListAccount implements Iterable<Account> {
    private ArrayList<Account> accounts;
    private int n;

    public ListAccount() {
        accounts = new ArrayList<>();
        n = 0;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        n++;
    }

    public void readAccount() throws IOException {
        // Thay đổi đường dẫn tới file thực tế trên hệ thống của bạn
        String filePath = "D:\\Năm hai\\DoAnLTHDT\\project_lthdt\\src\\ACCOUNT\\ListProduct.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Xử lý dòng đọc từ file và tạo đối tượng Account
                // Thêm tài khoản vào danh sách
                // ...
            }
        }
    }

    public void printAcc() {
        for (Account account : accounts) {
            // In thông tin tài khoản ra màn hình
            // ...
        }
    }

    public void deleteAccount(String username) {
        Iterator<Account> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getUsername().equals(username)) {
                iterator.remove();
                n--;
                break;
            }
        }
    }

    public void writeAccount() throws IOException {
        String filePath = "D:\\Năm hai\\DoAnLTHDT\\project_lthdt\\src\\ACCOUNT\\ListProduct.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Account account : accounts) {
                writer.write(account.getUsername() + " " + account.getPassword());
                writer.newLine();
            }
        }
    }

    @Override
    public Iterator<Account> iterator() {
        return accounts.iterator();
    }

    // Đoạn mã kiểm thử trong hàm main
    public static void main(String[] args) {
        ListAccount listAccount = new ListAccount();

        try {
            // Đọc danh sách tài khoản từ file
            listAccount.readAccount();

            // In danh sách tài khoản ra màn hình
            listAccount.printAcc();

            // Xóa một tài khoản
            listAccount.deleteAccount("usernameToDelete");

            // Ghi danh sách tài khoản vào file
            listAccount.writeAccount();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}