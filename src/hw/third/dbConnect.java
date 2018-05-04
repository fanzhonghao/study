package hw.third;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class dbConnect {
    private Connection con;
    private String address;
    private String name;
    private String password;
    public dbConnect(){
        address = "jdbc:mysql://localhost:3306/PIM?characterEncoding=utf8";
        name =  "fan";
        password = "@asd5211314";
    }
    public Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(address,name,password);
            if (con == null){
                System.out.println("数据库连接错误");
                System.exit(-1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
