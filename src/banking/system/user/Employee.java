package banking.system.user;

import java.util.Map;

public abstract class Employee extends User {
    private String employed_branch;
    private String employee_type;

    private static String[] attributesList =  {"id","first_name", "last_name", "nic", "birthday",
            "telephone", "employee_type","employed_branch", "email", "streetNumber", "streetName",
            "city", "district", "province", "zip"};

    public static String[] getAttributesList() {
        return attributesList;
    }

    public String getEmployed_branch() {
        return employed_branch;
    }

    public void setEmployed_branch(String employed_branch) {
        this.employed_branch = employed_branch;
    }


    public String getEmployee_type() {
        return employee_type;
    }

    public void setEmployee_type(String employee_type) {
        this.employee_type = employee_type;
    }

    public Employee(String employeeType) {
        this.employee_type = employeeType;
    }
    public void manageTransaction() {

    }
    public void getAccountHolders() {

    }
    public void getAccountHolderByField() {

    }
    public void CheckBalance() {

    }
    public void deposit() {

    }
    public void withdraw() {

    }
    public Boolean createAccountHolder(Map<String,String> attributes) {
       return true;
    }
}
