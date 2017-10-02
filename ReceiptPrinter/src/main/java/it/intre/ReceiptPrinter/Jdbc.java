package it.intre.ReceiptPrinter;



import java.sql.*;
import java.util.Properties;

public class Jdbc {

    public static void connectionToDB() {
        try {
            String url = "jdbc:postgresql://localhost:5432/receiptdb";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "intre$2017");

            Connection conn = DriverManager.getConnection(url, props);

            System.out.println("Test di connessione avvenuto con successo");

            viewTable(conn);

            conn.close();
        }catch (SQLException e) {
            System.out.println("ERRORE! Test di connessione NON avvenuto con successo");
        }
    }

    public static void viewTable(Connection conn) throws SQLException {

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
            System.out.println("ERRORE! query NON eseguita con successo");
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }

}
