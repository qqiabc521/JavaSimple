package com.ljj.javasimple.datastructure;

public class BinSearch {

    public static int search(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int index = (end - start) / 2 + start;
            if (array[index] == key) {
                return index;
            } else if (array[index] < key) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }

        return -1;
    }

    public static int search(int[] array, int start, int end, int key) {
        int index = (end - start) / 2 + start;
        if (array[index] == key) {
            return index;
        } else if (array[index] < key) {
            return search(array, index + 1, end, key);
        } else if (array[index] > key) {
            return search(array, start, index - 1, key);
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("result = " + search(array, 8));
        System.out.println("result = " + search(array, 0, array.length - 1, 8));
    }

}
