package rocks.zipcode.atm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rocks.zipcode.atm.bank.Bank;
import sun.rmi.runtime.Log;

public class ApplicationDisplay extends Application {

    private String currentPage = "Login";
    private CashMachine cashMachine = new CashMachine(new Bank());
    private LoginPage login = new LoginPage(cashMachine);

    @Override
    public void start(Stage stage) throws Exception {
        if(currentPage.equals("Login")) {
            stage.setScene(new Scene(login.createContent()));
            stage.show();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
