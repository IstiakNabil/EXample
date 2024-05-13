import java.util.Scanner;

public class UserAccountManager {
    private UserInfo userInfo;

    public UserAccountManager() {
        userInfo = null;
    }

    public boolean signUp(String username, String password, String email, String fullName, String phoneNumber) {
        if (userInfo == null) {
            userInfo = new UserInfo(username, password, email, fullName, phoneNumber);
            System.out.println("Sign-up successful. Please log in.");
            return true; // Sign-up successful
        } else {
            System.out.println("A user has already signed up. Please log in.");
            return false; // Sign-up failed
        }
    }

    public boolean login(String username, String password) {
        if (userInfo == null) {
            System.out.println("No users have signed up yet. Please sign up first.");
            return false;
        } else if (userInfo.getUsername().equals(username) && userInfo.getPassword().equals(password)) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }
}


class UserInfo {
    private String username;
    private String password;
    private String phoneNumber;
    private String bankAccount;
    private String nid;

    public UserInfo(String username, String password, String phoneNumber, String bankAccount, String nid) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.bankAccount = bankAccount;
        this.nid = nid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
