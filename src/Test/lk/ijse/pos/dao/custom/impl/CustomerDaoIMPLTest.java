package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.entity.Customer;

class CustomerDaoIMPLTest {

    public static void main(String[] args) throws Exception {
       new CustomerDaoIMPLTest().getCustomerCount();
    }

    void saveCustomer() throws Exception {

    }


    void getCustomerCount() throws Exception {
        System.out.println(new CustomerDaoIMPL().getCustomerCount());;
    }
}
