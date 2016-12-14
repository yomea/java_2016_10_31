package httpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装请求数据
 * @author may
 *
 */
public class Request {

	private static final String CLRF = "\r\n";//换行

	private BufferedReader bufferedReader;//读取流

	private Socket socket;//socket

	private Map<String, List<String>> params = null;//存参数

	private String url = "";//请求的url

	private String paramStr;//参数字符串

	private String method;//访问方式

	public Request() {
		url = "";
		paramStr = "";
		method = "";
		params = new HashMap<>();
	}

	public Request(Socket socket) {
		this();
		this.socket = socket;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream(), "utf-8"));
		} catch (IOException e) {
			return;
		}
	}
	/**
	 * 
	 * 解析参数方法
	 * @throws IOException
	 */
	public void parseParam() throws IOException {
		char[] buf = new char[20480];
		bufferedReader.read(buf);
		String stringInfo = new String(buf).trim();
		stringInfo = URLDecoder.decode(stringInfo, "utf-8");
		int firstLine = stringInfo.indexOf(CLRF);
		if(firstLine == -1) {
			return ;
		}
		String firstStr = stringInfo.substring(0, firstLine).trim();
		int urlStart = firstStr.indexOf("/") + 1;
		int urlEnd = firstStr.indexOf("HTTP");
		method = firstStr.substring(0, urlStart - 1).trim();
		String[] paramArr = null;
		this.url = firstStr.substring(urlStart, urlEnd).trim();
		if (method.equalsIgnoreCase("post")) {
			this.paramStr = stringInfo.substring(stringInfo.lastIndexOf(CLRF) + 1).trim();

		} else if (method.equalsIgnoreCase("get")) {

			String[] arrStr = this.url.split("\\?");
			if (arrStr.length > 0) {

				this.url = arrStr[0];

			}
			if (arrStr.length > 1) {

				this.paramStr = arrStr[1];
			}
			if (arrStr.length == 0) {
				this.url = "";

			}
		}
		//去除浏览器对/favicon.ico的请求
		if("favicon.ico".equals(this.url)) {
			return ;
			
		}
		// 如果没有参数，默认处理
		if (!this.paramStr.equals("")) {
			paramArr = this.paramStr.split("&");
			for (int i = 0; i < paramArr.length; i++) {
				// 如果他是键值对就处理，如果不是默认处理
				if (paramArr[i].matches(".+=.+")) {

					String[] keyValues = paramArr[i].split("=");

					if (this.params.containsKey(keyValues[0])) {
						this.params.get(keyValues[0]).add(keyValues[1]);

					} else {
						List<String> values = new ArrayList<String>();
						values.add(keyValues[1]);
						this.params.put(keyValues[0], values);

					}
				}

			}

		}
		
		

	}

	public String getMethod() throws IOException {
		
		return method;
	}

	/**
	 * 获取参数
	 * 
	 * @param paramName
	 *            参数名
	 * @return
	 */
	public String getParameter(String paramName) {

		List<String> list = params.get(paramName);

		if (list == null || list.size() == 0) {

			return null;

		}
		return list.get(0);
	}

	public String[] getParmeterValues(String paramName) {

		List<String> list = params.get(paramName);

		if (list == null || list.size() == 0) {

			return new String[0];

		}

		return list.toArray(new String[0]);
	}

	public String getUrl() {

		return url;
	}

}
