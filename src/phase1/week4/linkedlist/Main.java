package phase1.week4.linkedlist;

import phase1.week3.stack.ArrayStack;
import phase1.week3.stack.Stack;

import java.util.Random;

/**
 * ArrayStack vs LinkedListStack
 */
public class Main {

    //測使用stack執行opCount個push和pop操作所需要的時間，單位：秒
    private static double testStack(Stack<Integer> q, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            q.push(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            q.pop();


        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 10000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");
        //其實這個時間比較很複雜，因為LinkedListStack中包含更多的new
    }

}
