package exerice.calPanel.functionalPage;

import hw.forth.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-27
 * Description:
 * <p>
 * -----------------------
 */
public class RegisterPage extends JPanel implements ActionListener {
    private java.awt.Panel fatherPanel;
    private StringBuffer s;
    private CardLayout cardLayout;
    JButton registerButton;
    JTextField usernameTextField;
    JTextField userpasswordField;
    JTextField waringTextField;
    public RegisterPage(java.awt.Panel fatherPanel, CardLayout cardLayout, StringBuffer s){
        this.fatherPanel = fatherPanel;
        this.cardLayout = cardLayout;
        this.s = s;
        setLayout(new FlowLayout());

        for (int i = 0;i < 3;i++){
            JTextField jTextField = new JTextField();
            jTextField.setColumns(40);
            jTextField.setEditable(false);
            jTextField.setBackground(this.getBackground());
            jTextField.setBorder(null);
            add(jTextField);
        }

        waringTextField = new JTextField();
        waringTextField.setColumns(40);
        waringTextField.setForeground(Color.RED);
        waringTextField.setEditable(false);
        waringTextField.setBackground(this.getBackground());
        waringTextField.setBorder(null);
        add(waringTextField);

        JLabel jLabel = new JLabel("用户名:");
        JLabel jLabel1 = new JLabel("密  码:");
        JPanel usernamePanel = new JPanel();
        JPanel userpasswordPanel = new JPanel();
        usernameTextField = new JTextField();
        userpasswordField = new JTextField();
        usernameTextField.setColumns(25);
        userpasswordField.setColumns(25);
        usernamePanel.add(jLabel);
        usernamePanel.add(usernameTextField);
        userpasswordPanel.add(jLabel1);
        userpasswordPanel.add(userpasswordField);
        add(usernamePanel);
        add(userpasswordPanel);
        add(new JLabel("                                                   "));

        registerButton = new JButton("注册");
        JPanel downPanel = new JPanel();
        downPanel.setLayout(new GridLayout(1,1));
        downPanel.add(registerButton);
        add(downPanel);
        registerButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String address = "jdbc:mysql://localhost:3306/PIM?characterEncoding=utf8";
            String username = "fan";
            String userpassword = "@asd5211314";
            connection = DriverManager.getConnection(address,username,userpassword);
            if (connection == null)
            {
                System.out.println("数据库连接错误");
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        ResultSet resultSet = null;
        String sql = "select * from userInfo where name = ?";
        String sql2 = "insert into userInfo values(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,usernameTextField.getText());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                waringTextField.setText("用户名已存在");
            }else {
                s.append(usernameTextField.getText());
                PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
                preparedStatement1.setString(1,usernameTextField.getText());
                preparedStatement1.setString(2,userpasswordField.getText());
                preparedStatement1.executeUpdate();
                cardLayout.previous(fatherPanel);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
}
