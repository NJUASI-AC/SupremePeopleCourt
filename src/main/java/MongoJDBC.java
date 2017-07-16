import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

/**
 * Created by Administrator on 2017/7/16 0016.
 */
public class MongoJDBC {
    public static void main(String[] args) {
        try {
            DB db = new MongoClient().getDB("test");
            Jongo jongo = new Jongo(db);

            MongoCollection friends = jongo.getCollection("friends");

            MongoCursor<Friend> all = friends.find("{name: 'Joe'}").as(Friend.class);
            Friend one = friends.findOne("{name: 'Joe'}").as(Friend.class);

            System.out.println(one.getAge());
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
