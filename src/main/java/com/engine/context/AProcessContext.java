package com.engine.context;

import com.engine.Context;

/**
 * @Author:jihai
 * @Date:2022/8/22
 * @Description:
 */
public class AProcessContext extends Context {

    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
