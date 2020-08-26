package Inicio;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author CODICUS
 */
public class Conexion {

    private static Connection connection;
    private static String URI = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String USR = "JAVA";
    private static String PASS = "JAVA";

    static {
        connection = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("DRIVERS LISTOS ****************!");
            try {
                connection = DriverManager.getConnection(URI, USR, PASS);
                System.out.println("CONECTADO ****************!");
            } catch (SQLException sqlex) {
                System.out.println("No logramos instanciar una conexión!");
                sqlex.printStackTrace();
            }
        } catch (ClassNotFoundException cnfe) {
            System.out.println("No logramos instanciar una conexión!");
            cnfe.getMessage();
        }
    }
    
    public static Connection getConnection(){
        return connection;
    }

    public void cerrarConexion() {
        // CERRANDO LA CONEXIÓN
        try {
            connection.close();
            System.out.println("Conexión cerrada con éxito, ya no es posible acceder a la base de datos!");
        } catch (SQLException sqlex) {
            System.out.println("Error al cerrar la conexión!");
            sqlex.printStackTrace();
            return;
        }
    }
}
