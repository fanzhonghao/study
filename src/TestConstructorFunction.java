import java.util.Random;

/* *
 * -----------------------
 *
 * @Author:fan
 * @Date: 18-3-6
 * Description:
 *  测试构造函数是否为原子操作
 *  看不出不是原子操作
 * ------------------------
 */
public class TestConstructorFunction {
    private String name1;
    private String name2;
    public TestConstructorFunction(String name1,String name2){
        this.name1 = name1;
        try {
            Thread.sleep(new Random(10).nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.name2 = name2;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public static void main(String[] args) {
        TestConstructorFunction p1 = new TestConstructorFunction("Alice","Alice");
        TestConstructorFunction p2 = new TestConstructorFunction("Blender","Blender");
        while (true){
            new printName(p1,p2).start();
        }

    }
}
class printName extends Thread{
    private TestConstructorFunction p1;
    private TestConstructorFunction p2;
    public printName(TestConstructorFunction p1,TestConstructorFunction p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void run() {
        if (!p1.getName1().equals(p1.getName2())) {
            System.out.println("name1 = " + p1.getName1() + " name2 = " + p1.getName2());
        }
        if (!p2.getName1().equals(p2.getName2())){
            System.out.println("name1 = " + p2.getName1() + " name2 = " + p2.getName2());
        }
    }
}