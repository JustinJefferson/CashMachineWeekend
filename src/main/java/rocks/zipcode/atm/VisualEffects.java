package rocks.zipcode.atm;

import javafx.scene.paint.Color;

import javafx.scene.control.*;

import javafx.scene.paint.Color;

public class VisualEffects {



    //Text colors
    private static final Color lightBlue = Color.web("#8BF4FF"); //for blue text
    private static final Color black = Color.web("#000000"); //for black text

    public static void turnButtonInvisible(Labeled button){ //Turn text and button invisible
        button.setStyle("-fx-background-color:#8BF4FF"); //turn button blue
        button.setTextFill(lightBlue); //turn text blue
    }

    public static void turnButtonVisible(Labeled button){ //Turn text and button invisible
        button.setStyle("-fx-background-color:#FFFFFF"); //turn button white
        button.setTextFill(black); //turn text black
    }
    public static void turnTextBoxInvisible ( Labeled field){
        field.setStyle("-fx-background-color:#8BF4FF"); //Input text box color blue
    }
    public static void turnTextBoxVisible ( Labeled field){
        field.setStyle("-fx-background-color:#FFFFFF"); //Input text box color white
    }
    public static void turnTextInvisible ( Labeled text){
        text.setTextFill(lightBlue); //turn text blue
    }
    public static void turnTextVisible ( Labeled text){
        text.setTextFill(black); //turn text black
    }


}


//field.setStyle("-fx-background-color:#8BF4FF"); //Input text box color blue
//flowpane.setStyle("-fx-background-color:#8BF4FF"); //Where buttons are color blue
//vbox.setStyle("-fx-background-color:#8BF4FF"); //Background color blue