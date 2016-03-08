package examendebroma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author oracle
 */
public class OracleConnection {

    public static Connection conexion = null;
    private static ResultSet rs;
    private static ResultSetMetaData metaDatos;
    private static String[][] datosDevueltos;
    private static String[] nombresColumnas;

    public OracleConnection() throws SQLException {
        conexion = getConexion();
    }

    public static Connection getConexion() throws SQLException {
        String usuario = "hr";
        String password = "hr";
        String host = "localhost"; // tambien puede ser una ip como "192.168.1.14"
        String puerto = "1521";
        String sid = "orcl";
        String ulrjdbc = "jdbc:oracle:thin:" + usuario + "/" + password + "@" + host + ":" + puerto + ":" + sid;

        conexion = DriverManager.getConnection(ulrjdbc);
        return conexion;
    }

    public static void closeConexion() throws SQLException {
        conexion.close();
        System.out.println("Cliente oracle cerrado");
    }

}
