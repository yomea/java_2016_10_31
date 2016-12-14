package cn.itcast.tetris.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import cn.itcast.tetris.listener.GroundListener;
import cn.itcast.tetris.util.Global;


/**
 * ���Խ�������, �����<BR>
 * ά���ϰ������Ϣ<BR>
 * ����ʹ���ṩ�� addObstacle(int, int) �� addStubbornObstacle(int ,int) ��������ϰ��<BR>
 * <BR>
 * ����ͨ��setObstacleColor(), setStubbornObstacleColor() ��
 * setGriddingColor()���������ϰ�����������ɫ<BR>
 * ͨ��setDrawGridding() ���������Ƿ񻭿հ�(����)<BR>
 * �� setColorfulSupport() ���������Ƿ�֧�ֲ�ɫ��ʾ<BR>
 * <BR>
 * ���� drawObstacle(Graphics, int, int, int, int) �������Ըı��ϰ������ʾ��ʽ<BR>
 * ���� drawStubbornObstacle(Graphics, int, int, int, int) �������Ըı䲻���������ϰ������ʾ��ʽ<BR>
 * <BR>
 * 
 * 
 * @author may
 * 
 */
public class Ground {

	/**
	 * ������
	 */
	protected Set<GroundListener> listeners = new HashSet<GroundListener>();

	/**
	 * ����
	 */
	protected UnitType[][] obstacles = new UnitType[Global.WIDTH][Global.HEIGHT];

	/**
	 * �����������ϰ������ɫ
	 */
	protected Color stubbornObstacleColor = UnitType.STUBBORN_OBSTACLE
			.getColor();

	/**
	 * Ĭ�ϵ�������ɫ
	 */
	public static final Color DEFAULT_GRIDDING_COLOR = Color.LIGHT_GRAY;

	/**
	 * �������ɫ
	 */
	protected Color griddingColor = DEFAULT_GRIDDING_COLOR;

	public static final Color DEFAULT_OBSTACLE_COLOR = UnitType.OBSTACLE
			.getColor();
	/**
	 * �ϰ������ɫ
	 */
	protected Color obstacleColor = DEFAULT_OBSTACLE_COLOR;

	public static final Color DEFAULT_FULL_LINE_COLOR = Color.DARK_GRAY;
	/**
	 * ���е���ɫ
	 */
	protected Color fullLineColor = DEFAULT_FULL_LINE_COLOR;

	/**
	 * �Ƿ����� �Ŀ���
	 */
	protected boolean drawGridding;

	/**
	 * �Ƿ�֧�ֲ�ɫʯͷ
	 */
	protected boolean colorfulSupport;

	/**
	 * �Ƿ��ܽ���ʯͷ
	 */
	protected boolean full;

	protected Random random = new Random();

	public Ground() {
		init();
	}

	/**
	 * ��ʼ�����������clear() ����<BR>
	 * 
	 */
	public void init() {
		clear();
		full = false;
	}

	/**
	 * �������
	 */
	public void clear() {
		/**
		 * ��ʼ������
		 */
		for (int x = 0; x < Global.WIDTH; x++)
			for (int y = 0; y < Global.HEIGHT; y++)
				obstacles[x][y] = UnitType.BLANK.clone();
	}

	/**
	 * �������һ�������������ϰ�� �������������y ���겻С��5
	 */
	public void genernateAStubbornStochasticObstacle() {
		Random random = new Random();
		if (Global.HEIGHT < 5)
			return;
		int y = random.nextInt(5) + Global.HEIGHT - 5;
		int x = random.nextInt(Global.WIDTH);
		addStubbornObstacle(x, y);
	}

	/**
	 * ��ָ���ķ�Χ���������һЩ�ϰ���<BR>
	 * ��������������1 - lineNum
	 * 
	 * @param amount
	 *            Ҫ���ɵ�����
	 * @param lineNum
	 *            �кţ� ��1��ʼ
	 */
	public void generateSomeStochasticObstacle(int amount, int lineNum) {
		if (lineNum < 1)
			return;
		if (lineNum > Global.HEIGHT)
			lineNum = Global.HEIGHT;
		for (int i = 0; i < amount; i++) {
			int x = random.nextInt(Global.WIDTH);
			int y = random.nextInt(lineNum) + Global.HEIGHT - lineNum;
			obstacles[x][y] = UnitType.OBSTACLE.clone();
			obstacles[x][y].setColor(Global.getRandomColor());
		}
	}

