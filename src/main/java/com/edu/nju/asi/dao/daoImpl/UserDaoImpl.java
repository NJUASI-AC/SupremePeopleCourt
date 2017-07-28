package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.dao.UserDao;
import com.edu.nju.asi.model.Case;
import com.edu.nju.asi.model.UploadCase;
import com.edu.nju.asi.model.UploadCaseID;
import com.edu.nju.asi.model.User;
import com.edu.nju.asi.utilities.exception.RedundancyCaseException;
import com.edu.nju.asi.utilities.exception.UserExistedException;
import com.edu.nju.asi.utilities.exception.UserNotExistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Byron Dong on 2017/7/27.
 */
@Repository("UserDaoImpl")
public class UserDaoImpl implements UserDao {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private String collectionName = "User";

    private String upload_collectionName = "UploadCase";

    /**
     * 添加
     *
     * @param user 要插入的对象
     */
    @Override
    public void insert(User user) throws UserExistedException {

        if (this.find(user.getWorkID()) != null) {
            throw new UserExistedException();
        }

        mongoTemplate.insert(user, collectionName);
    }

    /**
     * 根据条件查找一个
     *
     * @param workID 案件名称
     * @return User
     */
    @Override
    public User find(String workID) {
        Query query = new Query(Criteria.where("workID").is(workID));
        User user = mongoTemplate.findOne(query, User.class, collectionName);
        return user;
    }

    /**
     * 需改
     *
     * @param user 要修改的对象
     */
    @Override
    public void update(User user) throws UserNotExistedException {

        if (this.find(user.getWorkID()) == null) {
            throw new UserNotExistedException();
        }
        Query query = new Query(Criteria.where("workID").is(user.getWorkID()));
        Update update = Update.update("name", user.getName()).set("subordinationCourt", user.getSubordinationCourt());
        mongoTemplate.upsert(query, update, User.class, collectionName);
    }

    /**
     * 注销用户
     *
     * @param workID 案件名称
     * @return User
     */
    @Override
    public void delete(String workID) throws UserNotExistedException {
        if (this.find(workID) == null) {
            throw new UserNotExistedException();
        }
        Query query = new Query(Criteria.where("workID").is(workID));
        mongoTemplate.remove(query,User.class, collectionName);
    }

    /**
     * 上传案例
     *
     * @param case_need 需要添加的case
     * @param workID 法官工号
     */
    @Override
    public  void uploadCase(Case case_need, String workID) throws UserNotExistedException, RedundancyCaseException {
        User user = this.find(workID);
        if(user==null){
            throw new UserNotExistedException();
        }

        List<String> caseIDs = user.getCaseIDs();
        if(caseIDs.contains(case_need.getCaseID())){
            throw new RedundancyCaseException();
        }

        Query query = new Query(Criteria.where("workID").is(user.getWorkID()));
        Update update = Update.update("caseIDs", user.getCaseIDs());
        mongoTemplate.upsert(query, update, User.class, collectionName);

        UploadCase uploadCase = new UploadCase(new UploadCaseID(workID,case_need.getCaseID()),case_need);
        mongoTemplate.insert(uploadCase, upload_collectionName);
    }

    /**
     * 获取当前用户的所有上传案例
     *
     * @param workID 法官工号
     * @return List<Case>
     */
    @Override
    public List<Case> getAllCase(String workID) throws UserNotExistedException {
        User user = this.find(workID);
        if(user==null){
            throw new UserNotExistedException();
        }

        List<String> caseIDs = user.getCaseIDs();
        List<Case> caseList = new ArrayList<>();
        for(String caseID:caseIDs){
            Query query = new Query(Criteria.where("uploadCaseID").is(new UploadCaseID(workID, caseID)));
            caseList.add(mongoTemplate.findOne(query,UploadCase.class, upload_collectionName).getUploadCase());
        }
        return caseList;
    }

    /**
     * 删除集合
     */
    @Override
    public void dropCollection() {
        mongoTemplate.dropCollection(collectionName);
    }
}
