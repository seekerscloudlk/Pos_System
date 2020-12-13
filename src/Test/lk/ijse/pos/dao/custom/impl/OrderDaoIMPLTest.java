package lk.ijse.pos.dao.custom.impl;


class OrderDaoIMPLTest {
    public static void main(String[] args) {
        new OrderDaoIMPLTest().getAllItemDetails();
    }

    void getAllItemDetails() {
        try {

            new OrderDaoIMPL().getAllItemDetails("D002");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
