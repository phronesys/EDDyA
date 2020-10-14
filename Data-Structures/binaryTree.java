import java.util.Queue;
import java.util.LinkedList;

/**
 * binaryTree
 * 
 * source: https://www.baeldung.com/java-binary-tree
 */
class Node{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BinaryTree {
    Node root;
    private Node addRecursive(Node current, int data)
    {
        if (current == null){
            return new Node(data);
        }
        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        } else {
            // valor repetido
            return current;
        }
        return current;
    }
    public void add(int data) {
        root = addRecursive(root, data);
    }
    private boolean containsNode(Node current, int data)
    {
        if (current == null){ return false; }       // no se econtró
        if (current.data == data){ return true; }   // encontrado
        return data < current.data
            ? containsNode(current.left, data)      // si es menor busca en left
            : containsNode(current.right, data);    // si no en right
    }
    public boolean contains(int data) {
        return containsNode(root, data);
    }
    private Node deleteRecursive(Node current, int data)
    {
        if (current == null) return null;
        if (data == current.data) {
            if (current.left == null && current.right == null) return null;
            if (current.right == null) return current.left;
            if (current.left == null) return current.right;  
            int smallest = findSmallest(current.right);
            current.data = smallest;
            current.right = deleteRecursive(current.right, smallest);
            return current;
        }
        if (data < current.data) {
            current.left = deleteRecursive(current.left, data);
            return current;
        }
        current.right = deleteRecursive(current.right, data);
        return current;
    }
    public void delete(int data){
        root = deleteRecursive(root, data);
    } 

    private void printPreOrder(Node current){
        if(current == null) return;
        System.out.print(current.data + " "); //pre order
        printPreOrder(current.left);
        printPreOrder(current.right);
    }
    public void preOrder(){
        printPreOrder(root);
        System.out.println();
    }
    private void printInOrder(Node current){
        if(current == null) return;
        printInOrder(current.left);
        System.out.print(current.data + " ");  //in order 
        printInOrder(current.right);
    }
    public void inOrder(){
        printInOrder(root);
        System.out.println();
    }
    private void printPostOrder(Node current){
        if (current == null) return;
        printPostOrder(current.left);
        printPostOrder(current.right);
        System.out.print(current.data + " ");  //post order
    }
    public void postOrder(){ 
        printPostOrder(root);
        System.out.println();
    }
    private int findSmallest(Node root) {
        return root.left == null ? root.data : findSmallest(root.left);
    }
    public void levelOrder() {
        if (root == null) return;

        Queue<Node> nodes = new LinkedList();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();

            System.out.print(node.data + "");
            if(node.left != null) {
                nodes.add(node.left);
            }
            if(node.right != null) {
                nodes.add(node.right);
            }
        }
    }
}
public class binaryTree {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(3);
        bt.add(4);
        bt.add(1);
        bt.add(6);
        bt.add(2);
        bt.add(5);
        if(bt.contains(9))
            System.out.println("ewe");
        else
            System.out.println("uwu"); 
        
        bt.preOrder();
        bt.inOrder();
        bt.postOrder();
        bt.levelOrder();
        bt.delete(3);
        bt.inOrder();
        bt.levelOrder();
    }
}