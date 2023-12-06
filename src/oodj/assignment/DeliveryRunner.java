package oodj.assignment;
import oodj.assignment.Order;
import java.util.ArrayList;
import java.util.List;

public class DeliveryRunner {
    private String username;
    private String password;
    private String earnings;
    private List<Order> tasks;  // Change ArrayList<String> to List<Order>
    private boolean makeDecision;
    private boolean acceptTask;

    public DeliveryRunner(String username, String password) {
        this.username = username;
        this.password = password;
        this.tasks = new ArrayList<>();
    }
    
    public String toString() {
        return "DeliveryRunner{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // Modify the method to accept an Order object instead of OrderID
    public void acceptTask(Order order) {
    this.acceptTask = true;
    this.makeDecision = true;
    this.tasks.add(order);
    order.acceptTask();
}

    // Modify the method to accept an Order object instead of OrderID
    public void declineTask(Order order) {
        this.acceptTask = false;
        this.makeDecision = true;
        this.tasks.remove(order);
    }

    public void resetDecision() {
        this.makeDecision = false;
        this.acceptTask = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEarnings() {
        return earnings;
    }

    public void setEarnings(String earnings) {
        this.earnings = earnings;
    }

    public List<Order> getTasks() {
        return tasks;
    }
}
