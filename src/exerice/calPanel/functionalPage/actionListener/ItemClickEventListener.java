package exerice.calPanel.functionalPage.actionListener;

import exerice.newPIM.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-28
 * Description:
 * <p>
 * -----------------------
 */
public class ItemClickEventListener implements MouseListener,ActionListener{
    private PIMEntity pimEntity;
    private JTextField jTextField;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JButton saveButton;
    private JPanel jPanel;
    private JPanel upPanel;
    private String type;
    private JButton deleteButton;
    public ItemClickEventListener(PIMEntity pimEntity){
        this.pimEntity = pimEntity;

        JPanel sumPanel = new JPanel();
        upPanel = new JPanel();
//        upPanel.setBounds(50,40,350,200);
        int num = 0;
        String[] datas = pimEntity.toString().split("##");
        num = datas.length;
        upPanel.setLayout(new GridLayout(num,2));
        String type = pimEntity.getClass().toString().substring(24);

        this.type = type;

        String owner = datas[0].substring(6);
        String whetherPublic = datas[1].substring(14);
        String priority = datas[2].substring(9);

        JLabel jLabel = new JLabel("owner:");
        JLabel jLabel1 = new JLabel("whetherPublic:");
        JLabel jLabel2 = new JLabel("priority:");
        jTextField = new JTextField();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField.setColumns(20);
        jTextField.setText(owner);
        jTextField.setEditable(false);
        jTextField1.setColumns(20);
        jTextField1.setText(whetherPublic);
        jTextField2.setColumns(20);
        jTextField2.setText(priority);
        upPanel.add(jLabel);
        upPanel.add(jTextField);
        upPanel.add(jLabel1);
        upPanel.add(jTextField1);
        upPanel.add(jLabel2);
        upPanel.add(jTextField2);
        if (type.equals("Note")){
            JLabel jLabel3 = new JLabel("data:");
            jTextField3 = new JTextField();
            jTextField3.setColumns(20);
            jTextField3.setText(datas[3].substring(5));
            upPanel.add(jLabel3);
            upPanel.add(jTextField3);
        }else if (type.equals("Todo")){
            JLabel jLabel3 = new JLabel("date:");
            jTextField3 = new JTextField();
            jTextField3.setColumns(20);
            jTextField3.setText(datas[3].substring(5));
            JLabel jLabel4 = new JLabel("data:");
            jTextField4 = new JTextField();
            jTextField4.setColumns(20);
            jTextField4.setText(datas[4].substring(5));
            upPanel.add(jLabel3);
            upPanel.add(jTextField3);
            upPanel.add(jLabel4);
            upPanel.add(jTextField4);
        }else if (type.equals("Contact")){
            JLabel jLabel3 = new JLabel("firstName:");
            jTextField3 = new JTextField();
            jTextField3.setColumns(20);
            jTextField3.setText(datas[3].substring(10));
            JLabel jLabel4 = new JLabel("lastName:");
            jTextField4 = new JTextField();
            jTextField4.setColumns(20);
            jTextField4.setText(datas[4].substring(9));
            JLabel jLabel5 = new JLabel("emailAddress:");
            jTextField5 = new JTextField();
            jTextField5.setColumns(20);
            jTextField5.setText(datas[5].substring(13));
            upPanel.add(jLabel3);
            upPanel.add(jTextField3);
            upPanel.add(jLabel4);
            upPanel.add(jTextField4);
            upPanel.add(jLabel5);
            upPanel.add(jTextField5);
        }else if (type.equals("Appointment")){
            JLabel jLabel3 = new JLabel("date:");
            jTextField3 = new JTextField();
            jTextField3.setColumns(20);
            jTextField3.setText(datas[3].substring(5));
            JLabel jLabel4 = new JLabel("description:");
            jTextField4 = new JTextField();
            jTextField4.setColumns(20);
            jTextField4.setText(datas[4].substring(12));
            upPanel.add(jLabel3);
            upPanel.add(jTextField3);
            upPanel.add(jLabel4);
            upPanel.add(jTextField4);
        }

        saveButton = new JButton("保存");
        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1,2,90,0));
        jPanel.add(saveButton);
        deleteButton = new JButton("删除");
        jPanel.add(deleteButton);


        saveButton.addActionListener(this);
        deleteButton.addActionListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Type: " + this.type);
        JFrame jFrame = new JFrame();
        jFrame.setBounds(800,100,400,280);
        jFrame.setLayout(new FlowLayout());
        jFrame.add(upPanel);
        jFrame.add(new Label("                                                      "));
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        jFrame.setResizable(false);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton){
            String type = pimEntity.getClass().toString().substring(24);
            String oData = pimEntity.toString();
            StringBuffer newData = new StringBuffer();
            newData.append("owner:" + jTextField.getText());
            newData.append("##whetherPublic:" + jTextField1.getText());
            newData.append("##priority:" + jTextField2.getText());
            PIMEntity pimEntity1 = null;
            if (type.equals("Note")){
                newData.append("##data:" + jTextField3.getText());
                pimEntity1 = new PIMNote();
            }else if (type.equals("Contact")){
                newData.append("##firstName:" + jTextField3.getText());
                newData.append("##lastName:" + jTextField4.getText());
                newData.append("##emailAddress:" + jTextField5.getText());
                pimEntity1 = new PIMContact();
            }else if (type.equals("Todo")){
                newData.append("##date:" + jTextField3.getText());
                newData.append("##data:" + jTextField4.getText());
                pimEntity1 = new PIMTodo();
            }else if (type.equals("Appointment:")){
                newData.append("##date:" + jTextField3.getText());
                newData.append("##description:" + jTextField4.getText());
                pimEntity1 = new PIMAppointment();
            }
            pimEntity1.fromString(String.valueOf(newData));
            System.out.println("数据已保存");
            if (!oData.equals(newData)){
                new PIMDelete(pimEntity).delete();
                pimEntity = pimEntity1;
                new PIMSave(pimEntity1).save();
            }
        }else if (e.getSource() == deleteButton){
            System.out.println("数据已删除");
            new PIMDelete(pimEntity).delete();

        }
    }
}
