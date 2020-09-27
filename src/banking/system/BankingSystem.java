package banking.system;

import banking.system.account.BankAccount;
import banking.system.beans.Transaction;
import banking.system.user.AccountHolder;
import banking.system.user.Cashier;
import banking.system.user.Employee;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankingSystem extends Application {
    Button button3;
    Stage window;
    Scene scene1;
    private static Bank bank;
    private static Cashier cashier;
    private Logger logger = Logger.getLogger(BankingSystem.class.getName());

    public static void main(String args[]) {
        System.out.println("Starting banking application....");
        //create a new Bank
        bank = new Bank("people's bank");
        cashier = new Cashier();
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Banking Application");

        button3 = new Button();
        button3.setText("Back");
        button3.setOnAction(event -> window.setScene(scene1));

        scene1 = getScene1();
        window.setScene(scene1);
        window.show();
    }

    public Scene getEmployees() {
        String[] attributes = Employee.getAttributesList();
        VBox layout2 = new VBox();
        Scene scene = new Scene(layout2, 900, 800);
        layout2.setSpacing(5);
        layout2.setPadding(new Insets(10, 50, 50, 60));

        try {
            List<Employee> employeeList = bank.getEmployees(cashier);

            Label tableLabel = new Label("Employees");
            Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
            tableLabel.setFont(font);
            final ObservableList<Employee> data = FXCollections.observableArrayList(employeeList);
            TableView<Employee> table = new TableView<>();
            table.setItems(data);
            for (String attribute : attributes) {
                TableColumn column = new TableColumn(attribute);
                column.setCellValueFactory(new PropertyValueFactory<>(attribute));
                table.getColumns().add(column);
            }
            table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            table.setMaxSize(850, 750);
            layout2.getChildren().addAll(tableLabel, table, button3);

        } catch (Exception exception) {
            logger.log(Level.SEVERE, exception.getMessage());
        }
        return scene;
    }

    public Scene getAccountHolders() {
        //scene2
        String[] attributes = AccountHolder.getAttributesList();
        VBox layout2 = new VBox();
        Scene scene = new Scene(layout2, 900, 800);
        layout2.setSpacing(5);
        layout2.setPadding(new Insets(10, 50, 50, 60));

        try {
            List<AccountHolder> accountHolderList = bank.getAccountHolders(cashier);
            Label tableLabel = new Label("Account Holders");
            Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
            tableLabel.setFont(font);
            final ObservableList<AccountHolder> data = FXCollections.observableArrayList(accountHolderList);
            TableView<AccountHolder> table = new TableView<>();
            table.setItems(data);
            for (String attribute : attributes) {
                TableColumn column = new TableColumn(attribute);
                column.setCellValueFactory(new PropertyValueFactory<>(attribute));
                table.getColumns().add(column);
            }
            table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            table.setMaxSize(850, 750);
            layout2.getChildren().addAll(tableLabel, table, button3);

        } catch (Exception exception) {
            logger.log(Level.SEVERE, exception.getMessage());
        }
        return scene;
    }

    public Scene getTransactions() {
        //scene2
        String[] attributes = Transaction.getAttributesList();
        VBox layout2 = new VBox();
        Scene scene = new Scene(layout2, 900, 800);
        layout2.setSpacing(5);
        layout2.setPadding(new Insets(10, 50, 50, 60));

        try {
            List<Transaction> transactionsList = bank.getTransactions(cashier);
            Label tableLabel = new Label("Transactions");
            Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
            tableLabel.setFont(font);
            final ObservableList<Transaction> data = FXCollections.observableArrayList(transactionsList);
            TableView<Transaction> table = new TableView<>();
            table.setItems(data);
            for (String attribute : attributes) {
                TableColumn column = new TableColumn(attribute);
                column.setCellValueFactory(new PropertyValueFactory<>(attribute));
                table.getColumns().add(column);
            }
            table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            table.setMaxSize(850, 750);
            layout2.getChildren().addAll(tableLabel, table, button3);

        } catch (Exception exception) {
            logger.log(Level.SEVERE, exception.getMessage());
        }
        return scene;
    }

    public Scene getBankAccounts() {
        String[] attributes = BankAccount.getAttributesList();
        VBox layout2 = new VBox();
        Scene scene = new Scene(layout2, 900, 800);
        layout2.setSpacing(5);
        layout2.setPadding(new Insets(10, 50, 50, 60));

        try {
            List<BankAccount> bankAccountList = bank.getBankAccounts(cashier);
            Label tableLabel = new Label("Bank Accounts");
            Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
            tableLabel.setFont(font);
            final ObservableList<BankAccount> data = FXCollections.observableArrayList(bankAccountList);
            TableView<BankAccount> table = new TableView<>();
            table.setItems(data);
            for (String attribute : attributes) {
                TableColumn column = new TableColumn(attribute);
                column.setCellValueFactory(new PropertyValueFactory<>(attribute));
                table.getColumns().add(column);
            }
            table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            table.setMaxSize(850, 750);
            layout2.getChildren().addAll(tableLabel, table, button3);

        } catch (Exception exception) {
            logger.log(Level.SEVERE, exception.getMessage());
        }
        return scene;
    }


    public Scene getScene1() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        Text scenetitle = new Text("Select an operation!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Button button0 = new Button();
        button0.setText("View Account Holders");
        button0.setOnAction(event -> window.setScene(getAccountHolders()));

        Button button1 = new Button();
        button1.setText("View Employees");
        button1.setOnAction(event -> window.setScene(getEmployees()));

        Button button2 = new Button();
        button2.setText("Add new Account Holder");
        button2.setOnAction(e -> window.setScene(getInputForm()));

        Button button4 = new Button();
        button4.setText("Add new employee");
        button4.setOnAction(e -> window.setScene(getInputFormEmployee()));

        Button button5 = new Button();
        button5.setText("Create transaction");
        button5.setOnAction(e -> window.setScene(getTransactionForm()));

        Button button6 = new Button();
        button6.setText("View transactions");
        button6.setOnAction(e -> window.setScene(getTransactions()));

        Button button7 = new Button();
        button7.setText("Create bank account");
        button7.setOnAction(e -> window.setScene(getBankAccountForm()));

        Button button8 = new Button();
        button8.setText("View bank accounts");
        button8.setOnAction(e -> window.setScene(getBankAccounts()));


        grid.add(button0, 0, 1);
        grid.add(button1, 0, 2);
        grid.add(button2, 0, 3);
        grid.add(button4, 0, 4);
        grid.add(button5, 0, 5);
        grid.add(button6, 0, 6);
        grid.add(button7, 0, 7);
        grid.add(button8, 0, 8);


        Scene scene = new Scene(grid, 900, 800);
        return scene;

    }

    public Scene getInputFormEmployee() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 900, 800);
        Text scenetitle = new Text("Welcome to banking system");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        String[] attributes = Employee.getAttributesList();

        //generate input fields
        int index = 0;
        for (String attribute : attributes) {
            grid.add(new Label(attribute), 0, index + 1);
            if ("birthday".equals(attribute)) {
                grid.add(new DatePicker(), 1, index + 1);
            } else if ("employed_branch".equals(attribute)) {
                ChoiceBox choiceBox = new ChoiceBox();
                choiceBox.getItems().add("Colombo");
                choiceBox.getItems().add("Kandy");
                choiceBox.getItems().add("Galle");
                choiceBox.getItems().add("Mathara");
                grid.add(choiceBox, 1, index + 1);
            } else if ("employee_type".equals(attribute)) {
                ChoiceBox choiceBox = new ChoiceBox();
                choiceBox.getItems().add("manager");
                choiceBox.getItems().add("cashier");
                grid.add(choiceBox, 1, index + 1);
            } else {
                grid.add(new TextField(), 1, index + 1);
            }
            index++;
        }

