package lk.ijse.pos.bo;

import lk.ijse.pos.bo.custom.impl.CustomerBOIMPL;
import lk.ijse.pos.bo.custom.impl.ItemBOImpl;


public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory(){}

    public enum BoType{
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL
    }
    public static BoFactory getInstance(){
        if (boFactory==null){
            boFactory= new BoFactory();
        }
        return boFactory;
    }

    public <T> T getBo(BoType type){
        switch (type){
            case CUSTOMER:
                return (T) new CustomerBOIMPL();
            case ITEM:
                return (T) new ItemBOImpl();
            case ORDER:
                return null;
            case ORDER_DETAIL:
                return null;
            default:
                return null;
        }
    }
}
