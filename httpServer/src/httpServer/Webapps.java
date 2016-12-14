package httpServer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * 用于初始化servlet
 * @author may
 *
 */
public class Webapps {
	
	private static Map<String, String> servlets = new HashMap<>();
	
	private static Map<String, String> mapping = new HashMap<>();
	
	private static int code = 0;
	
	static {
		
		try {
			ParseXmlUtil.parseXml();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			code = 505;
			e.printStackTrace();
		}
		
	}
	
	public static int getCode() {
		
		return code;
	}

	public static Map<String, String> getMapping() {
		return mapping;
	}

	public static void setMapping(Map<String, String> mapping) {
		Webapps.mapping = mapping;
	}
	
	public static Map<String, String> getServlets() {
		return servlets;
	}

	public static void setServlets(Map<String, String> servlets) {
		Webapps.servlets = servlets;
	}

	public static Servlet getServlet(String servletName) {
		Servlet servlet = null;
		String className = servlets.get(servletName);
		try {
			servlet = (Servlet) Class.forName(className).newInstance();
		} catch (Exception e) {
			servlet = null;
		}
		
		return servlet;
		
	}
	

}
