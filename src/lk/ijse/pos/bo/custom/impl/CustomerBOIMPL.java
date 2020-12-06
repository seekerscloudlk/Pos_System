package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dao.custom.impl.CustomerDaoIMPL;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;

import java.util.ArrayList;

public class CustomerBOIMPL implements CustomerBO {
    CustomerDAO customerDAO=new CustomerDaoIMPL();
    @Override
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.save(new Customer(dto.getId(), dto.getName(),
                dto.getAddress(), dto.getSalary()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.update(new Customer(dto.getId(), dto.getName(),
                dto.getAddress(), dto.getSalary()));
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    @Override
    public CustomerDTO getCustomer(String id) throws Exception {
        Customer customer= customerDAO.get(id);
        if (customer!=null){
            return new CustomerDTO(
                    customer.getId(),customer.getName(),customer.getAddress(),customer.getSalary()
            );
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        ArrayList<Customer> entityList = customerDAO.getAll();
        ArrayList<CustomerDTO> dtoList= new ArrayList<>();

        for (Customer c:entityList
             ) {
            dtoList.add(new CustomerDTO(
                    c.getId(),c.getName(),c.getAddress(),c.getSalary()
            ));
        }
        return dtoList;

    }
}
