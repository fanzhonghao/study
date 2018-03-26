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
public class Course {
    private String name;
    private Queue queue;//记录书
    private int numOfBooks;
    public Course(){}
    public Course(String name){
        this.name = name;
        numOfBooks = 0;
        queue = new LinkedBlockingQueue();
    }

    public void addBook(Book book){
        queue.add(book);
        numOfBooks++;
    }
    public void delete(String name){//删除某本书
        Queue queue1 = new LinkedBlockingQueue();
        Book book;
        int size = queue.size();
        int i;
        for (i = 0;i < size;i++){
            book = (Book) queue.peek();
            if (book.getName() != name)
                queue1.add(book);
        }
        queue.addAll(queue1);
        if (i == size)
            System.out.println("没有该书");
        else System.out.println("该书已删除");
    }
    public Queue getAllBook(){
        return queue;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
