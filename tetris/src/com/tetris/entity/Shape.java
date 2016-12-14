package com.tetris.entity;

import java.awt.Graphics;

import com.tetris.global.Global;
/**
 * 图形类
 * @author may
 *
 */
public class Shape {

	private int[][] body = null;

	private int state;//当前的状态

	private boolean isRotate = true;;

	private int speed = 1000;

	private int left = 7;

	private int top = 0;

	private Ground ground;

	private boolean L = false, R = false, D = false;

	public Shape() {
		new Thread(new MyThread()).start();
		;
	}

	public void drawMe(Graphics g) {

		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (getByPoint(x, y)) {

					g.fill3DRect((left + x) * Global.CELL_WIDTH, (top + y) * Global.CELL_HEIGHT ,
							Global.CELL_WIDTH, Global.CELL_HEIGHT, true);

				}
			}

		}

		this.moveLeft();
		this.moveRight();

	}

	public void setGround(Ground ground) {

		this.ground = ground;
	}

	private boolean getByPoint(int x, int y) {

		return body[state][y * 4 + x] == 1;
	}

	public boolean isMember(int x, int y, boolean isRotate) {
		if (isRotate) {

			return body[(state + 1) % body.length][y * 4 + x] == 1;
		}

		return getByPoint(x, y);
	}

	public void setState(int state) {

		this.state = state;
	}

	public void setBody(int[][] body) {
		this.body = body;

	}

	public void moveDown() {
			top++;
	}

	public void moveLeft() {
		if (ground.isMovable(this, Global.LEFT) && this.L) {
			left--;

		}
	}

	public void moveRight() {
		if (ground.isMovable(this, Global.RIGHT) && this.R) {
			left++;

		}

	}

	public void transformation() {
		if (this.isRotate) {

			state = (state + 1) % body.length;

		}

	}

	public void setSpeed() {
		if (D) {

			this.speed = 50;
			return ;
		}
		this.speed = 1000;
	}

	public int getLeft() {

		return this.left;
	}

	public int getTop() {

		return this.top;
	}

	public void setIsRotate(boolean isRotate) {
		this.isRotate = isRotate;

	}

	public void setL(boolean l) {
		L = l;
	}

	public void setR(boolean r) {
		R = r;
	}

	public void setD(boolean d) {
		D = d;
	}

	private class MyThread implements Runnable {

		@Override
		public void run() {
			while (ground.isDownable(Shape.this, Global.DOWN)) {
				try {
					moveDown();
					Thread.sleep(speed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}

	}

}
