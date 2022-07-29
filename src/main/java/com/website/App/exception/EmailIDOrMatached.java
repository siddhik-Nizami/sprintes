/**
 * 
 */
package com.website.App.exception;

/**
 * @author 10698333
 *
 */
public class EmailIDOrMatached extends Exception{
	/**
	 * when user singup the account when this Exception will be occured 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param str
	 * return the Exception when email is matched
	 */
	public EmailIDOrMatached(String str) {
		super(str);
	}

}
