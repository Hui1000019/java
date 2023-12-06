
package oodj.assignment;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;



public class CustomerMenu extends javax.swing.JFrame {
    private String cus;
    private Food food;
    private ArrayList<Order> allOrderCon;
    private String customer;
            
    ButtonGroup orderTypeGroup = new ButtonGroup();

    public CustomerMenu(String customer) {

        initComponents();
        groupRadioButtons();
        this.customer = customer;
        txtQty.setValue(1);
        textTotalAmount.setText(String.format(" RM "));
        allOrderCon = new ArrayList<>();
        showFoodId();

    }
    
    private void groupRadioButtons() {
    orderTypeGroup.add(radioBtnPickUp);
    orderTypeGroup.add(radioBtnTakeAway);
    orderTypeGroup.add(radioBtnDinein);
}
   public void showFoodId() {
        List<Food> allFood = DataIO.getAllFood();
        if (allFood != null) {
            DefaultListModel<String> ListFoodID = new DefaultListModel<>();
            String selectedCategory = boxCategories.getSelectedItem().toString(); // Get the selected category
            for (Food food : allFood) {
                if (selectedCategory.equals("All") || selectedCategory.equals(food.getCategories())) {
                ListFoodID.addElement(food.getFoodID() +" "+ food.getFoodName()+" "+food.getDescription()+" "+food.getPrice());
                }
            }

            lstFoodId.setModel(ListFoodID);

        }
   }
   
   public void showReview(){
       
   }
   
    private void addItemToCart() {
        if (lstFoodId.getSelectedValue() != null) {
            String selectedFood = lstFoodId.getSelectedValue().toString();

            // Get the quantity from the JSpinner
            int qty = (Integer) txtQty.getValue();

            DefaultTableModel cartModel = (DefaultTableModel) invoiceTable.getModel();
            String[] foodDetails = selectedFood.split(" ");
            String foodId = foodDetails[0];
            String foodName = foodDetails[1];
            double foodPrice = Double.parseDouble(foodDetails[foodDetails.length - 1]);

            // Calculate total price
            double total = qty * foodPrice;

            // Add the row to the cart table (JTable)
            cartModel.addRow(new Object[]{foodId, foodName, qty, foodPrice, total});
            txtQty.setValue(1);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a food item to add to the cart");
        }
    }


