package lk.ijse.pos.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pos.bo.BoFactory;
import lk.ijse.pos.bo.custom.OrderBO;
import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.entity.Order;
import lk.ijse.pos.view.tm.OrderTM;

import java.io.IOException;

public class OrdersFormController {
    public AnchorPane container;
    public TableView<OrderTM> tblOrders;
    public TableColumn colOid;
    public TableColumn colCId;
    public TableColumn colTotal;
    public TableColumn colDate;
    public TableColumn colOperate;

    OrderBO bo= BoFactory.getInstance().getBo(BoFactory.BoType.ORDER);

    public void initialize() throws Exception {

        colOid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colCId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colOperate.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadAllOrders();


        //---------------------
        tblOrders.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            try {
                loadUniqueOrderDetail(newValue.getId());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });


    }

    private void loadUniqueOrderDetail(String id) throws Exception {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("../view/ItemDetailForm.fxml"));
        Parent parent= loader.load();
        ItemDetailFormController controller=(ItemDetailFormController)loader.getController();
        controller.loadItemData(id);
        Scene scene= new Scene(parent);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
    }

    private void loadAllOrders() throws Exception {
        ObservableList<OrderTM> observableList= FXCollections.observableArrayList();
        for (OrderDTO oDto:bo.getAllOrders()
             ) {
            JFXButton btn= new JFXButton("Delete");
            OrderTM tm= new OrderTM(
              oDto.getId(),oDto.getDate(),oDto.getCustomerId(),btn
            );
            observableList.add(tm);
        }
        tblOrders.setItems(observableList);
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
}
