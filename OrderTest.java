public class OrderTest {
    public static void main(String[] args) {
        OrderCalculator calculator = new SimpleOrderCalculator();
        OrderPlacer placer = new OnlineOrderPlacer();
        InvoiceGenerator invoiceGenerator = new PDFInvoiceGenerator();
        EmailNotifier emailNotifier = new EmailNotificationSender();

        OrderService orderService = new OrderService(calculator, placer, invoiceGenerator, emailNotifier);
        orderService.processOrder(10.0, 2, "John Doe", "123 Main St", "order_123.pdf", "johndoe@example.com");
    }
}