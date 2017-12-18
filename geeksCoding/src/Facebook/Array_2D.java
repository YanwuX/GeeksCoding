package Facebook;


import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Array_2D {

    public static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }

    public static void main(String[] args) {
        List<String> A = Stream.of("1", "2", "3", "4").collect(Collectors.toList());

        ArrayList<ArrayList<Integer>> list =  new ArrayList<ArrayList<Integer>>();
        List sub = Arrays.asList(1, 2, 3, 4);
        list.add((ArrayList<Integer>) sub);

        Stream.of(new int[]{1, 2, 3, 4},new int[] {5, 6, 7, 8}, new int[] {9, 10, 11, 12}).collect(Collectors.toList());
        ArrayList<ArrayList<Integer>> B = performOps(list);
        for (int i = 0; i < B.size(); i++) {
            for (int j = 0; j < B.get(i).size(); j++) {
                System.out.print(B.get(i).get(j) + " ");
            }
        }
    }
}
