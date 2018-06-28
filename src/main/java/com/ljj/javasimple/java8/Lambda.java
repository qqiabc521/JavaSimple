package com.ljj.javasimple.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda {
    static List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

    public static void main(String[] args) {
//		Collections.sort(names, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);
//			}
//		});

        Collections.sort(names, (String a, String b) -> {
            return a.compareTo(b);
        });

        System.out.println(names);

    }

}
