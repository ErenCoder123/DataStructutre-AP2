import java.util.Scanner;

public class CafeteriaDemoMain {

    private OrderQueue pendingQueue = new OrderQueue();
    private OrderStack canceledStack = new OrderStack();
    private int nextOrderId = 1;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 7) {
            System.out.println("\n--- Cafeteria Management ---");
            System.out.println("1. Add New Order");
            System.out.println("2. Serve Order (Remove from Queue)");
            System.out.println("3. Cancel Order (Queue -> Stack)");
            System.out.println("4. Restore Order (Stack -> Queue)");
            System.out.println("5. Print Pending Orders (Queue)");
            System.out.println("6. Print Canceled Orders (Stack)");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Please enter a number.");
                continue;
            }

            switch (option) {
                case 1:
                    addNewOrder(scanner);
                    break;
                case 2:
                    serveOrder();
                    break;
                case 3:
                    cancelOrder();
                    break;
                case 4:
                    restoreOrder();
                    break;
                case 5:
                    pendingQueue.printQueue();
                    break;
                case 6:
                    canceledStack.printStack();
                    break;
                case 7:
                    System.out.println("Shutting down cafeteria system...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void addNewOrder(Scanner scanner) {
        System.out.print("Enter order description (e.g., Espresso Coffee): ");
        String description = scanner.nextLine();
        Order newOrder = new Order(nextOrderId++, description);
        pendingQueue.enqueue(newOrder);
    }

    private void serveOrder() {
        Order servedOrder = pendingQueue.dequeue();
        if (servedOrder != null) {
            System.out.println(">>> Order served: " + servedOrder);
        }
    }

    private void cancelOrder() {
        Order canceledOrder = pendingQueue.dequeue();
        if (canceledOrder != null) {
            canceledStack.push(canceledOrder);
            System.out.println(">>> Order canceled and moved to stack: " + canceledOrder);
        }
    }

    private void restoreOrder() {
        Order restoredOrder = canceledStack.pop();
        if (restoredOrder != null) {
            pendingQueue.enqueue(restoredOrder);
            System.out.println(">>> Order restored and moved to queue: " + restoredOrder);
        }
    }

    public static void main(String[] args) {
        CafeteriaDemoMain cafeteria = new CafeteriaDemoMain();
        cafeteria.run();
    }
}