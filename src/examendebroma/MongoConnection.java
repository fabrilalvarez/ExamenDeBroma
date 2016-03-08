package examendebroma;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author oracle
 */
public class MongoConnection {

    MongoClient cliente = null;
    MongoDatabase db = null;
    MongoCollection collections = null;
    Pedido17 pedido;

    public MongoConnection(String database) {
        conectar(database);
    }

    public ArrayList<Pedido17> consulta(String collection) {
        this.collections = db.getCollection(collection);
        System.out.println("Conectado a db." + collection);
        ArrayList<Pedido17> pedidos = new ArrayList<>();
        // Instanciamos el pedido
        // Hacemos la consulta
        //BasicDBObject consulta = new BasicDBObject(campo, contenido);
        // le damos un cursor Iterable
        FindIterable cursor = this.collections.find();
        // Iteramos para recorrer
        MongoCursor<Document> iterator = cursor.iterator();
        while (iterator.hasNext()) {
            pedido = new Pedido17();
            Document document = iterator.next();
            pedido.setCodcli(document.getString("codcli"));
            pedido.setCodpro(document.getString("codpro"));
            pedido.setCantidade(document.getDouble("cantidade"));
            pedido.setData(document.getString("data"));
            pedidos.add(pedido);
        }
        return pedidos;
    }

    public void conectar(String database) {
        this.cliente = new MongoClient("localhost", 27017);
        System.out.println("Conexión realizada");
        this.db = cliente.getDatabase(database);
        System.out.println("Conectado a db " + database);
    }

    public void cerrar() {
        cliente.close();
        System.out.println("cliente mongo cerrado");
    }
}
