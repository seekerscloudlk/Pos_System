package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.db.DataBaseConnection;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemDaoIMPL implements ItemDAO {

    @Override
    public boolean save(Item item) throws Exception {
        return CrudUtil.execute("INSERT INTO Item VALUES (?,?,?,?)",item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("DELETE FROM Item WHERE code=?",s);
    }

    @Override
    public boolean update(Item item) throws Exception {
        return CrudUtil.execute("UPDATE Item SET description=?,unitPrice=?,qtyOnHand=? WHERE code=?",
                item.getDescription(),item.getUnitPrice(),item.getQtyOnHand(),item.getCode());
    }

    @Override
    public Item get(String s) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Item WHERE code=?",s);
        if (resultSet.next()){
            return new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Item> getAll() throws Exception {
        ResultSet resultSet= CrudUtil.execute("SELECT * FROM Item");
        ArrayList<Item> myItemList= new ArrayList();
        while (resultSet.next()){
            myItemList.add(
                    new Item(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getDouble(3),
                            resultSet.getInt(4)
                    )
            );
        }
        return myItemList;
    }

    @Override
    public int getItemCount() throws Exception {
        ResultSet set=CrudUtil.execute("SELECT COUNT(code) AS `item count` FROM Item");
        if (set.next()){
            return set.getInt(1);
        }
        return 0;
    }
}
