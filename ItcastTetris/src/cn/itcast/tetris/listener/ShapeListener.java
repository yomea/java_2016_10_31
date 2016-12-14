package cn.itcast.tetris.listener;

import cn.itcast.tetris.entities.Shape;

/**
 * ͼ�μ�����
 * 
 * 
 * @author may
 */

public interface ShapeListener {
	/**
	 * ͼ��ѯ���Ƿ��������
	 * 
	 * 
	 * @param shape
	 * @return
	 */
	boolean isShapeMoveDownable(Shape shape);

	/**
	 * ͼ�������¼�
	 * 
	 * @param shape
	 */
	void shapeMovedDown(Shape shape);
}
