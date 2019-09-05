package com.tsystems.javaschool.tasks.subsequence;


import java.util.*;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Subsequence {


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * Checks if it is possible to get a sequence which is equal to the first
     * one by removing some elements from the second one.
     *
     * @param x first sequence
     * @param y second sequence
     * @return <code>true</code> if possible, otherwise <code>false</code>
     */
    @SuppressWarnings("rawtypes")
    public boolean find(List x, List y) throws IllegalArgumentException {
        // TODO: Implement the logic here


        try {


            TreeSet<Object> hs1 = new TreeSet<>();
            TreeSet<Object> hs2 = new TreeSet<>();

            ///------------------------------------------------
            int kol = 0;

            ///-----------общая последовательность-----------
            for (int i = 0; i < x.size(); i++)
                for (int j = 0; j < y.size(); j++)
                    if (x.get(i).equals(y.get(j)))
                        hs1.add(y.get(j));


            //------------первая последовательность-------
            for (int j = 0; j < x.size(); j++)
                hs2.add(x.get(j));


            if (hs1.equals(hs2))
                return true;

            else
                return false;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {

        Subsequence subsequence = new Subsequence();
        List x = Stream.of(1, 3, 5, 7, 9).collect(toList());
        List y = Stream.of(10, 1, 2, 3, 4, 5, 7, 9, 20).collect(toList());

        //run
        boolean result = subsequence.find(x, y);
        System.out.println("result = " + result);

        //----------------------------------------------------------------------------------
        List x1 = Stream.of(1, 3, 5, 7, 9).collect(toList());
        List y1 = Stream.of(10, 1, 2, 3, 4, 3, 5, 7, 9, 20).collect(toList());

        //run
        result = subsequence.find(x1, y1);
        System.out.println("result1 = " + result);
        ///-----------------------------------------------------------
        List x2 = Stream.of(1, 3, 5, 7, 9).collect(toList());
        List y2 = Stream.of(1, 2, 3, 4, 5, 7, 9, 20).collect(toList());
        result = subsequence.find(x2, y2);
        System.out.println("result2 = " + result);
        ///-----------------------------------------------------------
        List x3 = Stream.of("B", "A", "D", "C").collect(toList());
        List y3 = Stream.of("BD", "A", "ABC", "B", "M", "D", "M", "C", "DC", "D").collect(toList());
        result = subsequence.find(x3, y3);
        System.out.println("result3 = " + result);
        ///-----------------------------------------------------------
        List x4 = Stream.of("B", "A", "D", "C").collect(toList());
        List y4 = Stream.of("BD", "ABC", "B", "M", "D", "M", "C", "DC", "D").collect(toList());
        result = subsequence.find(x4, y4);
        System.out.println("result4 = " + result);
        ///-----------------------------------------------------------
        List x5 = Stream.of("B", "A", "D", "C").collect(toList());
        List y5 = new ArrayList();
        result = subsequence.find(x5, y5);
        System.out.println("result5 = " + result);
///-----------------------------------------------------------
        List x6 = null;
        List y6 = new ArrayList();
        result = subsequence.find(x6, y6);
        System.out.println("result6 = " + result);

    }
}