	/**
	 * ��ָ����ͼ�α��ʯͷ<BR>
	 * Ȼ�󽫻���� deleteFullLine() ����ɨ�貢ɾ������
	 * 
	 * @param shape
	 */
	public void accept(Shape shape) {

		/**
		 * ��ͼ�ζ�Ӧ��������ʯͷ
		 */
		int left = shape.getLeft();
		int top = shape.getTop();

		for (int x = 0; x < 4; x++)
			for (int y = 0; y < 4; y++)
				if (left + x < Global.WIDTH && top + y < Global.HEIGHT) {
					if (shape.isMember(x, y, false))
						/**
						 * ��������ϱ߽���, ���Ƿ�����
						 */
						if (top + y < 0) {
							full = true;
							for (GroundListener l : listeners)
								l.groundIsFull(this);
						} else {
							/**
							 * �ȱ���ϰ���
							 */
							obstacles[left + x][top + y]
									.cloneProperties(UnitType.OBSTACLE);
							obstacles[left + x][top + y]
									.setColor(colorfulSupport ? shape
											.getColor() : obstacleColor);
						}
				}
		/**
		 * ɨ�貢ɾ������
		 */
		deleteFullLine();
	}

	/**
	 * ɨ�貢ɾ������<BR>
	 * ������ deleteLine(int) ����ɾ������
	 */
	public void deleteFullLine() {
		/**
		 * ���һ�����˼���
		 */
		int deletedLineCount = 0;
		/**
		 * �����һ�п�ʼ, һֱ����һ��
		 */
		for (int y = Global.HEIGHT - 1; y >= 0; y--) {
			boolean isFull = true;
			for (int x = 0; x < Global.WIDTH; x++) {
				if (obstacles[x][y].equals(UnitType.BLANK))
					isFull = false;
			}
			/**
			 * �����ǰ������
			 */
			if (isFull) {
				/**
				 * ɾ����(��ǰ)�в��ҵ�ǰɨ���кż� 1
				 */
				deleteLine(y++);
				deletedLineCount++;
			}
		}

		/**
		 * ��������ˣ� �򴥷������¼�
		 */
		if (deletedLineCount > 0)
			for (GroundListener l : listeners)
				l.fullLineDeleted(this, deletedLineCount);
	}

	/**
	 * ɾ��ָ������(��һ���������е�ʯͷ��������һ��)
	 * 
	 * @param lineNum
	 */
	public void deleteLine(int lineNum) {

		/**
		 * ������Ҫ�����¼�
		 */
		for (GroundListener l : listeners)
			l.beforeDeleteFullLine(this, lineNum);

		for (int y = lineNum; y > 0; y--)
			for (int x = 0; x < Global.WIDTH; x++)
				if (!obstacles[x][y].equals(UnitType.STUBBORN_OBSTACLE))
					if (obstacles[x][y - 1].equals(UnitType.STUBBORN_OBSTACLE)) {
						obstacles[x][y].cloneProperties(UnitType.BLANK);
						obstacles[x][y].setColor(this.griddingColor);
					} else
						obstacles[x][y].cloneProperties(obstacles[x][y - 1]);
		/**
		 * ��һ�б�ɿհ�
		 */
		for (int x = 0; x < Global.WIDTH; x++)
			if (!obstacles[x][0].equals(UnitType.STUBBORN_OBSTACLE))
				obstacles[x][0] = UnitType.BLANK.clone();
	}

	/**
	 * �����Ƿ������(�Ƿ��ܽ���ͼ��)<BR>
	 * 
	 * @return
	 */
	public boolean isFull() {
		return full;
	}

	/**
	 * ����ͼ�εĶ������ж��Ƿ�������ϰ���򲻿��������ϰ���, ���Ƿ�ᳬ���߽�,
	 * 
	 * @param shape
	 * @param action
	 *            ͼ�ν�Ҫ���Ķ���
	 * @return ͼ���Ƿ�������������
	 */
	public synchronized boolean isMoveable(Shape shape, int action) {
		int left = shape.getLeft();
		int top = shape.getTop();
		/**
		 * ���ݶ������õ�������Ϣ
		 */
		switch (action) {

		case Shape.UP:
			top--;
			break;
		case Shape.DOWN:
			top++;
			break;
		case Shape.LEFT:
			left--;
			break;
		case Shape.RIGHT:
			left++;
			break;
		}

		if (top < 0 - shape.getHeight()) {
			return false;
		}
		for (int x = 0; x < 4; x++)
			for (int y = 0; y < 4; y++)

				/**
				 * ������λ�ó����߽�����ͼ�ε�һ����
				 */
				if ((left + x < 0 || left + x >= Global.WIDTH || top + y >= Global.HEIGHT)
						&& shape.isMember(x, y, action == Shape.ROTATE))
					return false;
				else if (top + y < 0)
					continue;
				else {
					/**
					 * ����λ�ò��ǿհף����ϰ���򲻿��������ϰ������ͼ�ε�һ����
					 */
					if (shape.isMember(x, y, action == Shape.ROTATE))
						if (!obstacles[left + x][top + y]
								.equals(UnitType.BLANK))
							return false;
				}
		return true;
	}

