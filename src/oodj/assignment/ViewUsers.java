package oodj.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ViewUsers extends javax.swing.JFrame {
    
    private String originalContent;//to store the original content of the file
    private String filename;
    
    public ViewUsers() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void viewuser(String userType){
        //this.userType = userType; //store the user type
        userlist.setEditable(false);
        try {
            //String filename = "";
            
            switch (userType){
                case "customer":
                    filename = "customers.txt";
                    break;
                case "vendor":
                    filename = "vendors.txt";
                    break;
                case "runner":
                    filename = "runners.txt";
                    break;
                default:
                    break;    
            }
            
            Scanner s = new Scanner(new File(filename));
            StringBuilder userList = new StringBuilder();
            while(s.hasNext()){
                String UID = s.nextLine();
                String username = s.nextLine();//.replace("Username: ", "");
                String password = s.nextLine();//.replace("Password: ", "");
                String additionalInfo = "";
                if(userType.equals("customer")){
                    additionalInfo = s.nextLine();  //credit  
                }else if(userType.equals("runner")){
                    additionalInfo = s.nextLine();  //location          
                }
                
                if(s.hasNextLine()){
                    s.nextLine();   
                }
                
                userList.append(UID).append("\n").append(username)
                        .append("\n").append(password).append("\n");
                
                if(!additionalInfo.isEmpty()){
                    userList.append(additionalInfo).append("\n");
                }
                userList.append("\n");
            }
            
            originalContent = userList.toString();
            userlist.setText(originalContent);
            s.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewUsers.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    private void editUserList(){
        userlist.setEditable(true);
        
    }
    
    private void saveUserList(){
        
        userlist.setEditable(false);

        try {
            FileWriter writer = new FileWriter(filename);
            String modifiedContent = userlist.getText().trim();//trim used to remove trailing whitespace
            writer.write(modifiedContent);
            writer.close();
            
            if(originalContent.length()<modifiedContent.length()){
                JOptionPane.showMessageDialog(null, "Dont add new user in this page!!!!!");
            }

        } catch (IOException ex) {
            Logger.getLogger(ViewUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        customer = new javax.swing.JButton();
        vendor = new javax.swing.JButton();
        runner = new javax.swing.JButton();
        userlist = new java.awt.TextArea();
        exit = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("User List");

        customer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        customer.setText("Customer");
        customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerActionPerformed(evt);
            }
        });

        vendor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        vendor.setText("Vendor");
        vendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorActionPerformed(evt);
            }
        });

        runner.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        runner.setText("Runner");
        runner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runnerActionPerformed(evt);
            }
        });

        userlist.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        exit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        edit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        save.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(userlist, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(customer, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(vendor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(runner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(84, 84, 84))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(customer)
                        .addGap(34, 34, 34)
                        .addComponent(vendor)
                        .addGap(30, 30, 30)
                        .addComponent(runner)
                        .addGap(35, 35, 35)
                        .addComponent(edit)
                        .addGap(32, 32, 32)
                        .addComponent(save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit))
                    .addComponent(userlist, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerActionPerformed
        viewuser("customer");
    }//GEN-LAST:event_customerActionPerformed

    private void vendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendorActionPerformed
        viewuser("vendor");
    }//GEN-LAST:event_vendorActionPerformed

    private void runnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runnerActionPerformed
        viewuser("runner");
    }//GEN-LAST:event_runnerActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispose();
        AdminMenu ad = new AdminMenu();
        ad.setVisible(true);
        ad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_exitActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        saveUserList();
    }//GEN-LAST:event_saveActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        editUserList();
    }//GEN-LAST:event_editActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton customer;
    private javax.swing.JButton edit;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton runner;
    private javax.swing.JButton save;
    private java.awt.TextArea userlist;
    private javax.swing.JButton vendor;
    // End of variables declaration//GEN-END:variables
}
