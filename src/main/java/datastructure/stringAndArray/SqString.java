package datastructure.stringAndArray;

public class SqString implements MyString {
    private char[] strValue;
    private int curLen;

    public SqString(String str) {
        char[] p = str.toCharArray();
        strValue = p;
        curLen = str.length();
    }

    public SqString(char[] str) {
        strValue = new char[str.length];
        for (int i = 0; i < str.length; i++)
            strValue[i] = str[i];
        curLen = strValue.length;
    }

    @Override
    public void clear() {
        curLen = 0;
    }

    @Override
    public boolean isEmpty() {
        return curLen == 0;
    }

    @Override
    public int length() {
        return curLen;
    }

    @Override
    public char charAt(int i) throws Exception {
        if (i < 0 || i >= curLen) {
            throw new StringIndexOutOfBoundsException(i);
        }
        return strValue[i];
    }

    public void allocate(int newCapacity) {
        char[] temp = strValue;
        strValue = new char[newCapacity];
        for (int i = 0; i < temp.length; i++) {
            strValue[i] = temp[i];
        }
    }

    @Override
    public MyString subString(int begin, int end) {
        if (begin < 0 || begin >= end || end > curLen)
            throw new StringIndexOutOfBoundsException("index out of bounds");
        char[] temp = new char[end - begin];
        for (int i = begin; i < end; i++) {
            temp[i - begin] = strValue[i];
        }
        return new SqString(temp);
    }

    @Override
    public MyString insert(int i, MyString str) throws Exception {
        if (i < 0 || i > curLen)
            throw new StringIndexOutOfBoundsException(i);
        int len = str.length();
        int newCapacity = len + curLen;
        allocate(newCapacity);
        for (int j = curLen - 1; j >= i; j--) {
            strValue[j + len] = strValue[j];
        }
        for (int j = i; j < i + len; j++) {
            strValue[i] = str.charAt(j - i);
        }
        return this;
    }

    @Override
    public MyString delete(int begin, int end) {
        if (begin < 0 || begin >= end || end > curLen)
            throw new StringIndexOutOfBoundsException("index out of bounds");
        for (int i = begin; i < end; i++) {
            strValue[i] = strValue[i + end - begin];
        }
        curLen = curLen - end + begin;
        return this;
    }

    @Override
    public MyString concat(MyString myString) {
        try {
            insert(curLen, myString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public int[] getNext() throws Exception {
        int[] next = new int[curLen + 1];
        next[0] = -1; next[1] = 0;
        int k = 0, j = 1;
        while(j < curLen){
            if(strValue[k] == strValue[j]) {
                next[j + 1] = next[j] + 1;
                j++; k++;
            }
            else if(k == 0) {
                next[j + 1] = 0;
                j++;
            }
            else k = next[k];
        }
        return next;
    }

    public int KMP(SqString p, int begin) throws Exception{
        int[] next = p.getNext();
        int j = 0;
        for(int i = begin; i < curLen;){
            if(j == -1 || strValue[i] == p.charAt(j)){
                i++; j++;
            }else{
                j = next[j];
            }
            if(j == p.length()){
                return i - p.length();
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        SqString sqString = new SqString("abcdabcefg");
        SqString p = new SqString("efg");
        int pp = sqString.KMP(p, 0);
        return;
    }
    
}