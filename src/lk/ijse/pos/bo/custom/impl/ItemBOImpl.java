package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.ItemBO;
import lk.ijse.pos.dao.DaoFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.impl.ItemDaoIMPL;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;

import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO= DaoFactory.getInstance().getDAO(DaoFactory.DAOType.ITEM);
    @Override
    public boolean saveItem(ItemDTO dto) throws Exception {
        return itemDAO.save(new Item(dto.getCode(),
                dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand()));
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws Exception {
        return itemDAO.update(new Item(dto.getCode(),
                dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand()));
    }

    @Override
    public boolean deleteItem(String id) throws Exception {
        return itemDAO.delete(id);
    }

    @Override
    public ItemDTO getItem(String id) throws Exception {
        Item item= itemDAO.get(id);
        if (item!=null){
            return new ItemDTO(item.getCode(),item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
        }
        return null;
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws Exception {
        ArrayList<Item> entityList= itemDAO.getAll();
        ArrayList<ItemDTO> dtoList= new ArrayList<>();

        for (Item i:entityList
             ) {
            dtoList.add(new ItemDTO(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand()));
        }
        return dtoList;
    }
}
