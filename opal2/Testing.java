public class Testing {

    public static void mirror(Stack s)
    {
        Queue q = new Queue();

        int n, qSize = 0;
        while (!s.isEmpty())
        {
            qSize++;
            q.enqueue(s.pop());
        }
        for (int i=0; i<qSize; i++) {

            n = q.dequeue();

            s.push(n);
            q.enqueue(n);
        }
        while (!s.isEmpty())
        {
            q.enqueue(s.pop());
        }
        for (int i=0; i<qSize;i++)
            q.enqueue(q.dequeue());
        while (!q.isEmpty())
            s.push(q.dequeue());
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(9);
        s.push(4);
        s.push(20);

        mirror(s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
