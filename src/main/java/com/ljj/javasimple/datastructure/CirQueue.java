package com.ljj.javasimple.datastructure;

public class CirQueue<E> {
    //对象数组，队列最多存储a.length - 1个对象
    private E[] a;
    //默认初始化大小
    private static final int DEFAULT_SIZE = 10;
    //对首下标
    private int front;
    //对尾下标
    private int rear;

    public CirQueue() {
        this(DEFAULT_SIZE);
    }

    public CirQueue(int size) {
        a = (E[]) new Object[size];
        front = 0;
        rear = 0;
    }

    /**
     * 将一个对象追加到队列尾部
     *
     * @param obj
     * @return
     */
    public boolean enqueue(E obj) {
        if ((rear + 1) % a.length == front) {
            return false;
        }
        a[rear] = obj;
        rear = (rear + 1) % a.length;
        return true;
    }

    /**
     * 队列头部出列
     *
     * @return
     */
    public E dequeue() {
        if (front == rear) {
            return null;
        }
        E obj = a[front];
        front = (front + 1) % a.length;
        return obj;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public int size() {
        return (rear - front) & (a.length - 1);
    }

    public int length() {
        if (rear > front) {
            return rear - front;
        } else {
            return a.length - 1;
        }
    }

    public static void main(String[] args) {
        CirQueue<String> queue = new CirQueue<>(4);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");

        System.out.println("size = " + queue.size());
        System.out.println("出栈操作");
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.dequeue());
        }
    }

}
