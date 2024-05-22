package cn.sine2cr.chainErp.utils;

public class BaseResponseInfo {
	public int code;
	public Object data;


	public BaseResponseInfo() {
		code = 400;
		data = null;
	}
}
