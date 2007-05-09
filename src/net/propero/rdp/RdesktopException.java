/* RdesktopException.java
 * Component: ProperJavaRDP
 * 
 * Revision: $Revision$
 * Author: $Author$
 * Date: $Date$
 *
 * Copyright (c) 2005 Propero Limited
 *
 * Purpose: General exception class for ProperJavaRDP
 */
package net.propero.rdp;

public class RdesktopException extends Exception {

    public RdesktopException() {
	super();
    }

    public RdesktopException(String s) {
	super(s);
    }
}
