import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private String customerName;
    private LocalDateTime transactionTime;
    private ArrayList<LineItem> lineItems = new ArrayList<>();

    public String getCustomerName() {
        return customerName;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", transactionTime=" + transactionTime +
                ", lineItems=" + lineItems +
                '}';
    }

    public Double cost(){
        Double cost = 0.0;
        for (int i = 0; i < lineItems.size(); i++)
            cost += lineItems.get(i).cost();
        return cost;
    }

    public boolean addProduct(Product product, int quantity){
        if (quantity <= product.getQuantity()){
            LineItem newProduct = new LineItem(product, quantity);
            lineItems.add(newProduct);
            product.setQuantity(product.getQuantity() - quantity);
            return true;
        }
        return false;
    }
}
