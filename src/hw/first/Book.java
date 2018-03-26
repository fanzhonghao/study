package hw.first;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-25
 * Description:
 * <p>记载书的类型
 * -----------------------
 */
public class Book {
    private String name;
    public Book(){

    }
    public Book(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
