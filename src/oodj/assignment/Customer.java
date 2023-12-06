package oodj.assignment;

import oodj.assignment.DataIO;
import oodj.assignment.Order;
import oodj.assignment.Transaction;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

public class Customer {
    private String cusID;
    private String username;
    private String password;
    private double credit;
    private List <Order> orders = new ArrayList<>();
    private List<Transaction> alltransactions;

    public Customer(String cusID) {
        this.cusID = cusID;
    }

    public Customer(String cusID, String username, String password, double credit) {
        this.cusID = cusID;
        this.username = username;
        this.password = password;
        this.credit = credit;
        this.alltransactions = alltransactions;
    }

   
    
    public void getOrder(Order order){
        this.orders.add(order);
        order.setCustomer(this);
    }
//    
//    public Customer(String cusID, String username, String password, double credit) {
//        this.cusID = cusID;
//        this.username = username;
//        this.password = password;
//        this.credit = credit;
//        this.alltransactions = new ArrayList<>();
//    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }
    
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getCredit() {
        return credit;
    }
 
    public List<Transaction> getAlltransactions() {
        return alltransactions;
    }

    public void setAlltransactions(List<Transaction> alltransactions) {
        this.alltransactions = alltransactions;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String toString(){
    return cusID;
}


}
