package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.OrderBO;
import lk.ijse.pos.dao.DaoFactory;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.dto.ItemDetailsDTO;
import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.entity.ItemDetails;
import lk.ijse.pos.entity.Order;

import java.util.ArrayList;

public class OrderBOIMPL implements OrderBO {

    OrderDAO dao = DaoFactory.getInstance().getDAO(DaoFactory.DAOType.ORDER);

    @Override
    public ArrayList<OrderDTO> getAllOrders() throws Exception {
        ArrayList<OrderDTO> dtoList = new ArrayList<>();
        for (Order o : dao.getAll()
        ) {
            dtoList.add(new OrderDTO(o.getId(), o.getDate(), o.getCustomerId()));
        }
        return dtoList;
    }

    @Override
    public ArrayList<ItemDetailsDTO> getAllItemDetails(String id) throws Exception {
        ArrayList<ItemDetailsDTO> dtoList = new ArrayList<>();
        for (ItemDetails e : dao.getAllItemDetails(id)
        ) {
            dtoList.add(new ItemDetailsDTO(
                e.getOrderId(),e.getItemCode(),e.getItemDescription(),e.getQty(),e.getUnitPrice()
            ));
        }
        return dtoList;
    }
}
