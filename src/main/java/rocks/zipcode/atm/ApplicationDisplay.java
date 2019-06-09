package rocks.zipcode.atm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;

public class ApplicationDisplay extends Application {

    private String currentPage = "Login";

    @Override
    public void start(Stage stage) throws Exception {
        if(currentPage.equals("Login")) {
            stage.setScene(new Scene(LoginPage.createContent()));
            stage.show();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
