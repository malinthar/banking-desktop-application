package banking.system.user;

import java.util.List;

public class Manager extends Employee {

    private static String[] attributesList =  {"id","first_name", "last_name", "nic", "birthday",
            "telephone", "registered_branch", "email", "streetNumber", "streetName",
            "city", "district", "province", "zip"};

    public Manager() {
        super("manager");
    }

    public void createUserAccount(Class accountType, List<String> details) {

    }

    public void createBankAccount() {

    }

}
