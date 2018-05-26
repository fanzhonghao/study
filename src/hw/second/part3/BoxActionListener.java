package hw.second.part3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class BoxActionListener implements ActionListener {
    private JComboBox yearBox;
    private JComboBox monthBox;
    private DataButton[] dataButtons;
    private int currentYear,currentMonth,currentDay;
    public BoxActionListener(JComboBox box,DataButton[] dataButtons,int currentYear,int currentMonth,int currentDay){
        this.yearBox = box;
        this.monthBox = box;
        this.dataButtons = dataButtons;
        this.currentMonth = currentMonth;
        this.currentYear = currentYear;
        this.currentDay = currentDay;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox box = (JComboBox) e.getSource();
        if (box.getItemCount() == 12){//月下拉列表事件
            monthBox = box;
        }else yearBox = box;
        int yearIndex = yearBox.getSelectedIndex();
        int year = Integer.parseInt((String) yearBox.getItemAt(yearIndex));
        int monthIndex = monthBox.getSelectedIndex();
        int month = Integer.parseInt((String) monthBox.getItemAt(monthIndex));
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int dayNum = 0;
        if (month == 2){
            dayNum = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
        }else dayNum = days[month-1];
        Date d = new Date(year - 1900,month - 1,1);
        String weekDay = d.toString().substring(0,3);
        int day;
        if (!(year == currentYear && month == currentMonth)) {
            day = 0;
        }else day = currentDay;
        new SetButtonNum(weekDay,dayNum,day).setNum(dataButtons);
    }
}
