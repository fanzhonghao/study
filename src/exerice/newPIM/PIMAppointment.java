package exerice.newPIM;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-26
 * Description:
 * <p>
 * -----------------------
 */
public class PIMAppointment extends PIMEntity{
    private String date;
    private String description;
    @Override
    public void fromString(String s) {
        String[] dataArray = s.split("##");
        int size = dataArray.length;
        for (int i = 0;i < size;i++){
            if (dataArray[i].matches("^owner.*")){
                setOwner(dataArray[i].substring(6));
            }else if (dataArray[i].matches("^whetherPublic.*")){
                boolean flag = dataArray[i].substring(14).equalsIgnoreCase("true");
                setWhetherPublic(flag);
            }else if (dataArray[i].matches("^priority.*")){
                setPriority(dataArray[i].substring(9));
            }else if (dataArray[i].matches("^date.*")){
                setDate(dataArray[i].substring(5));
            }else if (dataArray[i].matches("^description.*")){
                setDescription(dataArray[i].substring(12));
            }
        }
    }

    @Override
    public String toString() {
        return "owner:"+ getOwner() + "##" + "whetherPublic:" + isWhetherPublic() + "##" + "priority:" + getPriority() +
                "##" + "date:" + getDate() + "##" + "description:" + getDescription();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
