package hw.first;

import hw.first.Book;
import hw.first.Course;

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
public class AllCourseBooks {
    private Queue queue;
    public AllCourseBooks(){
        queue = new LinkedBlockingQueue();
        setInfo();
    }
    private void setInfo(){
        Course course = new Course("Java");
        course.addBook(new Book("Thinking in Java"));
        course.addBook(new Book("Java 8"));
        queue.add(course);
        Course course1 = new Course("WebEngineering");
        course1.addBook(new Book("Web Engineering"));
        queue.add(course1);
    }

    public Queue getQueue() {
        return queue;
    }

}
