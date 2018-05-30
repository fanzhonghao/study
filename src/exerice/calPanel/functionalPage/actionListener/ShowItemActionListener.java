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
public class ShowItemActionListener extends Panel implements MouseListener,ActionListener{
    private PIMEntity pimEntity;
    private CardLayout cardLayout;
    private Panel fatherPanel;
    private JButton returnButton;
    private JButton saveButton;
    JTextField jTextField = null;
    JTextField jTextField1 = null;
    JTextField jTextField2 = null;
    JTextField jTextField3 = null;
    JTextField jTextField4 = null;
    JTextField jTextField5 = null;
    public ShowItemActionListener(PIMEntity pimEntity,CardLayout cardLayout,Panel fatherPanel){
        this.cardLayout = cardLayout;
        this.fatherPanel = fatherPanel;
        this.pimEntity = pimEntity;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println(pimEntity.toString());
        String itemType = pimEntity.getClass().toString().substring(24);
        String datas = pimEntity.toString();
        String[] dataSplits = datas.split("##");
        String owner = dataSplits[0].substring(6);
        String whetherPublic = dataSplits[1].substring(14);
        String priority = dataSplits[2].substring(9);
        JPanel upPanel = new JPanel();
        System.out.println("itemType: " + itemType);
        if (itemType.equals("Note")){
            upPanel.setLayout(new GridLayout(4,2));
        }else if (itemType.equals("Todo")){
            upPanel.setLayout(new GridLayout(5,2));
        }else if (itemType.equals("Appointment")){
            upPanel.setLayout(new GridLayout(5,2));
        }else if (itemType.equals("Contact")){
            upPanel.setLayout(new GridLayout(6,2));
        }

        JLabel jLabel = new JLabel("owner:");
        JLabel jLabel1 = new JLabel("whetherPublic:");
        JLabel jLabel2 = new JLabel("priority:");
        jTextField = new JTextField();
        jTextField.setColumns(20);
        jTextField1 = new JTextField();
        jTextField1.setColumns(20);
        jTextField2 = new JTextField();
        jTextField2.setColumns(20);
        jTextField.setText(owner);
        jTextField.setEditable(false);
        jTextField1.setText(whetherPublic);
        jTextField2.setText(priority);
        upPanel.add(jLabel);
        upPanel.add(jTextField);
        upPanel.add(jLabel1);
        upPanel.add(jTextField1);
        upPanel.add(jLabel2);
        upPanel.add(jTextField2);

        if (itemType.equals("Note")){
            JLabel jLabel3 = new JLabel("Data:");
            jTextField3 = new JTextField();
            jTextField3.setColumns(20);
            jTextField3.setText(dataSplits[3].substring(5));
            upPanel.add(jLabel3);
            upPanel.add(jTextField3);
        }else if (itemType.equals("Todo")){
            JLabel jLabel3 = new JLabel("Date:");
            jTextField3 = new JTextField();
            jTextField3.setColumns(20);
            jTextField3.setText(dataSplits[3].substring(5));
            JLabel jLabel4 = new JLabel("Data:");
            jTextField4 = new JTextField();
            jTextField4.setColumns(20);
            jTextField4.setText(dataSplits[4].substring(5));
            upPanel.add(jLabel3);
            upPanel.add(jTextField3);
            upPanel.add(jLabel4);
            upPanel.add(jTextField4);
        }else if (itemType.equals("Appointment")){
            JLabel jLabel3 = new JLabel("Date:");
            jTextField3 = new JTextField();
            jTextField3.setColumns(20);
            jTextField3.setText(dataSplits[3].substring(5));
            JLabel jLabel4 = new JLabel("Description:");
            jTextField4 = new JTextField();
            jTextField4.setColumns(20);
            jTextField4.setText(dataSplits[4].substring(12));
            upPanel.add(jLabel3);
            upPanel.add(jTextField3);
            upPanel.add(jLabel4);
            upPanel.add(jTextField4);
        }else if (itemType.equals("Contact")){
            JLabel jLabel3 = new JLabel("FirstName:");
            jTextField3 = new JTextField();
            jTextField3.setColumns(20);
            jTextField3.setText(dataSplits[3].substring(10));
            JLabel jLabel4 = new JLabel("LastName:");
            jTextField4 = new JTextField();
            jTextField4.setColumns(20);
            jTextField4.setText(dataSplits[4].substring(9));
            JLabel jLabel5 = new JLabel("EmailAddress:");
            jTextField5 = new JTextField();
            jTextField5.setColumns(20);
            jTextField5.setText(dataSplits[5].substring(13));
            upPanel.add(jLabel3);
            upPanel.add(jTextField3);
            upPanel.add(jLabel4);
            upPanel.add(jTextField4);
            upPanel.add(jLabel5);
            upPanel.add(jTextField5);
        }

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1,2,80,0));
        returnButton = new JButton("返回");
        saveButton = new JButton("保存");
        jPanel.add(returnButton);
        jPanel.add(saveButton);
        add(upPanel);
        add(jPanel);
        fatherPanel.add(this);
        cardLayout.next(fatherPanel);
        returnButton.addActionListener(this);
        saveButton.addActionListener(this);
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

        if (e.getSource() == returnButton){
            cardLayout.previous(fatherPanel);
            fatherPanel.remove(4);
//            this.removeAll();
        }else if (e.getSource() == saveButton){
            String type = pimEntity.getClass().toString().substring(24);
            PIMEntity localPimEntity = null;
            StringBuffer data = new StringBuffer();
            data.append("owner:" + jTextField.getText());
            data.append("##whetherPublic:" + jTextField1.getText());
            data.append("##priority:" + jTextField2.getText());
            if (type.equals("Note")){
                data.append("##data:" + jTextField3.getText());
                localPimEntity = new PIMNote();
            }else if (type.equals("Contact")){
                data.append("##firstName:" + jTextField3.getText());
                data.append("##lastName:" + jTextField4.getText());
                data.append("##emailAddress:" + jTextField5.getText());
                localPimEntity = new PIMContact();
            }else if (type.equals("Todo")){
                data.append("##date:" + jTextField3.getText());
                data.append("##data:" + jTextField4.getText());
                localPimEntity = new PIMTodo();
            }else if (type.equals("Appointment")){
                data.append("##date:" + jTextField3.getText());
                data.append("##description:" + jTextField4.getText());
                localPimEntity = new PIMAppointment();
            }
            String oData = pimEntity.toString();
            System.out.println("数据已保存");
            if (!oData.equals(data)){
                localPimEntity.fromString(String.valueOf(data));
                new PIMDelete(pimEntity).delete();
                pimEntity = localPimEntity;
                new PIMSave(localPimEntity).save();
            }
        }
    }
}
