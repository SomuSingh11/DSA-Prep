public class MinHeap {
    private int[] heap;
    int capacity;
    int size;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    private int parent(int index){
        return (index-1)/2;
    }

    private int leftChild(int index){
        return (2*index) + 1;
    }

    private int rightChild(int index){
        return (2*index) + 2;
    }

    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int data){
        if(size == capacity){
            throw new RuntimeException("Heap is already full");
        }

        heap[size] = data;
        int curr = size;
        size++;

        // bubble up
        while(curr > 0 && heap[curr] < heap[parent(curr)]){
            swap(curr, parent(curr));
            curr = parent(curr);
        }

    }

    private void heapify(int index){
        int curr = index;
        
        while(true){
            int smallest = curr;
            int left = leftChild(smallest);
            int right = rightChild(smallest);

            if(left < size && heap[smallest] > heap[left]){
                smallest = left;
            }

            if(right < size && heap[smallest] > heap[right]){
                smallest = right;
            }

            if(smallest == curr) break;

            swap(smallest, curr);
            curr = smallest;
        }
    }

    public int getMin(){
        if(size == 0) throw new RuntimeException("Heap is empty");
        return heap[0];
    }

    public int extractMin(){
        if(size == 0) throw new RuntimeException("Heap is empty");

        int root = heap[0];
        heap[0] = heap[size-1];
        size--;

        heapify(0);
        return root;
    }
}
