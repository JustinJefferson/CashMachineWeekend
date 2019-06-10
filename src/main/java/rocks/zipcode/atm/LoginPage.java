package rocks.zipcode.atm;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import javafx.scene.control.Dialog;


import javafx.util.Pair;
import rocks.zipcode.atm.bank.Bank;
import rocks.zipcode.atm.bank.AccountData;
import rocks.zipcode.atm.bank.Account;

public class LoginPage {

    private String error = "";
    private CashMachine cashMachine;
    private Boolean login = false;
    private Integer accountNum = 1000;

    public LoginPage(CashMachine cashMachine){
        this.cashMachine = cashMachine;
    }

    //@Override

  //  public  void start (Stage primaryStage) {

    public Parent createContent() {
      // primaryStage.setTitle("Bank of Whatever");
        GridPane othergrid = new GridPane();
        othergrid.setAlignment(Pos.CENTER);
        othergrid.setHgap(10);
        othergrid.setVgap(10);
        othergrid.setPadding(new Insets(25, 25, 25, 25));

        Text otherHeading = new Text("Bank Page");
        otherHeading.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        othergrid.add(otherHeading, 0, 0, 2, 1);

        // positioning of box
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //text fields
        Text heading = new Text("Enter your User ID and Pin");
        heading.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(heading, 0, 0, 2, 1);

        Label userID = new Label("User ID:");
        grid.add(userID, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pin = new Label("PIN:");
        grid.add(pin, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Label errorMsg = new Label(error);
        grid.add(errorMsg, 0, 3, 2, 1);

        Label nameLabel = new Label("NAME:");
        grid.add(nameLabel, 0, 5);

        TextField nameInfo = new TextField();
        grid.add(nameInfo, 0, 6);

        Label emailLabel = new Label("EMAIL:");
        grid.add(emailLabel, 1, 5);

        TextField emailInfo = new TextField();
        grid.add(emailInfo, 1,6);

        Label balanceLabel = new Label("ACCOUNT BALANCE:");
        grid.add(balanceLabel, 0, 7);

        TextField balanceInfo = new TextField();
        grid.add(balanceInfo, 1, 7);

        Label amountLabel = new Label("AMOUNT:");
        grid.add(amountLabel, 0, 9);

        TextField amountInput = new TextField();
        grid.add(amountInput, 1, 9);



        //buttons
        Button btn = new Button("Login");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        btn.setOnAction(e -> {
            if(!login) {
                Boolean isLoggedIn = cashMachine.userLogin(userTextField.getText(), Integer.parseInt(pwBox.getText()));
                System.out.println("Print this");
                if (!isLoggedIn) {
                    errorMsg.setText("Incorrect User ID or PIN.");
                } else {
                    btn.setText("Logout");
                    login = true;
                    nameInfo.setText(cashMachine.getName(accountNum));
                    emailInfo.setText(cashMachine.getEmail(accountNum));
                    cashMachine.login(accountNum);
                    userTextField.setText("");
                    pwBox.setText("");
                }
            }
            else {
                btn.setText("Login");
                login = false;
                nameInfo.setText("");
                emailInfo.setText("");
                amountInput.setText("");
                balanceInfo.setText("");
            }
        });



        Button basicBtn = new Button("Basic");
        basicBtn.setOnAction(e -> {
            accountNum = 1000;
            if(login) {
                balanceInfo.setText(String.format("%.2f", cashMachine.getBalance(accountNum)));
                cashMachine.login(accountNum);
            }
        });
        Button premiumBtn = new Button("Premium");
        premiumBtn.setOnAction(e -> {
            accountNum = 1001;
            if(login){
                balanceInfo.setText(String.format("%.2f", cashMachine.getBalance(accountNum)));
                cashMachine.login(accountNum);
            }
        });
        Button savingsBtn = new Button("Savings");
        savingsBtn.setOnAction(e -> {
            accountNum = 1002;
            if(login) {
                balanceInfo.setText(String.format("%.2f", cashMachine.getBalance(accountNum)));
                cashMachine.login(accountNum);
            }
        });

        HBox accountBtnBox = new HBox( 30);
        accountBtnBox.setAlignment(Pos.CENTER);
        accountBtnBox.getChildren().add(basicBtn);
        accountBtnBox.getChildren().add(premiumBtn);
        accountBtnBox.getChildren().add(savingsBtn);
        grid.add(accountBtnBox, 0, 8, 2, 1);

        Button withdrawBtn = new Button("Withdraw");
        withdrawBtn.setOnAction(e -> {
            if(login) {
                float amount = Float.parseFloat(amountInput.getText());
                cashMachine.withdraw(amount);

                balanceInfo.setText(String.format("%.2f", cashMachine.getBalance(accountNum)));
                amountInput.setText("");
            }
        });
        Button depositBtn = new Button("Deposit");
        depositBtn.setOnAction(e -> {
            if(login) {
                float amount = Float.parseFloat(amountInput.getText());
                cashMachine.deposit(amount);

                balanceInfo.setText(String.format("%.2f", cashMachine.getBalance(accountNum)));
                amountInput.setText("");
            }
        });

        HBox withDepoBox = new HBox( 10);
        withDepoBox.setAlignment(Pos.BOTTOM_RIGHT);
        withDepoBox.getChildren().add(withdrawBtn);
        withDepoBox.getChildren().add(depositBtn);
        grid.add(withDepoBox, 1, 10);




        //Scene scene = new Scene(grid, 300, 275);
       // primaryStage.setScene(scene);

        // primaryStage.show();

        if(login) return othergrid;
        return grid;


    }





}

