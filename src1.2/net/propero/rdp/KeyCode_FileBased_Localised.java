/* KeyCode_FileBased_Localised.java
 * Component: ProperJavaRDP
 * 
 * Revision: $Revision$
 * Author: $Author$
 * Date: $Date$
 *
 * Copyright (c) 2005 Propero Limited
 *
 * Purpose: Java 1.2 specific extension of KeyCode_FileBased class
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 * 
 * (See gpl.txt for details of the GNU General Public License.)
 * 
 */
package net.propero.rdp;

import java.awt.event.KeyEvent;
import java.io.InputStream;

import net.propero.rdp.keymapping.KeyCode_FileBased;
import net.propero.rdp.keymapping.KeyMapException;


public class KeyCode_FileBased_Localised extends KeyCode_FileBased {

	/**
	 * @param fstream
	 * @throws KeyMapException
	 */
	public KeyCode_FileBased_Localised(InputStream fstream) throws KeyMapException {
		super(fstream);
	}

	public KeyCode_FileBased_Localised(String s) throws KeyMapException{
		super(s);
	}
	
	
}
