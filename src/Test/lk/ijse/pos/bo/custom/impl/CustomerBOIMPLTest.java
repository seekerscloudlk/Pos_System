package lk.ijse.pos.bo.custom.impl;


import lk.ijse.pos.dto.CustomerDTO;

class CustomerBOIMPLTest {
    public static void main(String[] args) throws Exception {
        new CustomerBOIMPLTest().saveCustomer();
    }

    void saveCustomer() throws Exception {
        CustomerDTO dto= new CustomerDTO("C043","Bandara","Panadura",45000);
        System.out.println(new CustomerBOIMPL().saveCustomer(dto));
    }
}