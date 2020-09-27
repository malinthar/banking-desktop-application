package banking.system.database;

import banking.system.Bank;
import banking.system.account.BankAccount;
import banking.system.beans.Transaction;
import banking.system.user.AccountHolder;
import banking.system.user.Cashier;
import banking.system.user.Employee;
import banking.system.user.Manager;
import com.sun.webkit.dom.DocumentImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseController {

    private static final Logger logger = Logger.getLogger(DataBaseController.class.getName());
    private DataBaseConnection dbConnection;

    public DataBaseController() {
        this.dbConnection = new DataBaseConnection();
    }

    public Boolean createUserAccount(Map<String, String> attributes, Class claz) throws SQLException {
        Connection conn = dbConnection.getConection();
        PreparedStatement statement = null;
        if (AccountHolder.class.equals(claz)) {
            String[] attributesList = AccountHolder.getAttributesList();
            StringBuilder entry = new StringBuilder("(");
            for (String attribute : attributesList) {
                if (!"id".equals(attribute)) {
                    entry.append("'");
                    entry.append(attributes.get(attribute));
                    entry.append("'");
                    if (!"zip".equals(attribute)) {
                        entry.append(",");
                    } else {
                        entry.append(")");
                    }
                }
            }
            String staementString = "insert into AccountHolder(first_name,last_name,nic,birthday," +
                    "telephone,registered_branch,email,streetNumber,streetName,city,district,province,zip) values" +
                    entry + ";";
            statement = conn.prepareStatement(staementString);
        } else {

            String[] attributesList = Employee.getAttributesList();
            StringBuilder entry = new StringBuilder("(");
            for (String attribute : attributesList) {
                if (!"id".equals(attribute)) {
                    entry.append("'");
                    entry.append(attributes.get(attribute));
                    entry.append("'");
                    if (!"zip".equals(attribute)) {
                        entry.append(",");
                    } else {
                        entry.append(")");
                    }
                }
            }
            String staementString = "insert into Employee(first_name,last_name,nic,birthday," +
                    "telephone,employee_type,employed_branch,email,streetNumber,streetName,city,district,province,zip) values" +
                    entry + ";";
            statement = conn.prepareStatement(staementString);
        }
        if (statement != null) {
            Boolean result = statement.execute();
            logger.info("Successfully created new user account!");
            return true;
        }
        return false;
    }


    public List<AccountHolder> getAccountHolders() throws SQLException {
        Connection conn = dbConnection.getConection();
        PreparedStatement statement = conn.prepareStatement("select * from AccountHolder");
        ResultSet results = statement.executeQuery();
        List<AccountHolder> accountHolderList = new ArrayList<>();
        while (results.next()) {
            AccountHolder holder = new AccountHolder();
            holder.setId(results.getString("id"));
            holder.setFirst_name(results.getString("first_name"));
            holder.setLast_name(results.getString("last_name"));
            holder.setNic(results.getString("nic"));
            holder.setTelephone(results.getString("telephone"));
            holder.setBirthday(results.getString("birthday"));
            holder.setRegistered_branch(results.getString("registered_branch"));
            holder.setEmail(results.getString("email"));
            holder.setStreetNumber(results.getString("streetNumber"));
            holder.setStreetName(results.getString("streetName"));
            holder.setCity(results.getString("city"));
            holder.setDistrict(results.getString("district"));
            holder.setProvince(results.getString("province"));
            holder.setZip(results.getString("zip"));
            accountHolderList.add(holder);
        }
        return accountHolderList;
    }


    public List<AccountHolder> findAccountHolderByField(String field) throws SQLException {
        Connection conn = dbConnection.getConection();
        PreparedStatement statement = conn.prepareStatement("select * from AccountHolder where firstName like '%" + field
                + "%' or lastName like '%" + field + "%'");
        ResultSet results = statement.executeQuery();
        List<AccountHolder> accountHolderList = new ArrayList<>();
        while (results.next()) {
            AccountHolder holder = new AccountHolder();
            holder.setId(results.getString("id"));
            holder.setFirst_name(results.getString("first_name"));
            holder.setLast_name(results.getString("last_name"));
            holder.setNic(results.getString("nic"));
            holder.setTelephone(results.getString("telephone"));
            holder.setRegistered_branch(results.getString("registered_branch"));
            holder.setEmail(results.getString("email"));
            holder.setStreetNumber(results.getString("streetNumber"));
            holder.setStreetName(results.getString("streetName"));
            holder.setCity(results.getString("city"));
            holder.setDistrict(results.getString("district"));
            holder.setProvince(results.getString("province"));
            holder.setZip(results.getString("zip"));
            accountHolderList.add(holder);
        }
        return accountHolderList;
    }

    public List<Employee> getEmployees() throws SQLException {
        Connection conn = dbConnection.getConection();
        PreparedStatement statement = conn.prepareStatement("select * from Employee");
        ResultSet results = statement.executeQuery();
        List<Employee> employeeList = new ArrayList<>();

        while (results.next()) {
            Employee employee;
            if ("cashier".equals(results.getString("employee_type"))) {
                employee = new Cashier();
            } else {
                employee = new Manager();
            }
            employee.setId(results.getString("id"));
            employee.setFirst_name(results.getString("first_name"));
            employee.setLast_name(results.getString("last_name"));
            employee.setNic(results.getString("nic"));
            employee.setBirthday(results.getString("birthday"));
            employee.setTelephone(results.getString("telephone"));
            employee.setEmployee_type(results.getString("employee_type"));
            employee.setEmployed_branch(results.getString("employed_branch"));
            employee.setEmail(results.getString("email"));
            employee.setStreetNumber(results.getString("streetNumber"));
            employee.setStreetName(results.getString("streetName"));
            employee.setCity(results.getString("city"));
            employee.setDistrict(results.getString("district"));
            employee.setProvince(results.getString("province"));
            employee.setZip(results.getString("zip"));
            employeeList.add(employee);
        }

        return employeeList;
    }

    public List<Transaction> getTransactions() throws SQLException {
        Connection conn = dbConnection.getConection();
        PreparedStatement statement = conn.prepareStatement("select * from TransactionLog");
        ResultSet results = statement.executeQuery();
        List<Transaction> transactionsList = new ArrayList<>();

        while (results.next()) {
            Transaction transaction = new Transaction();
            transaction.setTransaction_id(results.getString("transaction_id"));
            transaction.setTransaction_timestamp(results.getString("transaction_timestamp"));
            transaction.setTransaction_type(results.getString("transaction_type"));
            transaction.setAmount(results.getString("amount"));
            transaction.setAccount_number(results.getString("account_number"));
            transaction.setEmployee_id(results.getString("employee_id"));
            transactionsList.add(transaction);
        }
        return transactionsList;
    }

    public Transaction findTransactionByField(String field) throws SQLException {
        Connection conn = dbConnection.getConection();
        PreparedStatement statement = conn.prepareStatement("select * from Transaction where transaction_id = '" + field
                + field + "'");
        ResultSet results = statement.executeQuery();
        Transaction transaction = new Transaction();
        while (results.next()) {
            //Set Transaction properties
        }
        return transaction;
    }

    public boolean createTransaction(Map<String, String> attributes) throws SQLException {
        Connection conn = dbConnection.getConection();
        PreparedStatement statement = null;
        String[] attributesList = Transaction.getAttributesList();
        StringBuilder entry = new StringBuilder("(");
        for (String attribute : attributesList) {
            if ("transaction_id".equals(attribute) || "transaction_timestamp".equals(attribute)) {
                continue;
            } else {
                if("transaction_type".equals(attribute)) {
                    entry.append("'");
                    entry.append(attributes.get(attribute));
                    entry.append("'");
                    entry.append(",");
                } else {
                    entry.append(attributes.get(attribute));
                    if (!"employee_id".equals(attribute)) {
                        entry.append(",");
                    } else {
                        entry.append(")");
                    }
                }
            }
        }

        if ("deposit".equals(attributes.get("transaction_type"))) {
            Double amount = Double.parseDouble(attributes.get("amount"));

            StringBuilder depositQuery = new StringBuilder("update BankAccount set balance = balance + ");
            depositQuery.append(amount);
            depositQuery.append("where account_number = ");
            depositQuery.append(attributes.get("account_number"));
            depositQuery.append(";");
            PreparedStatement depositStatement = conn.prepareStatement(depositQuery.toString());
            Boolean result = depositStatement.execute();
        } else {
            //get current amount
            Double amount = Double.parseDouble(attributes.get("amount"));
            StringBuilder withdrawQuery = new StringBuilder("update BankAccount set balance = balance - ");
            withdrawQuery.append(amount);
            withdrawQuery.append("where account_number = ");
            withdrawQuery.append(attributes.get("account_number"));
            withdrawQuery.append(";");
            PreparedStatement withdrawStatement = conn.prepareStatement(withdrawQuery.toString());
            Boolean result = withdrawStatement.execute();
        }

        //update withdraw, or deposit amount in existing record
        String statementString = "insert into TransactionLog(transaction_type,amount,account_number,employee_id) values" +
                entry + ";";
        statement = conn.prepareStatement(statementString);
        if (statement != null) {
            Boolean result = statement.execute();
            logger.info("Successfully created new transaction!");
            return true;
        }
        return false;
    }

    public List<BankAccount> getBankAccounts() throws SQLException {
        Connection conn = dbConnection.getConection();
        PreparedStatement statement = conn.prepareStatement("select * from BankAccount");
        ResultSet results = statement.executeQuery();
        List<BankAccount> bankAccountList = new ArrayList<>();

        while (results.next()) {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setAccount_number(results.getString("account_number"));
            bankAccount.setAccount_name(results.getString("account_name"));
            bankAccount.setAccount_holder_id(results.getString("account_holder_id"));
            bankAccount.setAccount_type(results.getString("account_type"));
            bankAccount.setBalance(Double.parseDouble(results.getString("balance")));
            bankAccount.setBranch(results.getString("branch"));
            bankAccountList.add(bankAccount);
        }
        return bankAccountList;
    }


    public boolean createBankAccount(Map<String, String> attributes) throws SQLException {
        Connection conn = dbConnection.getConection();
        PreparedStatement statement = null;
        String[] attributesList = BankAccount.getAttributesList();
        StringBuilder entry = new StringBuilder("(");
        for (String attribute : attributesList) {
            if (!"account_number".equals(attribute)) {
                entry.append("'");
                entry.append(attributes.get(attribute));
                entry.append("'");
                if (!"branch".equals(attribute)) {
                    entry.append(",");
                } else {
                    entry.append(")");
                }
            }
        }

        String statementString = "insert into BankAccount(account_name,account_holder_id,account_type,balance,opened_date,branch) values" +
                entry + ";";
        statement = conn.prepareStatement(statementString);
        if (statement != null) {
            Boolean result = statement.execute();
            logger.info("Successfully created new user account!");
            return true;
        }
        return false;
    }
}
