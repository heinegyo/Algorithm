package phase1.week3.array;

import phase1.week2.selectionSort.Student;

public class Main {
    public static void main(String[] args) {
            Array<Integer> arr = new Array<Integer>();
            for (Integer i = 0; i < 10; i++) {
                arr.addLast(i);
            }
            System.out.println(arr);

            arr.add(1, 100);
            System.out.println(arr);

            arr.addFirst(-1);
            System.out.println(arr);

            arr.remove(2);
            System.out.println(arr);

            arr.removeElement(4);
            System.out.println(arr);

            arr.removeFirst();
            System.out.println(arr);

    }
}
