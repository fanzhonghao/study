package hw.third;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class dbInsert {
    private Connection con;
    public dbInsert(Connection con){
        this.con = con;
    }
    public void insert(String type,String data){
        String sql = "insert into info values(?,?)";
        try {
//            System.out.println("size: " + data.length());
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,type);
            preparedStatement.setString(2,data);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
