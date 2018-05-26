package hw.second;

import hw.second.part3.DataButton;

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
        numButtonBackgroudColor = Color.WHITE;
        numButtonForegroudColor = Color.BLACK;
        weekDayNumButtonForegroundColor = Color.RED;
        setLayout(new FlowLayout());
        String[] years = new String[50];//1970 - 2020
        for (int i = 0;i < 50;i++)
            years[i] = "" + (2019-i);
        yearBox = new JComboBox(years);
        String[] month = new String[12];
        for (int i = 0;i < 12;i++)
            month[i] = "" + (i+1);
        monthBox = new JComboBox(month);
        JPanel north = new JPanel();
        JPanel bottom = new JPanel();
        north.setLayout(new GridLayout(1,2,30,30));
        north.add(yearBox,BorderLayout.WEST);
        north.add(monthBox,BorderLayout.EAST);
        north.setSize(400,20);
        add(north);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(Color.GRAY);
        setSize(500,300);
        setResizable(true);
    }


    public static void main(String[] args) {
        new test();
    }
}
