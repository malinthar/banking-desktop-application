package banking.system.account;

import banking.system.service.TransactionService;

import java.util.List;

public class BankAccount {

    private String account_number;
    private String account_name;
    private String account_holder_id;
    private String account_type;
    private Double balance;
    private String opened_date;
    private String branch;
    private List<TransactionService> transactionsList;
    private static final String[] attributesList = {"account_number", "account_name",
            "account_holder_id", "account_type", "balance", "opened_date", "branch"};

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getAccount_holder_id() {
        return account_holder_id;
    }

    public void setAccount_holder_id(String account_holder_id) {
        this.account_holder_id = account_holder_id;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getOpened_date() {
        return opened_date;
    }

    public void setOpened_date(String opened_date) {
        this.opened_date = opened_date;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public static String[] getAttributesList() {
        return attributesList;
    }

    public void withdraw(Float amount) {
        if (balance >= amount) {
            balance = balance - amount;
        } else {
            throw new RuntimeException("Not sufficient account balance!");
        }
    }

    public void deposit(Float amount) {
        balance += amount;
    }
}
