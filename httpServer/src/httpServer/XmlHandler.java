package httpServer;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Sax解析XML方式的处理类
 * @author may
 *
 */
public class XmlHandler extends DefaultHandler {
	
	private String currentTag;
	private String url_pattern;
	private String servlet_name;
	private String servlet_class;
	

	@Override
	public void startDocument() throws SAXException {
		System.out.println("start...");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("end...");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		currentTag = qName;
	}
	

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("servlet")) {
			
			Webapps.getServlets().put(servlet_name, servlet_class);
			
		} else if(qName.equalsIgnoreCase("servlet-mapping")) {
			
			Webapps.getMapping().put(url_pattern, servlet_name);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch, start, length).trim();
		if(str.equals("")) {
			return ;
		}
		
		if(currentTag.equalsIgnoreCase("servlet-name")) {
			
			this.servlet_name = str;
			
		} else if(currentTag.equalsIgnoreCase("servlet-class")) {
			this.servlet_class = str;
		} else if(currentTag.equalsIgnoreCase("url-pattern")) {
			
			this.url_pattern = str;
		}
	}
	
	
	

}
