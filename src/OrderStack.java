public class OrderStack {
    private SinglyNode top; //

    public OrderStack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public void push(Order order) {
        SinglyNode newNode = new SinglyNode(order);

        newNode.next = this.top;
        this.top = newNode;

        System.out.println("[STACK] Canceled order added: " + order);
    }

    public Order pop() {
        if (isEmpty()) {
            System.out.println("[STACK] The canceled orders stack is empty.");
            return null;
        }

        Order removedOrder = this.top.order;
        this.top = this.top.next;

        return removedOrder;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("[STACK] No canceled orders.");
            return;
        }

        System.out.println("--- Canceled Orders (Stack) ---");
        SinglyNode current = this.top;
        while (current != null) {
            System.out.println("  -> " + current.order);
            current = current.next;
        }
        System.out.println("---------------------------------");
    }
}