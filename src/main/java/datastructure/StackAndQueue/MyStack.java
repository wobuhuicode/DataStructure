package datastructure.StackAndQueue;

public interface MyStack {
    void clear();
    boolean isEmpty();
    int length();
    Object peek();
    void push(Object o) throws Exception;
    Object pop();
    void display();
}
