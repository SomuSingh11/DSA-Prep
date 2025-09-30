public class BinarySearchTree {
    private Node root;
    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int data){
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }

        if(data < root.data){
            root.left = insertRec(root.left, data);
        } else if(data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public boolean search(int data){
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data){
        if(root == null) return false;

        if(root.data == data) return true;

        if(data < root.data) {
            return searchRec(root.left, data);
        }

        return searchRec(root.right, data);
    }

    public void delete(int data){
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, int data){

        if(root == null) return null;

        if(data < root.data){
            root.left = deleteRec(root.left, data);
        } else if(data > root.data){
            root.right = deleteRec(root.right, data);
        } else {
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            }

            //Both children are not null
            int minFromRight = minValue(root.right);
            root.data = minFromRight;
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    private int minValue(Node root){
        while(root.left != null){
            root = root.left;
        }

        return root.data;
    }
}
