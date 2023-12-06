package oodj.assignment;
import oodj.assignment.DeliveryRunner;
import oodj.assignment.Food;
import oodj.assignment.Order;
import oodj.assignment.Review;
import oodj.assignment.Transaction;
import oodj.assignment.Vendor;
import oodj.assignment.Customer;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DataIO {
    
    public static ArrayList<DeliveryRunner> allRunners = new ArrayList<>();
    public static ArrayList<Order> allOrders = new ArrayList<>();
    public static ArrayList<Customer> allCustomers = new ArrayList<>();
    public static ArrayList<Transaction> allTransaction = new ArrayList<>();
    public static ArrayList<Review> allReview = new ArrayList<>();
  //  public static ArrayList<Notification> allNotification = new ArrayList<>();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
    public static ArrayList<Food> allFood = new ArrayList<>();
    
    
    public static ArrayList<DeliveryRunner> getAllRunners() {
        return allRunners;
    }

    public static ArrayList<Order> getAllOrders() {
        return allOrders;
    }

    public static ArrayList<Customer> getAllCustomers() {
        return allCustomers;
    }

    public static ArrayList<Transaction> getAllTransaction() {
        return allTransaction;
    }

    public static ArrayList<Food> getAllFood(){
        return allFood;
    }
    
    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

 
    public static ArrayList<Review> getAllReview() {
        return allReview;
    }
 
//    public static void readNotification(){
//        try(Scanner scanner = new Scanner(new File("notification.txt"))){
//            while(scanner.hasNext()){
//                int id = Integer.parseInt(scanner.nextLine());
//                String username = scanner.nextLine();
//                String message = scanner.nextLine();
//                String date = scanner.nextLine();
//                String time = scanner.nextLine();
//                String status = scanner.nextLine();
//                scanner.nextLine();
//                allNotification.add(new Notification(id, username, message, date, time, status));
//            }
//        }catch(Exception e){
//            System.out.println("Error in readNotification: "+ e.getMessage());
//        }
//    }
//    public static void writeNotification() {
//        try (PrintWriter writer = new PrintWriter("notification.txt")) {
//                for (Notification notification : allNotification) {
//                    writer.println(notification.getId());
//                    writer.println(notification.getUsername());
//                    writer.println(notification.getMessage());
//                    writer.println(notification.getDate());
//                    writer.println(notification.getTime());
//                    writer.println(notification.getStatus());
//                    writer.println();
//                }              
//        } catch (Exception e) {
//            System.out.println("Error in writeNotification: " + e.getMessage());
//        }
//    }
    
    public static void readReview() {
    try (Scanner scanner = new Scanner(new File("review.txt"))) {
        while (scanner.hasNext()) {
            String orderIdString = scanner.nextLine();
            Order orderId = new Order(orderIdString);
            double vendorRating = Double.parseDouble(scanner.nextLine().trim());
            String vendorComment = scanner.nextLine().trim();
            double runnerRating = Double.parseDouble(scanner.nextLine().trim());
            String runnerComment = scanner.nextLine().trim();
            scanner.nextLine();
            // Add the review to the list
            allReview.add(new Review(orderId, vendorRating, vendorComment, runnerRating, runnerComment));
        }
    } catch (Exception e) {
        System.out.println("Error in readReview: " + e.getMessage());
    }
}
 
    
    public static void writeReview(){
        try(PrintWriter writer = new PrintWriter("review.txt")){
           for(Review review: allReview){
               writer.println(review.getOrderID());
               writer.println(review.getVendorRating());
               writer.println(review.getVendorComment());
               writer.println(review.getRunnerRating());
               writer.println(review.getRunnerComment());
               writer.println();
            }
        } catch(Exception e){
                System.out.println("Error in writeReview: " + e.getMessage());
        }
    }
    
    public static void readRunners() {
        try (Scanner scanner = new Scanner(new File("runners.txt"))) {
            while (scanner.hasNext()) {
                String name = scanner.nextLine();
                String password = scanner.nextLine();
                scanner.nextLine();
                allRunners.add(new DeliveryRunner(name, password));
            }
        } catch (Exception e) {
            System.out.println("Error in readRunners: " + e.getMessage());
        }
    }

    public static void writeRunners() {
        try (PrintWriter writer = new PrintWriter("runners.txt")) {
            for (DeliveryRunner runner : allRunners) {
                writer.println(runner.getUsername());
                writer.println(runner.getPassword());
                writer.println();
            }
        } catch (Exception e) {
            System.out.println("Error in writeRunners: " + e.getMessage());
        }
    }
    
     public static void readFood() {
        try (Scanner scanner = new Scanner(new File("foods.txt"))) {
            while (scanner.hasNext()) {
                String foodid = scanner.nextLine();
                String foodname = scanner.nextLine();
                double price = Double.parseDouble(scanner.nextLine());
                String description = scanner.nextLine();
                String categories = scanner.nextLine();
                String vendor = scanner.nextLine();
                scanner.nextLine();
                
               allFood.add(new Food(foodid,foodname,price,description,categories,vendor));
            }
        } catch (Exception e) {
            System.out.println("Error in Food: " + e.getMessage());
        }
    }

     public static void writeFood() {
    try (PrintWriter writer = new PrintWriter("foods.txt")) {
            for (Food food : allFood) {
                writer.println(food.getFoodID());
                writer.println(food.getFoodName());
                writer.println(food.getPrice());
                writer.println(food.getDescription());
                
                writer.println(); 
            }
        } catch (Exception e) {
            System.out.println("Error in writeFood: " + e.getMessage());
        }
    }
     
    public static void readOrders() {
    try (Scanner scanner = new Scanner(new File("orders.txt"))) {
            while (scanner.hasNext()) {
                String orderID = scanner.nextLine();
                String dateString = scanner.nextLine(); // date
                Date orderDate = dateFormat.parse(dateString);  
                Customer customer = new Customer(scanner.nextLine(), null,null, 0.0);  
                String customerLocation = scanner.nextLine();
                Vendor vendor = new Vendor(scanner.nextLine(), null, null);
                String vendorLocation = scanner.nextLine();
                double totalAmount = Double.parseDouble(scanner.nextLine());
                String orderType = scanner.nextLine();
                String orderStatusString= scanner.nextLine();
                Order.OrderStatus orderStatus = Order.OrderStatus.valueOf(orderStatusString);
                String runnerUsername = scanner.nextLine();
                DeliveryRunner runner = "N/A".equals(runnerUsername) ? null : new DeliveryRunner(runnerUsername, null);
                Date expectedDeliveryTime = dateFormat.parse(scanner.nextLine());

                scanner.nextLine(); 

                Order order = new Order(orderID, orderDate, customer, customerLocation, vendor, totalAmount,
                        orderType, runner, expectedDeliveryTime, orderStatus);
                allOrders.add(order);

            }
            
        } catch (Exception e) {
            System.out.println("Error in readOrders: " + e.getMessage());
        }
       
}

    public static void writeOrders() {
    try (PrintWriter writer = new PrintWriter("orders.txt")) {
            for (Order order : allOrders) {
                writer.println(order.getOrderID());
                writer.println(dateFormat.format(order.getDate())); // Format date and time
                writer.println(order.getCustomer().getUsername());
                writer.println(order.getCustomerLocation());
                writer.println(order.getVendor().getUsername());
                writer.println(order.getVendorLocation());
                writer.println(order.getTotalAmount());
                writer.println(order.getOrderType());
                writer.println(order.getOrderstatus().name()); // Write enum name instead of display name
                writer.println(order.getRunner() != null ? order.getRunner().getUsername() : "N/A");
                writer.println(dateFormat.format(order.getExpectedDeliveryTime())); // Format expected delivery time
                writer.println(); // Add a line for better readability
            }
        } catch (Exception e) {
            System.out.println("Error in writeOrders: " + e.getMessage());
        }
    }
    
    
    
    
    public static void readCustomers() {
        try (Scanner scanner = new Scanner(new File("customers.txt"))) {
            while (scanner.hasNext()) {
                String uid = scanner.nextLine().replace("UID: ","");
                String username = scanner.nextLine().replace("Username: ","");
                String password = scanner.nextLine().replace("Password: ","");
                String creditString = scanner.nextLine().replace("Balance: ","");
                scanner.nextLine();
                if (username != null && password != null && creditString != null) {
                    double credit = Double.parseDouble(creditString);
                    allCustomers.add(new Customer(uid, username, password, credit));
                    
                } else {
                    System.out.println("Incomplete data for a customer.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error in readCustomers: " + e.getMessage());
        }
    }

    public static void writeCustomers() {
        try (PrintWriter writer = new PrintWriter("customers.txt")) {
            for (Customer customer : allCustomers) {
                writer.println(customer.getCusID());
                writer.println(customer.getUsername());
                writer.println(customer.getPassword());
                writer.println(customer.getCredit());
                writer.println();
            }
        } catch (Exception e) {
            System.out.println("Error in writeCustomers: " + e.getMessage());
        }
    }

        public static void readTransaction() {
        try (Scanner scanner = new Scanner(new File("transaction_history.txt"))) {
        while (scanner.hasNext()) {
            //String name = scanner.nextLine();
            Customer username = new Customer(scanner.nextLine(),null, null,0);
            String transname = scanner.nextLine();
            String date = scanner.nextLine();
            double fees = Double.parseDouble(scanner.nextLine());
            scanner.nextLine(); // Skip the empty line
            
            // Create a new Transaction and add it to the list
            Transaction transaction = new Transaction(username, transname, date, fees);
            //username.getAlltransactions().add(transaction);
            allTransaction.add(transaction);
            
        }
    } catch (Exception e) {
        System.out.println("Error in readTransaction: " + e.getMessage());
        
    }
 }


        public static void writeTransaction() {
        try (PrintWriter writer = new PrintWriter("transaction_history.txt")) {
            for (Transaction transaction : allTransaction) {
                writer.println(transaction.getUsername());
                writer.println(transaction.getTransname());
                writer.println(transaction.getDate());
                writer.println(transaction.getFees());
                writer.println();
                
                // Add an empty line between transactions (optional, based on your preference)
                writer.println();
            }
        } catch (Exception e) {
            System.out.println("Error in writeTransaction: " + e.getMessage());
        }
    }
        public static Customer checkUsername(String x){
        for(Customer c : allCustomers){
            if(x.equals(c.getUsername())){
                return c;
            }
        }
        return null;
        }
//        public static void addNotification(String username, String message, String status) {
//             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//             SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
//
//             Date now = new Date();
//             String formattedDate = dateFormat.format(now); 
//             String formattedTime = timeFormat.format(now); // Formats the time as "HH:mm:ss"
//
//             Notification newNotification = new Notification(allNotification.size() + 1, username, message, formattedDate, formattedTime, status);
//             allNotification.add(newNotification);
//
//             writeNotification();
//     }


//     public static void addNotification(DeliveryRunner runner, String message, String status) {
//         addNotification(runner.getUsername(), message, status);
//     }
//
//     public static void addNotification(Customer customer, String message, String status) {
//         addNotification(customer.getUsername(), message, status);
//     }
//
//     public static void addNotification(Vendor vendor, String message, String status) {
//         addNotification(vendor.getUsername(), message, status);
//     }
}



