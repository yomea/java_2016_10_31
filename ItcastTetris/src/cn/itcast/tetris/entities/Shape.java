package cn.itcast.tetris.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.TooManyListenersException;

import cn.itcast.tetris.listener.ShapeListener;
import cn.itcast.tetris.util.Global;


/**
 * 
 * ά��һ��ͼ��, һ��ͼ�ο�����һ�ֻ����״̬<BR>
 * <BR>
 * ����ͨ�� setColor() �����ı�ͼ�ε���ɫ<BR>
 * <BR>
 * ����ͨ������ drawUnit(Graphics, int, int, int, int) �����ı�ͼ�ε���ʾ<BR>
 * <BR>
 * ���ڲ��� ShapeDriver ����ͼ�ζ�ʱ�����ƶ�<BR>
 * <BR>
 * ʹ��ʱһ��Ҫ��ʵ��ע�������, �������������� <BR>
 * 
 * 
 * @author ������
 */
public class Shape {

	/**
	 * ����(��ת)
	 */
	public static final int ROTATE = 5;
	/**
	 * ����
	 */
	public static final int UP = 1;
	/**
	 * ����
	 */
	public static final int DOWN = 2;
	/**
	 * ����
	 */
	public static final int LEFT = 3;
	/**
	 * ����
	 */
	public static final int RIGHT = 4;

	/**
	 * ��������
	 */
	protected ShapeListener listener;

	/**
	 * 
	 */
	protected int[][] body;

	/**
	 * ��ǰ��ʾ��״̬
	 */
	protected int status;

	/**
	 * ͼ�ε���ʵ�߶�
	 */
	protected int height;

	/**
	 * ���Ͻǵ�λ��
	 */
	protected int left;

	/**
	 * ���Ͻǵ�λ��
	 */
	protected int top;

	/**
	 * ������ٶ�
	 */
	protected int speed;

	/**
	 * ����
	 */
	protected boolean life;

	/**
	 * ��ͣ״̬
	 */
	protected boolean pause;

	protected boolean swift;

	protected int swiftSpeed = Global.SWIFT_SPEED;

	protected Thread shapeThread, swiftThread;

	/**
	 * ��ɫ
	 */
	protected Color color = Color.BLUE;

	/**
	 * ָ������, ָ��״̬�Ĺ��췽��<BR>
	 * ������� init() ����
	 * 
	 * @param body
	 * @param status
	 */
	public Shape(int[][] body, int status) {
		super();
		this.body = body;
		this.status = status;
		for (int y = 0; y < 4; y++)
			for (int x = 0; x < 4; x++)
				if (isMember(x, y, false))
					height = y + 1;
		init();
	}

	/**
	 * ��ʼ��λ�ã��ٶȵ�
	 */
	public void init() {
		life = true;
		pause = false;
		swift = false;
		left = Global.WIDTH / 2 - 2;
		top = 0 - height;
		speed = Global.CURRENT_SPEED;
	}

	/**
	 * ��ת(���������, ��ʾ��һ��״̬)
	 */
	public void rotate() {
		status = (status + 1) % body.length;
	}

	public void moveUp() {
		top--;
	}

	/**
	 * �����ƶ�
	 */
	public void moveDown() {
		top++;
	}

	/**
	 * �����ƶ�
	 */
	public void moveLeft() {
		left--;
	}

	/**
	 * �����ƶ�
	 */
	public void moveRight() {
		left++;
	}

	/**
	 * ����ͼ�ζ�ʱ������ڲ���
	 * 
	 * @author ������
	 */
	protected class ShapeDriver implements Runnable {

