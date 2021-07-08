package hw.second.part1;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-31
 * Description:
 * <p>
 * -----------------------
 */
public class PIMNote extends PIMEntity {
    private String data;
    @Override
    public void fromString(String s) {
        String[] array = s.split("##");
        int size = array.length;
        for (int i = 0;i < size;i++){
            if (array[i].matches("^priority.*")){
                setPriority(array[i].substring(9));
            }else if (array[i].matches("^data.*")){
                setData(array[i].substring(5));
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Type note");
        s.append("##priority:" + getPriority());
        s.append("##data:" + getData());
        return String.valueOf(s);
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