	/**
	 * �ı�ָ���е���ɫ,(������Ϊ����ǰ��Ч��)
	 * 
	 * @param lineNum
	 */
	public void changeFullLineColor(int lineNum) {

		for (int x = 0; x < Global.WIDTH; x++)
			obstacles[x][lineNum].setColor(fullLineColor);
	}

	/**
	 * ��ָ����λ�����һ���ϰ���
	 * 
	 * @param x
	 *            x ��������
	 * @param y
	 *            y ��������
	 */
	public void addObstacle(int x, int y) {
		if (x < 0 || x >= Global.WIDTH || y < 0 || y >= Global.HEIGHT)
			throw new RuntimeException("���λ�ó�������ʾ���� (x:" + x + "  y:" + y + ")");
		obstacles[x][y].cloneProperties(UnitType.OBSTACLE);
	}

	/**
	 * ��ָ����λ�����һ�鲻���������ϰ���
	 * 
	 * @param x
	 *            x ��������
	 * @param y
	 *            y ��������
	 */
	public void addStubbornObstacle(int x, int y) {
		if (x < 0 || x >= Global.WIDTH || y < 0 || y >= Global.HEIGHT)
			throw new RuntimeException("���λ�ó�������ʾ���� (x:" + x + "  y:" + y + ")");
		obstacles[x][y].cloneProperties(UnitType.STUBBORN_OBSTACLE);
	}

	/**
	 * ��ʾ, ������ drawGridding(Graphics, int, int, int, int),
	 * drawObstacle(Graphics, int, int, int, int)��
	 * drawStubbornObstacle(Graphics, int, int, int, int) ����
	 * 
	 * @param g
	 */
	public void drawMe(Graphics g) {
		for (int x = 0; x < Global.WIDTH; x++)
			for (int y = 0; y < Global.HEIGHT; y++) {
				/**
				 * ���հ�/����(�������)
				 */
				if (drawGridding && obstacles[x][y].equals(UnitType.BLANK)) {
					g.setColor(griddingColor);
					drawGridding(g, x * Global.CELL_WIDTH, y
							* Global.CELL_HEIGHT, Global.CELL_WIDTH,
							Global.CELL_HEIGHT);
				}
				/**
				 * �������������ϰ���
				 */
				else if (obstacles[x][y].equals(UnitType.STUBBORN_OBSTACLE)) {
					g.setColor(stubbornObstacleColor);
					drawStubbornObstacle(g, x * Global.CELL_WIDTH, y
							* Global.CELL_HEIGHT, Global.CELL_WIDTH,
							Global.CELL_HEIGHT);
				}
				/**
				 * ���ϰ���
				 */
				else if (obstacles[x][y].equals(UnitType.OBSTACLE)) {
					g.setColor(obstacles[x][y].getColor());
					drawObstacle(g, x * Global.CELL_WIDTH, y
							* Global.CELL_HEIGHT, Global.CELL_WIDTH,
							Global.CELL_HEIGHT);
				}
			}
	}

	/**
	 * 
	 * ��һ���հ׵ķ���(����), ���Ը�����������ı�հ�(����)����ʾ
	 * 
	 * @param g
	 * @param x
	 *            �������� x
	 * @param y
	 *            �������� y
	 * @param width
	 *            ���(��λ:����)
	 * @param height
	 *            �߶�(��λ:����)
	 */
	public void drawGridding(Graphics g, int x, int y, int width, int height) {
		g.drawRect(x, y, width, height);
	}

	/**
	 * 
	 * ��һ�������������ϰ���ķ���, ���Ը�����������ı䲻���������ϰ������ʾ
	 * 
	 * @param g
	 * @param x
	 *            �������� x
	 * @param y
	 *            �������� y
	 * @param width
	 *            ���(��λ:����)
	 * @param height
	 *            �߶�(��λ:����)
	 */
	public void drawStubbornObstacle(Graphics g, int x, int y, int width,
			int height) {
		g.fill3DRect(x, y, width, height, true);
	}

