package exerice.calPanel.functionalPage.actionListener;

import exerice.newPIM.PIMCollection;
import exerice.newPIM.PIMEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-28
 * Description:
 * <p>
 * -----------------------
 */
public class DateEventListener extends JPanel implements ActionListener{
    private String date;
    private Panel fatherPanel;
    private CardLayout cardLayout;
    JTextField jTextField = null;
    JTextField jTextField1 = null;
    JTextField jTextField2 = null;
    JTextField jTextField3 = null;
    JTextField jTextField4 = null;
    JTextField jTextField5 = null;
    JButton returnButton = null;

    public DateEventListener(String date,Panel fatherPanel,CardLayout cardLayout){
        this.date = date;
        this.fatherPanel = fatherPanel;
        this.cardLayout = cardLayout;

        PIMCollection pimCollection = new PIMCollection();
        pimCollection.getItemsForDate(date);
        int num = pimCollection.size();

        Iterator iterator = pimCollection.iterator();
        JPanel sumPanel = new JPanel();
        sumPanel.setLayout(new FlowLayout());
        add(sumPanel);
        for (int i = 0;i < num && iterator.hasNext();i++){

            JPanel upPanel = new JPanel();
            PIMEntity pimEntity = (PIMEntity) iterator.next();
            String type = pimEntity.getClass().toString().substring(24);

            String data = pimEntity.toString();
            String[] datas = data.split("##");
            JLabel jLabel = new JLabel("owner:");
            JLabel jLabel1 = new JLabel("whetherPublic:");
            JLabel jLabel2 = new JLabel("priority:");
            jTextField = new JTextField();
            jTextField.setText(datas[0].substring(6));
            jTextField1 = new JTextField();
            jTextField1.setText(datas[1].substring(14));
            jTextField2 = new JTextField();
            jTextField2.setText(datas[2].substring(9));
            jTextField.setEditable(false);
            jTextField.setColumns(20);
            jTextField1.setEditable(false);
            jTextField1.setColumns(20);
            jTextField2.setEditable(false);
            jTextField2.setColumns(20);
            if (type.equals("Note")){
                upPanel.setLayout(new GridLayout(4,2));
            }else if (type.equals("Todo")){
                upPanel.setLayout(new GridLayout(5,2));
            }else if (type.equals("Contact")){
                upPanel.setLayout(new GridLayout(6,2));
            }else if (type.equals("Appointment")){
                upPanel.setLayout(new GridLayout(5,2));
            }
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
                JLabel jLabel4 = new JLabel("lastName:");
                JLabel jLabel5 = new JLabel("emailAddress:");
                jTextField3 = new JTextField();
                jTextField3.setColumns(20);
                jTextField3.setText(datas[3].substring(10));
                jTextField4 = new JTextField();
                jTextField4.setColumns(20);
                jTextField4.setText(datas[4].substring(9));
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
                JLabel jLabel4 = new JLabel("description:");
                jTextField3 = new JTextField();
                jTextField3.setColumns(20);
                jTextField3.setText(datas[3].substring(5));
                jTextField4 = new JTextField();
                jTextField4.setColumns(20);
                jTextField4.setText(datas[4].substring(12));
                upPanel.add(jLabel3);
                upPanel.add(jTextField3);
                upPanel.add(jLabel4);
                upPanel.add(jTextField4);
            }

            upPanel.addMouseListener(new ItemClickEventListener(pimEntity));

            if (jTextField3 != null) jTextField3.setEditable(false);
            if (jTextField4 != null) jTextField4.setEditable(false);
            if (jTextField5 != null) jTextField5.setEditable(false);


            sumPanel.add(upPanel);
        }
        returnButton = new JButton("返回");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1,1));
        jPanel.add(returnButton);




        add(new Label("                                                             "));
        add(jPanel);
        returnButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton){
            cardLayout.previous(fatherPanel);
            cardLayout.previous(fatherPanel);
            fatherPanel.remove(3);
        }else {
            fatherPanel.add(this);
            cardLayout.next(fatherPanel);
            cardLayout.next(fatherPanel);
//            System.out.println("num: " + fatherPanel.getComponents().length);
        }

    }
}
