package dateSource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;

public class JdbcPool {

	private static LinkedList<Connection> jdbcPool = new LinkedList<Connection>();

	private static int maxSize = 0;

	private static int initSize = 0;

	private static String driver = null;

	private static String url = null;

	private static String username = null;

	private static String password = null;

	static {

		driver = PropertiesUtil.getProperties("jdbc.driverClassName");

		url = PropertiesUtil.getProperties("jdbc.url");

		username = PropertiesUtil.getProperties("jdbc.username");

		password = PropertiesUtil.getProperties("jdbc.password");

		String poolInitSize = PropertiesUtil.getProperties("jdbc.poolInitSize");

		String maxSizeStr = PropertiesUtil.getProperties("jdbc.maxSize");

		try {
			maxSize = Integer.valueOf(maxSizeStr);
			initSize = Integer.valueOf(poolInitSize);
		} catch (Exception e) {
			maxSize = 0;
			initSize = 10;
		}

		try {
			Class.forName(driver);

			for (int i = 0; i < initSize; i++) {
				Connection connection = DriverManager.getConnection(url, username, password);
				jdbcPool.add(connection);
			}

		} catch (Exception e) {
			System.out.println("数据库忙！！！");

		}

	}

	public synchronized Connection getConnection() {
		try {
			if (jdbcPool.size() <= 2 && maxSize > 0) {
				for (int i = 0; i < maxSize - initSize; i++) {
					Connection connection = DriverManager.getConnection(url, username, password);
					jdbcPool.add(connection);
				}

			}
			
			if(jdbcPool.size() <= 0) {
				System.out.println("busy");
				
				return null;
			}
			final Connection connection = jdbcPool.removeFirst();
			return (Connection) Proxy.newProxyInstance(this.getClass().getClassLoader(),
					connection.getClass().getInterfaces(), new InvocationHandler() {

						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							String methodName = method.getName();
							Object obj = null;

							if ("close".equals(methodName)) {

								jdbcPool.add(connection);
								return null;

							} else {

								obj = method.invoke(connection, args);
							}
							return obj;
						}
					});

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		}
		
		return null;
		
	}

}
