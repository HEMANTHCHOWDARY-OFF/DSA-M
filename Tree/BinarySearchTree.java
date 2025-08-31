import java.util.Scanner;

class Node{ //Node class which defines the behaviour of a node 
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class Tree{ //Operations of Binary Search Tree
    Node insert(Node root,int data){
        if(root == null){
            Node newN = new Node(data);
            return newN;
        }
        if(data < root.data){
            root.left = insert(root.left, data);
        }
        else if(data > root.data){
            root.right = insert(root.right, data);
        }
        return root;
    }
    public void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.print(root.data + " ");
            display(root.right);
        }
    }
    public Node getSuccessor(Node current){
        current = current.right;
        while(current != null && current.left != null){
            current = current.left;
        }
        return current;
    }
    public Node deleteNode(Node root,int x){
        if(root == null){
            return root;
        }
        if(root.data > x){
            root.left = deleteNode(root.left, x);
        }
        else if(root.data < x){
            root.right = deleteNode(root.right, x);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            Node successor = getSuccessor(root);
            root.data = successor.data;
            root.right = deleteNode(root.right, successor.data);
        }
        return root;
    }
    public boolean isFound(Node root,int key){
        Node temp = root;
        while(temp!=null){
            if(temp.data == key){
                return true;
            }
            else if(temp.data > key){
                temp = temp.left;
            }
            else if(temp.data < key){
                temp = temp.right;
            }
        }
        return false;
    }
}
public class BinarySearchTree{ //Main class to test the all the methods
        public static void main(String[] args) {
        Node root = null;
        Tree tree = new Tree();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the no of nodes : ");
        int n = s.nextInt();
        System.out.print("Enter " + n + " nodes : ");
        for(int i = 1;i<=n;i++){
            int data = s.nextInt();
            root = tree.insert(root, data);
        }
        System.out.println("In-Order Traversal : ");
        tree.display(root);
        System.out.println();
        System.out.println("Enter key to delete : ");
        int key = s.nextInt();
        if(tree.isFound(root, key)){
            root = tree.deleteNode(root,key);
            System.out.println("Tree After deletion : ");
        }
        else{
            System.out.println("-----Key not found in the tree-----");
        }
        tree.display(root);
        s.close();
    }   
}