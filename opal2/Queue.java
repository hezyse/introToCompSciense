public class Queue {
    private Node front;
    private Node rear;

    private class Node {
        int data;
        Node next;

        Node(int value) {
            data = value;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (front != null) {
            int value = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return value;
        } else {
            System.out.println("Queue is empty.");
            return -1;
        }
    }

    public boolean isEmpty() {
        return (front == null);
    }
}
