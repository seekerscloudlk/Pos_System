package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.entity.Item;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<String,Item> {
   /*public boolean saveItem(Item item)throws Exception;
   public Item getItem(String id)throws Exception;
   public boolean updateItem(Item item)throws Exception;
   public boolean deleteItem(String id)throws Exception;
   public ArrayList<Item> getAllItems()throws Exception;*/

    public int getItemCount()throws Exception;
}
