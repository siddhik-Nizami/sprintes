/**
 * 
 */
package com.website.App.exception;

/**
 * @author 10698333 This is the Exception when will be occured if Email id or
 *         password is not matched
 */
public class EmailIdOrPasswordNotMatched extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 370291852666458719L;

	/**
	 * @param msg This is the constructor for Email and password if password and
	 *            email not matched that time this Exception will be occured
	 */
	public EmailIdOrPasswordNotMatched(String msg) {
		super(msg);
	}

}
