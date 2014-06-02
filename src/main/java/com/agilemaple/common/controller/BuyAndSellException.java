package com.agilemaple.common.controller;

public class BuyAndSellException extends RuntimeException{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String exceptionMsg;
 
	public BuyAndSellException(String exceptionMsg) {

		this.exceptionMsg = exceptionMsg;
	}
	
	public String getExceptionMsg(){
		return this.exceptionMsg;
	}
	
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	} 
}
