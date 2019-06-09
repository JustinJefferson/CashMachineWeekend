package rocks.zipcode.atm.bank;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private String email;
    private String username;
    private Integer pin;
    private Map<Integer, Account> accounts = new HashMap<>();

    public User(){
        name = "";
        email = "";
        username = "";
        pin = 0;
        accounts.put(1000, new BasicAccount(new AccountData(
                1000, "Example 1", "example1@gmail.com", 500
        )));
    }

    public User(String name, String email, String username, Integer pin) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.pin = pin;
        accounts.put(1000, new BasicAccount(new AccountData(
                1000, name, email, 100)));
        accounts.put(1001, new PremiumAccount(new AccountData(
                1001, name, email, 0)));
        accounts.put(1002, new SavingsAccount(new AccountData(
                1003, name, email, 1000)));

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }
}
