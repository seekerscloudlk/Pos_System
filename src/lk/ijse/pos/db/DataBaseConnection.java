package lk.ijse.pos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static DataBaseConnection dataBaseConnection; //1
    // optional
    private static Connection connection;

    private DataBaseConnection() throws ClassNotFoundException, SQLException { //2
        Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/ThogaKade",
                "root","1234");
    }

    public static DataBaseConnection getInstance() throws SQLException, ClassNotFoundException { //3
      /*  if (dataBaseConnection==null){
            dataBaseConnection= new DataBaseConnection();
        }
        return dataBaseConnection;*/
        return (dataBaseConnection==null)?
                (dataBaseConnection=new DataBaseConnection()):(dataBaseConnection);
    }

    public Connection getConnection(){
        return connection;
    }
}
