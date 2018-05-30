package exerice.dbOperate;


import java.sql.*;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-26
 * Description:
 * <p>
 * -----------------------
 */
public class DBoperate {
    private Connection con;
    public void connect(){
        new DBConnect().connect();
    }
    public boolean insert(String type,String data){
        return new DBInsert().insert(type,data);
    }
    public ResultSet query(String type){
        return new DBQuery().query(type);
    }
    public ResultSet query(){
        return new DBQuery().query();
    }
    public boolean delete(String type,String data){
        return new DBDelete().delete(type,data);
    }
    public boolean update(String type,String data,String type2,String data2){
        return new DBUpdate().update(type,data,type2,data2);
    }
    public void close(){
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    class DBConnect{
        String address;
        String username;
        String userpassword;
        DBConnect(){
            address = "jdbc:mysql://localhost:3306/PIM?characterEncoding=utf8&useSSL=true";
            username =  "fan";
            userpassword = "@asd5211314";
        }

        void connect(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(address,username,userpassword);
                if (con == null){
                    System.out.println("数据库连接错误");
                    System.exit(0);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    class DBInsert{
        boolean insert(String type,String data){
            boolean flag = false;
            String sql = "insert into newInfo values(?,?)";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1,type);
                preparedStatement.setString(2,data);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                flag = true;
            } catch (SQLException e) {
//                e.printStackTrace();
            }
            return flag;
        }
    }
    class DBQuery{
        ResultSet resultSet = null;
        ResultSet query(String type){
            String sql = "select * from newInfo where type = ?";
            ResultSet resultSet = null;
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1,type);
                resultSet = preparedStatement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultSet;
        }
        ResultSet query(){
            String sql = "select * from newInfo";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultSet;
        }

    }
    class DBDelete{
        boolean delete(String type,String data){
            String sql = "delete from newInfo where type = ? and data = ?";
            boolean flag = false;
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1,type);
                preparedStatement.setString(2,data);
                preparedStatement.executeUpdate();
                flag = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return flag;
        }
    }
    class DBUpdate{
        boolean update(String type,String data,String type2,String data2){
            boolean flag = false;
            flag = new DBDelete().delete(type,data) && new DBInsert().insert(type2,data2);
            return flag;
        }
    }

    public Connection getCon() {
        return con;
    }
}
