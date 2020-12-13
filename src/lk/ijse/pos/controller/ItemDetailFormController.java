package lk.ijse.pos.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.pos.bo.BoFactory;
import lk.ijse.pos.bo.custom.OrderBO;
import lk.ijse.pos.dto.ItemDetailsDTO;
import lk.ijse.pos.view.tm.ItemDetailsTM;

public class ItemDetailFormController {
    public TableView<ItemDetailsTM> tblOrderDetail;
    public TableColumn colICode;
    public TableColumn colOId;
    public TableColumn colDescription;
    public TableColumn colQTY;
    public TableColumn colUnitPrice;

    OrderBO bo= BoFactory.getInstance().getBo(BoFactory.BoType.ORDER);

    public void initialize(){
        colICode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colOId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("itemDescription"));
        colQTY.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
    }

    public void printMySlip(ActionEvent actionEvent) {

    }

    public void loadItemData(String id) throws Exception {
        ObservableList<ItemDetailsTM> tmList= FXCollections.observableArrayList();
        for (ItemDetailsDTO dto:bo.getAllItemDetails(id)
             ) {
            tmList.add(new ItemDetailsTM(
                    dto.getOrderId(),dto.getItemCode(),
                    dto.getItemDescription(),dto.getQty(),dto.getUnitPrice()
            ));
        }
        tblOrderDetail.setItems(tmList);
    }


}
