package com.engine.component;


import com.engine.Component;
import com.engine.context.BProcessContext;
import com.engine.result.BProcessResult;

/**
 * @Author:jihai
 * @Date:2022/8/22
 * @Description:
 */
@org.springframework.stereotype.Component("bProcessComponent")
public class BProcessComponent extends Component<BProcessContext, BProcessResult> {

    @Override
    public BProcessResult execute(BProcessContext context) {
        System.out.println("处理B流程");
        BProcessResult bProcessResult = new BProcessResult();
        bProcessResult.setBizBSuccess(true);
        return bProcessResult;
    }
}
