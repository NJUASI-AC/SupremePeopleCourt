package com.edu.nju.asi.dao.daoImpl;

import com.edu.nju.asi.InfoCarrier.Case;
import com.edu.nju.asi.InfoCarrier.RecommendCase;
import com.edu.nju.asi.dao.DaoManager;
import com.edu.nju.asi.dao.DataManagerDao;
import com.edu.nju.asi.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Byron Dong on 2017/7/19.
 */
@Repository("DataManagerDaoImpl")
public class DataManagerDaoImpl implements DataManagerDao {

    /**
     * 获取推荐案例信息
     *
     *
     * @param actionCode 案号
     * @return RecommendCase
     */
    @Override
    public List<RecommendCase> getRecommendCase(String actionCode) {
        List<RecommendCase> recommendCases =  new ArrayList<>();
        Map<String, Proceedings> map = DaoManager.proceedingsDao.findAll(actionCode);
        if(!map.isEmpty()) {
            Map<String, Header> headers=  DaoManager.headerDao.findAll(map.keySet());
            Map<String, CaseBasic> caseBasics = DaoManager.caseBasicDao.findAll(map.keySet());
            Map<String, RefereeAnalysisProcess> refereeAnalysisProcesses = DaoManager.refereeAnalysisProcessDao.findAll(map.keySet());

            for (String caseID : map.keySet()) {
                CaseBasic caseBasic = caseBasics.get(caseID);
                RefereeAnalysisProcess refereeAnalysisProcess = refereeAnalysisProcesses.get(caseID);
                recommendCases.add(new RecommendCase(caseBasic, map.get(caseID), refereeAnalysisProcess,headers.get(caseID)));
            }
        }
        return recommendCases;
    }

    /**
     * 获取推荐案例信息
     *
     * @param caseIDS 案件ID集合
     * @return List<Case> 那件
     */
    @Override
    public List<Case> getCase(List<String> caseIDS) {
        List<Case> cases = new ArrayList<>();
        for(String caseID: caseIDS){
            FullText fullText = DaoManager.fullTextDao.find(caseID);
            Header header = DaoManager.headerDao.find(caseID);
            CaseBasic caseBasic = DaoManager.caseBasicDao.find(caseID);
            JudgementResult judgementResult = DaoManager.judgementResultDao.find(caseID);
            LitigationParticipants litigationParticipants = DaoManager.litigationParticipantsDao.find(caseID);
            Proceedings proceedings = DaoManager.proceedingsDao.find(caseID);
            RefereeAnalysisProcess refereeAnalysisProcess = DaoManager.refereeAnalysisProcessDao.find(caseID);
            Case case_need = new Case(fullText,header,litigationParticipants,proceedings,caseBasic,refereeAnalysisProcess,judgementResult);
            cases.add(case_need);
        }
        return cases;
    }
}
