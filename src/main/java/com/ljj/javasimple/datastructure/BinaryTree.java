package com.ljj.javasimple.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树链式存储
 *
 * @author Lijj
 */
public class BinaryTree {
    private TreeNode rootNode = null;

    public BinaryTree() {
        rootNode = new TreeNode(1, "A");
    }

    public void createBinTree(TreeNode root) {
        TreeNode nodeB = new TreeNode(2, "B");
        TreeNode nodeC = new TreeNode(3, "C");
        TreeNode nodeD = new TreeNode(4, "D");
        TreeNode nodeE = new TreeNode(5, "E");
        TreeNode nodeF = new TreeNode(6, "F");

        root.leftChild = nodeB;
        root.rightChild = nodeC;
        root.leftChild.leftChild = nodeD;
        root.leftChild.rightChild = nodeE;
        root.rightChild.rightChild = nodeF;
    }

    public boolean isEmpty() {
        return rootNode == null;
    }

    //树的高度
    public int height() {
        return height(rootNode);
    }

    public int height(TreeNode subTree) {
        if (subTree == null) {
            return 0;
        } else {
            int i = height(subTree.leftChild);
            int j = height(subTree.rightChild);
            return (i < j) ? (j + 1) : (i + 1);
        }
    }

    //节点个数
    public int size() {
        return size(rootNode);
    }

    public int size(TreeNode subTree) {
        if (subTree == null) {
            return 0;
        } else {
            return 1 + size(subTree.leftChild) + size(subTree.leftChild);
        }
    }

    public TreeNode getRoot() {
        return rootNode;
    }

    public TreeNode getLeftChildNode(TreeNode element) {
        return (element == null) ? null : element.leftChild;
    }

    public TreeNode getRightChildNode(TreeNode element) {
        return (element == null) ? null : element.rightChild;
    }

    //返回双亲节点
    public TreeNode parent(TreeNode element) {
        return (rootNode == null || element == null) ? null : parent(rootNode, element);
    }

    public TreeNode parent(TreeNode subTree, TreeNode element) {
        if (subTree == null) {
            return null;
        }
        if (subTree.leftChild == element || subTree.rightChild == element) {
            return subTree;
        }
        //先在左子树中查找，如果没有，再到右子树中查找
        TreeNode tempNode = parent(subTree.leftChild, element);
        if (tempNode != null) {
            return tempNode;
        } else {
            return parent(subTree.rightChild, element);
        }
    }

    //在释放某个结点时，该结点的左右子树都已经释放，
    //所以应该采用后续遍历，当访问某个结点时将该结点的存储空间释放  
    public void destory(TreeNode subTree) {
        if (subTree != null) {
            //删除左子树
            destory(subTree.leftChild);
            //删除右子树
            destory(subTree.rightChild);
            //删除根节点
            subTree = null;
        }
    }

    public void printlnAll(TreeNode subTree) {
        if (subTree == null) {
            return;
        }
        System.out.println("key:" + subTree.key + "--name:" + subTree.data);
        printlnAll(subTree.leftChild);
        printlnAll(subTree.rightChild);
    }

    public void println(TreeNode subTree) {
        if (subTree == null) {
            return;
        }
        System.out.println("key:" + subTree.key + "--name:" + subTree.data);
    }

    //层层遍历
    public void levelOrder(TreeNode subTree) {
        int levelNum = 0;
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(subTree);
        while (!treeQueue.isEmpty()) {
            levelNum = treeQueue.size();
            while (levelNum > 0) {
                TreeNode tempNode = treeQueue.poll();
                if (tempNode != null) {
                    println(tempNode);
                    treeQueue.add(tempNode.leftChild);
                    treeQueue.add(tempNode.rightChild);
                }
                levelNum--;
            }
        }
    }

    //递归前序遍历
    public void preOrder(TreeNode subTree) {
        if (subTree != null) {
            println(subTree);
            preOrder(subTree.leftChild);
            preOrder(subTree.rightChild);
        }
    }

    //非递归前序遍历
    public void nonRecPreOrder(TreeNode subTree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = subTree;
        stack.push(subTree);
        while (!stack.isEmpty()) {
            node = stack.pop();
            println(node);
            if (node != null) {
                stack.push(node.rightChild);
                stack.push(node.leftChild);
            }
        }
    }

    //非递归中序遍历
    public void inOrder(TreeNode subTree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = subTree;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(node);
                node = node.leftChild;
            }
            node = stack.pop();
            println(node);
            node = node.rightChild;
        }
    }


    /**
     * 二叉树节点数据结构
     *
     * @author Lijj
     */
    private class TreeNode {
        private int key = 0;
        private String data = null;
        private boolean isVisted = false;
        private TreeNode leftChild = null;
        private TreeNode rightChild = null;

        public TreeNode() {
        }

        public TreeNode(int key, String data) {
            this.key = key;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinTree(bt.rootNode);

        System.out.println("tree node size " + bt.size());
        System.out.println("tree node height " + bt.height());

        System.out.println("*******[ABDECF]遍历*****************");
        bt.printlnAll(bt.rootNode);

        System.out.println("*******(前序遍历)[ABDECF]遍历*****************");
        bt.preOrder(bt.rootNode);

        System.out.println("***非递归实现****(前序遍历)[ABDECF]遍历*****************");
        bt.nonRecPreOrder(bt.rootNode);

        System.out.println("***非递归实现****(中序遍历)[DBEACF]遍历*****************");
        bt.inOrder(bt.rootNode);

        System.out.println("***非递归实现****(层层遍历)[ABCDEF]遍历*****************");
        bt.levelOrder(bt.rootNode);

    }

}
