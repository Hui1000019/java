package oodj.assignment;

import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame{
    public Login(){
        initialComponents();
    }
    private Customer customer;
    private javax.swing.JButton login;
    private javax.swing.JButton clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField tfpasswd;
    private javax.swing.JTextField tfusername;
    
    private void initialComponents(){
        
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfusername = new javax.swing.JTextField();
        tfpasswd = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 153));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Food Order System");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("User ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Password:");

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    loginActionPerformed(evt);
            }
        });
        
        clear.setText("Clear ALL");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(login))
                            .addGap(23, 23, 23)
                            .addComponent(clear))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfusername, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(tfpasswd))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfusername, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfpasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGap(27, 27, 27))
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
    }
    
    void testlogin(String UID, String passwd) {
        if(UID.equals("")||passwd.equals("")){
            JOptionPane.showMessageDialog(null, "Please insert your information properly!");
            return;
        }
        
        String[] userFiles = {"admins.txt", "vendors.txt", "runners.txt", "customers.txt"};
        
        for (String userFile : userFiles) {
            try (RandomAccessFile raf = new RandomAccessFile(userFile, "r")) {
                String userType = getUserType(userFile);
                
                String forUID = null;
                String forUser = null;
                String forPasswd = null;
                String forCredit = null;
                String forLocation = null;
                
                while (raf.getFilePointer() < raf.length()) {
                    String line = raf.readLine();

                    if (line == null || line.trim().isEmpty()) {
                        continue; // Skip empty lines
                    }
         
                    String[] parts = line.split(": ", 2);
                    if(parts.length == 2){
                        String field = parts[0];
                        String value = parts[1].trim();

                        switch (field) {
                            case "UID":
                                forUID = value;
                                break;
                            case "Username":
                                forUser = value;
                                break;
                            case "Password":
                                forPasswd = value;
                                break;
                            case "Balance":
                                forCredit = value;
                                break;
                            case "Location":
                                forLocation = value;
                                break;
                            default:
                                break;
                        }
                    }
                    //check for matching
                    if (forUID != null && forPasswd != null 
                            && UID.equals(forUID) && passwd.equals(forPasswd)) { //
                        handleSuccessfulLogin(userType, forUID);
                        return;
                    }   
                }       
            } catch (IOException ex) {
                System.out.println("Error reading "+userFile+":"+ex.getMessage());
            }   
        }
        JOptionPane.showMessageDialog(null, "Incorrect username/password!");
    }
    
    
    void handleSuccessfulLogin(String userType, String forUser) {
        JOptionPane.showMessageDialog(null, "Login successfully as " + userType + "!\r\nWelcome " + forUser);
        
        switch (userType) {
            case "admin":
                AdminMenu ad = new AdminMenu();
                ad.setVisible(true);
                dispose(); // Close the current UI
                break;
            case "vendor":
                System.out.println("Hi vendor");
                break;
            case "customer":
                Customer fewg = new Customer(forUser);  
                CustomerMenu cus = new CustomerMenu(fewg.getCusID());
                cus.setVisible(true);
                dispose();
                break;
            case "runner":
                System.out.println("Hi runner");
                break;
            default:
                break;
        }
    }

    String getUserType(String userFile) {
        if (userFile.equals("admins.txt")) {
            return "admin";
        } else if (userFile.equals("vendors.txt")) {
            return "vendor";
        } else if (userFile.equals("runners.txt")) {
            return "runner";
        } else if (userFile.equals("customers.txt")) {
            return "customer";
        } else {
            return "unknown";
        }
    }

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {                                         
        testlogin(tfusername.getText(), tfpasswd.getText());        
    }  
    
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Clear ALL button, clearing text by setting the text field as ""
        tfusername.setText("");
        tfpasswd.setText("");
    } 
                                           
}
