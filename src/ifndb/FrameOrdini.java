/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ifndb;

import com.formdev.flatlaf.FlatLightLaf;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Reale
 */
public class FrameOrdini extends javax.swing.JFrame {

    /**
     * Creates new form FrameOrdiniperCliente
     */
    
    public FrameOrdini() {
        initComponents();
        try {
            //Orders:
            IFNDB.recoverFilterOrders(FilterCombo);
            IFNDB.recoverClientiCombo(IdClienteCombo);
            //Customers:
            IFNDB.recoverFilterCustomers(FilterCustomersCombo);
            IFNDB.recoverClientiCombo(IdCustomerCombo);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLayeredOrdini = new javax.swing.JLayeredPane();
        IdClienteCombo = new javax.swing.JComboBox<>();
        FilterCombo = new javax.swing.JComboBox<>();
        BTNVisualizza = new javax.swing.JButton();
        BTNElimina = new javax.swing.JButton();
        IdclienteLB1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        ClienteCheck = new javax.swing.JCheckBox();
        jLayeredClienti = new javax.swing.JLayeredPane();
        IdCustomerCombo = new javax.swing.JComboBox<>();
        FilterCustomersCombo = new javax.swing.JComboBox<>();
        BTNVisualizzaC = new javax.swing.JButton();
        BTNEliminaC = new javax.swing.JButton();
        IdclienteLB2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableC = new javax.swing.JTable();
        CompanyCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Northwind manager");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        IdClienteCombo.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        IdClienteCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        IdClienteCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IdClienteComboMouseClicked(evt);
            }
        });
        IdClienteCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdClienteComboActionPerformed(evt);
            }
        });

        FilterCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Discendente" }));
        FilterCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FilterComboMouseClicked(evt);
            }
        });
        FilterCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterComboActionPerformed(evt);
            }
        });

        BTNVisualizza.setBackground(new java.awt.Color(0, 153, 255));
        BTNVisualizza.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        BTNVisualizza.setForeground(new java.awt.Color(255, 255, 255));
        BTNVisualizza.setText("Visualizza");
        BTNVisualizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNVisualizzaActionPerformed(evt);
            }
        });

        BTNElimina.setBackground(new java.awt.Color(204, 0, 0));
        BTNElimina.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        BTNElimina.setForeground(new java.awt.Color(255, 255, 255));
        BTNElimina.setText("Elimina");
        BTNElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEliminaActionPerformed(evt);
            }
        });

        IdclienteLB1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        IdclienteLB1.setText("Ordina per:");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "OrderID", "CustomerID", "EmployeeID", "OrderDate"
            }
        ));
        table.setEditingRow(-1);
        table.setMaximumSize(new java.awt.Dimension(2147483647, 90));
        table.setShowGrid(true);
        jScrollPane1.setViewportView(table);

        ClienteCheck.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        ClienteCheck.setText("Filtra Cliente:");
        ClienteCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteCheckActionPerformed(evt);
            }
        });

        jLayeredOrdini.setLayer(IdClienteCombo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredOrdini.setLayer(FilterCombo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredOrdini.setLayer(BTNVisualizza, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredOrdini.setLayer(BTNElimina, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredOrdini.setLayer(IdclienteLB1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredOrdini.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredOrdini.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredOrdini.setLayer(ClienteCheck, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredOrdiniLayout = new javax.swing.GroupLayout(jLayeredOrdini);
        jLayeredOrdini.setLayout(jLayeredOrdiniLayout);
        jLayeredOrdiniLayout.setHorizontalGroup(
            jLayeredOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredOrdiniLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdclienteLB1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FilterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClienteCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdClienteCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jLayeredOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredOrdiniLayout.createSequentialGroup()
                        .addComponent(BTNElimina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTNVisualizza))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jLayeredOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredOrdiniLayout.createSequentialGroup()
                    .addGap(177, 177, 177)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(842, Short.MAX_VALUE)))
        );
        jLayeredOrdiniLayout.setVerticalGroup(
            jLayeredOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredOrdiniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 163, Short.MAX_VALUE))
            .addGroup(jLayeredOrdiniLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(IdclienteLB1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FilterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClienteCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IdClienteCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNElimina)
                    .addComponent(BTNVisualizza))
                .addContainerGap())
            .addGroup(jLayeredOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredOrdiniLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Ordini", jLayeredOrdini);

        IdCustomerCombo.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        IdCustomerCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        IdCustomerCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IdCustomerComboMouseClicked(evt);
            }
        });
        IdCustomerCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdCustomerComboActionPerformed(evt);
            }
        });

        FilterCustomersCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Discendente" }));
        FilterCustomersCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FilterCustomersComboMouseClicked(evt);
            }
        });
        FilterCustomersCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterCustomersComboActionPerformed(evt);
            }
        });

        BTNVisualizzaC.setBackground(new java.awt.Color(0, 153, 255));
        BTNVisualizzaC.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        BTNVisualizzaC.setForeground(new java.awt.Color(255, 255, 255));
        BTNVisualizzaC.setText("Visualizza");
        BTNVisualizzaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNVisualizzaCActionPerformed(evt);
            }
        });

        BTNEliminaC.setBackground(new java.awt.Color(204, 0, 0));
        BTNEliminaC.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        BTNEliminaC.setForeground(new java.awt.Color(255, 255, 255));
        BTNEliminaC.setText("Elimina");
        BTNEliminaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEliminaCActionPerformed(evt);
            }
        });

        IdclienteLB2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        IdclienteLB2.setText("Ordina per:");

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tableC.setAutoCreateRowSorter(true);
        tableC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CustomerID", "CompanyName", "ContactName", "ContactTitle"
            }
        ));
        tableC.setEditingRow(-1);
        tableC.setMaximumSize(new java.awt.Dimension(2147483647, 90));
        tableC.setShowGrid(true);
        jScrollPane2.setViewportView(tableC);

        CompanyCheck.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        CompanyCheck.setText("Filtra Cliente:");
        CompanyCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompanyCheckActionPerformed(evt);
            }
        });

        jLayeredClienti.setLayer(IdCustomerCombo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredClienti.setLayer(FilterCustomersCombo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredClienti.setLayer(BTNVisualizzaC, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredClienti.setLayer(BTNEliminaC, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredClienti.setLayer(IdclienteLB2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredClienti.setLayer(jSeparator2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredClienti.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredClienti.setLayer(CompanyCheck, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredClientiLayout = new javax.swing.GroupLayout(jLayeredClienti);
        jLayeredClienti.setLayout(jLayeredClientiLayout);
        jLayeredClientiLayout.setHorizontalGroup(
            jLayeredClientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredClientiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredClientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FilterCustomersCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CompanyCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdCustomerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdclienteLB2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jLayeredClientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredClientiLayout.createSequentialGroup()
                        .addComponent(BTNEliminaC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTNVisualizzaC))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jLayeredClientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredClientiLayout.createSequentialGroup()
                    .addContainerGap(173, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(846, Short.MAX_VALUE)))
        );
        jLayeredClientiLayout.setVerticalGroup(
            jLayeredClientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredClientiLayout.createSequentialGroup()
                .addGroup(jLayeredClientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredClientiLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(IdclienteLB2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FilterCustomersCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CompanyCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IdCustomerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredClientiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(jLayeredClientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNVisualizzaC)
                    .addComponent(BTNEliminaC))
                .addContainerGap())
            .addGroup(jLayeredClientiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredClientiLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Clienti", jLayeredClienti);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FilterComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilterComboMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_FilterComboMouseClicked

    private void IdCustomerComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IdCustomerComboMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_IdCustomerComboMouseClicked

    private void IdCustomerComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdCustomerComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdCustomerComboActionPerformed

    private void FilterCustomersComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilterCustomersComboMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_FilterCustomersComboMouseClicked

    private void FilterCustomersComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterCustomersComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FilterCustomersComboActionPerformed

    private void BTNVisualizzaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNVisualizzaCActionPerformed
        // TODO aaggiungere metodo per recuperare db customers
        try {
            String t = (String) FilterCustomersCombo.getSelectedItem();
            IFNDB.showCustomers((String) IdCustomerCombo.getSelectedItem(), t, tableC, CompanyCheck.isSelected());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,(String)e.getMessage(),"",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BTNVisualizzaCActionPerformed

    private void BTNEliminaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEliminaCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNEliminaCActionPerformed

    private void CompanyCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompanyCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CompanyCheckActionPerformed

    private void BTNEliminaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BTNEliminaActionPerformed
        // TODO add your handling code here:
        String t = (String) FilterCombo.getSelectedItem();
        IFNDB.deleteOrders(table);
        try{
            IFNDB.showOrders((String)IdClienteCombo.getSelectedItem(), t, table, ClienteCheck.isSelected());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"eliminazione fallita!","Errore",JOptionPane.ERROR_MESSAGE);
        }
        

    }// GEN-LAST:event_BTNEliminaActionPerformed

    private void BTNOrdinaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BTNOrdinaActionPerformed
        //
        try {
            IFNDB.recoverFilterOrders(FilterCombo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_BTNOrdinaActionPerformed

    private void IdClienteComboActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_IdClienteComboActionPerformed
        // TODO add your handling code here:

    }// GEN-LAST:event_IdClienteComboActionPerformed

    private void BTNVisualizzaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BTNVisualizzaActionPerformed
        // TODO add your handling code here:
        try {
            String t = (String) FilterCombo.getSelectedItem();
            IFNDB.showOrders((String) IdClienteCombo.getSelectedItem(), t, table, ClienteCheck.isSelected());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,(String)e.getMessage(),"",JOptionPane.WARNING_MESSAGE);
        }

    }// GEN-LAST:event_BTNVisualizzaActionPerformed

    private void FilterComboActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_FilterComboActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_FilterComboActionPerformed

    private void IdClienteComboMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_IdClienteComboMouseClicked
        // TODO add your handling code here:

    }// GEN-LAST:event_IdClienteComboMouseClicked

    private void ClienteCheckActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ClienteCheckActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_ClienteCheckActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameOrdini.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameOrdini.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameOrdini.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameOrdini.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FlatLightLaf.setup(); //look and feel setup
                new FrameOrdini().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNElimina;
    private javax.swing.JButton BTNEliminaC;
    public javax.swing.JButton BTNVisualizza;
    public javax.swing.JButton BTNVisualizzaC;
    private javax.swing.JCheckBox ClienteCheck;
    private javax.swing.JCheckBox CompanyCheck;
    private javax.swing.JComboBox<String> FilterCombo;
    private javax.swing.JComboBox<String> FilterCustomersCombo;
    private javax.swing.JComboBox<String> IdClienteCombo;
    private javax.swing.JComboBox<String> IdCustomerCombo;
    private javax.swing.JLabel IdclienteLB1;
    private javax.swing.JLabel IdclienteLB2;
    private javax.swing.JLayeredPane jLayeredClienti;
    private javax.swing.JLayeredPane jLayeredOrdini;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable table;
    private javax.swing.JTable tableC;
    // End of variables declaration//GEN-END:variables
}
