package phase2.week8;

import java.util.ArrayList;

public class TestSet {

    private static double testSet(Set<String> set, String filename) {
        long startTime = System.nanoTime();

        System.out.printf(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println(" Total words: " + words.size());

            for (String word : words)
                set.add(word);
            System.out.println("Total different word: " + set.getSize());
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "src/pride-and-prejudice.txt";
        //String filename = "phase2/week8/pride-and-prejudice.txt";
        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + " s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet,filename);
        System.out.println("Linked List Set: " + time2 + " s");
    }
}
