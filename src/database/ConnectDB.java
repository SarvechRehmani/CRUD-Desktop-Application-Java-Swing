package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    static Connection con;
    public static Connection connect(){
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/swingcrud","root","");
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
