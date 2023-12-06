
package oodj.assignment;

import oodj.assignment.Customer;
import java.util.ArrayList;
import java.util.List;


public class Transaction {
    private Customer username;
    private String Transname;
    private String date;
    private double fees;
    private List<Transaction> allTransactions;

    public Transaction(Customer username, String Transname, String date, double fees) {
        this.username = username;
        this.Transname = Transname;
        this.date = date;
        this.fees = fees;
        this.allTransactions = new ArrayList<>();
    }

    public Customer getUsername() {
        return username;
    }
    

    public String getTransname() {
        return Transname;
    }

    public String getDate() {
        return date;
    }

    public double getFees() {
        return fees;
    }

    public List<Transaction> getAllTransactions() {
        return allTransactions;
    }

    public void addTransaction(Transaction transaction) {
        allTransactions.add(transaction);
        
    
}
}

    