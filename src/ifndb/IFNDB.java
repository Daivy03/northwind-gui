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

    /**
     * @param args the command line arguments
     */
    public static void cercaCliente(String st, String FAsc) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "davide", "davide");

        Statement stmt = con.createStatement();
        ResultSet rs = null;

        // Esegue la query per selezionare i dati dalla tabella clienti
        // ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
        // if(FAsc.equalsIgnoreCase("Ascendente")){
        // rs = stmt.executeQuery("SELECT * from orders\n" +
        // "INNER JOIN customers on customers.CustomerID = orders.CustomerID\n" +
        // "WHERE customers.CustomerID LIKE\""+st+"\""+"\nORDER BY orders.OrderDate
        // ASC");
        // }else if(FAsc.equalsIgnoreCase("Discendente")){
        // rs = stmt.executeQuery("SELECT * from orders\n" +
        // "INNER JOIN customers on customers.CustomerID = orders.CustomerID\n" +
        // "WHERE customers.CustomerID LIKE\""+st+"\""+"\nORDER BY orders.OrderDate
        // DESC");
        // }else if(){
        //
        // }

        switch (FAsc) {
            case "CustomerID":
                String quer = "SELECT * FROM orders\n" +
                        "INNER JOIN customers on customers.CustomerID = orders.CustomerID\n" +
                        "ORDER BY customers.CustomerID ASC";
                stmt.executeQuery(quer);
                break;
            case "OrderDate":
                quer = "SELECT * FROM orders\n" +
                        "ORDER BY orders.OrderDate ASC";
                stmt.executeQuery(quer);
                break;
            case "ShipName":
                quer = "SELECT * FROM orders\n" +
                        "ORDER BY orders.ShipName ASC";
                stmt.executeQuery(quer);
                break;
            case "ShipCountry":
                quer = "SELECT * FROM orders\n" +
                        "ORDER BY orders. ASC";
                stmt.executeQuery(quer);
                break;
        }

        System.out.println(rs);
        // ResultSet rs = stmt.executeQuery("SELECT * from orders\n" +
        // "INNER JOIN customers on customers.CustomerID = orders.CustomerID\n" +
        // "WHERE customers.CustomerID LIKE\""+st+"\""+"\nORDER BY customers.CustomerID
        // ASC");

        // Crea un modello di tabella
        DefaultTableModel tableModel = new DefaultTableModel();
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

        JTable table = new JTable(tableModel);
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(100);
        }

        table.setEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 200));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JFrame frame = new JFrame("Risultati");
        frame.setContentPane(scrollPane);
        frame.pack();
        frame.setVisible(true);

        // Chiude la connessione al database
        con.close();
    }

    public static void showOrders(String clientId, String filterBy, JTable table, Boolean c)
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "davide", "davide");

        Statement stmt = con.createStatement();
        ResultSet rs = null;
        String quer;

        if (filterBy.equalsIgnoreCase("CustomerID") && c == false) {
            quer = "SELECT * FROM orders\n" +
                    "INNER JOIN customers on customers.CustomerID = orders.CustomerID\n" +
                    "ORDER BY customers.CustomerID ASC";
            rs = stmt.executeQuery(quer);
        } else if (c == true) {
            quer = "SELECT * FROM orders\n" +
                    "INNER JOIN customers on customers.CustomerID = orders.CustomerID\n" +
                    "WHERE customers.CustomerID LIKE \"" + clientId + "\"";
            rs = stmt.executeQuery(quer);
        } else {
            quer = "SELECT * FROM orders\n" +
                    "ORDER BY orders." + filterBy + " ASC";
            rs = stmt.executeQuery(quer);
        }

        // switch(FAsc){
        // case "CustomerID":
        //
        // break;
        // case "OrderDate":
        //
        // break;
        // case "ShipName":
        // quer = "SELECT * FROM orders\n" +
        // "ORDER BY orders.ShipName ASC";
        // rs = stmt.executeQuery(quer);
        // break;
        // case "ShipCountry":
        // quer = "SELECT * FROM orders\n" +
        // "ORDER BY orders. ASC";
        // rs = stmt.executeQuery(quer);
        // break;
        //
        // }

        DefaultTableModel tableModel = new DefaultTableModel();
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

        // Non creare un nuovo frame, ma utilizzare la tabella esistente
        JScrollPane scrollPane = (JScrollPane) table.getParent().getParent();
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Aggiorna il contenitore principale della tabella per far sì che venga
        // ridisegnata
        table.getParent().validate();

        // Chiude la connessione al database
        con.close();

    }
    // metodo per selezionare righe con checkbox true
    // public ArrayList<Object[]> getRigheSelezionate(DefaultTableModel tableModel)
    // {
    // ArrayList<Object[]> selectedRows = new ArrayList<>();
    // for (int i = 0; i < tableModel.getRowCount(); i++) {
    // Boolean isChecked = (Boolean) tableModel.getValueAt(i, 0);
    // if (isChecked) {
    // Object[] row = new Object[tableModel.getColumnCount()];
    // for (int j = 0; j < tableModel.getColumnCount(); j++) {
    // row[j] = tableModel.getValueAt(i, j);
    // }
    // selectedRows.add(row);
    // }
    // }
    // return selectedRows;
    // }

    // metodo seleziona celle e dati contenuti
    public static void deleteOrders(JTable table) {
        // String query = "DELETE FROM orders where OrderID like " + OrderID;
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

        // Estrai i dati della prima colonna e aggiungili all'ArrayList ordersId
        for (ArrayList<Object> row : selectedCells) {
            ordersId.add(row.get(0).toString()); // 0 rappresenta l'indice della prima colonna
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "davide", "davide");
            Statement stmt = con.createStatement();
            int rowsupdated=0;

            // Esegui la query di eliminazione per ogni orderId presente in ordersId
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

    public static ArrayList<String> recoverClienti() throws Exception {
        ArrayList<String> clienti = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "davide", "davide");
        Statement stmt = con.createStatement();
        String query = "SELECT CustomerID from customers";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String name = rs.getString("CustomerId");
            clienti.add(name);
        }
        return clienti;
    }

    public static ArrayList<String> recoverCompany() throws Exception {
        ArrayList<String> company = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "davide", "davide");
        Statement stmt = con.createStatement();
        String query = "SELECT CompanyName from customers";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String name = rs.getString("CompanyName");
            company.add(name);
        }
        return company;
    }

    public static String getCustomerID(String t) throws Exception {
        String s = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "davide", "davide");
        Statement st2 = con.createStatement();

        ResultSet rs2 = st2.executeQuery("SELECT customers.CustomerID from customers" +
                "WHERE CompanyName = " + t + "");

        s = rs2.getString(1);

        return s;
    }

    public static void cercaCompagnia(String st, String cID) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "davide", "davide");

        Statement stmt = con.createStatement();
        String companyid = null;

        Statement st2 = con.createStatement();
        if (st != null) {
            ResultSet rs2 = st2.executeQuery("SELECT customers.CustomerID from customers" +
                    "WHERE CompanyName = " + st + "");

            companyid = rs2.getString(1);

        }

        System.out.println(companyid);
        ResultSet rs = stmt.executeQuery("SELECT * from orders\n" +
                "INNER JOIN customers on customers.CustomerID = orders.CustomerID\n" +
                "WHERE customers.CustomerID LIKE\"" + cID + "\"");

        // Crea un modello di tabella
        DefaultTableModel tableModel = new DefaultTableModel();
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

        JTable table = new JTable(tableModel);
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(100);
        }

        table.setEnabled(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 200));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JFrame frame = new JFrame("Risultati per " + st);
        frame.setContentPane(scrollPane);
        frame.pack();
        frame.setVisible(true);

        // Chiude la connessione al database
        con.close();
    }

    public static void cercaOrdini(String st) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "davide", "davide");

        Statement stmt = con.createStatement();

        // Esegue la query per selezionare i dati dalla tabella clienti
        // ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
        ResultSet rs = stmt.executeQuery("SELECT * from orders\n" +
                "INNER JOIN customers on customers.CustomerID = orders.CustomerID\n" +
                "WHERE orders.OrderID LIKE\"" + st + "\"");

        // Crea un modello di tabella
        DefaultTableModel tableModel = new DefaultTableModel();
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

        JTable table = new JTable(tableModel);
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(100);
        }

        table.setEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 200));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JFrame frame = new JFrame("Risultati");
        frame.setContentPane(scrollPane);
        frame.pack();
        frame.setVisible(true);

        // Chiude la connessione al database
        con.close();
    }

    public static ArrayList<String> recoverOrders() throws Exception {
        ArrayList<String> ordini = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "davide", "davide");
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
            list = IFNDB.recoverClienti();
        } catch (Exception e) {
        }

        String[] clienti = list.toArray(new String[list.size()]);
        DefaultComboBoxModel model = (DefaultComboBoxModel) IdClienteCombo.getModel();
        // DefaultComboBoxModel model2 = (DefaultComboBoxModel)
        // FilterOrderCombo.getModel();
        // removing old data
        model.removeAllElements();
        // JComboBox listcustomers = new JComboBox(clienti);
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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "davide", "davide");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("Field");
                colonne.add(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Errore recupero ordini");
        }
        // imposto combobox con le colonne recuperate

        String[] cols = colonne.toArray(new String[colonne.size()]);
        DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
        model.removeAllElements();
        // JComboBox list = new JComboBox(cols);
        for (String item : cols) {
            model.addElement(item);
        }

    }

    public static void main(String[] args) {

    }

}
