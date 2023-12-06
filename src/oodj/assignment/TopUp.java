package oodj.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class TopUp extends javax.swing.JFrame {
   public static ArrayList<Customer> allCustomers = new ArrayList<>();
        
    public TopUp() {
        initComponents();   
    }
    
    public void  readCustomersToArray(String UID){
        boolean userfound = false;
        double currentBalance = 0;  
        
        allCustomers.clear();//Clear the existing customer before reading the file
        try(Scanner scanner = new Scanner(new File("customers.txt"))){
            while(scanner.hasNextLine()){
                String existingUID = scanner.nextLine().replace("UID: ","").trim();
                String username = scanner.nextLine().replace("Username: ","").trim();
                String password = scanner.nextLine().replace("Password: ","").trim();
                String creditString = scanner.nextLine().replace("Balance: ", "").trim();
                currentBalance = Double.parseDouble(creditString);
                
                if(scanner.hasNextLine()){
                    scanner.nextLine();
                }
//                Customer customer = new Customer(existingUID ,username, password, currentBalance);
//                allCustomers.add(customer);
                
                if(existingUID.equals(UID)){
                    tfcreditbalance.setText(Double.toString(currentBalance));
                    userfound = true;
                }
            }
            if(!userfound){
                if(UID.equals("")){
                    JOptionPane.showMessageDialog(null, "Please insert the data properly!");
                }else{
                    JOptionPane.showMessageDialog(null, "Customer not found!");    
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }
    }
    
    private void topUpAmount(double amount){
        String customerID = tfcustID.getText();
        Optional<Customer> optionalCustomer = allCustomers.stream()
                .filter(customer -> customer.getCusID().equals(customerID))
                .findFirst();

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            double newBalance = customer.getCredit() + amount;
            
            tfnewbalance.setText(Double.toString(newBalance));
            customer.setCredit(newBalance);
            //writeCustomerToFile();
            
            JOptionPane.showMessageDialog(null, "Top-up successful! New balance: " + newBalance);
        } else {
            JOptionPane.showMessageDialog(null, "Customer not found!");
        }writeCustomerToFile();   
    }
    
//    private void saveNewBalance(){
//        for(Customer customer : allCustomers){
//            if(customer.getCusID().equals(tfcustID.getText())){
//                customer.setCredit(newBalance);
//                break;
//            }   
//        }
//        writeCustomerToFile();
//    }
    
    private void writeCustomerToFile(){
        try(PrintWriter writer = new PrintWriter(new FileWriter("customers.txt"))){
            for(Customer customer : allCustomers){
            // Write customer information to the file
                writer.println("UID: " + customer.getCusID());
                writer.println("Username: " + customer.getUsername());
                writer.println("Password: " + customer.getPassword());
                writer.println("Balance: " + customer.getCredit());
                writer.println();    
            }
            //writer.println();
        }catch(IOException e){
            System.out.println("Error in: " + e.getMessage());
        }      
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        topup = new javax.swing.JLabel();
        custID = new javax.swing.JLabel();
        tfcustID = new javax.swing.JTextField();
        topup5 = new javax.swing.JButton();
        topup10 = new javax.swing.JButton();
        topup50 = new javax.swing.JButton();
        topup100 = new javax.swing.JButton();
        creditbalance = new javax.swing.JLabel();
        tfcreditbalance = new javax.swing.JTextField();
        okbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfnewbalance = new javax.swing.JTextField();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        topup.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        topup.setText("Top Up");

        custID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        custID.setText("Customer ID:");

        tfcustID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        topup5.setText("$5");
        topup5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topup5ActionPerformed(evt);
            }
        });

        topup10.setText("$10");
        topup10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topup10ActionPerformed(evt);
            }
        });

        topup50.setText("$50");
        topup50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topup50ActionPerformed(evt);
            }
        });

        topup100.setText("$100");
        topup100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topup100ActionPerformed(evt);
            }
        });

        creditbalance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        creditbalance.setText("Credit Balance:");

        tfcreditbalance.setEditable(false);
        tfcreditbalance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        okbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        okbutton.setText("OK");
        okbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okbuttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("New Balance: ");

        tfnewbalance.setEditable(false);
        tfnewbalance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(topup100)
                .addGap(90, 90, 90))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(205, 205, 205)
                            .addComponent(topup))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(topup5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(topup10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(156, 156, 156))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(creditbalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(custID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(topup50, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfcustID)
                                .addComponent(tfcreditbalance)
                                .addComponent(tfnewbalance, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(okbutton)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(topup)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(custID)
                    .addComponent(tfcustID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creditbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfcreditbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfnewbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(topup5)
                    .addComponent(topup10)
                    .addComponent(topup50)
                    .addComponent(topup100))
                .addGap(23, 23, 23)
                .addComponent(okbutton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okbuttonActionPerformed
        readCustomersToArray(tfcustID.getText());
    }//GEN-LAST:event_okbuttonActionPerformed

    private void topup5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topup5ActionPerformed
        topUpAmount(5);
    }//GEN-LAST:event_topup5ActionPerformed

    private void topup10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topup10ActionPerformed
        topUpAmount(10);
    }//GEN-LAST:event_topup10ActionPerformed

    private void topup50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topup50ActionPerformed
        topUpAmount(50);
    }//GEN-LAST:event_topup50ActionPerformed

    private void topup100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topup100ActionPerformed
        topUpAmount(100);
    }//GEN-LAST:event_topup100ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel creditbalance;
    private javax.swing.JLabel custID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okbutton;
    private javax.swing.JTextField tfcreditbalance;
    private javax.swing.JTextField tfcustID;
    private javax.swing.JTextField tfnewbalance;
    private javax.swing.JLabel topup;
    private javax.swing.JButton topup10;
    private javax.swing.JButton topup100;
    private javax.swing.JButton topup5;
    private javax.swing.JButton topup50;
    // End of variables declaration//GEN-END:variables
}
