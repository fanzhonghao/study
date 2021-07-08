package exerice.calPanel.functionalPage;

import exerice.calPanel.DataButton;
import exerice.newPIM.PIMCollection;

import java.awt.*;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-28
 * Description:
 * <p>
 * -----------------------
 */
public class SetButtonForegroundColor {
    private int month;
    private int year;
    private DataButton[] dataButtons;
    public SetButtonForegroundColor(final int year,final int month,DataButton[] dataButtons){
        this.dataButtons = dataButtons;
        this.month = month;
        this.year = year;

        String sMonth = "";
        String sYear = "";
        String sDay = "";
        if (month < 10) {
            sMonth = "0" + month;
        }else sMonth = sMonth + month;
        sYear = sYear + year;

        PIMCollection pimCollection = new PIMCollection();
        int num = 0;
        for (;dataButtons[num].getNum() == 0;num++);
        int oneBegin = num;
        for (;num < 37;num++){
            int day = dataButtons[num].getNum();
            if (day < 10){
                sDay = "0" + day;
            }else sDay = sDay + day;
            pimCollection.getItemsForDate(sMonth + "/" + sDay + "/" + sYear);

//            System.out.println("Date: " + sMonth + "/" + sDay + "/" + sYear);

            if (pimCollection.size() > 0) {
                if (dataButtons[num].getForeground() == Color.RED)
                {
                    dataButtons[num].setForeground(Color.PINK);
                }else dataButtons[num].setForeground(Color.BLUE);
            }else {//目标设置正常
                if (dataButtons[num].getForeground() == Color.BLUE || dataButtons[num].getForeground() == Color.PINK){
                    int x = (dataButtons[num].getNum() + oneBegin) % 7;
                    if (x  == 0 || x  == 1){
                        dataButtons[num].setForeground(Color.GRAY);
                    }else dataButtons[num].setForeground(Color.BLACK);
                }
            }
            sDay = "";
        }

    }
}
