public class OrderService {
    private final OrderCalculator calculator;
    private final OrderPlacer placer;
    private final InvoiceGenerator invoiceGenerator;
    private final EmailNotifier emailNotifier;

    public OrderService(OrderCalculator calculator, OrderPlacer placer, InvoiceGenerator invoiceGenerator, EmailNotifier emailNotifier) {
        this.calculator = calculator;
        this.placer = placer;
        this.invoiceGenerator = invoiceGenerator;
        this.emailNotifier = emailNotifier;
    }

    public void processOrder(double price, int quantity, String customerName, String address, String fileName, String email) {
        double total = calculator.calculateTotal(price, quantity);
        System.out.println("Order total: $" + total);
        placer.placeOrder(customerName, address);
        invoiceGenerator.generateInvoice(fileName);
        emailNotifier.sendEmailNotification(email);
    }
}