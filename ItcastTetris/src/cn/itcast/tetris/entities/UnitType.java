package cn.itcast.tetris.entities;

import java.awt.Color;


/**
 * ���Ա�ʾ����������ϰ���, �����������ϰ���, �հ�<BR>
 * <BR>
 * �ⲿ������ֱ��new һ��ʵ��, ��Ӧ���� clone() ��������ʵ��(��ֹ��������ʶ�������)<BR>
 * �������һ���ϰ���:<BR>
 * <code><BR>
 UnitType aObstacle = UnitType.OBSTACLE.clone();<BR>
 * </code><BR>
 * 
 * 
 * @author may
 */
public class UnitType implements Cloneable {

	/* ����һЩҪ�õ��ĳ��� */

	/**
	 * �հ����͵�ֵ
	 */
	private static final int BLANK_VALUE = 0;

	/**
	 * �߿����͵�ֵ
	 */
	private static final int STUBBORN_OBSTACLE_VALUE = 1;

	/**
	 * �ϰ������͵�ֵ
	 */
	private static final int OBSTACLE_VALUE = 2;

	/**
	 * �հ�����
	 */
	public static final UnitType BLANK = new UnitType(BLANK_VALUE, Color.WHITE);

	/**
	 * �߿�������
	 */
	public static final UnitType STUBBORN_OBSTACLE = new UnitType(
			STUBBORN_OBSTACLE_VALUE, new Color(0x808000));

	/**
	 * �ϰ�������
	 */
	public static final UnitType OBSTACLE = new UnitType(OBSTACLE_VALUE,
			Color.DARK_GRAY);

	/**
	 * ����ֵ
	 */
	private int value;

	/**
	 * ��ɫ
	 */
	private Color color;

	/**
	 * �õ�����ֵ
	 * 
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * ��������ֵ
	 * 
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * �õ���ɫ
	 * 
	 * @return
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * ������ɫ
	 * 
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * �������͵�˽�еĹ��췽��<BR>
	 * 
	 * @param value
	 */
	private UnitType(int value) {
		super();
		this.value = value;
	}

	/**
	 * �������ͺ���ɫ��˽�еĹ��췽��
	 * 
	 * @param value
	 * @param color
	 */
	private UnitType(int value, Color color) {
		super();
		this.value = value;
		this.color = color;
	}

	/**
	 * ����һ���µ�,���Լ���һ������ɫ����������ͬ��UnitType
	 */
	@Override
	public UnitType clone() {
		// TODO Auto-generated method stub
		return new UnitType(this.value, this.color);
	}

	/**
	 * ���Լ���¡�ɺ�ָ����UnitType ��ͬ�� UnitType, value �� Color ���ᱻ��¡
	 * 
	 * @param ut
	 */
	public void cloneProperties(UnitType ut) {
		this.color = ut.color;
		this.value = ut.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	/**
	 * ��ͬ�����;������, ���Ƚ���ɫ
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final UnitType other = (UnitType) obj;
		if (value != other.value)
			return false;
		return true;
	}

}
