

public class Account {
    public String password;
    public String username;
    public String confirm;

    public Account() {
        password = "";
        username = "";
        confirm = "";
    }

    public Account(String password, String username, String confirm) {
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public static void main(String[] args) {

    }
}
