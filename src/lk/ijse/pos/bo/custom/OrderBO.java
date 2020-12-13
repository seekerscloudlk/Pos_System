package lk.ijse.pos.bo.custom;

import lk.ijse.pos.dto.ItemDetailsDTO;
import lk.ijse.pos.dto.OrderDTO;

import java.util.ArrayList;

public interface OrderBO {
    public ArrayList<OrderDTO> getAllOrders()throws Exception;
    //-----------
    public ArrayList<ItemDetailsDTO> getAllItemDetails(String id)throws Exception;
}
