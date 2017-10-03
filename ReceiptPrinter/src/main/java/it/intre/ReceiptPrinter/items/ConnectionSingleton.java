package it.intre.ReceiptPrinter.items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionSingleton {
    private static ConnectionSingleton connSingleton;
    private Connection conn;

    private ConnectionSingleton()
    {
    }

    public Connection getConnection()
    {
        return conn;
    }

    public static ConnectionSingleton getConnectionSingleton()
    {
        if (connSingleton == null)
        {
            connSingleton = new ConnectionSingleton();
            try {
                String url = "jdbc:postgresql://localhost:5432/receiptdb";
                Properties props = new Properties();
                props.setProperty("user", "postgres");
                props.setProperty("password", "intre$2017");

                connSingleton.conn = DriverManager.getConnection(url, props);

                System.out.println("Successful connection");

            }catch (SQLException e) {
                System.out.println("ERROR! Connection NOT successfully completed");
            }
        }

        return connSingleton;
    }

    public void CloseConnectionToDB() {
        try {
            conn.close();
            System.out.println("Successful close connection");
        }catch (SQLException e) {
            System.out.println("ERROR! Close connection NOT successfully completed");
        }
    }
}
