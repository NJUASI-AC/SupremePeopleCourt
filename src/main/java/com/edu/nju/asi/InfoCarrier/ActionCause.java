package com.edu.nju.asi.InfoCarrier;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class ActionCause implements Serializable{

    /**
     * 案由名称
     */
    String actionName;

    /**
     * 案由代码
     */
    String actionCode;

    public ActionCause() {
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }
}