//        PasswordField pwBox = new PasswordField();
//        grid.add(pwBox, 1, 2);

        Button btn = new Button("Submit");
        btn.setOnAction(e -> {
            Map<String, String> inputList = new HashMap<>();
            logger.info("submitting form");
            ObservableList<Node> children = grid.getChildren();
            int i = 0;
            for (Node child : children) {
                if (child instanceof TextField) {
                    if (((TextField) child).getText().isEmpty()) {
                        showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(),
                                "Form Error!", "Please fill all the fields");
                        return;
                    } else {
                        inputList.put(attributes[i], ((TextField) child).getText());
                        i++;
                    }
                } else if (child instanceof ChoiceBox) {
                    inputList.put(attributes[i], (String) ((ChoiceBox) child).getValue());
                    i++;
                } else if (child instanceof DatePicker) {
                    inputList.put(attributes[i], ((DatePicker) child).getValue().toString());
                    i++;
                }
            }

            try {
                if (bank.createEmployee(cashier, inputList)) {
                    showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow()
                            , "Success", "Added new account holder successfully!");
                } else {
                    showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow()
                            , "Failed", "Could not add new AccountHolder!");
                }
            } catch (Exception exc) {
                showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow()
                        , "Failure", "Could not add new AccountHolder!");
            }
        });

        Button btnBack = new Button("Back");
        btnBack.setOnAction(e -> window.setScene(scene1));
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(btnBack, btn);
        grid.add(hbBtn, 1, 16);
        return scene;
    }

    public Scene getInputForm() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 900, 800);
        Text scenetitle = new Text("Welcome to banking system");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        String[] attributes = AccountHolder.getAttributesList();

        //generate input fields
        int index = 0;
        for (String attribute : attributes) {
            grid.add(new Label(attribute), 0, index + 1);
            if ("birthday".equals(attribute)) {
                grid.add(new DatePicker(), 1, index + 1);
            } else if ("registered_branch".equals(attribute)) {
                ChoiceBox choiceBox = new ChoiceBox();
                choiceBox.getItems().add("Colombo");
                choiceBox.getItems().add("Kandy");
                choiceBox.getItems().add("Galle");
                choiceBox.getItems().add("Mathara");
                grid.add(choiceBox, 1, index + 1);
            } else {
                grid.add(new TextField(), 1, index + 1);
            }
            index++;
        }

