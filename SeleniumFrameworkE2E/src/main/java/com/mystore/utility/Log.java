package com.mystore.utility;

import org.apache.log4j.Logger;

public class Log {
	
	//Steps:
	//1.Add log4j.xml in project directory
	//2.Add Log class in utility package
	//3.Configure @BeforeSuite at BaseClass to configure log4j.xml
	//DomConfigurator.configure("log4j.xml")
	//4.Need to just call in methods in test case from Log class
	

	// Initialize Log4j logs
	public static Logger Log = Logger.getLogger(Log.class.getName());//

	public static void startTestCase(String sTestCaseName) {
		Log.info("=====================================" + sTestCaseName
				+ " TEST START=========================================");
	}

	public static void endTestCase(String sTestCaseName) {
		Log.info("=====================================" + sTestCaseName
				+ " TEST END=========================================");
	}

	// Need to create below methods, so that they can be called

	public static void info(String message) {
		Log.info(message);
	}

	public static void warn(String message) {
		Log.warn(message);
	}

	public static void error(String message) {
		Log.error(message);
	}

	public static void fatal(String message) {
		Log.fatal(message);
	}

	public static void debug(String message) {
		Log.debug(message);
	}
}
