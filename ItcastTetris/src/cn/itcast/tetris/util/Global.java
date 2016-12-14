package cn.itcast.tetris.util;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;


/**
 * 
 * 
 * ������<BR>
 * <BR>
 * �����д�������������õ���һЩ����<BR>
 * ����֧�������ļ�<BR>
 * �����ļ���·��Ϊ��Ϸ���е�Ŀ¼, �ļ���Ϊ tetris.ini<BR>
 * <BR>
 * �����ļ���д����μ��ֶε�ע��<BR>
 * <BR>
 * �����ļ������������ֻд��Ҫ���õ�, û��д��������Ĭ��Ϊȱʡֵ<BR>
 * ���������ȱʡֵ��μ��ֶε�ע��<BR>
 * <BR>
 * ÿ�������������ֵ��Χ, ������Χ(��Ч)������ֵ����������<BR>
 * ����ֵ�ķ�Χ��μ��ֶε�ע��<BR>
 * 
  * 
 * @author may
 * 
 */
public class Global {

	private static Properties properties = new Properties();

	/**
	 * �����ļ���·��(Ĭ��Ϊ��ǰĿ¼�µ� snake.ini�ļ�)
	 */
	private static String CONFIG_FILE = "tetris.ini";

	/**
	 * һ�����ӵĿ��, ��λ:���� <BR>
	 * ��Ӧ�������ļ��еĹؼ���Ϊ: cell_width, ���� cell_sizeָ��<BR>
	 * ��Χ1 �� 100<BR>
	 * ȱʡֵΪ 23
	 */
	public static final int CELL_WIDTH;

	/**
	 * һ�����ӵĸ߶�, ��λ:���� <BR>
	 * ��Ӧ�������ļ��еĹؼ���Ϊ: cell_width, ���� cell_sizeָ��<BR>
	 * ��Χ1 �� 100<BR>
	 * ȱʡֵΪ 23
	 */
	public static final int CELL_HEIGHT;
	/**
	 * �ø��ӱ�ʾ�Ŀ��, (���Ϊ���ٸ�����) ��λ:�� <BR>
	 * ��Ӧ�������ļ��еĹؼ���Ϊ: width<BR>
	 * ��Χ10 �� 80<BR>
	 * ȱʡֵΪ 15
	 */
	public static final int WIDTH;

	/**
	 * �ø��ӱ�ʾ�ĸ߶�, (�߶�Ϊ���ٸ�����), ��λ:��<BR>
	 * ��Ӧ�������ļ��еĹؼ���Ϊ: height<BR>
	 * ��Χ10 �� 60<BR>
	 * ȱʡֵΪ20
	 */
	public static final int HEIGHT;

	/**
	 * ͼ������ĳ�ʼ�ٶ� (��λ: ����/��)<BR>
	 * ��Ӧ�������ļ��еĹؼ���Ϊ: speed<BR>
	 * ��Χ10 �� ���޴�<BR>
	 * ȱʡֵΪ 200
	 */
	public static final int DEFAULT_SPEED;

	/**
	 * ���浱ǰ��Ϸ��ͼ�ε������ٶ�
	 */
	public static int CURRENT_SPEED;

	/**
	 * ͼ�ο���������ٶ� (��λ: ����/��)<BR>
	 * ��Ӧ�������ļ��еĹؼ���Ϊ: swift_speed<BR>
	 * ��Χ0 �� ���޴�<BR>
	 * ȱʡֵΪ 15
	 */
	public static final int SWIFT_SPEED;

	/**
	 * ÿ�μ��ٻ���ٵķ��� (��λ: ����/��)<BR>
	 * ��Ӧ�������ļ��Ĺؼ���Ϊ: speed_step<BR>
	 * ��Χ1 �� ���޴�<BR>
	 * ȱʡֵΪ 25
	 */
	public static final int SPEED_STEP;

	/**
	 * ��������ǰ��ͣЧ����ʱ��(��λ: ����)<BR>
	 * ��Ӧ�������ļ��Ĺؼ���Ϊ: stay_time<BR>
	 * ��Χ0 �� ���޴�<BR>
	 * ȱʡֵΪ 200
	 */
	public static final int DEFAULT_STAY_TIME;

	/**
	 * ��������ǰ��ͣЧ����ʱ��
	 */
	public static int STAY_TIME;

	private static Random random = new Random();

	public static final String TITLE_LABEL_TEXT;

	public static final String INFO_LABEL_TEXT;

	private static final Color[] DEFAULT_COLORS = new Color[] {
			new Color(0x990066), new Color(0x990099), new Color(0x330099),
			new Color(0x663300), new Color(0x009966), new Color(0x003333) };

	public static final List<Color> COMMON_COLORS;

