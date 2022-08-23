package com.engine;

import com.engine.context.AProcessContext;
import com.engine.context.BProcessContext;
import com.engine.result.AProcessResult;
import com.engine.result.BProcessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author:jihai
 * @Date:2022/8/22
 * @Description:
 */
@Controller
public class OrderController {

    @Autowired
    private SopEngineTemplate sopEngineTemplate;

    public void doABiz() {
        AProcessContext aProcessContext = new AProcessContext();
        aProcessContext.setBizIdentify("a");
        aProcessContext.setOrderId(1L);
        AProcessResult aProcessResult = sopEngineTemplate.sopExecute(aProcessContext);
        System.out.println("process A result : " + aProcessResult.getBizASuccess());
    }

    public void doBBiz() {
        BProcessContext bProcessContext = new BProcessContext();
        bProcessContext.setBizIdentify("b");
        bProcessContext.setUserName("jihai");
        BProcessResult bProcessResult = sopEngineTemplate.sopExecute(bProcessContext);
        System.out.println("process B result : " + bProcessResult.getBizBSuccess());
    }
}
