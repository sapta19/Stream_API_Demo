import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
public class TransactionStaemExample {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction(1, 100.50, LocalDate.of(2023, 1, 10), "COMPLETED"),
            new Transaction(2, 200.75, LocalDate.of(2023, 2, 15), "PENDING"),
            new Transaction(3, 150.00, LocalDate.of(2023, 3, 20), "COMPLETED"),
            new Transaction(4, 300.00, LocalDate.of(2023, 4, 25), "CANCELLED")
        );   
        // Filter transactions by status (e.g., "COMPLETED"). 
        transactions.stream().filter(n-> n.getStatus().equals("COMPLETED")).forEach(System.out::println);
        // Calculate the total amount of all completed transactions
        Double totalAmm  = transactions.stream().mapToDouble(Transaction::getAmount).sum();
        System.out.println("Total Ammount" + totalAmm);
        // Group transactions by status.
        Map<String,List<Transaction>> grouped = transactions.stream().collect(Collectors.groupingBy(Transaction::getStatus));
        System.out.println(grouped);
        // Earliest 
        Optional<LocalDate> minDate = transactions.stream().map(Transaction::getDate).min(Comparator.naturalOrder());
        System.out.println(minDate.orElse(null));
    }
}
class Transaction {
    private int id;
    private double amount; 
    private LocalDate date;
    private String status;
    public Transaction(int id, double amount, LocalDate date, String status){
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Transaction [id=" + id + ", amount=" + amount + ", date=" + date + ", status=" + status + "]";
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}