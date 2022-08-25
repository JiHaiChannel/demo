package com.engine;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:jihai
 * @Date:2022/8/22
 * @Description:
 */
@org.springframework.stereotype.Component
public class SopEngineTemplate {

    @Autowired
    private ApplicationContext applicationContext;

    public <CONTENT extends Context, RESULT extends Result> RESULT sopExecute(CONTENT context) {
        // 加载对应身份的组件
        RESULT result = null;
        try {
            List<Component<Context, Result>> componentList = loadComponetList(context.getBizIdentify());
            for (int i = 0; i < componentList.size(); i++) {
                Component component = componentList.get(i);
                if (i == componentList.size() - 1) {
                    result = (RESULT) component.execute(context);
                } else {
                    component.execute(context);
                }
            }

            // TODO 开启事务
            for (Component component : componentList) {
                component.doTransaction(context);
            }
            // TODO 结束事务
        } catch (Exception exception) {
            result = (RESULT) Result.fail("execute error");
        }

        return result;
    }

    private List<Component<Context, Result>> loadComponetList(String bizIdentify) throws IOException {
        // 通过业务身份加载对应流程
        File file = ResourceUtils.getFile("classpath:" + bizIdentify + "-process.json");
        JSONArray jsonArray = JSONObject.parseArray(FileUtils.readFileToString(file, Charsets.UTF_8));

        List<Component<Context, Result>> resultList = new ArrayList<>();
        for (Object o : jsonArray.toArray()) {
            resultList.add(applicationContext.getBean(o.toString(), Component.class));
        }
        return resultList;
    }

}
