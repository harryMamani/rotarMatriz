package com.pe.qds.rotarMatriz.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Util {

	public static String getStackTraceToString(Throwable exception) {
		StringWriter stringWriter = new StringWriter();
		exception.printStackTrace(new PrintWriter(stringWriter, true));
		return stringWriter.toString();
	}
}
