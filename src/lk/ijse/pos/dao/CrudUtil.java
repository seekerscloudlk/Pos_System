package lk.ijse.pos.dao;

import lk.ijse.pos.db.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrudUtil {
    public static <T> T execute(String sql,Object...params) throws Exception{
        PreparedStatement statement= DataBaseConnection.getInstance().getConnection().
                prepareStatement(sql);
        // fori-> tab
        for (int i = 0; i < params.length; i++) {
            statement.setObject((i+1),params[i]);
        }

        if (sql.startsWith("SELECT")){
            return (T)statement.executeQuery();
        }

        return ((T)(Boolean)(statement.executeUpdate()>0));
    }
}
