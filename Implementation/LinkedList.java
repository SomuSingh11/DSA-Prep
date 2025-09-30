
class LinkedList {
    private Node head;
    private int size;

    private class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    // functions
    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data){
        Node newNode = new Node(data);

        if(isEmpty()){
            head = newNode;
        } else {
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public int deleteFirst(){
        if(isEmpty()){
            throw new RuntimeException("Cannot remove from empty list");
        }

        int nodeData = head.data;
        head = head.next;
        size--;
        return nodeData;
    }

    public int deleteLast(){
        if(isEmpty()){
            throw new RuntimeException("Cannot remove from empty list");
        }
        if(size == 1){
            return deleteFirst();
        }

        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }   

        int nodeData = temp.next.data;
        temp.next = null;
        size--;
        return nodeData;
    }

    public Node getPreviousNode(int index){
        if (index <= 0 || index > size) {
            throw new IllegalArgumentException("Index must be > 0 and <= size");
        }
        Node temp = head;
        for(int i=0; i < index-1; i++){
            temp = temp.next;
        }
        return temp;
    }

    public void addAtIndex(int index, int data){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size){
            addLast(data);
            return;
        }
                
        Node newNode = new Node(data);
        Node previousNode = getPreviousNode(index);

        newNode.next = previousNode.next;
        previousNode.next = newNode;
        size++;
    }

    public int deleteAtIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if(index == 0) return deleteFirst();
        if(index == size-1) return deleteLast();

        Node previousNode= getPreviousNode(index);
        int data = previousNode.next.data;

        previousNode.next = previousNode.next.next;

        size--;
        return data;
    }

}