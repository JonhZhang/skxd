package com.skxd.vo;

import java.util.List;

import com.skxd.model.SkxdArea;
import com.skxd.model.SkxdUser;

public class SkxdUserVo extends SkxdUser {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String roleName;
	private List<SkxdArea> areas;

	public List<SkxdArea> getAreas() {
		return areas;
	}

	public void setAreas(List<SkxdArea> areas) {
		this.areas = areas;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
    
}