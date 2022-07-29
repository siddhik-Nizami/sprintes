/**
 * 
 */
package com.website.App.exception;

/**
 * @author 10698333 This is Custome Exception of the application if userNot
 *         found that time this Exception will be show to User.
 */
public class UserNotFoundTheException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * @param msg Message param contained the message This Exception will be occured
	 *            when useNot found the Database
	 * 
	 */
	public UserNotFoundTheException(String msg) {
		super(msg);
	}

}
