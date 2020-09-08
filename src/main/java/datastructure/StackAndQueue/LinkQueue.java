package datastructure.StackAndQueue;

public class LinkQueue implements MyQueue {
    private Node front;
    private Node rear;

    public LinkQueue(){
        front = rear = null;
    }

    @Override
    public void clear() {
        front = rear = null;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int length() {
        Node p = front;
        int length = 0;
        for(; p != null; length++){
            p = p.next;
        }
        return length;
    }

    @Override
    public Object peek() {
        if(isEmpty()) return null;
        return front.node;
    }

    @Override
    public void offer(Object o) throws Exception {
        Node newNode = new Node(o);
        if(isEmpty()){
            front = rear = newNode;
        }else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    @Override
    public Object poll() {
        if(isEmpty()) return null;
        Object temp = front.node;
        front = front.next;
        return temp;
    }

    @Override
    public void display() {

    }
}
