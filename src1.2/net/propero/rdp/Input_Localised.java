/* Input_Localised.java
 * Component: ProperJavaRDP
 * 
 * Revision: $Revision$
 * Author: $Author$
 * Date: $Date$
 *
 * Copyright (c) 2005 Propero Limited
 *
 * Purpose: Java 1.2 specific extension of Input class
 */
//Created on 07-Jul-2003

package net.propero.rdp;
import java.awt.event.*;

import net.propero.rdp.keymapping.KeyCode;
import net.propero.rdp.keymapping.KeyCode_FileBased;

public class Input_Localised extends Input {
	public void clearKeys(){
		super.clearKeys();
		if (lastKeyEvent != null && lastKeyEvent.isAltGraphDown()) sendScancode(getTime(),RDP_KEYRELEASE,0x38 | KeyCode.SCANCODE_EXTENDED); //r.alt
	}
	public void setKeys(){
		super.setKeys();
		if (lastKeyEvent != null && lastKeyEvent.isAltGraphDown()) sendScancode(getTime(),RDP_KEYPRESS,0x38 | KeyCode.SCANCODE_EXTENDED); //r.alt
	}
		  
	public Input_Localised(RdesktopCanvas c, Rdp r, String k){
		super(c,r,k);
	}

	public Input_Localised(RdesktopCanvas c, Rdp r, KeyCode_FileBased k){
		super(c,r,k);
	}
	 
	
	 public boolean handleShortcutKeys(long time, KeyEvent e, boolean pressed){
		if (super.handleShortcutKeys(time,e,pressed)) return true;

		if (!altDown) return false; // all of the below have ALT on
	 
		switch(e.getKeyCode()){		
		case KeyEvent.VK_MINUS: // for laptops that can't do Ctrl+Alt+Minus
			if (ctrlDown){
					if(pressed){
						sendScancode(time,RDP_KEYRELEASE,0x1d); // Ctrl
						sendScancode(time,RDP_KEYPRESS,0x37 | KeyCode.SCANCODE_EXTENDED); // PrtSc
						logger.debug("shortcut pressed: sent ALT+PRTSC");
					}
					else{
						sendScancode(time,RDP_KEYRELEASE,0x37 | KeyCode.SCANCODE_EXTENDED); // PrtSc
						sendScancode(time,RDP_KEYPRESS,0x1d); // Ctrl
					}
			}
			break;
		default: return false;
		}
		return true;
	}
	
}
