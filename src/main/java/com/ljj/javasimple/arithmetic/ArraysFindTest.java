package com.ljj.javasimple.arithmetic;

/**
 * 二维数组中的查找
 * <p>
 * 在一个二维数据中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增排序。
 * 输入这样一个数组和一个整数，判断数组是否包含该整数。
 */
public class ArraysFindTest {

    /**
     * 思路：
     * 二维数据相当于一个矩阵，且是有序的。从左下角开始，向右递增，向上递减。
     * 从左下角开始查找，比目标数字，上移；比目标数字小，右移。
     *
     * @param arrays
     * @param target
     * @return
     */
    private static boolean find(int[][] arrays, int target) {
        if(arrays == null || arrays.length == 0){
            return false;
        }
        int row = arrays.length;
        int col = arrays[0].length;

        int i = row - 1;
        int j = 0;
        while(i >=0 && j < col){
            if(arrays[i][j] == target){
                return true;
            }
            if(arrays[i][j] < target){
                j++;
                continue;
            }
            if(arrays[i][j] > target){
                i--;
                continue;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{4, 5, 9}, {13, 17, 19}, {20, 27, 28}};

        int target = 4;
        System.out.println(target + " " + find(array, target));

        target = 11;
        System.out.println(target + " " + find(array, target));

        target = 27;
        System.out.println(target + " " + find(array, target));
    }
}
