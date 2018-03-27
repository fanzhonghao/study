package Test;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-27
 * Description:
 * <p>'x'的int值是120.
 * 第一个输出因为i是int型变
 * 量，char型x自动转换为int
 * 型。
 * 第二个输出，当后两个表达
 * 式有一个是常量表达式时，
 * 另一个是T，如果常量表达式
 * 可以被T表示，输出结果为T类
 * 型。
 * -----------------------
 */
public class TypeTransform {
    public static void main(String[] args) {
        char x = 'x';
        int i = 10;
        System.out.println(false ? i : x);
        System.out.println(false ? 10 : x);
    }
}
