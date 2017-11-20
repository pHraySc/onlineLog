package com.asiainfo.onlineLog.dao;

import com.asiainfo.onlineLog.model.TasApplication;
import com.asiainfo.onlineLog.model.TasApproveExp;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/11/17.
 */
@Repository
public interface IOnlineLogDao {


    List<TasApplication> queryTasApplictionList();

    List<TasApproveExp> queryTasApproveExpList();
}
