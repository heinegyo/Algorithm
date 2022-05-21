package phase2.week8.Map;

import phase2.week8.FileOperation;
import phase2.week8.Set.BSTSet;
import phase2.week8.Set.LinkedListSet;
import phase2.week8.Set.Set;

import java.util.ArrayList;

public class TestMap {
    private static double testMap(Map<String, Integer> map, String filename) {
        long startTime = System.nanoTime();

        System.out.printf(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println(" Total words: " + words.size());

            for (String word : words)
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
        }

        System.out.println("Total different words : " + map.getSize());
        System.out.println("Frequency of PRIDE " + map.get("pride"));
        System.out.println("Frequency of PREJUDICE " + map.get("prejudice"));

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "src/pride-and-prejudice.txt";
        //String filename = "phase2/week8/pride-and-prejudice.txt";
        BSTMap<String,Integer> bstMap = new BSTMap<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("BST Map: " + time1 + " s");

        System.out.println();

        LinkedListMap<String,Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, filename);
        System.out.println("Linked List Map: " + time2 + " s");
    }

}
