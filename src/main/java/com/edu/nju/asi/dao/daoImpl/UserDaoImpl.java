package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.UserDao;
import com.edu.nju.asi.model.Address;
import com.edu.nju.asi.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.xml.ws.soap.Addressing;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017/7/16 0016.
 */
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

    public static void main(String[] args) {
        UserDao userDao = new ClassPathXmlApplicationContext("applicationContext.xml").getBean(UserDao.class);
//        userDao.createCollection("law");
        Map<String, String> name = new TreeMap<>();
        name.put("asdf", "1234");
        name.put("qqwer", "qwer");

        Address address = new Address("qwer", 134);

//        userDao.insert(new User(address, name,"123",LocalDate.of(1970,1,1)), "law");

        Map<String, Object> map = new TreeMap<>();
        map.put("password", "47756");
        User user = userDao.findOne(map, "law");
        System.out.println(user.localDate);
    }

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(User object, String collectionName) {
        mongoTemplate.insert(object, collectionName);
    }

    @Override
    public User findOne(Map<String,Object> params, String collectionName) {
        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(new Address("qwer", 134))), User.class,collectionName);
    }

    @Override
    public List<User> findAll(Map<String,Object> params, String collectionName) {
        List<User> result = mongoTemplate.find(new Query(Criteria.where("age").lt(params.get("maxAge"))), User.class,collectionName);
        return result;
    }

    @Override
    public void update(Map<String,Object> params,String collectionName) {
        mongoTemplate.upsert(new Query(Criteria.where("id").is(params.get("id"))), new Update().set("name", params.get("name")), User.class,collectionName);
    }

    @Override
    public void createCollection(String name) {
        mongoTemplate.createCollection(name);
    }

    @Override
    public void remove(Map<String, Object> params,String collectionName) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(params.get("id"))),User.class,collectionName);
    }

    @Override
    public int getColletions() {
        return mongoTemplate.getCollectionNames().size();
    }

}
