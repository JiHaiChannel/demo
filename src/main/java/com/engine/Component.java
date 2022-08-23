package com.engine;

/**
 * @Author:jihai
 * @Date:2022/8/22
 * @Description:
 */
public abstract class Component<CONTEXT extends Context, RESULT extends Result> {

    public abstract RESULT execute(CONTEXT context);

    protected void doTransaction(CONTEXT context) {}
}
