package oodj.assignment;

import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Registration extends javax.swing.JFrame {
    public Registration() {
        initComponents();
        AdminMenu ad = new AdminMenu();
        ad.setVisible(false);
    }

    private void registerCustomer(String username, String passwd, String creditString){ //method for register customer
        try{
            RandomAccessFile raf = new RandomAccessFile("customers.txt","rw");
            
            int ln=1;
            while(raf.readLine()!=null){
                ln++;
            }
            
            String lastID = "C" + String.format("%04d", ln / 5);
            int newID = Integer.parseInt(lastID.substring(1))+1;
            String newUID = "C"+ String.format("%04d", newID);
            
            if(raf.length()==0){
                raf.writeBytes("UID: "+newUID+"\r\n");
                raf.writeBytes("Username: "+username+"\r\n");
                raf.writeBytes("Password: "+passwd+"\r\n");
                raf.writeBytes("Balance: "+creditString);
                JOptionPane.showMessageDialog(null, "Registered new customer successfully!\nThe new customer UID is "+newUID);
                raf.close();
                return;
            }
            
   
            raf.seek(0); //reset the file pointer to the beginning
            for(int i=0;i<ln;i+=5){
                String existingUID = raf.readLine().substring(5);
                String existingUsername = raf.readLine().substring(10);
                String existingPassword = raf.readLine().substring(10);
                String existingCredit = raf.readLine().substring(8);
                //ensure register with data
                if(username.equals("") || passwd.equals("")){
                    JOptionPane.showMessageDialog(null, "Please insert the data properly!");
                    raf.close();
                    return;
                }
                //check for existing username avoid repetition
                if(username.equals(existingUsername)){
                    JOptionPane.showMessageDialog(null, "Username already exist!");
                    return; //exit the method without adding duplicate entry
                }
                raf.readLine();//skip the empty line
                
            }
            
            if(creditString.isEmpty()){
                creditString = "0";
            }
            

            raf.seek(raf.length()); //move file pointer to the end to append new data
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            
            raf.writeBytes("UID: "+newUID+"\r\n");
            raf.writeBytes("Username: "+username+"\r\n");
            raf.writeBytes("Password: "+passwd+"\r\n");
            raf.writeBytes("Balance: "+creditString);
            JOptionPane.showMessageDialog(null, "Registered new customer successfully!\nThe new customer UID is "+newUID);
            ln+=5; //update ln after writing data
            raf.close();
        }catch(IOException e){
            System.out.println("Your configuration having an error!");
        }  
    }     
    
    private void registerVendor(String username, String passwd){ //method for register customer
        try{
            RandomAccessFile raf = new RandomAccessFile("vendors.txt","rw");
            int ln=1;
            while(raf.readLine()!=null){
                ln++;
            }   
            
            String lastID = "V" + String.format("%04d", ln / 4);
            int newID = Integer.parseInt(lastID.substring(1))+1;
            String newUID = "V"+ String.format("%04d", newID);
            
            if(raf.length()==0){
                raf.writeBytes("UID: "+newUID+"\r\n");
                raf.writeBytes("Username: "+username+"\r\n");
                raf.writeBytes("Password: "+passwd);
                JOptionPane.showMessageDialog(null, "Registered new customer successfully!\nThe new vendor UID is "+newUID);
                raf.close();
                return;
            }
            
            raf.seek(0); //reset the file pointer to the beginning
            for(int i=0;i<ln;i+=4){
                String existingUID = raf.readLine().substring(5);
                String existingUsername = raf.readLine().substring(10);
                String existingPassword = raf.readLine().substring(10);
                //ensure register with data
                if(username.equals("") || passwd.equals("")){
                    JOptionPane.showMessageDialog(null, "Please insert the data properly!");
                    raf.close();
                    return;
                }
                //check for existing username avoid repetition
                if(username.equals(existingUsername)){
                    JOptionPane.showMessageDialog(null, "Username already exist!");
                    return; //exit the method without adding duplicate entry
                }
                raf.readLine();//skip the empty line
            }
            
            
            
            raf.seek(raf.length()); //move file pointer to the end to append new data
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            raf.writeBytes("UID: "+newUID+"\r\n");
            raf.writeBytes("Username: "+username+"\r\n");
            raf.writeBytes("Password: "+passwd);

            JOptionPane.showMessageDialog(null, "Registered new vendor successfully!\nThe new vendor UID is "+newUID);
            ln+=4; //update ln after writing data
            raf.close();
        }catch(IOException e){
            System.out.println("Your configuration having an error!");
        }  
    }    
    
    private void registerRunner(String username, String passwd){ //method for register customer
        try{
            RandomAccessFile raf = new RandomAccessFile("Runners.txt","rw");
            int ln=1;
            while(raf.readLine()!=null){
                ln++;
            }   
            
            String lastID = "R" + String.format("%04d", ln / 4);
            int newID = Integer.parseInt(lastID.substring(1))+1;
            String newUID = "R"+ String.format("%04d", newID);
            
            if(raf.length()==0){
                raf.writeBytes("UID: "+newUID+"\r\n");
                raf.writeBytes("Username: "+username+"\r\n");
                raf.writeBytes("Password: "+passwd+"\r\n");
                raf.writeBytes("Location: ");
                JOptionPane.showMessageDialog(null, "Registered new customer successfully!\nThe new runner UID is "+newUID);
                raf.close();
                return;
            }            
            
            raf.seek(0); //reset the file pointer to the beginning
            for(int i=0;i<ln;i+=5){
                String existingUID = raf.readLine().substring(5);
                String existingUsername = raf.readLine().substring(10);
                String existingPassword = raf.readLine().substring(10);
                String existingLocation = raf.readLine().substring(10);
                //ensure register with data
                if(username.equals("") || passwd.equals("")){
                    JOptionPane.showMessageDialog(null, "Please insert the data properly!");
                    raf.close();
                    return;
                }
                //check for existing username avoid repetition
                if(username.equals(existingUsername)){
                    JOptionPane.showMessageDialog(null, "Username already exist!");
                    return; //exit the method without adding duplicate entry
                }
                raf.readLine();//skip the empty line
            }
            

            
            raf.seek(raf.length()); //move file pointer to the end to append new data
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            raf.writeBytes("UID: "+newUID+"\r\n");
            raf.writeBytes("Username: "+username+"\r\n");
            raf.writeBytes("Password: "+passwd+"\r\n");
            raf.writeBytes("Location: ");

            JOptionPane.showMessageDialog(null, "Registered new runner successfully!");
            ln+=5; //update ln after writing data
            raf.close();
        }catch(IOException e){
            System.out.println("Your configuration having an error!");
        }  
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usn = new javax.swing.JTextField();
        pwd = new javax.swing.JTextField();
        customerButton = new javax.swing.JButton();
        vendorButton = new javax.swing.JButton();
        runnerButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        topupcredit = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Registration");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Password:");

        usn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usnActionPerformed(evt);
            }
        });

        customerButton.setText("Customer");
        customerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerButtonActionPerformed(evt);
            }
        });

        vendorButton.setText("Vendor");
        vendorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorButtonActionPerformed(evt);
            }
        });

        runnerButton.setText("Runner");
        runnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runnerButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Credit Top Up: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(customerButton)
                .addGap(68, 68, 68)
                .addComponent(vendorButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(runnerButton)
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(topupcredit, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(exitButton)
                        .addGap(241, 241, 241))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(topupcredit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerButton)
                            .addComponent(vendorButton)
                            .addComponent(runnerButton))
                        .addGap(38, 38, 38)))
                .addComponent(exitButton)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usnActionPerformed
        
    }//GEN-LAST:event_usnActionPerformed

    private void customerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerButtonActionPerformed
        registerCustomer(usn.getText(), pwd.getText(),topupcredit.getText());
    }//GEN-LAST:event_customerButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        dispose();
        AdminMenu ad = new AdminMenu();
        ad.setVisible(true);
        ad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void runnerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runnerButtonActionPerformed
        registerRunner(usn.getText(), pwd.getText());
    }//GEN-LAST:event_runnerButtonActionPerformed

    private void vendorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendorButtonActionPerformed
        registerVendor(usn.getText(), pwd.getText());
    }//GEN-LAST:event_vendorButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton customerButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField pwd;
    private javax.swing.JButton runnerButton;
    private javax.swing.JTextField topupcredit;
    private javax.swing.JTextField usn;
    private javax.swing.JButton vendorButton;
    // End of variables declaration//GEN-END:variables
}
