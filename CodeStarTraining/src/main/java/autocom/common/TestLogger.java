//package autocom.common;
//
//import java.util.logging.Level;
//
//import org.testng.log4testng.Logger;
//
//public class TestLogger {
//	static final Logger logger = Logger.getLogger(TestLogger.class);
//	public static void log(String message, Level level) {
//		Throwable t = new Throwable();
//		String logMessage = message;
//		StackTraceElement[] elements = t.getStackTrace();
//		String Filename = elements[2].getFileName();
//		String sClassName = Filename.substring(0, Filename.length() - 5);//remove .java
//		String sMethodName = elements[2].getMethodName();
//		logMessage = String.format("[%-10s][%s] %s", sClassName, sMethodName, message);
////		logger.log(level, logMessage);
//	}
//	
//	public static void info(String message) {
//		log(message, Level.INFO);
//	}
//	public static void warn(String message) {
//		log(message, Level.WARNING);
//	}
//	
//}
//
