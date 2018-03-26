package hw.first;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-25
 * Description:
 * <p>
 * -----------------------
 */
public class Student {
    private String name;//姓名
    private int no;//学号
    private Queue courseQueue = new LinkedBlockingQueue();
    private int courseNum;
    public Student(){
        courseNum = 0;
    }
    public Student(int no){
        this.no = no;
        courseNum = 0;
    }
    public Student(int no,String name){
        this.name = name;
        this.no = no;
        courseNum = 0;
    }
    public Student(int no,String name,Queue queue){
        this.name = name;
        this.no = no;
        this.courseQueue = queue;
        courseNum = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Queue getCourseQueue() {
        return courseQueue;
    }

    public void addCourse(Course course){
        courseQueue.add(course);
        courseNum++;
    }

    public int getCourseNum() {
        return courseNum;
    }
}
