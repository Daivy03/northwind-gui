/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ifndb;

import java.awt.Dimension;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Reale
 */
public class IFNDB {
    private static String user = "root";
    private static String password = "";

    /**
     * @param args the command line arguments
     */
    
    public static void showOrders(String clientId, String filterBy, JTable table, Boolean c){
        ResultSet rs = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", user, password);

        String companyName = clientId;
        String query = "SELECT CustomerID FROM customers WHERE CompanyName = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, companyName);
        ResultSet resultSet = statement.executeQuery();
        String customerID = null;
        if (resultSet.next()) {
            customerID = resultSet.getString("CustomerID");
        }

        String quer;
        if (filterBy.equalsIgnoreCase("CustomerID") && !c) {
            quer = "SELECT * FROM orders\n" +
                    "INNER JOIN customers on customers.CustomerID = orders.CustomerID\n" +
                    "ORDER BY customers.CustomerID ASC";
        } else if (c) {
            quer = "SELECT orders.* FROM orders\n" +
                    "INNER JOIN customers on orders.CustomerID = customers.CustomerID\n" +
                    "WHERE customers.CustomerID = ? "+
                    "ORDER BY orders."+ filterBy + " ASC";
        } else {
            quer = "SELECT * FROM orders\n" +
                    "ORDER BY orders." + filterBy + " ASC";
        }

        PreparedStatement stmt = con.prepareStatement(quer);
        if (c) {
            stmt.setString(1, customerID);
        }
        rs = stmt.executeQuery();

        DefaultTableModel tableModel = new DefaultTableModel(){
            //impedire la modifica (solo visibile) delle righe
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        int columnCount = rs.getMetaData().getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            tableModel.addColumn(rs.getMetaData().getColumnName(i));
        }

        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            tableModel.addRow(row);
        }

        table.setModel(tableModel);

        for (int i = 1; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(100);
        }

        table.setEnabled(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = (JScrollPane) table.getParent().getParent();
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Aggiorna il contenitore principale della tabella per far sì che venga ridisegnata
        table.getParent().validate();

        // Chiude la connessione al database
        con.close();
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    }
    public static void showCustomers(String clientId, String filterBy, JTable table, Boolean c){
        ResultSet rs = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", user, password);

        String companyName = clientId;
        String query = "SELECT CustomerID FROM customers WHERE CompanyName = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, companyName);
        ResultSet resultSet = statement.executeQuery();
        String customerID = null;
        if (resultSet.next()) {
            customerID = resultSet.getString("CustomerID");
        }

        String quer;
        if (filterBy.equalsIgnoreCase("CustomerID") && !c) {
            quer = "SELECT * FROM customers\n" +
                    "ORDER BY customers.CustomerID ASC";
        } else if (c) {
            quer = "SELECT * FROM customers\n" +
                    "WHERE customers.CustomerID = ? "+
                    "ORDER BY customers."+ filterBy + " ASC";
        } else {
            quer = "SELECT * FROM customers\n" +
                    "ORDER BY customers." + filterBy + " ASC";
        }

        PreparedStatement stmt = con.prepareStatement(quer);
        if (c) {
            stmt.setString(1, customerID);
        }
        rs = stmt.executeQuery();

        DefaultTableModel tableModel = new DefaultTableModel(){
            //impedire la modifica (solo visibile) delle righe
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        int columnCount = rs.getMetaData().getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            tableModel.addColumn(rs.getMetaData().getColumnName(i));
        }

        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            tableModel.addRow(row);
        }

        table.setModel(tableModel);

        for (int i = 1; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(200);
        }

        table.setEnabled(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = (JScrollPane) table.getParent().getParent();
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Aggiorna il contenitore principale della tabella per far sì che venga ridisegnata
        table.getParent().validate();

        // Chiude la connessione al database
        con.close();
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    }
    
    public static void deleteOrders(JTable table) {
       
        int[] selectedRows = table.getSelectedRows();
        int columnCount = table.getColumnCount();
        ArrayList<String> ordersId = new ArrayList<>();

        ArrayList<ArrayList<Object>> selectedCells = new ArrayList<>();
        for (int i = 0; i < selectedRows.length; i++) {
            ArrayList<Object> row = new ArrayList<>();
            for (int j = 0; j < columnCount; j++) {
                row.add(table.getValueAt(selectedRows[i], j));
            }
            selectedCells.add(row);
        }

        
        for (ArrayList<Object> row : selectedCells) {
            ordersId.add(row.get(0).toString());
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", user, password);
            Statement stmt = con.createStatement();
            int rowsupdated=0;

            
            for (String orderId : ordersId) {
                String query = "DELETE FROM orders WHERE OrderID = " + orderId;
                rowsupdated = stmt.executeUpdate(query);
                if (rowsupdated>0) {
            JOptionPane.showMessageDialog(null, "Ordine eliminato!");
}
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static ArrayList<String> recoverCompany() throws Exception {
        ArrayList<String> company = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", user, password);
        Statement stmt = con.createStatement();
        String query = "SELECT CompanyName from customers";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String name = rs.getString("CompanyName");
            company.add(name);
        }
        return company;
    }
    
    public static ArrayList<String> recoverOrders() throws Exception {
        ArrayList<String> ordini = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", user, password);
        Statement stmt = con.createStatement();
        String query = "SELECT OrderID from orders";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String name = rs.getString("OrderId");
            ordini.add(name);
        }
        return ordini;
    }

    public static void recoverClientiCombo(JComboBox IdClienteCombo) {
        ArrayList<String> list = new ArrayList();

        try {
            list = IFNDB.recoverCompany();
        } catch (Exception e) {
        }

        String[] clienti = list.toArray(new String[list.size()]);
        DefaultComboBoxModel model = (DefaultComboBoxModel) IdClienteCombo.getModel();
        model.removeAllElements();
       
        for (String item : clienti) {
            model.addElement(item);
        }
        
        
    }

    public static void recoverFilterOrders(JComboBox combo) {
        String query = "SELECT COLUMN_NAME AS Field \n" +
                "FROM information_schema.columns \n" +
                "WHERE table_name = 'orders' \n" +
                "AND COLUMN_NAME NOT IN \n" +
                "  (SELECT COLUMN_NAME \n" +
                "   FROM orders \n" +
                "   WHERE COLUMN_NAME IS NULL);";
        ArrayList<String> colonne = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("Field");
                colonne.add(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "recupero ordini fallito!","Errore",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            
        }
        // imposto combobox con le colonne recuperate

        String[] cols = colonne.toArray(new String[colonne.size()]);
        DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
        model.removeAllElements();
        for (String item : cols) {
            model.addElement(item);
        }

    }
    public static void recoverFilterCustomers(JComboBox combo) {
        String query = "SELECT COLUMN_NAME AS Field \n" +
                "FROM information_schema.columns \n" +
                "WHERE table_name = 'customers' \n" +
                "AND COLUMN_NAME NOT IN \n" +
                "  (SELECT COLUMN_NAME \n" +
                "   FROM customers \n" +
                "   WHERE COLUMN_NAME IS NULL);";
        ArrayList<String> colonne = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("Field");
                colonne.add(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "recupero ordini fallito!","Errore",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            
        }
        // imposto combobox con le colonne recuperate

        String[] cols = colonne.toArray(new String[colonne.size()]);
        DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
        model.removeAllElements();
        for (String item : cols) {
            model.addElement(item);
        }

    }

    public static void main(String[] args) {
    }

}
