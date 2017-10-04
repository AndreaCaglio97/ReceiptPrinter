package it.intre.ReceiptPrinter.database;

import it.intre.ReceiptPrinter.models.Category;
import it.intre.ReceiptPrinter.models.Product;

import java.sql.*;
import java.util.Properties;

public class DBManager {

    public static void closeConnectionToDB() {
        ConnectionManager connSingleton = ConnectionManager.getConnectionSingleton();
        connSingleton.closeConnectionToDB();
    }

    public static void viewTable(Connection conn)  {

        Statement stmt = null;
        String query = "SELECT  name,  price, category\n" +
                        "FROM product\n" +
                        "WHERE is_imported = true\n" +
                        "ORDER BY id_product";
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                Category category =  Category.valueOf(rs.getString("category"));
                System.out.println(name + "\t" + price + "\t" + category);
            }
        } catch (SQLException e ) {
            System.out.println("ERROR! query NOT successfully completed");
        } finally {
            SQLExceptionHandling(stmt);
        }
    }

    public static Product productFromDB(int id_product)  {
        ConnectionManager connManager = ConnectionManager.getConnectionSingleton();
        Statement stmt = connManager.createStatement();
        Product product = null;
        String query = "SELECT  *\n" +
                "FROM product\n" +
                "WHERE id_product = " + id_product;
        try {
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            String name = rs.getString("name");
            boolean isImported = rs.getBoolean("is_imported");
            double price = rs.getDouble("price");
            Category category =  Category.valueOf(rs.getString("category"));
            product = new Product(name,isImported,price,category,1);
        } catch (SQLException e ) {
            System.err.println("ERROR! query NOT successfully completed");
        } finally {
            SQLExceptionHandling(stmt);
        }
        return product;
    }

    private static void SQLExceptionHandling(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e){
            System.err.println("ERROR! query NOT successfully completed");
        }
    }

}
