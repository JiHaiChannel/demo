package com.engine.component;

import com.engine.Component;
import com.engine.Context;
import com.engine.Result;

/**
 * @Author:jihai
 * @Date:2022/8/22
 * @Description:
 */
@org.springframework.stereotype.Component("checkOrderParamComponent")
public class CheckOrderParamComponent extends Component<Context, Result> {

    @Override
    public Result execute(Context context) {
        if (context.getBizIdentify() == null) {
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("bizIdentify unknow");
            return result;
        }
        return Result.ok();
    }
}
