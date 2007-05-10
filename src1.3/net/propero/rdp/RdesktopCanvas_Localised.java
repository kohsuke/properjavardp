/* RdesktopCanvas_Localised.java
 * Component: ProperJavaRDP
 * 
 * Revision: $Revision$
 * Author: $Author$
 * Date: $Date$
 *
 * Copyright (c) 2005 Propero Limited
 *
 * Purpose: Java 1.3 specific extension of RdesktopCanvas class
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
// Created on 03-Sep-2003

package net.propero.rdp;
import java.awt.image.*;
import java.awt.*;

import net.propero.rdp.Options;


public class RdesktopCanvas_Localised extends RdesktopCanvas {
	
	private Robot robot = null;

RdesktopCanvas_Localised(int width, int height){
	super(width,height);
}

	public void movePointer(int x, int y){
		Point p = this.getLocationOnScreen();
		x = x + p.x;
		y = y + p.y;
		robot.mouseMove(x, y);
	}
	
	protected Cursor createCustomCursor(Image wincursor, Point p, String s, int cache_idx){
		return Toolkit.getDefaultToolkit().createCustomCursor(wincursor, p, "");
	}	
		
		public void addNotify(){
		super.addNotify();

		if (robot == null) {
			try {
				robot = new Robot();
			} catch(AWTException e) {
			logger.warn("Pointer movement not allowed");
			}
		}
	}
	
	public void update(Graphics g){
		Rectangle r = g.getClipBounds();
        g.drawImage(backstore.getSubimage(r.x,r.y,r.width,r.height),r.x,r.y,null);
	}
}
