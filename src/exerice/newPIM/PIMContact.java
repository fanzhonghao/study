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
public class PIMContact extends PIMEntity{
    private String firstName;
    private String lastName;
    private String emailAddress;

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
            }else if (dataArray[i].matches("^firstName.*")){
                setFirstName(dataArray[i].substring(10));
            }else if (dataArray[i].matches("^lastName.*")){
                setLastName(dataArray[i].substring(9));
            }else if (dataArray[i].matches("^emailAddress.*")){
                setEmailAddress(dataArray[i].substring(13));
            }
        }
    }

    @Override
    public String toString() {
        return "owner:"+ getOwner() + "##" + "whetherPublic:" + isWhetherPublic() + "##" + "priority:" + getPriority() +
                "##" + "firstName:" + getFirstName() + "##" + "lastName:" + getLastName() + "##" + "emailAddress:" +
                getEmailAddress();
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
}
