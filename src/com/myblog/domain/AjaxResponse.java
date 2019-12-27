package com.myblog.domain;

import java.io.Serializable;

//@JsonSerialize(include = Inclusion.NON_NULL)
public class AjaxResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Integer status; // ERROR or SUCCESS
	protected String errorCode; // Error Code - message bundle will have the
								// text
	protected String message; // Additional details if any for error or success
	protected Object data;
	protected Long datetime;
	public static Integer ERROR = 0;
	public static Integer SUCCESS = 1;

	public AjaxResponse(){
		
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the ErrorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @param status
	 *            the Status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the Message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the Data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	public Long getDatetime() {
		return datetime;
	}

	public void setDatetime(Long datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "AjaxResponse [status=" + status + ", errorCode=" + errorCode
				+ ", message=" + message + ", data=" + data + ", datetime="
				+ datetime + "]";
	}

}
