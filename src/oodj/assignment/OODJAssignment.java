package oodj.assignment;

import javax.swing.JFrame;

public class OODJAssignment {

    public static void main(String[] args) {
    
        DataIO dataIO = new DataIO();
        
        DataIO.readCustomers();
        
        DataIO.readTransaction();
        DataIO.readOrders();
        DataIO.readFood();
        Login login = new Login();
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
}
