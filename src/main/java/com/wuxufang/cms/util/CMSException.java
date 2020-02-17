package com.wuxufang.cms.util;

/**
 * 
 * @ClassName: CMSException 
 * @Description: CMS 自定义异常
 * @author: 煜
 * @date: 2020年2月12日 下午6:00:56
 */
public class CMSException extends RuntimeException {
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private  String message;

	public CMSException() {

	}

	public CMSException(String message) {
		super(message);
		this.message =message;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
