public class OrderQueue {
    private SinglyNode front; // Head of the queue
    private SinglyNode rear;  // Tail of the queue

    public OrderQueue() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public void enqueue(Order order) {
        SinglyNode newNode = new SinglyNode(order);

        if (isEmpty()) {
            this.front = newNode;
            this.rear = newNode;
        } else {
            this.rear.next = newNode;
            this.rear = newNode;
        }
        System.out.println("[QUEUE] Order added: " + order);
    }

    public Order dequeue() {
        if (isEmpty()) {
            System.out.println("[QUEUE] The pending orders queue is empty.");
            return null;
        }

        Order removedOrder = this.front.order;

        this.front = this.front.next;

        if (this.front == null) {
            this.rear = null;
        }

        return removedOrder;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("[QUEUE] No pending orders.");
            return;
        }

        System.out.println("--- Pending Orders (Queue) ---");
        SinglyNode current = this.front;
        while (current != null) {
            System.out.println("  -> " + current.order);
            current = current.next;
        }
        System.out.println("--------------------------------");
    }
}