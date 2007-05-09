/* RdesktopFrame_Localised.java
 * Component: ProperJavaRDP
 * 
 * Revision: $Revision$
 * Author: $Author$
 * Date: $Date$
 *
 * Copyright (c) 2005 Propero Limited
 *
 * Purpose: Java 1.1 specific extension of RdesktopFrame class
 */
// Created on 03-Sep-2003

package net.propero.rdp;


public class RdesktopFrame_Localised extends RdesktopFrame {
	protected void checkFullScreenWidthHeight(){
			if(Options.fullscreen){
			//	can't remove frame decoration so reduce size to compensate
				Options.height -= 26;
				Options.width -= 8;
			}
		}
}
