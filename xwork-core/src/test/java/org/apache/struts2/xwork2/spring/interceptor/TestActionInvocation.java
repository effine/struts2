/*
 * Created on 6/11/2004
 */
package org.apache.struts2.xwork2.spring.interceptor;

import org.apache.struts2.xwork2.ActionContext;
import org.apache.struts2.xwork2.ActionEventListener;
import org.apache.struts2.xwork2.ActionInvocation;
import org.apache.struts2.xwork2.ActionProxy;
import org.apache.struts2.xwork2.interceptor.PreResultListener;
import org.apache.struts2.xwork2.util.ValueStack;
import org.apache.struts2.xwork2.Result;

import java.lang.reflect.Method;

/**
 * @author Simon Stewart
 */
public class TestActionInvocation implements ActionInvocation {
    private Object action;
    private boolean executed;

    public TestActionInvocation(Object wrappedAction) {
        this.action = wrappedAction;
    }

    public Object getAction() {
        return action;
    }

    public boolean isExecuted() {
        return executed;
    }

    public ActionContext getInvocationContext() {
        return null;
    }

    public ActionProxy getProxy() {
        return null;
    }

    public Result getResult() throws Exception {
        return null;
    }

    public String getResultCode() {
        return null;
    }

    public void setResultCode(String resultCode) {

    }

    public ValueStack getStack() {
        return null;
    }

    public void addPreResultListener(PreResultListener listener) {
    }

    public String invoke() throws Exception {
        return invokeActionOnly();
    }

    public String invokeActionOnly() throws Exception {
        executed = true;
        Method method = action.getClass().getMethod("execute", new Class[0]);
        return (String) method.invoke(action, new Object[0]);
    }

    public void setActionEventListener(ActionEventListener listener) {
    }

    public void init(ActionProxy proxy)  {
    }
}