//        PasswordField pwBox = new PasswordField();
//        grid.add(pwBox, 1, 2);

        Button btn = new Button("Submit");
        btn.setOnAction(e -> {
            Map<String, String> inputList = new HashMap<>();
            logger.info("submitting form");
            ObservableList<Node> children = grid.getChildren();
            int i = 0;
            for (Node child : children) {
                if (child instanceof TextField) {
                    if (((TextField) child).getText().isEmpty()) {
                        showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(),
                                "Form Error!", "Please fill all the fields");
                        return;
                    } else {
                        inputList.put(attributes[i], ((TextField) child).getText());
                        i++;
                    }
                } else if (child instanceof ChoiceBox) {
                    inputList.put(attributes[i], (String) ((ChoiceBox) child).getValue());
                    i++;
                } else if (child instanceof DatePicker) {
                    inputList.put(attributes[i], ((DatePicker) child).getValue().toString());
                    i++;
                }
            }

            try {
                if (bank.createAccountHolder(cashier, inputList)) {
                    showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow()
                            , "Success", "Added new account holder successfully!");
                } else {
                    showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow()
                            , "Failed", "Could not add new AccountHolder!");
                }
            } catch (Exception exc) {
                showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow()
                        , "Failure", "Could not add new AccountHolder!");
            }
        });

        Button btnBack = new Button("Back");
        btnBack.setOnAction(e -> window.setScene(scene1));
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(btnBack, btn);
        grid.add(hbBtn, 1, 15);
        return scene;
    }

    public Scene getTransactionForm() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 900, 800);
        Text scenetitle = new Text("Welcome to banking system");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        String[] attributes = Transaction.getAttributesList();

        //generate input fields
        int index = 0;
        for (String attribute : attributes) {
            if ("transaction_timestamp".equals(attribute)|| "transaction_id".equals(attribute)) {
                continue;
            } else {
                grid.add(new Label(attribute), 0, index + 1);
                if ("transaction_type".equals(attribute)) {
                    ChoiceBox choiceBox = new ChoiceBox();
                    choiceBox.getItems().add("deposit");
                    choiceBox.getItems().add("withdraw");
                    grid.add(choiceBox, 1, index + 1);
                } else if ("account_type".equals(attribute)) {
                    ChoiceBox choiceBox = new ChoiceBox();
                    choiceBox.getItems().add("savings");
                    choiceBox.getItems().add("current");
                    grid.add(choiceBox, 1, index + 1);
                } else {
                    grid.add(new TextField(), 1, index + 1);
                }
            }
            index++;
        }

