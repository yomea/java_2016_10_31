package httpServer;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * 解析XML文件
 * @author may
 *
 */
public class ParseXmlUtil {
	
	
	public static void parseXml() throws ParserConfigurationException, SAXException, IOException {
		
		SAXParserFactory sax = SAXParserFactory.newInstance();
		SAXParser parser = sax.newSAXParser();
		parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("httpServer/web.xml"), new XmlHandler());
		
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		parseXml();
	}
	
}