	/**
	 * ����һ���������ɫ
	 * 
	 * @return
	 */
	public static Color getRandomColor() {
		return DEFAULT_COLORS[random.nextInt(DEFAULT_COLORS.length)];
	}

	/**
	 * Ĭ�ϵĹ�����, ˽�е�, ��������������ʵ��
	 */
	private Global() {
	}

	/**
	 * ��ʼ������
	 */
	static {
		InputStream inputStream = null;

		try {
			inputStream = new FileInputStream(CONFIG_FILE);
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			System.out.println("û�������ļ�");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Integer temp = null;
		WIDTH = (temp = getIntValue("width")) != null && temp <= 80
				&& temp >= 10 ? temp : 15;
		HEIGHT = (temp = getIntValue("height")) != null && temp <= 60
				&& temp >= 10 ? temp : 20;
		DEFAULT_SPEED = CURRENT_SPEED = (temp = getIntValue("speed")) != null
				&& temp >= 10 ? temp : 300;
		SWIFT_SPEED = (temp = getIntValue("swift_speed")) != null && temp >= 0 ? temp
				: 15;
		SPEED_STEP = (temp = getIntValue("speed_step")) != null && temp >= 1 ? temp
				: 25;
		DEFAULT_STAY_TIME = STAY_TIME = (temp = getIntValue("stay_time")) != null
				&& temp >= 0 ? temp : 200;
		int defaultCellSize = (temp = getIntValue("cell_size")) != null
				&& temp > 0 && temp <= 100 ? temp : 23;
		CELL_WIDTH = (temp = getIntValue("cell_width")) != null && temp > 0
				&& temp <= 100 ? temp : defaultCellSize;
		CELL_HEIGHT = (temp = getIntValue("cell_height")) != null && temp > 0
				&& temp <= 100 ? temp : defaultCellSize;

		String tempStr = null;
		TITLE_LABEL_TEXT = (tempStr = getValue("title")) == null ? "˵����"
				: tempStr;
		INFO_LABEL_TEXT = (tempStr = getValue("info")) == null ? "��������Ʒ���, �س�����ͣ/����\nPAGE UP, PAGE DOWN ���ٻ����\n\n�����뿴 www.itcast.cn "
				: tempStr;

		COMMON_COLORS = loadColors();
	}

	/**
	 * Ҫ���Ƕ������<BR>
	 * 1. û�����key��value<BR>
	 * 2 ��key û�� value
	 */
	private static Integer getIntValue(String key) {
		if (key == null)
			throw new RuntimeException("key ����Ϊ��");
		try {
			return new Integer(properties.getProperty(key));
		} catch (NumberFormatException e) {
			return null;
		}
	}

	private static String getValue(String key) {
		try {
			return new String(properties.getProperty(key).getBytes("iso8859-1"));
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("all")
	private static List<Color> loadColors() {

		List<Color> l = new ArrayList<Color>(7);
		for (int i = 0; i < 7; i++)
			l.add(null);

		Set set = properties.keySet();
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			if ("1".equals(key.trim()))
				addColor(l, 0, getValue(key));
			else if ("2".equals(key.trim()))
				addColor(l, 1, getValue(key));
			else if ("3".equals(key.trim()))
				addColor(l, 2, getValue(key));
			else if ("4".equals(key.trim()))
				addColor(l, 3, getValue(key));
			else if ("5".equals(key.trim()))
				addColor(l, 4, getValue(key));
			else if ("6".equals(key.trim()))
				addColor(l, 5, getValue(key));
			else if ("7".equals(key.trim()))
				addColor(l, 6, getValue(key));
		}

		for (int i = 0; i < 7; i++) {
			l.remove(null);
		}

		if (l.size() < 1) {
			for (int i = 0; i < DEFAULT_COLORS.length; i++) {
				l.add(DEFAULT_COLORS[i]);
			}
		} else {
			if (l.size() != 7)
				System.out.println("��һ�������� " + l.size() + " ����Ч��ɫ�� ������������");

			return l.subList(0, l.size() > 7 ? 7 : l.size());
		}
		return l;
	}

	@SuppressWarnings("unchecked")
	private static void addColor(List l, int index, String str) {
		str = str.trim();
		if (!str.startsWith("0x") || str.length() < 3) {
			System.out.println("��ɫ������������ : " + str + " (key)");
			return;
		}

		try {
			String strRGB = str.substring(2, str.length() >= 8 ? 8 : str
					.length());
			int rgb = Integer.valueOf(strRGB, 16);
			Color c = new Color(rgb);
			if (c != null) {
				l.add(index, c);
			}
		} catch (Exception e) {
			System.out.println("(e)��ɫ������������:" + str + "(key)");
			e.printStackTrace();
			return;
		}
	}

}