	/**
	 * 
	 * ��һ���ϰ���ķ���, ���Ը�����������ı��ϰ������ʾ
	 * 
	 * @param g
	 * @param x
	 *            �������� x
	 * @param y
	 *            �������� y
	 * @param width
	 *            ���(��λ:����)
	 * @param height
	 *            �߶�(��λ:����)
	 */
	public void drawObstacle(Graphics g, int x, int y, int width, int height) {
		g.fill3DRect(x, y, width, height, true);
	}

	/**
	 * �õ������������ϰ������ɫ
	 * 
	 * @return
	 */
	public Color getStubbornObstacleColor() {
		return stubbornObstacleColor;
	}

	/**
	 * ���ò����������ϰ������ɫ
	 * 
	 * @param stubbornObstacleColor
	 */
	public void setStubbornObstacleColor(Color stubbornObstacleColor) {
		this.stubbornObstacleColor = stubbornObstacleColor;
	}

	/**
	 * �õ��������ɫ
	 * 
	 * @return
	 */
	public Color getGriddingColor() {
		return griddingColor;
	}

	/**
	 * �����������ɫ
	 * 
	 * @param griddingColor
	 */
	public void setGriddingColor(Color griddingColor) {
		this.griddingColor = griddingColor;
	}

	/**
	 * �õ��ϰ������ɫ
	 * 
	 * @return
	 */
	public Color getObstacleColor() {
		return obstacleColor;
	}

	/**
	 * �����ϰ������ɫ
	 * 
	 * @param obstacleColor
	 */
	public void setObstacleColor(Color obstacleColor) {
		this.obstacleColor = obstacleColor;
	}

	/**
	 * �õ����е���ɫ
	 * 
	 * @return
	 */
	public Color getFullLineColor() {
		return fullLineColor;
	}

	/**
	 * �������е���ɫ
	 * 
	 * @param fullLineColor
	 */
	public void setFullLineColor(Color fullLineColor) {
		this.fullLineColor = fullLineColor;
	}

	/**
	 * �Ƿ�����
	 * 
	 * @return
	 */

	public boolean isDrawGridding() {
		return drawGridding;
	}

	/**
	 * �����Ƿ�����
	 * 
	 * @param drawGridding
	 */
	public void setDrawGridding(boolean drawGridding) {
		this.drawGridding = drawGridding;
	}

	/**
	 * �Ƿ�֧�ֲ�ɫ��ʾ
	 * 
	 * @return
	 */
	public boolean isColorfulSupport() {
		return colorfulSupport;
	}

	/**
	 * �����Ƿ�֧�ֲ�ɫ��ʾ
	 * 
	 * @param colorfulSupport
	 */
	public void setColorfulSupport(boolean colorfulSupport) {
		this.colorfulSupport = colorfulSupport;
	}

	/**
	 * ��Ӽ�����, ����Ӷ��
	 * 
	 * @param l
	 */
	public void addGroundListener(GroundListener l) {
		if (l != null)
			this.listeners.add(l);
	}

	/**
	 * �Ƴ�������
	 * 
	 * @param l
	 */
	public void removeGroundListener(GroundListener l) {
		if (l != null)
			this.listeners.remove(l);
	}

	/**
	 * ָ��λ���Ƿ��ǲ��ɳ����ϰ���
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isStubbornObstacle(int x, int y) {
		if (x >= 0 && x < Global.WIDTH && y >= 0 && y < Global.HEIGHT)
			return obstacles[x][y].equals(UnitType.STUBBORN_OBSTACLE);
		else
			throw new RuntimeException("������곬������ʾ����: (x:" + x + " y:" + y + ")");
	}

	/**
	 * ָ��λ���Ƿ����ϰ���
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isObstacle(int x, int y) {
		if (x >= 0 && x < Global.WIDTH && y >= 0 && y < Global.HEIGHT)
			return obstacles[x][y].equals(UnitType.OBSTACLE);
		else
			throw new RuntimeException("������곬������ʾ����: (x:" + x + " y:" + y + ")");
	}

	/**
	 * ָ��λ���Ƿ��ǿհ�
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isBlank(int x, int y) {
		if (x >= 0 && x < Global.WIDTH && y >= 0 && y < Global.HEIGHT)
			return obstacles[x][y].equals(UnitType.BLANK);
		else
			throw new RuntimeException("������곬������ʾ����: (x:" + x + " y:" + y + ")");
	}
}
