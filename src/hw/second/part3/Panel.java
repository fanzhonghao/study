package hw.second.part3;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-23
 * Description:
 * <p>
 * -----------------------
 */
public class Panel extends JFrame{
    private DataButton[] dataButton;
    private JComboBox yearBox;
    private JComboBox monthBox;
    private Color numButtonForegroudColor;
    private Color numButtonBackgroudColor;
    private Color weekDayNumButtonForegroundColor;
    public Panel(){
        setBounds(500,200,400,280);
        setTitle("Calendar");
        numButtonBackgroudColor = Color.WHITE;
        numButtonForegroudColor = Color.BLACK;
        weekDayNumButtonForegroundColor = Color.GRAY;
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
        //
        JPanel north = new JPanel();
        JPanel bottom = new JPanel();
        north.setLayout(new GridLayout(1,5,5,30));
        north.add(jLabel1);
        north.add(yearBox);
        north.add(jLabels[0]);
        north.add(monthBox);
        north.add(jLabels[1]);
        north.setSize(400,20);
        add(north);

        JTextField jTextField = new JTextField();
        jTextField.setHorizontalAlignment(JTextField.CENTER);
        jTextField.setFont(new Font("TimesRoman",Font.BOLD,20));
        String[] weekDays = { "  Sun", "  Mon", "  Tue", "  Wed",  "  Thu", "  Fri" ,"  Sat" };

        JLabel[] jLabel = new JLabel[7];
        for (int i = 0;i < 7;i++)
            jLabel[i] = new JLabel(weekDays[i]);

        dataButton = new DataButton[37];
        bottom.setLayout(new GridLayout(7,7,6,3));
        for (int i = 0;i < 7;i++) bottom.add(jLabel[i]);

        for (int i = 0;i < 37;i++){
            dataButton[i] = new DataButton(0);
        }

        for (int i = 0;i < 37;i++)
        {
            dataButton[i].setBackground(numButtonBackgroudColor);
            if (i % 7 == 0 || i % 7 == 6)
            {
                dataButton[i].setForeground(weekDayNumButtonForegroundColor);
            }else dataButton[i].setForeground(numButtonForegroudColor);
        }

        Date date = new Date();
        int year = date.getYear() + 1900;
        int mon = date.getMonth() + 1;
        int day = date.getDate();
//        System.out.println("day: " + day);

        System.out.println(date);
        int dayNum;
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (mon == 2){
            dayNum = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
        }else dayNum = days[mon-1];
        Date date1 = new Date(year-1900,mon-1,1);
        String weekDay = date1.toString().substring(0,3);
        new SetButtonNum(weekDay,dayNum,day).setNum(dataButton);
        yearBox.setSelectedIndex(2069 - year);
        monthBox.setSelectedIndex(mon-1);
        for (int i = 0;i < 37;i++)
            bottom.add(dataButton[i]);
        add(bottom);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(Color.GRAY);

//        setBounds(500,200,400,280);在此设置时，会导致UI不能出现
        setResizable(false);

        yearBox.addActionListener(new BoxActionListener(monthBox,dataButton,year,mon,day));
        monthBox.addActionListener(new BoxActionListener(yearBox,dataButton,year,mon,day));
    }


    public static void main(String[] args) {
        new Panel();
    }
}
