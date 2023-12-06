package oodj.assignment;

import oodj.assignment.Order;

public class Review {
    private Order OrderID;
    private double vendorRating;
    private String vendorComment;
    private double runnerRating;
    private String runnerComment;
    
 
    public Review(Order OrderID, double vendorRating, String vendorComment, double runnerRating, String runnerComment) {
        this.OrderID = OrderID;
        this.vendorRating = vendorRating;
        this.vendorComment = vendorComment;
        this.runnerRating = runnerRating;
        this.runnerComment = runnerComment;
    }
 
    public Order getOrderID() {
        return OrderID;
    }
 
    public double getVendorRating() {
        return vendorRating;
    }
 
    public String getVendorComment() {
        return vendorComment;
    }
 
    public double getRunnerRating() {
        return runnerRating;
    }
 
    public String getRunnerComment() {
        return runnerComment;
    }

}
