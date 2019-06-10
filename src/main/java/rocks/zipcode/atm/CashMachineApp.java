package rocks.zipcode.atm;

import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.media.AudioClip;
        import javafx.scene.control.TextArea;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.VBox;
        import javafx.stage.Stage;
        import javafx.scene.layout.FlowPane;

import javafx.scene.paint.Color;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

/**
 * @author ZipCodeWilmington
 */
public class CashMachineApp extends Application {

    private TextField field = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());

    private static final Color lightBlue = Color.web("#8BF4FF"); //for blue text
    private static final Color black = Color.web("#000000"); //for black text

 /*  //Easter Egg
    File BrokeClip = new File ("src/Resources/BrokeClip.wav");
    AudioClip easterEgg1 = new AudioClip(BrokeClip.toURI().toString());
*/



    private Parent createContent() {
        VBox vbox = new VBox(10);
        vbox.setStyle("-fx-background-color:#8BF4FF"); //Background color blue
        vbox.setPrefSize(600, 600);

        TextArea areaInfo = new TextArea();

        //Declare buttons
        Button btnSubmit = new Button("Login"); //Change to "Set Account ID"
        Button btnWithdraw = new Button("Withdraw");
        Button btnDeposit = new Button("Deposit");
        Button btnExit = new Button("Exit");

        //Declare flowPane
        FlowPane flowpane = new FlowPane(); //Where the buttons are


        //Submit
        btnSubmit.setOnAction(e -> {
            int id = Integer.parseInt(field.getText());
            cashMachine.login(id);
            areaInfo.setText(cashMachine.toString());
        });

        //Deposit
        btnDeposit.setOnAction(e -> {

            int amount = Integer.parseInt(field.getText());

            cashMachine.deposit(amount);

            areaInfo.setText(cashMachine.toString());
        });

        //Withdraw
        btnWithdraw.setOnAction(e -> {
            int amount = Integer.parseInt(field.getText());
     //       easterEgg1.play();
            cashMachine.withdraw(amount);


            areaInfo.setText(cashMachine.toString());
        });

        //Exit
        btnExit.setOnAction(e -> {
            cashMachine.exit();

            areaInfo.setText(cashMachine.toString());
        });



        flowpane.setStyle("-fx-background-color:#8BF4FF"); //color blue
        flowpane.getChildren().add(btnSubmit);
        flowpane.getChildren().add(btnDeposit);
        flowpane.getChildren().add(btnWithdraw);
        flowpane.getChildren().add(btnExit);
        vbox.getChildren().addAll(field, flowpane, areaInfo);
        return vbox;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
