package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.db.DataBaseConnection;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CustomerDaoIMPL implements CustomerDAO {

    @Override
    public boolean save(Customer customer) throws Exception {
        return CrudUtil.execute("INSERT INTO Customer VALUES (?,?,?,?)", customer.getId(),customer.getName(),customer.getAddress(),customer.getSalary());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("DELETE FROM Customer WHERE id=?",s);
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        return CrudUtil.execute("UPDATE Customer SET name=?,address=?,salary=? WHERE id=?",
                customer.getName(),customer.getAddress(),customer.getSalary(),customer.getId());
    }

    @Override
    public Customer get(String s) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Customer WHERE id=?",s);
        if (resultSet.next()){
            return new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        ResultSet resultSet= CrudUtil.execute("SELECT * FROM Customer");
        ArrayList<Customer> myCustomerList= new ArrayList();
        while (resultSet.next()){
            myCustomerList.add(
                    new Customer(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDouble(4)
                    )
            );
        }
        return myCustomerList;
    }

    @Override
    public int getCustomerCount() throws Exception {
        ResultSet result=CrudUtil.execute("SELECT COUNT(id) AS `customer count` FROM Customer");
        if (result.next()){
            return result.getInt(1);
        }
        return 0;
    }
}
