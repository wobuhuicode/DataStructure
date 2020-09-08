package datastructure.linearList;

public class SqList implements MyList{
    Object[] listItems;
    int curLen;
    int maxSize;

    public SqList() {
        this.listItems = new Object[20];
        this.curLen = 0;
        this.maxSize = 10;
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
    public Object get(int i) {
        return listItems[i];
    }

    @Override
    public void insert(int i, Object t) throws Exception {
        if(curLen == maxSize) throw new Exception("顺序表满");
        if(i < 0 || i > curLen) throw new Exception("插入位置非法");
        for(int k = curLen; k > i; k--)
            listItems[k] = listItems[k - 1];
        curLen ++;
        listItems[i] = t;
    }

    @Override
    public Object remove(int i) throws Exception {
        if(i < 0 || i >= curLen) throw new Exception("删除位置非法");
        Object res = listItems[i];
        for(int k = i; k < curLen - 1; k++)
            listItems[i] = listItems[i+1];
        curLen--;
        if((float)curLen/listItems.length < 0.4){
            Object[] objects = new Object[listItems.length/2];
            for(int k = 0; k < curLen; k++) objects[k] = listItems[k];
            this.listItems = objects;
        }
        return res;
    }

    @Override
    public int indexOf(Object t) {
        for (int k = 0; k < curLen; k++){
            if(listItems[k].equals(t)) return k;
        }
        return -1;
    }

    @Override
    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < curLen; k++)
            stringBuilder.append(listItems[k].toString());
        return stringBuilder.toString();
    }


}


