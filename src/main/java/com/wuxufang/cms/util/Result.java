package com.wuxufang.cms.util;

/**
 * 
 * @ClassName: Result 
 * @Description: 返回统一的结果值
 * @author: 煜
 * @date: 2020年2月12日 下午6:01:56 
 * @param <T>
 */
public class Result<T> {
   //返回结果的状态
	private Integer code;
	private String  msg;
	private T data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
