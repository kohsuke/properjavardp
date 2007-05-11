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
//Created on 07-Jul-2003
package net.propero.rdp;

import java.awt.event.*;

import net.propero.rdp.keymapping.KeyCode;
import net.propero.rdp.keymapping.KeyCode_FileBased;

public class Input_Localised extends Input {
	public void clearKeys() {
		super.clearKeys();
		if (lastKeyEvent != null && lastKeyEvent.isAltGraphDown())
			sendScancode(getTime(), RDP_KEYRELEASE,
					0x38 | KeyCode.SCANCODE_EXTENDED); // r.alt
	}

	public void setKeys() {
		super.setKeys();
		if (lastKeyEvent != null && lastKeyEvent.isAltGraphDown())
			sendScancode(getTime(), RDP_KEYPRESS,
					0x38 | KeyCode.SCANCODE_EXTENDED); // r.alt
	}

	public Input_Localised(RdesktopCanvas c, Rdp r, String k) {
		super(c, r, k);
	}

	public Input_Localised(RdesktopCanvas c, Rdp r, KeyCode_FileBased k) {
		super(c, r, k);
	}

	public boolean handleShortcutKeys(long time, KeyEvent e, boolean pressed) {
		if (super.handleShortcutKeys(time, e, pressed))
			return true;

		if (!altDown)
			return false; // all of the below have ALT on

		switch (e.getKeyCode()) {
		case KeyEvent.VK_MINUS: // for laptops that can't do Ctrl+Alt+Minus
			if (ctrlDown) {
				if (pressed) {
					sendScancode(time, RDP_KEYRELEASE, 0x1d); // Ctrl
					sendScancode(time, RDP_KEYPRESS,
							0x37 | KeyCode.SCANCODE_EXTENDED); // PrtSc
					logger.debug("shortcut pressed: sent ALT+PRTSC");
				} else {
					sendScancode(time, RDP_KEYRELEASE,
							0x37 | KeyCode.SCANCODE_EXTENDED); // PrtSc
					sendScancode(time, RDP_KEYPRESS, 0x1d); // Ctrl
				}
			}
			break;
		default:
			return false;
		}
		return true;
	}

}
