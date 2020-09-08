package datastructure.linearList;

public interface MyList {
    void clear();
    boolean isEmpty();
    int length();
    Object get(int i) throws Exception;
    void insert(int i, Object t) throws Exception;
    Object remove(int i) throws Exception;
    int indexOf(Object t);
    String display();
}
