package dateSource;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	public static Properties properties = new Properties();
	
	
	static {
		
		try {
			properties.load(PropertiesUtil.class.getResourceAsStream("/jdbc.properties"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getProperties(String key) {
		
		return properties.getProperty(key);
		
	}

}
