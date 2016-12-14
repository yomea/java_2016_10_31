package cn.itcast.tetris.entities;

import java.awt.Color;
import java.util.Random;

import cn.itcast.tetris.listener.ShapeListener;
import cn.itcast.tetris.util.Global;


/**
 * ͼ�ι���<BR>
 * ���Բ���������״, ������ɫ��ͼ��<BR>
 * <BR>
 * setDefaultShapeColor() ������������Ĭ�ϲ�����ͼ�ε���ɫ<BR>
 * Ҳ����ͨ�� setColorfulShape() ���������Ƿ������ɫͼ��<BR>
 * <BR>
 * 
 * 
 * @author may
 * 
 */
public class ShapeFactory {
	/**
	 * ������������Щ��״��ͼ��
	 */
	protected static int shapes[][][] = new int[][][] {
	/* ��һ�� */{ /** ***** */
	{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },

	/* �ڶ��� */
	{ /** ********* */
	{ 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },

	{ 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } },
	/* ������ */
	{ /** ******* */
	{ 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },

	{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 } },
	/* ������ */
	{ /** ******** */
	{ 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, } },
	/* ������ */
	{ /** ******** */
	{ 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } },
	/* ������ */
	{ /** *********** */
	{ 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },

	{ 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } },

	/* ������ */
	{ /** ********** */
	{ 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 } },

	};

	protected Random random = new Random();

	/**
	 * ͼ�ε�Ĭ����ɫ
	 */
	public static final Color DEFAULT_SHAPE_COLOR = new Color(0x990066);
	/**
	 * ������ͼ�ε���ɫ
	 */
	protected Color defaultShapeColor = DEFAULT_SHAPE_COLOR;

	/**
	 * �Ƿ������ɫͼ��
	 */
	protected boolean colorfulShape;

	/**
	 * ������������͵�ͼ�Σ����ҰѴ������ļ�����ע�����
	 * 
	 * @param shpaeListener
	 * @return
	 */
	public Shape getShape(ShapeListener shapeListener) {
		int type = random.nextInt(shapes.length);
		Shape shape = new Shape(shapes[type], random
				.nextInt(shapes[type].length));
		shape.setColor(colorfulShape ? Global.getRandomColor()
				: defaultShapeColor);
		shape.addShapeListener(shapeListener);
		return shape;
	}

	/**
	 * �õ�Ĭ�ϲ�����ͼ�ε���ɫ
	 * 
	 * @return
	 */
	public Color getDefaultShapeColor() {
		return defaultShapeColor;
	}

	/**
	 * ����Ĭ�ϲ�����ͼ�ε���ɫ
	 * 
	 * @param defaultShapeColor
	 */
	public void setDefaultShapeColor(Color defaultShapeColor) {
		this.defaultShapeColor = defaultShapeColor;
	}

	/**
	 * �Ƿ������ɫͼ��
	 * 
	 * @return �Ƿ������ɫͼ��
	 */
	public boolean isColorfulShape() {
		return colorfulShape;
	}

	/**
	 * �����Ƿ������ɫͼ��
	 * 
	 * @param colorfulShape
	 */
	public void setColorfulShape(boolean colorfulShape) {
		this.colorfulShape = colorfulShape;
	}

}
