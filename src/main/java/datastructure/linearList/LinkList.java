package datastructure.linearList;

import java.util.Scanner;

public class LinkList implements MyList{
    Node head;

    public LinkList(){
        head = null;
    }

    public LinkList(int n, boolean order) throws Exception {
        this();
        if(order) headInsertCreate(n);
        else tailInsertCreate(n);
    }

    void headInsertCreate(int n) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter numbers: ");
        for(int i = 0; i < n; i++)
            this.insert(0, scanner.nextInt());
        scanner.close();
    }

    void tailInsertCreate(int n) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter numbers: ");
        for(int i = 0; i < n; i++)
            this.insert(i, scanner.nextInt());
        scanner.close();
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int length() {
        int curLen = 0;
        Node p = head;
        for(; p != null; p = p.next)
            curLen++;
        return curLen;
    }

    @Override
    public Object get(int i) throws Exception {
        if(i < 0) throw new Exception("illegal parameter i");
        Node p = head;
        for(int k = 0; k < i - 1; k++)
        {
            p = p.next;
            if(p == null) throw new Exception("illegal parameter i");
        }
        return p.node;
    }

    @Override
    public void insert(int i, Object t) throws Exception {
        Node p = head;
        if(i < 0) throw new Exception("插入位置非法");
        if(head == null) {
            head = new Node(t);
            return;
        }
        int b = 1;
        for(; b < i ; b++) {
            if(p == null) throw new Exception("插入位置非法");
            p = p.next;
        }
        Node newNode = new Node(t);
        if(i == 0){
            newNode.next = head;
            head = newNode;
        }else{
            newNode.next = p.next;
            p.next = newNode;
        }
    }

    @Override
    public Object remove(int i) throws Exception {
        if(i < 0) throw new Exception("illegal parameter i");
        if(i == 0) head = head.next;
        Node p = head;
        for(int k = 0; k < i - 1; k++)
        {
            p = p.next;
            if(p == null) throw new Exception("illegal parameter i");
        }
        Node temp = p.next;
        p.next = p.next.next;
        return temp.node;
    }

    @Override
    public int indexOf(Object t) {
        Node p = head;
        int k = 0;
        for(; p != null; p = p.next){
            if (p.node.equals(t)) return k;
            k++;
        }
        return -1;
    }

    @Override
    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        Node p = head;
        for (;p != null; p = p.next)
            stringBuilder.append(p.node);
        return stringBuilder.toString();
    }

    public void josephus(){
        head = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers: ");
        int m = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter count: ");
        int n = scanner.nextInt();
        scanner.close();
        head = new Node(1);
        head.next = head;
        Node p = head;
        for(int i = 0; i < m - 1; i++){
            Node newNode = new Node(i + 2);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode;
        }
        p = head;
        while(p.next != p){
            for(int i = 0; i < n - 2; i++)
                p = p.next;
            System.out.print(p.next.node + " ");
            p.next = p.next.next;
            p = p.next;
        }
        System.out.print(p.node + " ");
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

