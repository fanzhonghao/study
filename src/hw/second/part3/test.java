package hw.second.part3;

import exerice.calPanel.DataButton;

import javax.swing.*;
import java.awt.*;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-23
 * Description:
 * <p>
 * -----------------------
 */
public class test extends JFrame{
    private DataButton[] dataButton;
    private JComboBox yearBox;
    private JComboBox monthBox;
    private Color numButtonForegroudColor;
    private Color numButtonBackgroudColor;
    private Color weekDayNumButtonForegroundColor;
    public test(){
        setBounds(500,200,400,280);
        setTitle("Calendar");
        numButtonBackgroudColor = Color.WHITE;
        numButtonForegroudColor = Color.BLACK;
        weekDayNumButtonForegroundColor = Color.RED;
        setLayout(new FlowLayout());
        String[] years = new String[100];//1970 - 2020
        for (int i = 0;i < 100;i++)
            years[i] = "" + (2069-i);
        yearBox = new JComboBox(years);
        String[] month = new String[12];
        for (int i = 0;i < 12;i++)
            month[i] = "" + (i+1);
        monthBox = new JComboBox(month);
        JLabel[] jLabels = new JLabel[2];
        jLabels[0] = new JLabel("年");
        jLabels[1] = new JLabel("月");
        JLabel jLabel1 = new JLabel("  ");
        JPanel north = new JPanel();
        north.setLayout(new GridLayout(1,5,5,30));
        north.add(jLabel1);
        north.add(yearBox);
        north.add(jLabels[0]);
        north.add(monthBox);
        north.add(jLabels[1]);
        north.setSize(400,20);
        add(north);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(Color.GRAY);
//        setSize(400,280);
//        setBounds(500,200,400,280);
        setResizable(false);
    }


    public static void main(String[] args) {
        test t = new test();
//        t.setResizable(false);
    }
}
