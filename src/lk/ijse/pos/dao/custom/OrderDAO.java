package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.entity.ItemDetails;
import lk.ijse.pos.entity.Order;

import java.util.ArrayList;

public interface OrderDAO extends CrudDAO<String, Order> {
    public ArrayList<ItemDetails> getAllItemDetails(String id) throws Exception;
}
