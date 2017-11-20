package com.asiainfo.onlineLog.dao;

import com.asiainfo.onlineLog.model.ConcreteUse;
import com.asiainfo.onlineLog.model.TasApplication;
import com.asiainfo.onlineLog.model.TasApproveExp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/11/17.
 */
@Repository
public interface IOnlineLogDao {

    /**
     * 根据电话号码获取具体信息
     *
     * @param phoneNo, startTime, endTime
     * @return List
     */
    List<ConcreteUse> queryCompGprsBillInfo(String phoneNo, String startTime, @Param("") String endTime);

    List<TasApplication> queryTasApplictionList();

    List<TasApproveExp> queryTasApproveExpList();
}
