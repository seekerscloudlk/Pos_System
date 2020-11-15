package lk.ijse.pos.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class DashBoardFormController {
    public AnchorPane container;

    public void openCustomerForm(MouseEvent mouseEvent) {
        openUI("CustomerForm");
    }
    public void openItemForm(MouseEvent mouseEvent) {
        openUI("ItemForm");
    }
    public void openPlaceOrderForm(MouseEvent mouseEvent) {
        openUI("PlaceOrderForm");
    }
    public void openOrderForm(MouseEvent mouseEvent) {
        openUI("OrdersForm");
    }
    void openUI(String location){
        Stage stage = (Stage) container.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().
                    getResource("../view/"+location+ ".fxml"))));
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
