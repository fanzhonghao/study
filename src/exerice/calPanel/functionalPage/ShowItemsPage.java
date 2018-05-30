package exerice.calPanel.functionalPage;

import exerice.calPanel.functionalPage.actionListener.ShowItemActionListener;
import exerice.newPIM.PIMCollection;
import exerice.newPIM.PIMEntity;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
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
public class ShowItemsPage extends JPanel implements ActionListener{
    private String type;
    private CardLayout cardLayout;
    private Panel fatherPanel;
    private JButton returnButton;
    private JComboBox typesBox;
    private String userName;
    public ShowItemsPage(String type,CardLayout cardLayout,Panel panel,String userName){
        this.userName = userName;
        this.type = type;
        this.cardLayout = cardLayout;
        this.fatherPanel = panel;
        Iterator<PIMEntity> iterator = null;
        setLayout(new FlowLayout());

        PIMCollection pimCollection = new PIMCollection();

        if (type.equals("all")){
            pimCollection.getAll();
            iterator = pimCollection.iterator();
        }else if (type.equals("note")){
            iterator = pimCollection.getNotes().iterator();
        }else if (type.equals("contact")){
            iterator = pimCollection.getContacts().iterator();
        }else if (type.equals("todo")){
            iterator = pimCollection.getTodos().iterator();
        }else if (type.equals("appointment")){
            iterator = pimCollection.getAppointments().iterator();
        }else if (type.matches("^owner:.*")){
            iterator = pimCollection.getAllByOwner(type.substring(6)).iterator();
        }else if (type.matches("^date:.*")){
            iterator = pimCollection.getItemsForDate(type.substring(5)).iterator();
        }

        JPanel returnPanel = new JPanel();

        returnButton = new JButton("返回");

        String[] types = {"all","note","contact","todo","appointment"};
        typesBox = new JComboBox(types);
        typesBox.setMaximumRowCount(4);
        typesBox.setLightWeightPopupEnabled(false);

        typesBox.setSelectedItem(type);

        JLabel typeLable = new JLabel("type:");
        JPanel typePanel = new JPanel();
        typePanel.add(typeLable);
        typePanel.add(typesBox);

        returnPanel.add(typePanel);
        returnPanel.add(returnButton);

        JPanel sumPanel = new JPanel();
        int num = pimCollection.size();
        sumPanel.setLayout(new GridLayout(num + 1,1));
        add(sumPanel);
        sumPanel.add(returnPanel);


        while (iterator.hasNext()){
            PIMEntity pimEntity = iterator.next();
            String datas = pimEntity.toString();
            String itemType = pimEntity.getClass().toString().substring(24);
            String[] dataSplits = datas.split("##");
            String owner = dataSplits[0].substring(6);
            String whetherPublic = dataSplits[1].substring(14);
            String priority = dataSplits[2].substring(9);
            JPanel upPanel = new JPanel();
            JLabel jLabel = new JLabel("owner:");
            JLabel jLabel1 = new JLabel("whetherPublic:");
            JLabel jLabel2 = new JLabel("priority:");
            JTextField jTextField = new JTextField();
            jTextField.setColumns(20);
            JTextField jTextField1 = new JTextField();
            jTextField1.setColumns(20);
            JTextField jTextField2 = new JTextField();
            jTextField2.setColumns(20);
            if (itemType.equals("Note")){
                upPanel.setLayout(new GridLayout(4,2));
            }else if (itemType.equals("Todo")){
                upPanel.setLayout(new GridLayout(5,2));
            }else if (itemType.equals("Appointment")){
                upPanel.setLayout(new GridLayout(5,2));
            }else if (itemType.equals("Contact")){
                upPanel.setLayout(new GridLayout(6,2));
            }

            upPanel.setVisible(true);
            upPanel.add(jLabel);
            upPanel.add(jTextField);
            upPanel.add(jLabel1);
            upPanel.add(jTextField1);
            upPanel.add(jLabel2);
            upPanel.add(jTextField2);
            Border border = new EtchedBorder(EtchedBorder.RAISED);
            upPanel.setBorder(border);
            jTextField.setText(owner);
            jTextField.setEditable(false);
            jTextField1.setText(whetherPublic);
            jTextField2.setText(priority);

            JTextField jTextField3 = null;
            JTextField jTextField4 = null;
            JTextField jTextField5 = null;

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

            jTextField1.setEditable(false);
            jTextField2.setEditable(false);
            if (jTextField3 != null) jTextField3.setEditable(false);
            if (jTextField4 != null) jTextField4.setEditable(false);
            if (jTextField5 != null) jTextField5.setEditable(false);


            upPanel.addMouseListener(new ShowItemActionListener(pimEntity,cardLayout,fatherPanel));


            sumPanel.add(upPanel);
            sumPanel.setSize(sumPanel.getWidth(),sumPanel.getHeight() + 20);
        }
        returnButton.addActionListener(this);
        typesBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton){
            cardLayout.previous(fatherPanel);
            cardLayout.previous(fatherPanel);
            fatherPanel.remove(3);

        }else if (e.getSource() == typesBox){
            int index = ((JComboBox)e.getSource()).getSelectedIndex();
            cardLayout.previous(fatherPanel);
            fatherPanel.remove(3);
            JScrollPane jScrollPane = null;
            switch (index){
                case 0:
                    jScrollPane = new JScrollPane(new ShowItemsPage("all",cardLayout,fatherPanel,userName));
                    break;
                case 1:
                    jScrollPane = new JScrollPane(new ShowItemsPage("note",cardLayout,fatherPanel,userName));
                    break;
                case 2:
                    jScrollPane = new JScrollPane(new ShowItemsPage("contact",cardLayout,fatherPanel,userName));
                    break;
                case 3:
                    jScrollPane = new JScrollPane(new ShowItemsPage("todo",cardLayout,fatherPanel,userName));
                    break;
                case 4:
                    jScrollPane = new JScrollPane(new ShowItemsPage("appointment",cardLayout,fatherPanel,userName));
                    break;
            }
            jScrollPane.setBounds(50,50,300,200);
            fatherPanel.add(jScrollPane);
            cardLayout.next(fatherPanel);
        }else {
            JScrollPane jScrollPane = new JScrollPane(new ShowItemsPage("all",cardLayout,fatherPanel,String.
                    valueOf(userName)));
            jScrollPane.setBounds(50,50,300,200);
            fatherPanel.add(jScrollPane);
            cardLayout.next(fatherPanel);
            cardLayout.next(fatherPanel);
        }
    }
}
