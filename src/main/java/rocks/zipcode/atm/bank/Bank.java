package rocks.zipcode.atm.bank;

import rocks.zipcode.atm.ActionResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZipCodeWilmington
 */
public class Bank {

    private Map<Integer, Account> accounts = new HashMap<>();
    private Map<String, User> users = new HashMap<>();

    public Bank() {
        users.put("Adam", new User("Adam", "Adamloblaw034@gmail.com", "AdamIsGreat03", 1234)); //Changed usernme to Adam from AdamIsGreat03 and pin to 1234 from 7027
        users.put("alicemayer55", new User("Alice", "alicegracemayer@yahoo.com", "alicemayer55",4576));
        users.put("easyaccount", new User("John Doe", "johndoe@zipcode.io", "easyaccount", 1111,
                123, 456, 789));
        users.put("exampleAccount", new User("Jane Doe", "janedoe@zipcode.io", "exampleAccount", 0000,
                700, 800, 2000));

        accounts.put(1000, new BasicAccount(new AccountData(
                1000, "Example 1", "example1@gmail.com", 500
        )));

        accounts.put(2000, new PremiumAccount(new AccountData(
                2000, "Example 2", "example2@gmail.com", 200
        )));

        accounts.put(3000, new PremiumAccount(new AccountData(
                3000, "Bob", "bobisbob@aol.com", 200
        )));

        accounts.put(4000, new BasicAccount(new AccountData(
                4000, "Alice", "aliceisdead@podcast.listen", 800
        )));
    }

    public Boolean setUserToBank(String username, Integer pin) {

        User user = users.get(username);

        if (user != null) {
            if(user.getPin().equals(pin)) {
                accounts = user.getAccounts();
                return true;
            }
        }
        return false;
    }

    public float getBalanceOfAccount(int id) {
        Account account = accounts.get(id);
        return account.getBalance();
    }

    public String getNameOnAccount(int id) {
        Account account = accounts.get(id);
        return account.getName();
    }

    public String getEmailOnAccount(int id){
        Account account = accounts.get(id);
        return account.getEmail();
    }

    public ActionResult<AccountData> getAccountById(int id) {
        Account account = accounts.get(id);

        if (account != null) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("No account with id: " + id + "\nTry account 1000 or 2000");
        }
    }

    public ActionResult<AccountData> deposit(AccountData accountData, float amount) {
        Account account = accounts.get(accountData.getId());
        account.deposit(amount);

        return ActionResult.success(account.getAccountData());
    }

    public ActionResult<AccountData> withdraw(AccountData accountData, float amount) {
        Account account = accounts.get(accountData.getId());
        boolean ok = account.withdraw(amount);

        if (ok) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("Withdraw failed: " + amount + ". Account has: " + account.getBalance());
        }
    }
}
