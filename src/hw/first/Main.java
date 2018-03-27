package hw.first;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-25
 * Description:
 * <p>
 * -----------------------
 */
public class Main {
    public static void main(String[] args) {
        if (args.length < 1){
            System.out.println("缺少学生学号及课程名称");
            System.exit(-1);
        }else if (args.length < 2){
            System.out.println("缺少课程名称");
            System.exit(-1);
        }
        Student student = new Student(Integer.parseInt(args[0]));
        AllCourseBooks allCourseBooks = new AllCourseBooks();
        List list = new LinkedList(allCourseBooks.getQueue());

        int listSize = list.size();
        Course course;
        int argsLen = args.length;
        for (int i = 0;i < listSize;i++){
            course = (Course) list.get(i);
            for (int j = 1;j < argsLen;j++){
                if (args[j].equalsIgnoreCase(course.getName())){
                    student.addCourse(course);
                }
            }
        }
        System.out.print(student.getNo() + " select ");
        Queue queue = student.getCourseQueue();
        int queueSize = student.getCourseNum();
        Course course1;
        int bookNum;
        Queue bookQueue;
        Book book;
        for (int i = 0;i < queueSize;i++){
            course1 = (Course) queue.poll();
            System.out.print(course1.getName() + " with ");
            bookQueue = course1.getAllBook();
            bookNum = bookQueue.size();
            for (int j = 0;j < bookNum;j++){
                book = (Book) bookQueue.poll();
                System.out.print(book.getName());
                if (j < bookNum-1) System.out.print(" , ");
                else if (i < queueSize-1){
                    System.out.print("; and ");
                }
            }

        }
        System.out.println();
    }
}
