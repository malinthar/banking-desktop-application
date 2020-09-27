package banking.system.user;

import banking.system.account.BankAccount;
import banking.system.service.Service;

import java.util.List;

public class AccountHolder extends User {
    private String registered_branch;
    private List<BankAccount> bankAccounts;
    private List<Service> subscribedServices;
    private static String[] attributesList = {"id", "first_name", "last_name", "nic", "birthday",
            "telephone", "registered_branch", "email", "streetNumber", "streetName",
            "city", "district", "province", "zip"};

    public static String[] getAttributesList() {
        return attributesList;
    }

    public String getRegistered_branch() {
        return registered_branch;
    }

    public void setRegistered_branch(String registered_branch) {
        this.registered_branch = registered_branch;
    }
}
