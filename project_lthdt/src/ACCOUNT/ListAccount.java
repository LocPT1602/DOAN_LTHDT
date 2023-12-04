
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

        String filePath = "D:\\Năm hai\\DoAnLTHDT\\project_lthdt\\src\\ACCOUNT\\ListAccount.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 2) {
                    String username = parts[1];
                    String password = parts[0];
                    account account = new account(username, password, "");
                    addAccount(account);
                } else {
                    // Xử lý trường hợp dòng không hợp lệ, nếu cần thiết
                }
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
                writer.write(account.getUsername() + " " + account.getPassword());
                writer.newLine();
            }
        }
    }

    @Override
    public Iterator<account> iterator() {
        return accounts.iterator();
    }

    public static void main(String[] args) {
        ListAccount listAccount = new ListAccount();

        try {

            // listAccount.readAccount();
            listAccount.printAcc();

            // listAccount.printAcc();

            // listAccount.deleteAccount("usernameToDelete");

            listAccount.writeAccount();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}