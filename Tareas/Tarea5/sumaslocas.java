import java.util.*;

class BST {
    class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    Node root;
    BST(){ root = null;}
    public void insert(int data){
        root = insertRec(root, data);
    }
    Node insertRec(Node root, int data)
    {
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
    
        return root;
    }
    public void sumaloca(char[] a, char[] b)
    {
        int p, q;
        p = search(a);
        q = search(b);
        System.out.println(p+q);
    }
    int search(char[] x)
    {
        Node temp;
        temp = this.root;
        for(int k = 0; k < x.length; k++)
        {
            if(x[k] == '1'){
                temp = temp.right;
            }else if(x[k] == '0'){
                temp = temp.left;
            }
        }
        return temp.data;
    }
}
public class sumaslocas {

    public static void main(String[] args) {
        BST binaryTree = new BST();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0; i < n; i++)
        {
            binaryTree.insert(scan.nextInt());
        }
        n = scan.nextInt();
        char[] a,b;
        for(int i = 0; i < n; i++)
        {
            a = scan.next().toCharArray();
            b = scan.next().toCharArray();
            binaryTree.sumaloca(a,b);
        }
        scan.close();
    }
}
