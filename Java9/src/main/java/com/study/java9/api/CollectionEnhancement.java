package com.study.java9.api;

import com.stufy.common.CommonUtil;

import java.util.*;

public class CollectionEnhancement {
    public static void main(String[] args) {
        easyInitialize();
        arrayEnhancement();
        enumerationIterator();
    }

    private static void easyInitialize() {
        //Easy to initialize collection
        List<Integer> list = List.of(1,2,3,4,5,6,7,8);
        CommonUtil.BLACK_HOLE.accept(list);

        Set<Integer> set = Set.of(1,2,3,4,5,6,7,8);
        CommonUtil.BLACK_HOLE.accept(set);

        Map<Integer, String> map = Map.of(1, "1", 2, "2");
        CommonUtil.BLACK_HOLE.accept(map);

        //easy to create entry and map from entries
        Map.Entry<Integer, String> entry = Map.entry(1, "1");
        Map<Integer, String> map2 = Map.ofEntries(entry, Map.entry(2, "2"));
        CommonUtil.BLACK_HOLE.accept(map2);
    }

    private static void arrayEnhancement() {
        CommonUtil.log("arrayEnhancement");
        int[] ints1 = {1, 3, 5, 7, 9};
        int[] ints2 = {1, 3, 5, 6, 7, 10};
        int[] ints3 = {1, 3};
        int m = Arrays.mismatch(ints3, ints1);    // any value of the new api?
        System.out.println("mismatch index = " + m);

        //find mismatch in range
        int[] arrayA = {-2, 1, 3, 5, 7, 9};
        int[] arrayB = {-1, 0, 1, 3, 5, 7, 10};
        int j = Arrays.mismatch(arrayA, 1, arrayA.length, arrayB, 2, arrayB.length);
        System.out.println("mismatch index = " + j);

        //compare arrays
        String[] stringsA = {"one", "two"};
        String[] stringsB = {"four", "three"};
        int i = Arrays.compare(stringsA, stringsB);
        System.out.println(i);

        //can be used to sort collection of arrays
        List<String[]> list = Arrays.asList(stringsA, stringsB);
        System.out.print("before: ");
        list.forEach(a -> System.out.print(Arrays.toString(a)));
        list.sort(Arrays::compare);//java 8 method reference
        System.out.print("\nafter:  ");
        list.forEach(a -> System.out.print(Arrays.toString(a)));
        System.out.println();

        //equals with range
        String[] sa = {"d", "e", "f", "g", "h"};
        String[] sb = {"a", "b", "c", "d", "e", "f"};
        boolean b = Arrays.equals(sa, 0, 2, sb, 3, 5);
        System.out.println(b);
    }

    private static void enumerationIterator() {
        CommonUtil.log("enumerationIterator");
        //Enumeration is obsolete, use Iterator instead, for legacy classes, like Vector, Property, it is still useful

        Vector<Integer> vector = new Vector<>(List.of(1,2,3,4,5,6,7,8));
        Enumeration<Integer> enumeration = vector.elements();
        //Java 9 add asIterator to convert it to iterator
        enumeration.asIterator().forEachRemaining(System.out::println);
    }
}
