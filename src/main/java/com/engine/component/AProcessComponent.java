package com.engine.component;

import com.engine.Component;
import com.engine.context.AProcessContext;
import com.engine.result.AProcessResult;

/**
 * @Author:jihai
 * @Date:2022/8/22
 * @Description:
 */
@org.springframework.stereotype.Component("aProcessComponent")
public class AProcessComponent extends Component<AProcessContext, AProcessResult> {

    @Override
    public AProcessResult execute(AProcessContext aProcessContext) {
        System.out.println("处理A流程");
        AProcessResult aProcessResult = new AProcessResult();
        aProcessResult.setBizASuccess(true);
        return aProcessResult;
    }


}
