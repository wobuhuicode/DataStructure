package datastructure.StackAndQueue;

public class SqStack implements MyStack {
    private Object[] stackElem;
    private int top;
    private int maxSize;

    public SqStack(int maxSize){
        top = 0;
        this.maxSize = maxSize;
        stackElem = new Object[maxSize];
    }

    @Override
    public void clear() {
        top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int length() {
        return top;
    }

    @Override
    public Object peek() {
        if(!isEmpty()){
            return stackElem[top - 1];
        }else
            return null;
    }

    @Override
    public void push(Object o) throws Exception {
        if(top == maxSize) throw new Exception("stack overflow");
        stackElem[top] = o;
        top++;
    }

    @Override
    public Object pop() {
        if(isEmpty()) return null;
        return stackElem[--top];
    }

    @Override
    public void display() {

    }


}


