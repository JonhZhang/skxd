package com.skxd.vo;

import java.io.Serializable;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/11/25.
 */
public class NodeVo implements Serializable {
    private String id;
    private String pId;
    private String name;
    private boolean open=true;
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
