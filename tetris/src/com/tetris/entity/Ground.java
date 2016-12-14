package com.tetris.entity;

import java.awt.Graphics;

import com.tetris.global.Global;
import com.tetris.view.MyPanel;
/**
 * 定义阻碍物类
 * @author may
 */
public class Ground {

	private MyPanel panel;

	private int count = 0;

	private int[][] exsts = new int[Global.WIDTH + 1][Global.HEIGHT + 1];

	private ShapeFactory factory = new ShapeFactory();

	public Ground(MyPanel myPanel) {
		this.panel = myPanel;
	}

	public void accept(Shape shape) {
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {

				if (shape.isMember(x, y, false)) {
					this.exsts[shape.getLeft() + x][shape.getTop() + y] = 1;
					
				}
			}

		}
		line();
	}

	/**
	 * 如果连成了一条线就消掉
	 */
	public void line() {

		for (int i = 0; i < Global.WIDTH; i++) {
			for (int j = 0; j < Global.WIDTH; j++) {
				if (exsts[j][i] == 1) {

					count++;
				}

			}
			//连成30个，将消除行以上的全部往下移动
			if (count == Global.WIDTH) {
				if (i == 0) {
					for (int j = 0; j < Global.WIDTH; j++) {
						exsts[j][i] = 0;

					}
				} else {
					for (int n = i; n > 0; n--) {
						for (int j = 0; j < Global.WIDTH; j++) {
							exsts[j][n] = exsts[j][n - 1];

						}

					}
				}

			}
			count = 0;

		}

	}
	//判断是够包含该位置
	public boolean contains(Shape shape, int x, int y) {

		if (exsts[shape.getLeft() + x][shape.getTop() + y] == 1) {

			return true;
		}

		return false;

	}
	//画出自己
	public void drawMe(Graphics g) {
		for (int i = 0; i < exsts.length; i++) {
			for (int j = 0; j < exsts[i].length; j++) {
				if (exsts[i][j] == 1) {
					g.fill3DRect(i * Global.CELL_WIDTH, j * Global.CELL_HEIGHT , Global.CELL_WIDTH,
							Global.CELL_HEIGHT, true);

				}

			}

		}
	}
	//到图形工厂取得图形
	public Shape getShape() {
		return factory.getShape(this);

	}
	
	//是否已经到达底部
	public boolean isDownable(Shape shape, int action) {

		int top = shape.getTop();

		top++;

		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {

				if (shape.isMember(x, y, action == Global.ROTATE)) {
					if ((top + y + 1) > Global.HEIGHT || this.contains(shape, x, y + 1)) {
						panel.setShape(this.getShape());
						this.accept(shape);
						return false;
					}

				}
			}

		}

		return true;
	}
	//是否能够移动
	public synchronized boolean isMovable(Shape shape, int action) {

		int left = shape.getLeft();

		int top = shape.getTop();

		switch (action) {
		case Global.LEFT:
			left--;
			break;
		case Global.RIGHT:
			left++;
			break;
		case Global.DOWN:
			top++;
			break;
		}

		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (shape.isMember(x, y, action == Global.ROTATE)) {

					if ((left + x) < 0 || (left + x + 1) > Global.WIDTH || (top + y + 1) > Global.HEIGHT
							|| this.contains(shape, x, y + 1) || this.contains(shape, x + 1, y)
							|| this.contains(shape, shape.getLeft() == 0 ? x : x - 1, y)) {

						return false;
					}

				}
			}

		}

		return true;
	}

}
