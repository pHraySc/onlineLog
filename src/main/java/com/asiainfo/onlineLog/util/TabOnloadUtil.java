package com.asiainfo.onlineLog.util;

import com.asiainfo.onlineLog.dao.IOnlineLogDao;
import com.asiainfo.onlineLog.model.TasApplication;
import com.asiainfo.onlineLog.model.TasApproveExp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/11/20.
 */
public class TabOnloadUtil {


    @Autowired
    private static IOnlineLogDao onlineLogDao;

    private static List<TasApplication> tasApplicationList;

    private static List<TasApproveExp> tasApproveExpList;

    public static Map tasApplicationMap;

    public static Map tasApproveExpMap;


    static {

        tasApplicationMap = new HashMap();

        tasApproveExpMap = new HashMap();

        tasApplicationList = onlineLogDao.queryTasApplictionList();

        tasApproveExpList = onlineLogDao.queryTasApproveExpList();

        for (TasApplication tasApplication : tasApplicationList) {

            tasApplicationMap.put(tasApplication.getBusiId(),
                    tasApplication.getBusiName() + "&"
                            + tasApplication.getAppType() + "&"
                            + tasApplication.getExplain());
        }

        for (TasApproveExp tasApproveExp : tasApproveExpList) {

            tasApproveExpMap.put(tasApproveExp.getId(),
                    tasApproveExp.getSituation() + "&" +
                            tasApproveExp.getReason());
        }


    }

}
