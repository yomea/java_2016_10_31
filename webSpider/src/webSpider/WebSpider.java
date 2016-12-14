package webSpider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSpider {
	
	public static List<String> urls = new ArrayList<String>();
	
	public static String captureUrl(String url, String charset) {
		
		BufferedReader reader = null;
		
		StringBuilder str = new StringBuilder();
		
		try {
			URL urlInstance = new URL(url);
			reader = new BufferedReader(new InputStreamReader(urlInstance.openStream(), Charset.forName(charset)));
			String s = null;
			while((s = reader.readLine()) != null) {
				str.append(s);
				
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		
		return str.toString();
		
	}
	
	public static void spider(String url, String charset) {
		
		String str = WebSpider.captureUrl(url, charset);
		//href="http://caipiao.163.com/?from=wscj"
		Pattern pattern = Pattern.compile("href=\"([\\w./:]+?)\"");
		
		Matcher matcher = pattern.matcher(str);
		
		while(matcher.find()) {
			String href = matcher.group(1);
			System.out.println(href);
			//spider(href, charset);
			//urls.add(url);
		}
		
	}
	
	public static void main(String[] args) {
		WebSpider.spider("http://wlmt.date/d/", "gb2312");
	}
	

}
