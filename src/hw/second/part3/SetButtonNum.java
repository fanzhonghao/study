package hw.second.part3;


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
public class SetButtonNum {
    private String weekDay;//记录一号是星期几
    private int dayNum;//记录当前月的天数
    private int currentDay;
    private static int upDay;
    public SetButtonNum(String weekDay,int dayNum,int currentDay){
        this.weekDay = weekDay;
        this.dayNum = dayNum;
        this.currentDay = currentDay;
    }
    public void setNum(DataButton[] buttons){//设置button
        int zeroNum = 0;
        switch (weekDay){
            case "Sun": break;
            case "Mon": zeroNum = 1;break;
            case "Tue": zeroNum = 2;break;
            case "Wed": zeroNum = 3;break;
            case "Thu": zeroNum = 4;break;
            case "Fri": zeroNum = 5;break;
            case "Sat": zeroNum = 6;break;
        }
        for (int i = 0;i < 37;i++)
            buttons[i].setNum(0);

        for (int i = 0;i < dayNum;i++){
            buttons[i+zeroNum].setNum(i+1);
        }
        if (currentDay != 0){
            buttons[zeroNum+currentDay-1].setForeground(Color.RED);
            upDay = currentDay + zeroNum - 1;
            currentDay = 0;
        }else if (upDay != 0){
            if (upDay % 7 == 0 || upDay % 7 == 6) buttons[upDay].setForeground(Color.GRAY);
            else buttons[upDay].setForeground(Color.BLACK);
            upDay = 0;
        }
    }
}








