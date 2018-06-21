package com.ljj.javasimple.datastructure;

public class LinkQueue<T> {
	
	//链的数据结构
	private class Node{
		private T data;
		private Node next;
		public Node(){}
		
		public Node(T data,Node next){
			this.data = data;
			this.next = next;
		}
	}
	//队列头指针
	private Node front;
	
	//队列尾指针
	private Node rear;
	
	//队列长度
	private int size = 0;
	
	public LinkQueue(){
		Node  n = new Node();
		n.next = null;
		front = rear = n;
	}
	
	public void push(T data){
		//创建一个节点
		Node n = new Node(data,null);
		
		//将队尾指针指向新加入的节点
		rear.next = n;
		//将新节点插入队尾
		rear = n;
		size++;
	}
	
	public T poll(){
		if(front == null){
			throw new RuntimeException("堆栈为空");
		}
		Node node = front.next;
		T data = node.data;
		//头节点元素指向出栈节点的下一个节点元素
		front.next = node.next;
		
		//如果头节点元素的下一个节点为null，则为空栈
		if(front.next == null){
			rear = front;
		}
		node = null;
		size--;
		return data;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public String toString(){
		if(isEmpty()){
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");
		for(Node cur = front.next;cur != null;cur = cur.next){
			sb.append(cur.data).append(",");
		}
		int length = sb.length();
		return sb.delete(length - 1, length).append("]").toString();
	}

	public static void main(String[] args) {
		LinkQueue<String> queue = new LinkQueue<>();
		queue.push("1");
		queue.push("2");
		queue.push("3");
		queue.push("4");
		queue.push("5");
		queue.push("6");
		
		System.out.println(queue);
		System.out.println("长度："+queue.size());
		System.out.println(queue.poll());
		System.out.println("长度："+queue.size());
		System.out.println(queue.poll());
		System.out.println("长度："+queue.size());
		System.out.println(queue);
		
	}

}