   public void editItemFromCart(){
          int selectedRow = invoiceTable.getSelectedRow();

    if (selectedRow >= 0) {
        // Get the new quantity from the spinner
        int newQty = Integer.parseInt(txtQty.getValue().toString()) ;

        // Get the current quantity from the table
        int currentQty = Integer.parseInt(invoiceTable.getValueAt(selectedRow, 2).toString()) ; // Assuming quantity is in column 2

        // Check if newQty is greater than currentQty
        if (newQty > currentQty) {
            JOptionPane.showMessageDialog(this, "New quantity cannot be greater than the current quantity in the cart");
        } else {
            // Update the quantity in the table
            invoiceTable.setValueAt(currentQty - newQty, selectedRow, 2); // Assuming quantity is in column 2
            
            // Check if the new quantity is zero and remove the row if it is
            if (currentQty - newQty == 0) {
                DefaultTableModel model = (DefaultTableModel) invoiceTable.getModel();
                model.removeRow(selectedRow);
            }
        }txtQty.setValue(1);
    } else {
        // Show a message if no row is selected
        JOptionPane.showMessageDialog(this, "Please select an item to update the quantity in the cart");
    }
   }
    public void totalAmount(){
        double totalAmount = 0.0;

        for (int row = 0; row < invoiceTable.getRowCount(); row++) {
            double rowTotal = Double.parseDouble(invoiceTable.getValueAt(row, 4).toString());
            totalAmount += rowTotal;
        }

        textTotalAmount.setText(String.format(" RM "+"%.2f", totalAmount)); // Format as a decimal with two decimal places
    } 

public void makePayment() {
    // Get the total amount from the textTotalAmount field
    String totalAmountText = textTotalAmount.getText();

    if (" RM ".equals(totalAmountText)) {
        JOptionPane.showMessageDialog(this, "Please calculate the total amount first by clicking the 'Total' button.", "Total Amount Missing", JOptionPane.ERROR_MESSAGE);
        return; // Stop further processing
    }

    totalAmountText = totalAmountText.replace(" RM ", ""); // Remove the " RM " prefix
    double totalAmount = Double.parseDouble(totalAmountText);

    if (cus == null) {
        JOptionPane.showMessageDialog(this, "Please select a dining option (Pick Up, Take Away, or Dine In).", "Dining Option Missing", JOptionPane.ERROR_MESSAGE);
        return; 
    }


    if (totalAmount != 0) {
        DefaultTableModel cartModel = (DefaultTableModel) invoiceTable.getModel();

        int confirm = JOptionPane.showConfirmDialog(this, "Confirm your order?\nTotal Amount: RM " + String.format("%.2f", totalAmount), "Payment Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {

            String deliveryAddress = JOptionPane.showInputDialog(this, "Enter delivery address:");
          
        } else {
            // If the confirmation is canceled, reset the total amount to default
            textTotalAmount.setText("RM ");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select food items and click the 'Total' button.", "No Food Amount", JOptionPane.ERROR_MESSAGE);
    }
}

public void addOrder()
   


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        boxCategories = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstFoodId = new javax.swing.JList<>();
        btnAddCart = new javax.swing.JButton();
        btnEditItem = new javax.swing.JButton();
        btnTotal = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        radioBtnDinein = new javax.swing.JRadioButton();
        radioBtnTakeAway = new javax.swing.JRadioButton();
        radioBtnPickUp = new javax.swing.JRadioButton();
        btnLogout = new javax.swing.JButton();
        btnSelectType = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        txtQty = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        textTotalAmount = new javax.swing.JTextField();
        txtReview = new java.awt.TextArea();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnBalanceNHistory = new javax.swing.JMenuItem();
        btnOrderHistory = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("jRadioButtonMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boxCategories.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Food", "Snack", "Beverage", " " }));
        boxCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCategoriesActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(lstFoodId);

        btnAddCart.setText("Add to cart");
        btnAddCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCartActionPerformed(evt);
            }
        });

        btnEditItem.setText("Delete Item");
        btnEditItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditItemActionPerformed(evt);
            }
        });

        btnTotal.setText("Total");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });

        btnPay.setText("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        jLabel1.setText("Food Menu");

        radioBtnDinein.setText("Dine In");
        radioBtnDinein.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnDineinActionPerformed(evt);
            }
        });

        radioBtnTakeAway.setText("Take Away");
        radioBtnTakeAway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnTakeAwayActionPerformed(evt);
            }
        });

        radioBtnPickUp.setText("Pick Up");
        radioBtnPickUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPickUpActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnSelectType.setText("Select Type");
        btnSelectType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectTypeActionPerformed(evt);
            }
        });

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Food", "Qty", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(invoiceTable);
        if (invoiceTable.getColumnModel().getColumnCount() > 0) {
            invoiceTable.getColumnModel().getColumn(0).setResizable(false);
            invoiceTable.getColumnModel().getColumn(1).setResizable(false);
            invoiceTable.getColumnModel().getColumn(2).setResizable(false);
            invoiceTable.getColumnModel().getColumn(3).setResizable(false);
            invoiceTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel2.setText("Qty");

        textTotalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTotalAmountActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        btnBalanceNHistory.setText("Balance and Transaction History");
        btnBalanceNHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalanceNHistoryActionPerformed(evt);
            }
        });
        jMenu1.add(btnBalanceNHistory);

        btnOrderHistory.setText("Order History");
        btnOrderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderHistoryActionPerformed(evt);
            }
        });
        jMenu1.add(btnOrderHistory);

        jMenuItem3.setText("Notification");
        jMenu1.add(jMenuItem3);

        jMenuBar.add(jMenu1);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boxCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(radioBtnDinein)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioBtnTakeAway)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioBtnPickUp)
                        .addGap(18, 18, 18)
                        .addComponent(btnSelectType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(476, 476, 476))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtReview, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddCart, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnEditItem, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(299, 299, 299))))
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioBtnDinein)
                    .addComponent(radioBtnTakeAway)
                    .addComponent(radioBtnPickUp)
                    .addComponent(btnLogout)
                    .addComponent(btnSelectType))
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTotal)
                            .addComponent(textTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtReview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddCart)
                        .addComponent(btnEditItem)
                        .addComponent(jLabel2)
                        .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(128, 128, 128))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCategoriesActionPerformed
        showFoodId();
    }//GEN-LAST:event_boxCategoriesActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        totalAmount();
    }//GEN-LAST:event_btnTotalActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void radioBtnPickUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPickUpActionPerformed
         cus = "Pick Up";
    }//GEN-LAST:event_radioBtnPickUpActionPerformed

    private void radioBtnTakeAwayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnTakeAwayActionPerformed
        cus = "Take  Away";
    }//GEN-LAST:event_radioBtnTakeAwayActionPerformed

    private void radioBtnDineinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnDineinActionPerformed
        cus = "Dine In";
    }//GEN-LAST:event_radioBtnDineinActionPerformed

    private void btnSelectTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectTypeActionPerformed
        JOptionPane.showMessageDialog(rootPane,"Your Select a "+cus+"!");
    }//GEN-LAST:event_btnSelectTypeActionPerformed

    private void btnBalanceNHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalanceNHistoryActionPerformed
        Credit c =new Credit();
        c.setVisible(true);
    }//GEN-LAST:event_btnBalanceNHistoryActionPerformed

    private void btnOrderHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderHistoryActionPerformed

        orderhistory historyWindow = new orderhistory(customer);
        historyWindow.setVisible(true);
    }//GEN-LAST:event_btnOrderHistoryActionPerformed

    private void textTotalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTotalAmountActionPerformed

    }//GEN-LAST:event_textTotalAmountActionPerformed

    private void btnAddCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCartActionPerformed
        addItemToCart();
    }//GEN-LAST:event_btnAddCartActionPerformed

    private void btnEditItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditItemActionPerformed
        editItemFromCart();
    }//GEN-LAST:event_btnEditItemActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        makePayment();
        //writeToFile();
    }//GEN-LAST:event_btnPayActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCategories;
    private javax.swing.JButton btnAddCart;
    private javax.swing.JMenuItem btnBalanceNHistory;
    private javax.swing.JButton btnEditItem;
    private javax.swing.JButton btnLogout;
    private javax.swing.JMenuItem btnOrderHistory;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnSelectType;
    private javax.swing.JButton btnTotal;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> lstFoodId;
    private javax.swing.JRadioButton radioBtnDinein;
    private javax.swing.JRadioButton radioBtnPickUp;
    private javax.swing.JRadioButton radioBtnTakeAway;
    private javax.swing.JTextField textTotalAmount;
    private javax.swing.JSpinner txtQty;
    private java.awt.TextArea txtReview;
    // End of variables declaration//GEN-END:variables
}
