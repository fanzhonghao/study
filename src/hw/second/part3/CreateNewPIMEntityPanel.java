package hw.second.part3;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Date;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-24
 * Description:
 * <p>
 * -----------------------
 */
public class CreateNewPIMEntityPanel extends JFrame{
    private Date date;
    private String priority;
    private String data;
    private String description;
    private String firstName;
    private String LastName;
    private String emailAddress;
    private Color foregroundColor;
    private Color backgroundColor;
    public CreateNewPIMEntityPanel(){
        setBounds(500,200,400,280);
        setTitle("Create PIMEntity");
//        setLayout(new FlowLayout());
//        setLayout(new FlowLayout());
//        setLayout(null);
        foregroundColor = Color.BLACK;
        backgroundColor = Color.GRAY;
        setBackground(backgroundColor);
        setLayout(new GridLayout(8,1,5,5));
        String[] types = {"Note","Todo","Appointment","Contact"};
        JComboBox typeBox = new JComboBox(types);
        JLabel jLabel = new JLabel("Type: ");
        jLabel.setBounds(0,0,10,5);
        jLabel.setForeground(Color.RED);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.add(jLabel,BorderLayout.WEST);
        jPanel.add(typeBox,BorderLayout.WEST);
        add(jPanel);

        JTextField jTextField = new JTextField(21);
        JLabel jLabel1 = new JLabel("Priority: ");
        JPanel jPanel1 = new JPanel();
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField);
        add(jPanel1);

        JTextField jTextField1 = new JTextField(21);
        JLabel jLabel2 = new JLabel("Data: ");
        JPanel jPanel2 = new JPanel();
        jPanel2.add(jLabel2);
        jPanel2.add(jTextField1);
        add(jPanel2);






        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

    }

    public static void main(String[] args) {
        new CreateNewPIMEntityPanel();
    }
}
