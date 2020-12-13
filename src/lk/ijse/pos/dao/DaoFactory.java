package lk.ijse.pos.dao;

import lk.ijse.pos.dao.custom.impl.CustomerDaoIMPL;
import lk.ijse.pos.dao.custom.impl.ItemDaoIMPL;
import lk.ijse.pos.dao.custom.impl.OrderDaoIMPL;

public class DaoFactory {// Singleton+Factory
    private static DaoFactory daoFactory;

    private DaoFactory(){}

    public enum DAOType{
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL
    }
    public static DaoFactory getInstance(){
        if (daoFactory==null){
            daoFactory= new DaoFactory();
        }
        return daoFactory;
    }

    public <T> T getDAO(DAOType type){
        switch (type){
            case CUSTOMER:
                return (T) new CustomerDaoIMPL();
            case ITEM:
                return (T) new ItemDaoIMPL();
            case ORDER:
                return (T) new OrderDaoIMPL();
            case ORDER_DETAIL:
                return null;
            default:
                return null;
        }
    }

}
