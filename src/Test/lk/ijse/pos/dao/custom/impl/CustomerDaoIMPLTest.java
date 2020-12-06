package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.entity.Customer;

class CustomerDaoIMPLTest {

    public static void main(String[] args) throws Exception {
        new CustomerDaoIMPLTest().saveCustomer();
    }

    void saveCustomer() throws Exception {
        Customer c1= new Customer("C041","Kamal","Colombo",25000);
        if (new CustomerDaoIMPL().save(c1)){
            System.out.println("Saved");
        }else{
            System.out.println("Try Again");
        }
    }
}