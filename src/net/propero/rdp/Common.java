/* Common.java
 * Component: ProperJavaRDP
 * 
 * Revision: $Revision$
 * Author: $Author$
 * Date: $Date$
 *
 * Copyright (c) 2005 Propero Limited
 *
 * Purpose: Provide a static interface to individual network layers
 *          and UI components
 */
package net.propero.rdp;

import java.awt.datatransfer.DataFlavor;
import java.util.StringTokenizer;

import net.propero.rdp.rdp5.Rdp5;

public class Common {

    public static boolean underApplet = false;
	public static Rdp5 rdp;
	public static Secure secure;
	public static MCS mcs;
	public static RdesktopFrame frame;

    /**
     * Quit the application
     */
	public static void exit(){
		Rdesktop.exit(0,rdp,frame,true);
	}
}
