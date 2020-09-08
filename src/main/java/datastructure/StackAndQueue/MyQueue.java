package datastructure.StackAndQueue;

public interface MyQueue {
    void clear();
    boolean isEmpty();
    int length();
    Object peek();
    void offer(Object o) throws Exception;
    Object poll();
    void display();
}
