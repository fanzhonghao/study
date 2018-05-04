package hw.third;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class dbQuery {
    private Connection con;
    public dbQuery(Connection con){
        this.con = con;
    }
    public ResultSet query(){
        //查询所有
        ResultSet r = null;
        String sql = "select * from info";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            r = pre.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }
    public ResultSet query(String type){
        String sql = "select * from info where type = ?";
        ResultSet r = null;
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,type);
            r = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }
}
