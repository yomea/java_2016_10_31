package lib;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialClob;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ArrayHandler：把结果集中的第一行数据转成对象数组。
 * ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。
 * BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
 * BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
 * ColumnListHandler：将结果集中某一列的数据存放到List中。
 * KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map里，再把这些map再存到一个map里，其key为指定的key。
 * MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
 * MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List
 * 
 * @author may
 *
 */
public class ApacheDbutilsTest {

	private static ComboPooledDataSource dataSource;

	static {
		dataSource = new ComboPooledDataSource("MySql");// 使用MySql配置项
	}

	public static void main(String[] args) throws Exception {
		// add();
		// getAll();
		// testArrayHandler();
		testArrayListHandler();
	}

	public static void add() throws SQLException {
		// 将数据源传递给QueryRunner，QueryRunner内部通过数据源获取数据库连接
		QueryRunner qr = new QueryRunner(dataSource);
		String sql = "insert into users(name,password,email,birthday) values(?,?,?,?)";
		Object params[] = { "孤傲苍狼", "123", "gacl@sina.com", new Date() };
		// Object params[] = {"白虎神皇","123", "gacl@sina.com", "1988-05-07"};
		qr.update(sql, params);
	}

	public static void delete() throws SQLException {

		QueryRunner qr = new QueryRunner(dataSource);
		String sql = "delete from users where id=?";
		qr.update(sql, 1);

	}

	public static void update() throws SQLException {
		QueryRunner qr = new QueryRunner(dataSource);
		String sql = "update users set name=? where id=?";
		Object params[] = { "ddd", 5 };
		qr.update(sql, params);
	}

	public static void find() throws SQLException {
		QueryRunner qr = new QueryRunner(dataSource);
		String sql = "select * from users where id=?";
		Object params[] = { 2 };
		User user = (User) qr.query(sql, params, new BeanHandler(User.class));
		System.out.println(user.getUser_name());
	}

	public static void getAll() throws SQLException {
		QueryRunner qr = new QueryRunner(dataSource);
		String sql = "select * from users";
		List<User> list = (List<User>) qr.query(sql, new BeanListHandler<>(User.class));
		System.out.println(list.size());
	}

	/**
	 * @Method: testBatch
	 * @Description:批处理
	 * @Anthor:孤傲苍狼
	 *
	 * @throws SQLException
	 */
	public static void testBatch() throws SQLException {
		QueryRunner qr = new QueryRunner(dataSource);
		String sql = "insert into users(name,password,email,birthday) values(?,?,?,?)";
		Object params[][] = new Object[10][];
		for (int i = 0; i < 10; i++) {
			params[i] = new Object[] { "aa" + i, "123", "aa@sina.com", new Date() };
		}
		qr.batch(sql, params);
	}

	// 用dbutils完成大数据（不建议用）
	/***************************************************************************
	 * create table testclob ( id int primary key auto_increment, resume text );
	 **************************************************************************/
	public static void testclob() throws SQLException, IOException {
		QueryRunner runner = new QueryRunner(dataSource);
		String sql = "insert into testclob(resume) values(?)"; // clob
		// 这种方式获取的路径，其中的空格会被使用“%20”代替
		String path = ApacheDbutilsTest.class.getClassLoader().getResource("data.txt").getPath();
		// 将“%20”替换回空格
		path = path.replaceAll("%20", " ");
		FileReader in = new FileReader(path);
		char[] buffer = new char[(int) new File(path).length()];
		in.read(buffer);
		SerialClob clob = new SerialClob(buffer);
		Object params[] = { clob };
		runner.update(sql, params);
	}

	public static void testArrayHandler() throws SQLException {
		QueryRunner qr = new QueryRunner(dataSource);
		String sql = "select * from users";
		Object result[] = (Object[]) qr.query(sql, new ArrayHandler());
		System.out.println(Arrays.asList(result)); // list toString()
	}

	public static void testArrayListHandler() throws SQLException {

		QueryRunner qr = new QueryRunner(dataSource);
		String sql = "select * from users";
		List<Object[]> list = (List) qr.query(sql, new ArrayListHandler());
		for (Object[] o : list) {
			System.out.println(Arrays.asList(o));
		}
	}

	public static void testColumnListHandler() throws SQLException {
		QueryRunner qr = new QueryRunner(dataSource);
		String sql = "select * from users";
		List list = (List) qr.query(sql, new ColumnListHandler("id"));
		System.out.println(list);
	}

	public static void testKeyedHandler() throws Exception {
		QueryRunner qr = new QueryRunner(dataSource);
		String sql = "select * from users";

		Map<Integer, Map> map = (Map) qr.query(sql, new KeyedHandler("id"));
		for (Map.Entry<Integer, Map> me : map.entrySet()) {
			int id = me.getKey();
			Map<String, Object> innermap = me.getValue();
			for (Map.Entry<String, Object> innerme : innermap.entrySet()) {
				String columnName = innerme.getKey();
				Object value = innerme.getValue();
				System.out.println(columnName + "=" + value);
			}
			System.out.println("----------------");
		}
	}

	public static void testMapHandler() throws SQLException {

		QueryRunner qr = new QueryRunner(dataSource);
		String sql = "select * from users";

		Map<String, Object> map = (Map) qr.query(sql, new MapHandler());
		for (Map.Entry<String, Object> me : map.entrySet()) {
			System.out.println(me.getKey() + "=" + me.getValue());
		}
	}

	public static void testMapListHandler() throws SQLException {
		QueryRunner qr = new QueryRunner(dataSource);
		String sql = "select * from users";
		List<Map> list = (List) qr.query(sql, new MapListHandler());
		for (Map<String, Object> map : list) {
			for (Map.Entry<String, Object> me : map.entrySet()) {
				System.out.println(me.getKey() + "=" + me.getValue());
			}
		}
	}

	public static void testScalarHandler() throws SQLException {
		QueryRunner qr = new QueryRunner(dataSource);
		String sql = "select count(*) from users"; // [13] list[13]
		int count = ((Long) qr.query(sql, new ScalarHandler(1))).intValue();
		System.out.println(count);
	}

}
