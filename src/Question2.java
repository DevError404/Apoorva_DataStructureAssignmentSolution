import java.io.*;

class Node
{
    int val;
    Node left, right;
    Node(int item)
    {
        val = item;
        left = right = null;
    }
}

class Question2 {
    public static Node node;
    static Node prevNode = null;
    static Node headNode = null;
    
    static void convertBTToSkewed(Node root, int order)
    {
        if(root == null)
        {
            return;
        }
        if(order > 0)
        {
            convertBTToSkewed(root.right, order);
        }
        else
        {
            convertBTToSkewed(root.left, order);
        }
        Node rightNode = root.right;
        Node leftNode = root.left;
    
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
       
        if (order > 0)
        {
            convertBTToSkewed(leftNode, order);
        }
        else
        {
            convertBTToSkewed(rightNode, order);
        }
    }
  
    static void traverseTree(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.val + " ");
        traverseTree(root.right);       
    }
    
    
    public static void main(String[] args) {
    	Question2 tree = new Question2();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left= new Node(55);
       
        int order = 0;
        convertBTToSkewed(node, order);
        traverseTree(headNode);
    }
}