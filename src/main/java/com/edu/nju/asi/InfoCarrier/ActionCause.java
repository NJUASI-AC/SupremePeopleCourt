package com.edu.nju.asi.InfoCarrier;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class ActionCause implements Serializable{

    /**
     * 起诉案由
     */
    String actionCause;

    /**
     * 完整罪名
     */
    String actionName;

    /**
     * 罪名代码
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

    public String getActionCause() {
        return actionCause;
    }

    public void setActionCause(String actionCause) {
        this.actionCause = actionCause;
    }
}
