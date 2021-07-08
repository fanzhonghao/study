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
public abstract class PIMEntity {
    private String owner;
    private String priority;
    private boolean whetherPublic;
    public void setOwner(String name){
        this.owner = name;
    }
    public void setWhetherPublic(boolean setPublic){
        this.whetherPublic = setPublic;
    }
    public void setPriority(String priority){
        this.priority = priority;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isWhetherPublic() {
        return whetherPublic;
    }

    public String getPriority() {
        return priority;
    }

    abstract public void fromString(String s);
    abstract public String toString();
}
