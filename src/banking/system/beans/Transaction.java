package banking.system.beans;

public class Transaction {

    private String transaction_id;
    private String transaction_timestamp;
    private String transaction_type;
    private String amount;
    private String account_number;
    private String employee_id;

    private static String[] attributesList = {"transaction_id","transaction_timestamp",
            "transaction_type","amount","account_number","employee_id"};

    public static String[] getAttributesList() {
        return attributesList;
    }
    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTransaction_timestamp() {
        return transaction_timestamp;
    }

    public void setTransaction_timestamp(String transaction_timestamp) {
        this.transaction_timestamp = transaction_timestamp;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }



}
