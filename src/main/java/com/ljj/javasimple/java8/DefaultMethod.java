package com.ljj.javasimple.java8;

/**
 * 接口的默认方法
Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法
 * @author lijunjie
 *
 */
public class DefaultMethod {
	
	interface Formula{
		double calculate(int a);
		
		default double sqrt(int b){
			return Math.sqrt(b);
		}
		
		default double sum(int a, int b){
			return a + b;
		}
	}

	public static void main(String[] args) {
		Formula formula = new Formula(){

			@Override
			public double calculate(int a) {
				return sqrt(a);
			}
			
		};
		System.out.println(formula.calculate(100));
		System.out.println(formula.sqrt(16));
		System.out.println(formula.sum(1,1));
				
	}
	
	

}
