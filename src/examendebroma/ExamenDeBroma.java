package examendebroma;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oracle
 */
public class ExamenDeBroma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        OracleConnection oracle = new OracleConnection();
        MongoConnection mongo = new MongoConnection("tenda");
        ArrayList<Pedido17> pedidos = new ArrayList<>();
        pedidos = mongo.consulta("pedidos");
        System.out.println("************************************************");
        System.out.println("IMPRIMO EL ARRAYLIST PEDIDOS DESDE EL MAIN");
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println(pedidos.get(i));
        }
        System.out.println("************************************************");
        oracle.closeConexion();
        mongo.cerrar();
    }

}
