/**
 * 
 */
package com.website.App.Utility;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 10698333
 *
 */
public class Utility {

	/**
	 * @param request
	 * @return
	 */
	public static String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}
