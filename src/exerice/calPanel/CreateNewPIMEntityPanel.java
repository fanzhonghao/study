package exerice.calPanel;


import exerice.newPIM.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class CreateNewPIMEntityPanel extends JPanel implements ActionListener {
    private JTextField ownerTextField;
    private JTextField priorityTextField;
    private ButtonGroup whetherPublic;
    private Panel subFatherPanel;
    private CardLayout localCardLayout;
    private JTextField noteDataJTextField;
    private JTextField todoDateJTextField;
    private JTextField todoDataJTextField;
    private JTextField contactFirstNameJTextField;
    private JTextField contactLastNameJTextField;
    private JTextField contactEmailAddressJTextField;
    private JTextField appointmentDateJTextField;
    private JTextField appointmentDescriptionJTextField;
    private JComboBox typeBox;
    private JButton returnButton;
    private JButton saveButton;
    private JButton clearButton;
    private CardLayout cardLayout;
    private Panel fatherPanel;
    private StringBuffer owner;
    private JRadioButton isPublic;
    private JRadioButton isnotPublic;
    public CreateNewPIMEntityPanel(CardLayout cardLayout,Panel panel,StringBuffer owner){
        this.cardLayout = cardLayout;
        this.fatherPanel = panel;
        this.owner = owner;
//        System.out.println("owner: " + owner);

        returnButton = new JButton("返回");
        JPanel returnPanel = new JPanel();
        returnPanel.setLayout(new GridLayout(1,6));
        for (int i = 0;i < 5;i++) returnPanel.add(new JLabel());
        returnPanel.add(returnButton);
        add(returnPanel);

        setLayout(new FlowLayout());
        String[] types = {"Note","Todo","Contact","Appointment"};
        typeBox = new JComboBox(types);
        JLabel jLabel = new JLabel("Type: ");
        jLabel.setBounds(0,0,10,5);
        jLabel.setForeground(Color.RED);
        typeBox.setMaximumRowCount(2);

//        typeBox.addActionListener(this);
        typeBox.setLightWeightPopupEnabled(false);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.add(jLabel);
        jPanel.add(typeBox);
        typeBox.addActionListener(this);
        add(jPanel);

        JPanel emptyPanel = new JPanel();
        emptyPanel.setLayout(new GridLayout(1,1));
        emptyPanel.add(new Label("                                            "));
        add(emptyPanel);

        subFatherPanel  = new Panel();
        localCardLayout = new CardLayout();
        subFatherPanel.setLayout(localCardLayout);

        Panel upPanel = new Panel();
        Panel p1 = new Panel();
        Panel p2 = new Panel();
        Panel p3 = new Panel();
        Panel p4 = new Panel();


        JLabel jLabel1 = new JLabel("Owner:");
        ownerTextField = new JTextField();
        ownerTextField.setColumns(19);
        Panel ownerPanel = new Panel();
        ownerPanel.setLayout(new GridLayout(1,2));
        ownerPanel.add(jLabel1);
        ownerPanel.add(ownerTextField);

        upPanel.setLayout(new GridLayout(3,1,0,0));
        upPanel.add(ownerPanel);
        JLabel jLabel2 = new JLabel("Priority:");
        priorityTextField = new JTextField();
        priorityTextField.setColumns(18);
        Panel priorityPanel = new Panel();
        priorityPanel.setLayout(new GridLayout(1,2));
        priorityPanel.add(jLabel2);
        priorityPanel.add(priorityTextField);
        upPanel.add(priorityPanel);
        JLabel jLabel3 = new JLabel("WhetherPublic:");
        isPublic = new JRadioButton("是");
        isnotPublic = new JRadioButton("否");
        whetherPublic = new ButtonGroup();
        whetherPublic.add(isPublic);
        whetherPublic.add(isnotPublic);
        JPanel whetherPublicPanel = new JPanel();
        isPublic.setSelected(true);
        whetherPublicPanel.setLayout(new GridLayout(1,4));
        whetherPublicPanel.add(jLabel3);
        whetherPublicPanel.add(new JLabel());
        whetherPublicPanel.add(isPublic);
        whetherPublicPanel.add(isnotPublic);
        upPanel.add(whetherPublicPanel);
        add(upPanel);

        JLabel jLabel4 = new JLabel("Data:                       ");
        noteDataJTextField = new JTextField();
        noteDataJTextField.setColumns(20);
        JPanel notePanel = new JPanel();
        notePanel.setLayout(new GridLayout(1,2));
        notePanel.add(jLabel4);
        notePanel.add(noteDataJTextField);
        p1.add(notePanel);
        subFatherPanel.add(p1);

        add(subFatherPanel);

        JLabel jLabel5 = new JLabel("Date:                       ");
        todoDateJTextField = new JTextField();
        todoDateJTextField.setColumns(20);
        JPanel todoPanel = new JPanel();
        todoPanel.setLayout(new GridLayout(2,1));
        todoPanel.add(jLabel5);
        todoPanel.add(todoDateJTextField);
        JLabel jLabel6 = new JLabel("Data:                       ");
        todoDataJTextField = new JTextField();
        todoDataJTextField.setColumns(20);
        todoPanel.add(jLabel6);
        todoPanel.add(todoDataJTextField);
        p2.add(todoPanel);
        subFatherPanel.add(p2);

        JLabel jLabel7 = new JLabel("FirstName:                  ");
        contactFirstNameJTextField = new JTextField();
        contactFirstNameJTextField.setColumns(20);
        JLabel jLabel8 = new JLabel("LastName:                   ");
        contactLastNameJTextField = new JTextField();
        contactLastNameJTextField.setColumns(20);
        JLabel jLabel9 = new JLabel("EmailAddress:               ");
        contactEmailAddressJTextField = new JTextField();
        contactEmailAddressJTextField.setColumns(20);
        JPanel contactPanel = new JPanel();
        contactPanel.setLayout(new GridLayout(3,2));
        contactPanel.add(jLabel7);
        contactPanel.add(contactFirstNameJTextField);
        contactPanel.add(jLabel8);
        contactPanel.add(contactLastNameJTextField);
        contactPanel.add(jLabel9);
        contactPanel.add(contactEmailAddressJTextField);
        p3.add(contactPanel);
        subFatherPanel.add(p3);

        JLabel jLabel10 = new JLabel("Date:                       ");
        appointmentDateJTextField = new JTextField();
        appointmentDateJTextField.setColumns(20);
        JLabel jLabel11 = new JLabel("Description:                ");
        appointmentDescriptionJTextField = new JTextField();
        appointmentDescriptionJTextField.setColumns(20);
        JPanel appointmentPanel = new JPanel();
        appointmentPanel.setLayout(new GridLayout(2,2));
        appointmentPanel.add(jLabel10);
        appointmentPanel.add(appointmentDateJTextField);
        appointmentPanel.add(jLabel11);
        appointmentPanel.add(appointmentDescriptionJTextField);
        p4.add(appointmentPanel);
        subFatherPanel.add(p4);


        JPanel downPanel = new JPanel();
        downPanel.setLayout(new GridLayout(1,2,90,0));
        saveButton = new JButton("save");
        clearButton = new JButton("clear");
        downPanel.add(saveButton);
        downPanel.add(clearButton);
        add(downPanel);
        returnButton.addActionListener(this);
        saveButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == typeBox){
            JComboBox types = (JComboBox) e.getSource();
            int type = types.getSelectedIndex();
            localCardLayout.first(subFatherPanel);
            for (int i = 0;i < type;i++)
                localCardLayout.next(subFatherPanel);
            clear();
        }else if (e.getSource() == returnButton){//返回日历层
            cardLayout.previous(fatherPanel);
        }else if (e.getSource() == saveButton){
            PIMEntity pimEntity = null;
            String[] types = {"Note","Todo","Contact","Appointment"};
            int typeIndex = typeBox.getSelectedIndex();
            String type = types[typeIndex];
            StringBuffer data = new StringBuffer();
            data.append("owner:" +  owner);
            data.append("##" + "whetherPublic:");
            if (isPublic.isSelected()){
                data.append("true");
            }else data.append("false");
            data.append("##" + "priority:" + priorityTextField.getText());
            switch (typeIndex){
                case 0:
                    data.append("##data:" + noteDataJTextField.getText());
                    pimEntity = new PIMNote();
                    pimEntity.fromString(String.valueOf(data));
                    break;
                case 1:
                    data.append("##date:" + todoDateJTextField.getText());
                    data.append("##data:" + todoDataJTextField.getText());
                    pimEntity = new PIMTodo();
                    pimEntity.fromString(String.valueOf(data));
                    break;
                case 2:
                    data.append("##firstName:" + contactFirstNameJTextField.getText());
                    data.append("##lastName:" + contactLastNameJTextField.getText());
                    data.append("##emailAddress:" + contactEmailAddressJTextField.getText());
                    pimEntity = new PIMContact();
                    pimEntity.fromString(String.valueOf(data));
                    break;
                case 3:
                    data.append("##date:" + appointmentDateJTextField.getText());
                    data.append("##description:" + appointmentDescriptionJTextField.getText());
                    pimEntity = new PIMAppointment();
                    pimEntity.fromString(String.valueOf(data));
                    break;
            }
            new PIMSave(pimEntity).save();
            clear();
        }else if (e.getSource() == clearButton){
            clear();
        }
    }

    public void clear(){
        noteDataJTextField.setText("");
        todoDataJTextField.setText("");
        todoDateJTextField.setText("");
        contactFirstNameJTextField.setText("");
        contactLastNameJTextField.setText("");
        contactEmailAddressJTextField.setText("");
        appointmentDateJTextField.setText("");
        appointmentDescriptionJTextField.setText("");
    }

    public void initThis(){
        ownerTextField.setText(String.valueOf(owner));
        ownerTextField.setEditable(false);
    }
}
