import java.util.Scanner;

public class account {
    public String password;
    public String username;
    public String confirm;
    Scanner sc = new Scanner(System.in);

    public account() {
        password = "";
        username = "";
        confirm = "";
    }

    public account(String password, String username, String confirm) {
        this.password = password;
        this.username = username;
        this.confirm = confirm;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setPassword() {
        password = sc.nextLine();
    }

    public void setUsername() {
        username = sc.nextLine();
    }

    public void setConfirm() {
        confirm = sc.nextLine();
    }

    public static void main(String[] args) {

    }
}