//        PasswordField pwBox = new PasswordField();
//        grid.add(pwBox, 1, 2);

        Button btn = new Button("Submit");
        btn.setOnAction(e -> {
            Map<String, String> inputList = new HashMap<>();
            logger.info("submitting form");
            ObservableList<Node> children = grid.getChildren();
            int i = 0;
            for (Node child : children) {
                if (child instanceof TextField) {
                    if (((TextField) child).getText().isEmpty()) {
                        showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(),
                                "Form Error!", "Please fill all the fields");
                        return;
                    } else {
                        inputList.put(attributes[i+2], ((TextField) child).getText());
                        i++;
                    }
                } else if (child instanceof ChoiceBox) {
                    inputList.put(attributes[i+2], (String) ((ChoiceBox) child).getValue());
                    i++;
                } else if (child instanceof DatePicker) {
                    inputList.put(attributes[i+2], ((DatePicker) child).getValue().toString());
                    i++;
                }
            }

            try {
                if (bank.createTransaction(cashier, inputList)) {
                    showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow()
                            , "Success", "Transaction performed successfully!");
                } else {
                    showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow()
                            , "Failure", "Could not create transaction!");
                }
            } catch (Exception exc) {
                showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow()
                        , "Failure", "Could not create tranasaction!");
            }
        });

        Button btnBack = new Button("Back");
        btnBack.setOnAction(e -> window.setScene(scene1));
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(btnBack, btn);
        grid.add(hbBtn, 1, 15);
        return scene;
    }

    public Scene getBankAccountForm() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 900, 800);
        Text scenetitle = new Text("Welcome to banking system");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        String[] attributes = BankAccount.getAttributesList();

        //generate input fields
        int index = 0;
        for (String attribute : attributes) {
            grid.add(new Label(attribute), 0, index + 1);
            if ("opened_date".equals(attribute)) {
                grid.add(new DatePicker(), 1, index + 1);
            } else if ("branch".equals(attribute)) {
                ChoiceBox choiceBox = new ChoiceBox();
                choiceBox.getItems().add("Colombo");
                choiceBox.getItems().add("Kandy");
                choiceBox.getItems().add("Galle");
                choiceBox.getItems().add("Mathara");
                grid.add(choiceBox, 1, index + 1);
            } else if ("account_type".equals(attribute)) {
                ChoiceBox choiceBox = new ChoiceBox();
                choiceBox.getItems().add("savings");
                choiceBox.getItems().add("current");
                grid.add(choiceBox, 1, index + 1);
            } else {
                grid.add(new TextField(), 1, index + 1);
            }
            index++;
        }

//        PasswordField pwBox = new PasswordField();
//        grid.add(pwBox, 1, 2);

        Button btn = new Button("Submit");
        btn.setOnAction(e -> {
            Map<String, String> inputList = new HashMap<>();
            logger.info("submitting form");
            ObservableList<Node> children = grid.getChildren();
            int i = 0;
            for (Node child : children) {
                if (child instanceof TextField) {
                    if (((TextField) child).getText().isEmpty()) {
                        showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(),
                                "Form Error!", "Please fill all the fields");
                        return;
                    } else {
                        inputList.put(attributes[i], ((TextField) child).getText());
                        i++;
                    }
                } else if (child instanceof ChoiceBox) {
                    inputList.put(attributes[i], (String) ((ChoiceBox) child).getValue());
                    i++;
                } else if (child instanceof DatePicker) {
                    inputList.put(attributes[i], ((DatePicker) child).getValue().toString());
                    i++;
                }
            }

            try {
                if (bank.createBankAccount(cashier, inputList)) {
                    showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow()
                            , "Success", "Created bank account successfully!");
                } else {
                    showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow()
                            , "Failure", "Could not create bank account!");
                }
            } catch (Exception exc) {
                showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow()
                        , "Failure", "Could not create bank account!");
            }
        });

        Button btnBack = new Button("Back");
        btnBack.setOnAction(e -> window.setScene(scene1));
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(btnBack, btn);
        grid.add(hbBtn, 1, 15);
        return scene;
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

}
