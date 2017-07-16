import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.junit.Test;


/**
 * Created by Administrator on 2017/7/16 0016.
 */
public class TestMongodb {
    @Test
    public void testMongodb(){
        try{
            //连接到mongodb服务
            MongoClient mongo = new MongoClient("127.0.0.1", 27017);
            //根据mongodb数据库的名称获取mongodb对象
            MongoDatabase db = mongo.getDatabase("test");
            MongoIterable<String> collectionNames = db.listCollectionNames();
            MongoCursor<String> cursor = collectionNames.iterator();
            while(cursor.hasNext()){
                System.out.println("collectionName==="+cursor.next());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