		/**
		 * ����ͼ�ζ�ʱ����
		 */
		public void run() {
			if (listener == null)
				throw new RuntimeException("����ע�� ShapeListener");

			while (life && listener.isShapeMoveDownable(Shape.this)) {
				if (!swift) {
					if (!pause) {
						moveDown();
						/**
						 * ���������¼�
						 */
						listener.shapeMovedDown(Shape.this);
					}
				}
				try {
					Thread.sleep(speed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			life = false;
		}

	}

	/**
	 * ��ʾ, ������drawUnit(Graphics, int, int, int, int)����
	 * 
	 * @param g
	 */
	public void drawMe(Graphics g) {
		/**
		 * ���˾Ͳ����ˣ������Ϸ����ʱ�����һ��ͼ��
		 */
		if (!life)
			return;
		g.setColor(color);
		for (int x = 0; x < 4; x++)
			for (int y = 0; y < 4; y++)
				if (getFlagByPoint(status, x, y))
					drawUnit(g, (left + x) * Global.CELL_WIDTH, (top + y)
							* Global.CELL_HEIGHT, Global.CELL_WIDTH,
							Global.CELL_HEIGHT);
	}

	/**
	 * 
	 * �������ÿһ������ķ���, ���Ը�����������ı�ͼ�ε���ʾ
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
	public void drawUnit(Graphics g, int x, int y, int width, int height) {
		g.fill3DRect(x, y, width, height, true);
	}

	/**
	 * ������꣨x��y���Ƿ���ͼ���еĵ�
	 * 
	 * @param x
	 *            �������x
	 * @param y
	 *            �������y
	 * @return
	 */
	protected boolean getFlagByPoint(int status, int x, int y) {
		return body[status][y * 4 + x] == 1;
	}

	/**
	 * 
	 * ָ����λ���Ƿ���ͼ�ε�һ����
	 * 
	 * @param x
	 *            x�����ӣ�����ԣ�����
	 * @param y
	 *            y�����ӣ�����ԣ�����
	 * @param isRotate
	 *            �Ƿ���ת��
	 * @return
	 */
	public boolean isMember(int x, int y, boolean isRotate) {
		return getFlagByPoint(isRotate ? (status + 1) % body.length : status,
				x, y);
	}

	/**
	 * ����
	 */
	public void speedUp() {
		if (speed > Global.SPEED_STEP)
			speed -= Global.SPEED_STEP;
		Global.CURRENT_SPEED = speed;
	}

	/**
	 * ����
	 */
	public void speedDown() {
		speed += Global.SPEED_STEP;
		Global.CURRENT_SPEED = speed;
	}

	/**
	 * �õ�ͼ�ε������ٶ�
	 * 
	 * @return
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * ����ͼ�ε������ٶ�
	 * 
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * �õ�ͼ�ε���ͣ״̬
	 * 
	 * @return
	 */
	public boolean isPause() {
		return pause;
	}

	/**
	 * ����ͼ�ε���ͣ״̬
	 * 
	 * @param pause
	 */
	public void setPause(boolean pause) {
		this.pause = pause;
	}

	/**
	 * ������ͣ״̬<BR>
	 * ������ͣ״̬, ���������<BR>
	 * ����������, ����ͣ
	 */
	public void changePause() {
		this.pause = !this.pause;
	}

	/**
	 * �õ�ͼ�εĵ�ǰ�ǵڼ���״̬
	 * 
	 * @return
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * ����ͼ�εĵ�ǰ�ǵڼ���״̬
	 * 
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * �õ�ͼ�ε�λ��
	 * 
	 * @return
	 */
	public int getLeft() {
		return left;
	}

	/**
	 * ����ͼ�ε�λ��
	 * 
	 * @param left
	 */
	public void setLeft(int left) {
		this.left = left;
	}

	/**
	 * �õ�ͼ�ε�λ��
	 * 
	 * @return
	 */
	public int getTop() {
		return top;
	}

	/**
	 * ����ͼ�ε�λ��
	 * 
	 * @param top
	 */
	public void setTop(int top) {
		this.top = top;
	}

	/**
	 * �õ�ͼ�ε���ɫ
	 * 
	 * @return
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * ����ͼ�ε���ɫ
	 * 
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * ����ͼ�ε����ͣ�����״̬��
	 * 
	 * @param body
	 */
	public void setBody(int[][] body) {
		this.body = body;
	}

	/**
	 * ��Ӽ�����<BR>
	 * ������������ͼ��������߳�
	 * 
	 * @param l
	 */
	public void addShapeListener(ShapeListener l) {
		if (l == null || this.listener == l)
			return;
		if (this.listener != null)
			throw new RuntimeException(new TooManyListenersException());
		this.listener = l;

		start();
	}

	protected void start() {
		shapeThread = new Thread(new ShapeDriver());
		shapeThread.start();
	}

	public boolean isLife() {
		return life;
	}

	/**
	 * ����ͼ�ζ�ʱ������߳�
	 */
	public synchronized void die() {
		this.life = false;
	}

	public boolean isSwift() {
		return swift;
	}

	/**
	 * һ�䵽��
	 * 
	 * @param swift
	 */
	public void setSwift(boolean swift) {

		if (this.swift == swift)
			return;

		this.swift = swift;
		if (this.swift) {
			swiftThread = new Thread(new ShapeSwiftDriver());
			swiftThread.start();
		}
	}

	protected class ShapeSwiftDriver implements Runnable {

		public void run() {
			// TODO Auto-generated method stub
			while (swift && life) {
				if (listener == null)
					throw new RuntimeException("����ע�� ShapeListener");
				if (listener.isShapeMoveDownable(Shape.this)) {
					if (!pause) {
						moveDown();
						/**
						 * ���������¼�
						 */
						listener.shapeMovedDown(Shape.this);
					}
					try {
						Thread.sleep(swiftSpeed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					life = false;
				}
			}
		}

	}

	public int getSwiftSpeed() {
		return swiftSpeed;
	}

	public void setSwiftSpeed(int swiftSpeed) {
		this.swiftSpeed = swiftSpeed;
	}

	public int getHeight() {
		return height;
	}

}
