package phase1.week3.array;

import phase1.week2.selectionSort.Student;

public class Main {
    public static void main(String[] args) {

        Array<phase1.week2.selectionSort.Student> arr = new Array<>();
        arr.addLast(new Student("Alice",100));
        arr.addLast(new Student("Bob",66));
        arr.addLast(new Student("Charlie",88));

        System.out.println(arr);

    }
}
