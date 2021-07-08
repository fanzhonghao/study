package hw.second.part1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-31
 * Description:
 * <p>
 * -----------------------
 */
public class PIMTodo extends PIMEntity {
    private Date date;
    private String data;

    @Override
    public void fromString(String s) {
        String[] array = s.split("##");
        int size = array.length;
        for (int i = 0;i < size;i++){
            if (array[i].matches("^date.*")){
                String a = array[i].substring(5);
                SimpleDateFormat d = new SimpleDateFormat("MM/dd/yyyy");
                try {
                    date = d.parse(a);
                } catch (ParseException e) {
                    date = new Date(a);
                }
            }else if (array[i].matches("^data.*")){
                setData(array[i].substring(5));
            }else if (array[i].matches("^priority.*")){
                setPriority(array[i].substring(9));
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Type todo");
        s.append("##priority:" + getPriority());
        s.append("##date:" + getDate());
        s.append("##data:" + getData());
        return String.valueOf(s);
    }

    public Date getDate() {
        return date;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDate(String date) {
        try {
            this.date = new SimpleDateFormat("MM/dd/yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
