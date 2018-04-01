package hw.second.part3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-4-1
 * Description:
 * <p>
 * -----------------------
 */
public class Cal {
    public static void main(String[] args) throws ParseException {
        int mon = 0;
        int year = 0;
        int days = 0;
        final String[]  MONTHS = {
                "Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"
        };
        final String[] DAYS = {
                "Sun","Mon","Tue","Wed","Thu","Fri","Sat"
        };

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String t = String.valueOf(calendar.getTime());

//        System.out.println(t);

        String[] time = t.split(" ");
        for (int i = 0;i < 12;i++){
            if (time[1].equalsIgnoreCase(MONTHS[i])){
                mon = i+1;
                break;
            }
        }
        year = Integer.parseInt(time[5]);

        if (args.length == 2){
            try {
                int m = Integer.parseInt(args[0]);
                if (m > 0 && m < 13) mon = m;
                int y = Integer.parseInt(args[1]);
                if (y > 1970) year = y;
            }catch (NumberFormatException e){

            }
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String mon1;

        if (mon < 10){
            mon1 = "0" + mon;
        }else mon1 = String.valueOf(mon);
        t = String.valueOf(simpleDateFormat.parse("01/" + mon1 + "/" + year));
        String weekDay = t.substring(0,3);
        switch (mon){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: days = 31;break;
            case 4: case 6: case 9: case 11: days = 30;break;
            case 2: days = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? 29 : 28;
        }
        System.out.println("             " + MONTHS[mon-1] + "    " + year);
        for (int i = 0;i < 7;i++)
            System.out.print(DAYS[i] + "   ");
        System.out.println();
        int flag = 0;
        for (int i = 0;i < 7;i++){
            if (DAYS[i].equalsIgnoreCase(weekDay))
                flag = i;
        }
        for (int i = 0;i < flag;i++){
            System.out.print("      ");
        }
        for (int i = 1;i <= days;i++){
            if (i < 10) System.out.print(" " + i + "    ");
            else System.out.print(i + "    ");
            if ((i + flag) %7 == 0) System.out.println();
        }
    }
}

