package lk.ijse.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane container;


    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)container.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"))));
        stage.centerOnScreen();
    }
}
