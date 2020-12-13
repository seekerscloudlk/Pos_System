package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.entity.Customer;


public interface CustomerDAO extends CrudDAO<String,Customer> { // customer---> entity
    public int getCustomerCount()throws Exception;
}
