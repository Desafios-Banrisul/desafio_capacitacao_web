package Framework.Utils;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private List<Account> listAccounts;

    public User(){
        listAccounts = new ArrayList<>();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getListAccount() {
        return listAccounts;
    }

    public void setListAccounts(List<Account> listAccounts) {
        this.listAccounts = listAccounts;
    }
}
