package lk.ijse.pos.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.pos.bo.BoFactory;
import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.bo.custom.ItemBO;

import java.io.IOException;

public class DashBoardFormController {
    public AnchorPane container;
    public Label txtCustomerCount;
    public Label txtItemCount;
    public Label txtOrderCount;
    private CustomerBO customerBO;
    private ItemBO itemBO;


    public void initialize() {

        //-----------
        customerBO = BoFactory.getInstance().getBo(BoFactory.BoType.CUSTOMER);
        itemBO = BoFactory.getInstance().getBo(BoFactory.BoType.ITEM);
        //-----------

        try {
            loadAllCounts();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAllCounts() throws Exception {
        //-------load customer count

        txtCustomerCount.setText(String.valueOf(customerBO.getCustomerCount()));
        txtItemCount.setText(String.valueOf(itemBO.getItemCount()));

        //-------load customer count
    }

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

    void openUI(String location) {
        Stage stage = (Stage) container.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().
                    getResource("../view/" + location + ".fxml"))));
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
