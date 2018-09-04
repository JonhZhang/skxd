package com.skxd.controller.util;

import com.zxs.common.Constant;
import com.zxs.resp.ReturnResult;

public class ReturnResultExt extends ReturnResult{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static ReturnResult returnSuccess( Object data) {
		return returnSuccess("操作成功", data);
	}
	public static ReturnResult returnSuccess(String message, Object data) {
		ReturnResult result = new ReturnResult();
		result.setData(data);
		result.setMessage(message);
		result.setStatus(Constant.ReturnResult.STATUS.SUCCESS);
		return result;
	}
	
	public static ReturnResult returnFail( Object data) {
		return returnFail("操作失败", data);
	}
	public static ReturnResult returnFail(String message, Object data) {
		ReturnResult result = new ReturnResult();
		result.setData(data);
		result.setMessage(message);
		result.setStatus(Constant.ReturnResult.STATUS.FAIL);
		return result;
	}

	public static ReturnResult returnLogin() {
		ReturnResult result = new ReturnResult();
		result.setMessage("登录超时，需要重新登录");
		result.setStatus("-2");
		return result;
	}

}
