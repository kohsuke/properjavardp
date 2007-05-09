/* ClipInterface.java
 * Component: ProperJavaRDP
 * 
 * Revision: $Revision$
 * Author: $Author$
 * Date: $Date$
 *
 * Copyright (c) 2005 Propero Limited
 *
 * Purpose: 
 */
package net.propero.rdp.rdp5.cliprdr;

import java.awt.datatransfer.Transferable;

public interface ClipInterface {
	
	public void copyToClipboard(Transferable t);
	public void send_data(byte []data, int length);
	public void send_null(int type, int status);
}
