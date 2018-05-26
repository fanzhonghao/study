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
public class PIMContact extends PIMEntity {
    private String firstName;
    private String lastName;
    private String emailAddress;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void fromString(String s) {
        String[] array = s.split("##");
        int size = array.length;
        for (int i = 0;i < size;i++){
            if (array[i].matches("^firstName.*")){
                setFirstName(array[i].substring(10));
            }else if (array[i].matches("^lastName.*")){
                setLastName(array[i].substring(9));
            }else if (array[i].matches("^emailAddress.*")){
                setEmailAddress(array[i].substring(13));
            }else if (array[i].matches("^priority.*"))
                setPriority(array[i].substring(9));
        }
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Type contact");
        s.append("##priority:" + getPriority());
        s.append("##firstName:" + getFirstName());
        s.append("##lastName:" + getLastName());
        s.append("##emailAddress:" + getEmailAddress());
        return String.valueOf(s);
    }
}
