package hw.third;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-4-6
 * Description:
 * <p>
 * -----------------------
 */
public class dbOperate {
    private Connection con;
    public void connect(){
        con = new dbConnect().connect();
    }
    public void insert(String type,String data){
        new dbInsert(con).insert(type,data);
    }
    public ResultSet query(){
        return new dbQuery(con).query();
    }
    public ResultSet query(String type){
        return new dbQuery(con).query(type);
    }
    public void close(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
