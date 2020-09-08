package datastructure.StackAndQueue;

public class CircleSqQueue implements MyQueue {
    private Object[] queueElem;
    private int front;
    private int rear;
    private int maxSize;

    public CircleSqQueue(int maxSize){
        front = rear = 0;
        queueElem = new Object[maxSize];
        this.maxSize = maxSize;
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
        return (rear - front + maxSize)%maxSize;
    }

    @Override
    public Object peek() {
        if(isEmpty()) return null;
        else return queueElem[front];
    }

    @Override
    public void offer(Object o) throws Exception {
        if(rear + 1 % maxSize == rear) throw new Exception("queue overflow");
        else {
            queueElem[rear] = o;
            rear = (rear + 1) % maxSize;
        }
    }

    @Override
    public Object poll() {
        if(isEmpty()) return null;
        else {
            Object temp = queueElem[front];
            front = (front + 1) % maxSize;
            return temp;
        }
    }

    @Override
    public void display() {
        if(!isEmpty()){
            for (int i = front; i < length() + front; i++){
                System.out.println(queueElem[i%maxSize] + " ");
            }
        }
    }
}
