package com.skxd.vo;

import java.io.Serializable;
import java.util.List;

import com.skxd.model.SkxdArea;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/10/19.
 */
public class SkxdAreaVo extends SkxdArea implements Serializable {
   
	private List<SkxdArea> chichildren;

	public List<SkxdArea> getChichildren() {
		return chichildren;
	}

	public void setChichildren(List<SkxdArea> chichildren) {
		this.chichildren = chichildren;
	}
	
   
}
