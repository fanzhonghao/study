package hw.second.part1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-31
 * Description:
 * <p>
 * -----------------------
 */
public class PIMAppointment extends PIMEntity {
    private Date date;
    private String description;
    @Override
    public void fromString(String s){
        String[] array = s.split("##");
        int size = array.length;
        for (int i = 0;i < size;i++){
            if (array[i].matches("^date.*")){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String a = array[i].substring(5);
                try {
                    date = simpleDateFormat.parse(a);
                } catch (ParseException e) {
                    date = new Date(a);
                }
            }else if (array[i].matches("^description.*")){
                String a = array[i].substring(12);
                setDescription(a);
            }else if (array[i].matches("^priority.*")){
                setPriority(array[i].substring(9));
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Type appointment");
        s.append("##priority:" + getPriority());
        s.append("##date:" + getDate());
        s.append("##description:" + getDescription());
        return String.valueOf(s);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
