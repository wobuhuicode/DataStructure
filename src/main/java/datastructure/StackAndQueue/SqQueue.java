package datastructure.StackAndQueue;

public class SqQueue implements MyQueue {
    private Object[] queueElem;
    private int front;
    private int rear;
    private int maxSize;

    public SqQueue(int maxSize){
        this.maxSize = maxSize;
        front = rear = 0;
        queueElem = new Object[maxSize];
    }

    @Override
    public void clear() {
        front = rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    @Override
    public int length() {
        return rear - front;
    }

    @Override
    public Object peek() {
        return queueElem[front];
    }

    @Override
    public void offer(Object o) throws Exception {
        if(rear == maxSize) throw new Exception("queue overflow");
        queueElem[rear++] = o;
    }

    @Override
    public Object poll() {
        if(rear == front) return null;
        Object o = queueElem[front];
        front++;
        return o;
    }

    @Override
    public void display() {

    }
}
