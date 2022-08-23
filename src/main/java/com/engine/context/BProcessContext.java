package com.engine.context;

import com.engine.Context;

/**
 * @Author:jihai
 * @Date:2022/8/22
 * @Description:
 */
public class BProcessContext extends Context {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
