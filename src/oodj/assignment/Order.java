package oodj.assignment;
import oodj.assignment.Vendor;
import oodj.assignment.Food;
import oodj.assignment.DeliveryRunner;
import oodj.assignment.Customer;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
   private static int orderIDCount = 1;
    private static final DecimalFormat orderIDFormat = new DecimalFormat("OD00000");

    private String orderID;
    private Date date;
    private Customer customer;
    private String customerLocation;
    private Vendor vendor;
    private String vendorLocation;
    private double totalAmount;
    private Food food;
    private String orderType;
    private DeliveryRunner runner;
    private Date expectedDeliveryTime;
    private OrderStatus orderstatus;
    
    
    public Order(String orderID){
        this.orderID = orderID;
    }
    
    public Order(String orderID, Date date,Customer customer,  String customerLocation, Vendor vendor
            , double totalAmount, String orderType, DeliveryRunner runner, Date expectedDeliveryTime, 
            OrderStatus orderstatus) {
        this.orderID = orderID;
        this.date = date;
        this.customer = customer;
        this.customerLocation = customerLocation;
        this.vendor = vendor;
        this.vendorLocation = vendorLocation;
        this.totalAmount = totalAmount;
        //this.food = food;
        this.orderType = orderType;
        this.runner = runner;
        this.expectedDeliveryTime = expectedDeliveryTime;
        this.orderstatus = orderstatus;
    
    }
    
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
        
    public static int getOrderIDCount() {
        return orderIDCount;
    }

    public static DecimalFormat getOrderIDFormat() {
        return orderIDFormat;
    }

    public String getOrderID() {
        return orderID;
    }

    public Date getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getCustomerLocation() {
        return customerLocation;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public String getVendorLocation() {
        return vendorLocation;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Food getFood() {
        return food;
    }

    public String getOrderType() {
        return orderType;
    }

    public DeliveryRunner getRunner() {
        return runner;
    }

    public Date getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    public OrderStatus getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(OrderStatus orderstatus) {
        this.orderstatus = orderstatus;
    }
    
    public enum OrderStatus {
        PLACED("Placed"),
        ACCEPTED_BY_VENDOR("Accepted by vendor"),
        DECLINED("Declined"),
        PREPARING("Preparing"),
        DONE("Done"),
        ACCEPTED_BY_RUNNER("Accepted by Runner"),
        DELIVERING("Delivering"),
        DELIVERED("Delivered"),
        CANCELLED("Cancelled");
    
//
        private final String displayName;

        OrderStatus(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
    public void assignRunner(DeliveryRunner runner) {
    if (this.getOrderType().equals("Delivery") &&
        this.getOrderstatus() == OrderStatus.ACCEPTED_BY_VENDOR &&
        this.getRunner() == null && runnerAvailable(runner)) {
        this.runner = runner;
//        runner.acceptTask(this);
//        this.setOrderstatus(OrderStatus.ACCEPTED_BY_RUNNER);
    }
}

    public void setRunner(DeliveryRunner runner) {
        this.runner = runner;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
    
    public boolean runnerAvailable(DeliveryRunner runner){
        int maxTasks = 2;
        return runner.getTasks().size() <  maxTasks;
    }
    
    public String getFormattedDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(this.date);
    }
    
    public void acceptTask() {
    if (this.getOrderstatus() == OrderStatus.ACCEPTED_BY_VENDOR && this.getRunner() != null) {
        this.setOrderstatus(OrderStatus.ACCEPTED_BY_RUNNER);
    }
}
    
    public String toString() {
        return "Order ID: " + orderID + "\n" +
               //"Order Date: " + dateFormat.format(orderDate) + "\n" +
               "Customer: " + customer.getUsername() + "\n" +
               "Customer Location: " + customerLocation + "\n" +
               //"Vendor: " + vendor.getName() + "\n" +
               "Vendor Location: " + vendorLocation + "\n" +
               "Total Amount: " + totalAmount + "\n" +
               "Order Type: " + orderType + "\n" +
               //"Order Status: " + orderStatus + "\n" +
               "Runner: " + (runner != null ? runner.getUsername() : "N/A") + "\n" ;
               //"Expected Delivery Time: " + dateFormat.format(expectedDeliveryTime) + "\n";
    }
}
