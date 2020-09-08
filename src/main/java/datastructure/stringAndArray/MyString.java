package datastructure.stringAndArray;

public interface MyString 
{
    void clear();
    boolean isEmpty();
    int length();
    char charAt(int i) throws Exception;
    MyString subString(int begin, int end);
    MyString insert(int i, MyString str) throws Exception;
    MyString delete(int begin, int end);
    MyString concat(MyString myString);   
}
