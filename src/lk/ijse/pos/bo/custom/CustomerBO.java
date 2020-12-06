package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.CustomerDTO;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public boolean saveCustomer(CustomerDTO dto)throws Exception;
    public boolean updateCustomer(CustomerDTO dto)throws Exception;
    public boolean deleteCustomer(String id)throws Exception;
    public CustomerDTO getCustomer(String id)throws Exception;
    public ArrayList<CustomerDTO> getAllCustomers()throws Exception;
}
