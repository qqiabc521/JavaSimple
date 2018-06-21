package com.ljj.javasimple.datastructure;

import java.util.Arrays;

public class CommonSort {
	
	/**
	 * 冒泡排序
	 * @param array
	 * @return
	 */
	public static int[] bubbleSort(int[] array){
		int temp;
		for(int i=0;i<array.length;i++){
			for(int j = i+1;j<array.length;j++){
				if(array[i] > array[j]){
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	/**
	 * 插入排序
	 * @param array
	 * @return
	 */
	public static int[] insertSort(int[] array){
		int temp;
		int j;
		for(int i=0;i<array.length;i++){
			temp = array[i];
			j = i;
			while(j > 0 && temp < array[j - 1]){
				array[j] = array[j - 1];
				j--;
			}
			array[j] = temp;
		}
		
		return array;
	}
	
	/**
	 * 选择排序
	 * @param array
	 * @return
	 */
	public static int[] selectSort(int[] array){
		int index,temp;
		for(int i=0;i<array.length;i++){
			index = i;
			temp = array[i];
			for(int j = i+1;j<array.length;j++){
				if(array[j] < temp){
					temp = array[j];
					index = j;
				}
			}
			if(index != i){
				temp = array[i];
				array[i] = array[index];
				array[index] = temp;
			}
		}
		return array;
	}
	
	/**
	 * 快速查找
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	public static int[] quickSort(int[] array,int left,int right){
		System.out.println("left = "+left+",right = "+right);
		if(left >= right){
			return array;
		}
		int index = partition(array,left,right);
		quickSort(array,left,index-1);
		quickSort(array,index + 1,right);
		return array;
	}
	
	private static int partition(int[] array,int left,int right){
		int temp = array[left];
		while(left < right){
			while(array[right] >= temp && left < right){
				right--;
			}
			array[left] = array[right];
			while(array[left] <= temp && left < right){
				left++;
			}
			array[right] = array[left];
		}
		array[left] = temp;
		print(array);
		return left;
	}
	
	private static void print(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
		System.out.println("");
	}
	
	private static void println(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {
		int a[] = {8,4,3,6,9,5,2,1,7,0};
		
		System.out.println("===============冒泡排序========================");
		println(bubbleSort(Arrays.copyOf(a, a.length)));
		
		System.out.println("===============插入排序========================");
		println(insertSort(Arrays.copyOf(a, a.length)));
		
		System.out.println("===============选择排序========================");
		println(selectSort(Arrays.copyOf(a, a.length)));
		
		System.out.println("===============快速排序========================");
		println(quickSort(Arrays.copyOf(a, a.length),0,a.length-1));
	}

}
