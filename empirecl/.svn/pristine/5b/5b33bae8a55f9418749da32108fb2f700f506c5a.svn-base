package com.netsol.utility;

import java.text.SimpleDateFormat;
import java.util.Random;

public class CommonUtils {

	private static final String osName;

	static {
		osName = System.getProperty("os.name").toLowerCase();
	}
	
	public static String replaceNullStringWithEmpty(String str) {
		if (str == null) {
			return "";
		}
		return str;
	}

	public static String formatDateToString(final java.util.Date date,
			final String pattern) {

		// Format date for XSQL call
		SimpleDateFormat formatter;

		formatter = new SimpleDateFormat(pattern);
		final String formatDate = formatter.format(date);
		return formatDate;
	}

	public static boolean isWindowOS() {

		if (osName.contains("xp") || osName.contains("window"))
			return true;

		return false;
	}

	public static boolean isLinuxOS() {

		if (osName.contains("linux"))
			return true;

		return false;
	}

	public static boolean isMacOS() {

		if (osName.contains("mac"))
			return true;

		return false;
	}

	public static String getRealPath() {
		String actualPath = new CommonUtils().getClass().getProtectionDomain()
				.getCodeSource().getLocation().toString();
		String realPath = actualPath.substring(0, actualPath.indexOf("WEB-"));
		if (realPath.contains("file:/")) {
			if (CommonUtils.isWindowOS()) {
				realPath = realPath.substring(6); // for window
				realPath.replace("/", "\\");
			} else if (CommonUtils.isLinuxOS()) {
				realPath = realPath.substring(5);// for Linux
			}
		}
		return realPath;
	}

	public static String getAlphaNumeric(int len) {
		String ALPHA_NUM ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$";
		StringBuffer sb = new StringBuffer(len);
        Random r = new Random();
        for (int i=0; i<len; i++) {
            int ndx = r.nextInt(ALPHA_NUM.length());
              sb.append(ALPHA_NUM.charAt(ndx));
        }
        return sb.toString();
	}
}
