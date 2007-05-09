/* LicenceStore_Localised.java
 * Component: ProperJavaRDP
 * 
 * Revision: $Revision$
 * Author: $Author$
 * Date: $Date$
 *
 * Copyright (c) 2005 Propero Limited
 *
 * Purpose: Java 1.4 specific extension of LicenceStore class
 */
// Created on 05-Aug-2003

package net.propero.rdp;

import java.util.prefs.Preferences;


public class LicenceStore_Localised extends LicenceStore {

    public byte[] load_licence(){
        Preferences prefs = Preferences.userNodeForPackage(this.getClass());
        return prefs.getByteArray("licence."+Options.hostname,null);
        
    }
    
    public void save_licence(byte[] databytes){
        Preferences prefs = Preferences.userNodeForPackage(this.getClass());
        prefs.putByteArray("licence."+Options.hostname, databytes);
    }
    
}
