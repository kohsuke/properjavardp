/* KeyCode_FileBased_Localised.java
 * Component: ProperJavaRDP
 * 
 * Revision: $Revision$
 * Author: $Author$
 * Date: $Date$
 *
 * Copyright (c) 2005 Propero Limited
 *
 * Purpose: Java 1.4 specific extension of KeyCode_FileBased class
 */
package net.propero.rdp;

import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.HashMap;

import net.propero.rdp.keymapping.KeyCode_FileBased;
import net.propero.rdp.keymapping.KeyMapException;


public class KeyCode_FileBased_Localised extends KeyCode_FileBased {

	private HashMap keysCurrentlyDown = new HashMap();
	
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
	
	private void updateCapsLock(KeyEvent e){
		if(Options.useLockingKeyState){
			try {
				Options.useLockingKeyState = true;
				capsLockDown = e.getComponent().getToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
			} catch (Exception uoe){ Options.useLockingKeyState = false; }
		}
	}
	
}
