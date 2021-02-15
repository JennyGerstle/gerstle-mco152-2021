package gerstle.physics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.swing.*;
import java.sql.SQLOutput;

public class RocketController
{

        @FXML
        TextField velocityField;
        @FXML
        TextField angleField;
        @FXML
        TextField secondsField;
        @FXML
        private Text actiontarget;

    public void calculateRocket(ActionEvent actionEvent)
    {
        double velocity = Double.parseDouble(velocityField.getText());
        double angle = Double.parseDouble(angleField.getText());
        double seconds = Double.parseDouble(secondsField.getText());

        Rocket rocket = new Rocket(velocity, angle);
        System.out.println();
        System.out.println(rocket.getX(seconds));
        System.out.println(rocket.getY(seconds));
        actiontarget.setText(Double.toString(rocket.getFlightTime()));
    }
}
