package gerstle.physics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RocketController
{

        @FXML
        TextField velocityField;
        @FXML
        TextField angleField;
        @FXML
        TextField secondsField;
        @FXML
        Label flightTimeLabel;
        @FXML
        Label LocationLabel;
        @FXML
        RocketCanvas rocketCanvas;



    public void calculateRocket(ActionEvent actionEvent)
    {
        double velocity = Double.parseDouble(velocityField.getText());
        double angle = Double.parseDouble(angleField.getText());
        double seconds = Double.parseDouble(secondsField.getText());

        Rocket rocket = new Rocket(velocity, angle);
        flightTimeLabel.setText(Double.toString(rocket.getFlightTime()));
        String location = String.format("(%.2f, %.2f)",
                rocket.getX(seconds),
                rocket.getY(seconds));
        LocationLabel.setText(location);

        rocketCanvas.draw(rocket);
    }
}
