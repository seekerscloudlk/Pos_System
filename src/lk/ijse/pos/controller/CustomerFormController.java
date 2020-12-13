package lk.ijse.pos.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pos.bo.BoFactory;
import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.bo.custom.impl.CustomerBOIMPL;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.view.tm.CustomerTM;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerFormController {

    public TableView<CustomerTM> tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colOperate;
    CustomerBO bo;

    public AnchorPane container;
    public TextField txtId;
    public TextField txtName;
    public TextField txtSalary;
    public TextField txtAddress;
    public JFXButton btnSaveAndUpdate;

    public void initialize() throws Exception {
        bo = BoFactory.getInstance().getBo(BoFactory.BoType.CUSTOMER);
        loadAllCustomers();
        //---------------------
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOperate.setCellValueFactory(new PropertyValueFactory<>("btn"));

        ///---------------------------------
        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setCustomerData(newValue);
        });

    }

    private void setCustomerData(CustomerTM cTm) {
        txtId.setText(cTm.getId());
        txtId.setEditable(false);
        txtName.setText(cTm.getName());
        txtAddress.setText(cTm.getAddress());
        txtSalary.setText(String.valueOf(cTm.getSalary()));
        btnSaveAndUpdate.setText("Update");
    }

    private void loadAllCustomers() throws Exception {
        ArrayList<CustomerDTO> dtoList = bo.getAllCustomers();
        ObservableList<CustomerTM> observableList = FXCollections.observableArrayList();
        for (CustomerDTO dto : dtoList
        ) {
            JFXButton btn = new JFXButton("Delete");
            CustomerTM tm = new CustomerTM(
                    dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary(), btn
            );


            //--------------
            btn.setOnAction((e) -> {
                try {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.YES) {
                        if (bo.deleteCustomer(tm.getId())) {
                            loadAllCustomers();
                            new Alert(Alert.AlertType.CONFIRMATION, "Deleted!", ButtonType.OK).show();
                        } else {
                            new Alert(Alert.AlertType.WARNING, "Try Again!", ButtonType.CLOSE).show();
                        }
                    }

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });

            observableList.add(tm);
        }

        tblCustomer.setItems(observableList);

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
        CustomerDTO dto = new CustomerDTO(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                Double.parseDouble(txtSalary.getText())
        );

        if (btnSaveAndUpdate.getText().equalsIgnoreCase("Save")){
            if (bo.saveCustomer(dto)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!", ButtonType.OK).show();
                loadAllCustomers();
            } else {
                new Alert(Alert.AlertType.ERROR, "Try Again!", ButtonType.CLOSE).show();
            }
        }else{
            if (bo.updateCustomer(dto)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!", ButtonType.OK).show();
                loadAllCustomers();
            } else {
                new Alert(Alert.AlertType.ERROR, "Try Again!", ButtonType.CLOSE).show();
            }
        }
    }

    public void btnBackToSaveState(MouseEvent mouseEvent) {
        txtId.setText("");
        txtId.setEditable(true);
        txtName.setText("");
        txtAddress.setText("");
        txtSalary.clear();
        btnSaveAndUpdate.setText("Save");
    }
}
