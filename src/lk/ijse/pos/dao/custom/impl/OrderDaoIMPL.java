package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.entity.ItemDetails;
import lk.ijse.pos.entity.Order;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class OrderDaoIMPL implements OrderDAO {
    @Override
    public boolean save(Order order) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Order order) throws Exception {
        return false;
    }

    @Override
    public Order get(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Order> getAll() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM Orders");
        ArrayList<Order> orderList = new ArrayList<>();
        while (set.next()) {
            orderList.add(new Order(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3)
            ));
        }
        return orderList;
    }

    @Override
    public ArrayList<ItemDetails> getAllItemDetails(String id) throws Exception {
        ArrayList<ItemDetails> detailsArray = new ArrayList<>();
        String sql = "SELECT d.orderId,d.itemCode,d.qty,d.unitPrice,i.description FROM" +
                " OrderDetail d JOIN Item i ON d.orderId='" + id + "' AND d.itemCode=i.code";
        ResultSet set = CrudUtil.execute(sql);
        while (set.next()){
            detailsArray.add(new ItemDetails(
                    set.getString(1),
                    set.getString(2),
                    set.getString(5),
                    set.getInt(3),
                    set.getDouble(4)
            ));
        }
        return detailsArray;
    }
}
