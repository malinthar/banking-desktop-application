package banking.system;

import banking.system.account.BankAccount;
import banking.system.beans.Transaction;
import banking.system.database.DataBaseController;
import banking.system.user.AccountHolder;
import banking.system.user.Employee;
import banking.system.user.User;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Bank {
    private String name;
    private List<Employee> employees;
    private List<BankAccount> bankAccounts;
    private DataBaseController dbController;
    private Logger logger = Logger.getLogger(Bank.class.getName());

    public Bank(String name) {
        this.name = name;
        dbController = new DataBaseController();

    }

    public List<AccountHolder> getAccountHolders(User user) throws Exception {
        if (user instanceof Employee) {
            return dbController.getAccountHolders();
        } else {
            throw new RuntimeException("!!Unauthorized access attempt by" + user.getId());
        }
    }
    public List<Employee> getEmployees(User user) throws Exception {
        if (user instanceof Employee) {
            return dbController.getEmployees();
        } else {
            throw new RuntimeException("!!Unauthorized access attempt by" + user.getId());
        }
    }
    public List<Transaction> getTransactions(User user) throws Exception {
        if (user instanceof Employee) {
            return dbController.getTransactions();
        } else {
            throw new RuntimeException("!!Unauthorized access attempt by" + user.getId());
        }
    }
    public List<BankAccount> getBankAccounts(User user) throws Exception {
        if (user instanceof Employee) {
            return dbController.getBankAccounts();
        } else {
            throw new RuntimeException("!!Unauthorized access attempt by" + user.getId());
        }
    }

    public Boolean createAccountHolder(User user, Map<String, String> attributes) throws Exception {
        if (user instanceof Employee) {
            return dbController.createUserAccount(attributes, AccountHolder.class);
        } else {
            throw new RuntimeException("!!Unauthorized access attempt by" + user.getId());
        }
    }

    public Boolean createEmployee(User user, Map<String, String> attributes) throws Exception {
        if (user instanceof Employee) {
            return dbController.createUserAccount(attributes, Employee.class);
        } else {
            throw new RuntimeException("!!Unauthorized access attempt by" + user.getId());
        }
    }

    public Boolean createBankAccount(User user, Map<String, String> attributes) throws Exception {
        if (user instanceof Employee) {
            return dbController.createBankAccount(attributes);
        } else {
            throw new RuntimeException("!!Unauthorized access attempt by" + user.getId());
        }
    }

    public Boolean createTransaction(User user, Map<String, String> attributes) throws Exception {
        if (user instanceof Employee) {
            return dbController.createTransaction(attributes);
        } else {
            throw new RuntimeException("!!Unauthorized access attempt by" + user.getId());
        }
    }

}
