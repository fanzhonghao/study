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
public class PIMNote extends PIMEntity{
    private String data;

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
            }else if (dataArray[i].matches("^data.*")){
                setData(dataArray[i].substring(5));
            }
        }
    }

    @Override
    public String toString() {
        return "owner:"+ getOwner() + "##" + "whetherPublic:" + isWhetherPublic() + "##" + "priority:" + getPriority() +
                "##" + "data:" + getData();
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
