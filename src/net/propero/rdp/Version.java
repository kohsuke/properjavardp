/* Version.java
 * Component: ProperJavaRDP
 * 
 * Revision: $Revision$
 * Author: $Author$
 * Date: $Date$
 *
 * Copyright (c) 2005 Propero Limited
 *
 * Purpose: Stores version information
 */

package net.propero.rdp;

import java.io.FileOutputStream;
import java.io.PrintWriter;


/**
 * Records the current version information of properJavaRDP
 */

public class Version
{
    public static String version = "1.1";

    /**
     * Display the current version of properJavaRDP
     */
    public static void main(String[] argv)
    {
	try {
	    if (argv.length == 0) {
		System.out.println(version);
	    } else {
		String filename = argv[0];
		System.out.println("Writing version information to: " + filename);
		PrintWriter file = new PrintWriter(new FileOutputStream(filename), true);

		file.println("product.version=" + version);
		file.close();
	    }
	} catch (Exception e) {
	    System.err.println("Problem writing version information: " + e);
	    e.printStackTrace(System.err);
	}
    }
}
