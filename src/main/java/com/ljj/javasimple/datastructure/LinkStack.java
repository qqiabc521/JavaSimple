package com.ljj.javasimple.datastructure;

public class LinkStack<T> {
	//定义节点数据结构
	private class Node{
		public T data;
		public Node next;
		public Node(){}
		
		public Node(T data,Node node){
			this.data = data;
			this.next = node;
		}
	}
	
	//栈顶元素
	private Node top;
	private int size;
	
	public void push(T element){
		top = new Node(element,top);
		size++;
	}
	
	//出栈
	public T pop(){
		Node oldNode = top;
		top = top.next;
		//释放引用
		oldNode.next = null;
		size--;
		return oldNode.data;
	}
	
	//返回栈顶元素，但不出栈
	public T peek(){
		return top== null?null:top.data;
	}
	
	//堆栈长度
	public int length(){
		return size;
	}
	
	//判断链栈释放为空栈
	public boolean empty(){
		return size == 0;
	}
	
	public String toString(){
		if(empty()){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder("[");
			for(Node current = top;current != null;current = current.next){
				sb.append(current.data.toString()).append(",");
			}
			int len = sb.length();
			return sb.delete(len - 1, len).append("]").toString();
		}
	}
	
	public static void main(String[] args){
		LinkStack<String> stack = new LinkStack<>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.push("e");
		
		System.out.println(stack);
		
		System.out.println("栈顶元素"+stack.peek());
		System.out.println("第一次弹出栈顶元素"+stack.pop());
		System.out.println("第二次弹出栈顶元素"+stack.pop());
		
		System.out.println("两次pop之后的栈"+stack);
	}
}
