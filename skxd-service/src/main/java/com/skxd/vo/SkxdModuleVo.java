package com.skxd.vo;
import com.skxd.model.SkxdAdminModule;

import java.io.Serializable;
import java.util.List;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/10/29.
 */
public class SkxdModuleVo implements Serializable{

    private String id;
    private String name;
    private String url;
    private Integer level;
    private String parent;
    private String style;
    private List<SkxdAdminModule> children;

    public List<SkxdAdminModule> getChildren() {
        return children;
    }

    public void setChildren(List<SkxdAdminModule> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

}
