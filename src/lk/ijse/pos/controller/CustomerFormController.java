package lk.ijse.pos.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pos.bo.BoFactory;
import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.bo.custom.impl.CustomerBOIMPL;
import lk.ijse.pos.dto.CustomerDTO;

import java.io.IOException;

public class CustomerFormController {

    CustomerBO bo;

    public AnchorPane container;
    public TextField txtId;
    public TextField txtName;
    public TextField txtSalary;
    public TextField txtAddress;
    public JFXButton btnSaveAndUpdate;

    public void initialize(){
        bo= BoFactory.getInstance().getBo(BoFactory.BoType.CUSTOMER);
    }

    public void backToHomeOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) container.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().
                    getResource("../view/DashBoardForm.fxml"))));
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnSaveAndUpdateOnAction(ActionEvent actionEvent) throws Exception {
        CustomerDTO dto= new CustomerDTO(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                Double.parseDouble(txtSalary.getText())
        );
        if (bo.saveCustomer(dto)){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved!", ButtonType.OK).show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Try Again!", ButtonType.CLOSE).show();
        }
    }
}
