package ua.lviv.mavenJU.JA.lesson_02;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class CustomLoggerFile {
	private static Logger LOG = Logger.getLogger(CustomLoggerFile.class);

	public static void logWithBasicConfigurator() {
		BasicConfigurator.configure();	
		LOG.debug("DEBUG Logger message of project");
		LOG.info("INFO Logger message of project");
		LOG.warn("WARN Logger message of project");

	}
	
	public static void logWithDomConfigurator() {
		DOMConfigurator.configure("loggerConfig.xml");	

		LOG.error("ERROR Logger message of project");
	}
}
