package datastructure.StackAndQueue;

public class LinkStack implements MyStack {
    private Node top;

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int length() {
        Node p = top;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }

    @Override
    public Object peek() {
        if(isEmpty()) return null;
        else return top.node;
    }

    @Override
    public void push(Object o) throws Exception {
        Node newNode = new Node(o);
        newNode.next = top;
        top = newNode;
    }

    @Override
    public Object pop() {
        if(isEmpty()) return null;
        Node temp = top;
        top = top.next;
        return temp.node;
    }

    @Override
    public void display() {

    }
}

class Node{
    public Object node;
    public Node next;

    Node(Object o, Node next){
        node = o;
        this.next = next;
    }

    Node(Object o){
        this(o, null);
    }

    Node(){
        this(null, null);
    }
}
