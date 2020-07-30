package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PrepareSqlJobHandler extends IJobHandler {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        JSONObject obj = new JSONObject(param);

        String[] dateArr = obj.getString("businessDate").split("-");
        String businessDate = String.join("", dateArr);

        String prepareSql = obj.getString("prepareSql").replaceAll("\\$\\{date}", "'" + businessDate + "'");
        XxlJobLogger.log(prepareSql);
        jdbcTemplate.update(prepareSql);

        return SUCCESS;
    }
}
