import java.util.Arrays;

class ArrayStack {
    private int[] stack;
    private int capacity;
    private int top; 

    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive number.");
        }
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1; 
    }

    public void push(int item) {
        if (isFull()) {
            throw new RuntimeException("Stack Overflow: Cannot push item, the stack is full.");
        }
        top++;
        stack[top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow: Cannot pop from an empty stack.");
        }
        int item = stack[top];
        top--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot peek into an empty stack.");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == (capacity - 1);
    }

    public int size() {
        return top + 1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        int[] contents = Arrays.copyOf(stack, size());
        return Arrays.toString(contents);
    }
}

public class Stack_using_arrays {
    public static void main(String[] args) {
        System.out.println("--- Creating a stack with capacity 3 ---");
        ArrayStack stack = new ArrayStack(3);

        System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.println("\nPushing 10, 20, 30...");
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Current stack: " + stack);
        System.out.println("Is stack full? " + stack.isFull());
        System.out.println("Peek at top: " + stack.peek());

        System.out.println("\nAttempting to push to a full stack...");
        try {
            stack.push(40);
        } catch (RuntimeException e) {
            System.err.println("Caught expected error: " + e.getMessage());
        }

        System.out.println("\nPopping one item: " + stack.pop());
        System.out.println("Current stack: " + stack);

        System.out.println("\nPopping all remaining items...");
        stack.pop();
        stack.pop();

        System.out.println("Attempting to pop from an empty stack...");
        try {
            stack.pop();
        } catch (RuntimeException e) {
            System.err.println("Caught expected error: " + e.getMessage());
        }
    }
}
