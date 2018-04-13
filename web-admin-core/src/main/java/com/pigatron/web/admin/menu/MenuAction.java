package com.pigatron.web.admin.menu;

/**
 * Created by rob on 12/03/2016.
 */
public class MenuAction {

    public static final String TYPE_ROUTE = "route";
    public static final String TYPE_OPEN = "open";

    private String type;
    private String action;

    public MenuAction(String type, String action) {
        this.type = type;
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
