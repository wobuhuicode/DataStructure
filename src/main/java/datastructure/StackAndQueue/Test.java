package datastructure.StackAndQueue;

public class Test {
    public static void main(String[] args) throws Exception {
        CircleSqQueue circleSqQueue = new CircleSqQueue(6);
        circleSqQueue.offer(1);
        circleSqQueue.offer(2);
        circleSqQueue.offer(3);
        circleSqQueue.offer(4);
        circleSqQueue.offer(5);
        circleSqQueue.poll();
        circleSqQueue.poll();
        circleSqQueue.offer(6);
        circleSqQueue.offer(6);
        circleSqQueue.display();
        System.out.println(circleSqQueue.length());
        System.out.println(fibonacci(10));
        System.out.println(radixTransform(10, 8));
        System.out.println(bracketCheck("({([])})"));
        System.out.println(bracketCheck("({([})})"));

    }


    static String radixTransform(int number, int radix) throws Exception {
        StringBuilder res = new StringBuilder();
        LinkStack linkStack = new LinkStack();
        while(number / radix > 0){
            linkStack.push(number % radix);
            number /= radix;
        }
        if(number != 0) linkStack.push(number);
        while(!linkStack.isEmpty()){
            res.append(linkStack.pop());
        }
        return res.toString();
    }

    static boolean bracketCheck(String brackets) throws Exception {
        LinkStack linkStack = new LinkStack();
        for(int i = 0; i < brackets.length(); i++) {
            char curChar = brackets.charAt(i);
            if (curChar == '(' || curChar == '[' || curChar == '{') {
                linkStack.push(curChar);
            } else if (curChar == ')' || curChar == ']' || curChar == '}') {
                switch (curChar) {
                    case ')' -> {
                        if ('(' != (char) linkStack.pop()) return false;
                    }
                    case ']' -> {
                        if ('[' != (char) linkStack.pop()) return false;
                    }
                    case '}' -> {
                        if ('{' != (char) linkStack.pop()) return false;
                    }
                }
            }
        }
        return linkStack.isEmpty();
    }

    static int fibonacci(int n){
        if(n == 1) return 0;
        else if(n == 2) return 1;
        int[] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for(int i = 2; i < n; i++){
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[n - 1];
    }
}
