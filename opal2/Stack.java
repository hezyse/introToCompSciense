public class Stack {
    private Node top;

    private class Node {
        int data;
        Node next;

        Node(int value) {
            data = value;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top != null) {
            int value = top.data;
            top = top.next;
            return value;
        } else {
            System.out.println("Stack is empty.");
            return -1;
        }
    }

    public boolean isEmpty() {
        return (top == null);
    }
}
