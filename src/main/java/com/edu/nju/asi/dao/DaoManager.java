package com.edu.nju.asi.dao;

import com.edu.nju.asi.utilities.ApplicationContextHelper;
import org.springframework.context.ApplicationContext;

/**
 * Created by Byron Dong on 2017/7/17.
 */
public class DaoManager {

    /**
     *  案件基本情况Dao
     */
    public final static CaseBasicDao caseBasicDao;

    /**
     *  分析需要Dao
     */
    public final static DataManagerDao dataManagerDao;

    /**
     *  全文Dao
     */
    public final static FullTextDao fullTextDao;

    /**
     *  文首Dao
     */
    public final static HeaderDao headerDao;

    /**
     *  判决结果Dao
     */
    public final static JudgementResultDao judgementResultDao;

    /**
     *  诉讼参与人Dao
     */
    public final static LitigationParticipantsDao litigationParticipantsDao;

    /**
     *  诉讼记录Dao
     */
    public final static ProceedingsDao proceedingsDao;

    /**
     *  裁判分析过程Dao
     */
    public final static RefereeAnalysisProcessDao refereeAnalysisProcessDao;

    private DaoManager() {
    }

    static {
        ApplicationContext applicationContext = ApplicationContextHelper.getApplicationContext();
        caseBasicDao = applicationContext.getBean(CaseBasicDao.class);
        dataManagerDao = applicationContext.getBean(DataManagerDao.class);
        fullTextDao = applicationContext.getBean(FullTextDao.class);
        headerDao = applicationContext.getBean(HeaderDao.class);
        judgementResultDao = applicationContext.getBean(JudgementResultDao.class);
        litigationParticipantsDao = applicationContext.getBean(LitigationParticipantsDao.class);
        proceedingsDao = applicationContext.getBean(ProceedingsDao.class);
        refereeAnalysisProcessDao = applicationContext.getBean(RefereeAnalysisProcessDao.class);
    }

}

