package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobContext;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ExecuteSqlJobHandler extends IJobHandler {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        // 分片参数
        int shardIndex = XxlJobContext.getXxlJobContext().getShardIndex();
        int shardTotal = XxlJobContext.getXxlJobContext().getShardTotal();

        JSONObject obj = new JSONObject(param);

        String[] dateArr = obj.getString("businessDate").split("-");
        String businessDate = String.join("", dateArr);

        String executeSql = obj.getString("executeSql")
                .replaceAll("\\$\\{date}", "'" + businessDate + "'")
                .replaceAll("\\$\\{index}", Integer.toString(shardIndex))
                .replaceAll("\\$\\{total}", Integer.toString(shardTotal));
        XxlJobLogger.log(executeSql);
        jdbcTemplate.update(executeSql);

        return SUCCESS;
    }
}
