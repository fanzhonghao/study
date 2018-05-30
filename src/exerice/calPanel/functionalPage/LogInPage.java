package exerice.calPanel.functionalPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class LogInPage extends JPanel implements ActionListener{

    private Panel fatherPanel;
    private StringBuffer s;
    private CardLayout cardLayout;
    private JButton customerButton;
    JButton logInButton;
    JButton registerButton;
    JTextField usernameTextField;
    JTextField userpasswordField;
    JTextField waringTextField;
    public LogInPage(Panel fatherPanel,CardLayout cardLayout,StringBuffer s){
        this.fatherPanel = fatherPanel;
        this.cardLayout = cardLayout;
        this.s = s;
        setLayout(new FlowLayout());
        customerButton = new JButton("游客");
        JPanel j1 = new JPanel();
        JLabel emptyLabel = new JLabel();
        j1.setLayout(new GridLayout(1,2,90,0));
        j1.add(emptyLabel);
        j1.add(customerButton);
        add(j1);

        for (int i = 0;i < 2;i++){
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


        registerButton = new JButton("注册");
        logInButton = new JButton("登录");
        JPanel downPanel = new JPanel();
        downPanel.setLayout(new GridLayout(1,2,90,0));
        downPanel.add(registerButton);
        downPanel.add(logInButton);
        add(downPanel);
        customerButton.addActionListener(this);
        logInButton.addActionListener(this);
        registerButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customerButton){
            cardLayout.next(fatherPanel);
            s.append("");
        }else if (e.getSource() == logInButton){
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String address = "jdbc:mysql://localhost:3306/PIM?characterEncoding=utf8";
                String username = "fan";
                String userpassword = "@asd5211314";
                connection = DriverManager.getConnection(address,username,userpassword);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


            ResultSet resultSet = null;
            String sql = "select * from userInfo";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    String name = resultSet.getString(1);
                    String password = resultSet.getString(2);
                    if (name.equals(usernameTextField.getText()) && password.equals(userpasswordField.getText())){
                        s.append(name);
                        break;
                    }
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            if (s.length() != 0){
                System.out.println("logName: " + s);
                cardLayout.next(fatherPanel);
            }else {
                waringTextField.setText("错误的用户名或密码");
            }
        }else if (e.getSource() == registerButton){//注册
            System.out.println("注册");
            JPanel jPanel = new RegisterPage(fatherPanel,cardLayout,s);
            fatherPanel.add(jPanel);
            cardLayout.next(fatherPanel);
            cardLayout.next(fatherPanel);
            cardLayout.next(fatherPanel);
            cardLayout.next(fatherPanel);
        }
    }
}
