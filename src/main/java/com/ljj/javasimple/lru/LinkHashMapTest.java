package com.ljj.javasimple.lru;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkHashMapTest {

    private static LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<>(10,0.75f,true);

    public static void main(String[] args){
        for (int i=0;i<10;i++){
            linkedHashMap.put(i,String.valueOf(i));
        }

        println(linkedHashMap);

        linkedHashMap.get(5);

        println(linkedHashMap);
    }

    private static void println(LinkedHashMap map){
        System.out.println("================= println =======================");
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey().intValue() + ":"+entry.getValue());
        }
        System.out.println("");
    }
}
