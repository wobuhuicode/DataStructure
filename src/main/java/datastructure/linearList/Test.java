package datastructure.linearList;

public class Test {
    public static void main(String[] args){
        SqList sqList = new SqList();
        LinkList linkList = new LinkList();
        try {
            sqList.insert(0, 1);
            sqList.insert(1, 2);
            sqList.insert(2, 3);
            sqList.insert(3, 4);
            sqList.insert(4, 5);
            sqList.insert(5, 6);
            sqList.insert(5, 6);
            System.out.println(sqList.display());
            sqList.remove(3);
            System.out.println(sqList.display());
            System.out.println(sqList.indexOf(6));
            System.out.println(sqList.get(6));

//            linkList.headInsertCreate(6);
//            System.out.println(linkList.display());
//            linkList.clear();
//            linkList.tailInsertCreate(6);
//            System.out.println(linkList.display());
//            linkList.remove(4);
//            System.out.println(linkList.display());
            linkList.josephus();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
