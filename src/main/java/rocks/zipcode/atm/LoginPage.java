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

    //@Override

  //  public  void start (Stage primaryStage) {

    public static void login () {
      // primaryStage.setTitle("Bank of Whatever");

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

        Label userID = new Label("Enter User ID:");
        grid.add(userID, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pin = new Label("Pin:");
        grid.add(pin, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        //buttons
        Button btn = new Button("Login");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
       // btn.setOnAction(e -> {
        // should lead to user page when clicked
          //  cashmachine.
              //  }


        //Scene scene = new Scene(grid, 300, 275);
       // primaryStage.setScene(scene);

        // primaryStage.show();


    }





}

