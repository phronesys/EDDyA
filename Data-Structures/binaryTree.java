/**
 * binaryTree
 */
class Node{
    int data;
    Node left;
    Node rigth;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.rigth = null;
    }
}
public class binaryTree {

    Node root;
    private Node addRecursive(Node current, int data)
    {
        if (current == null){
            return new Node(data);
        }
        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.rigth = addRecursive(current.rigth, data);
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
            : containsNode(current.rigth, data);    // si no en rigth
    }
    public boolean contains(int data) {
        return containsNode(root, data);
    }
    public static void main(String[] args) {
        binaryTree bt = new binaryTree();
        bt.add(5);
        bt.add(4);
        bt.add(8);
        bt.add(1);
        bt.add(7);
        bt.add(3);
        if(bt.contains(9))
            System.out.println("ewe");
        else
            System.out.println("uwu"); 
        
    }
}