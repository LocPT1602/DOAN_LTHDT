
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        for (Account account : accounts) {
            System.out.println("tai khoan la : " + account.username);
            System.out.println("mau khau la : " + account.password);
        }
    }

    public List<Account> loadAccounts() throws IOException {
        String filePath = "D:\\Năm hai\\DoAnLTHDT\\project_lthdt\\src\\ACCOUNT\\ListAccount.txt";
        List<Account> accounts = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length == 2) {
                String username = parts[0];
                String password = parts[1];
                // boolean confirm = Boolean.parseBoolean(parts[2]);
                Account account = new Account(username, password, "");
                accounts.add(account);
            }
        }
        reader.close();
        return accounts;
    }

    public void saveAccounts(List<Account> accounts) throws IOException {
        String filePath = "D:\\Năm hai\\DoAnLTHDT\\project_lthdt\\src\\ACCOUNT\\ListAccount.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        for (Account account : accounts) {
            writer.write(account.getUsername() + " " + account.getPassword());
            writer.newLine();
        }
        writer.close();
    }

    public void deleteAccount(String username) throws IOException {
        List<Account> accounts = loadAccounts();
        Iterator<Account> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getUsername().equals(username)) {
                iterator.remove();
                break;
            }
        }
        saveAccounts(accounts);
    }

    public void writeAccount() throws IOException {
        String filePath = "D:\\Năm hai\\DoAnLTHDT\\project_lthdt\\src\\ACCOUNT\\ListAccount.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (Account account : accounts) {
                writer.write(account.getUsername() + " " + account.getPassword());
                writer.newLine();
                System.out.println("Đã ghi vào file thành công");
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