package com.tetris.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import com.tetris.entity.Ground;
import com.tetris.entity.Shape;
import com.tetris.global.Global;

public class MyPanel extends JPanel {

	private boolean start = false;

	private Shape shape = null;

	private Ground ground = null;

	private static final long serialVersionUID = -521797325085137973L;

	public MyPanel() {
		ground = new Ground(this);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		g.fillRect(0, 0, Global.CELL_WIDTH * Global.WIDTH, Global.CELL_HEIGHT * Global.HEIGHT);
		g.setColor(Color.BLUE);
		shape.drawMe(g);
		ground.drawMe(g);
	}


	public void startGame() {
		shape = ground.getShape();
		new Thread(new ShapeThread()).start();

	}

	public void setShape(Shape shape) {

		this.shape = shape;
	}

	private class ShapeThread implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(100);
				} catch (Exception e) {
				}

				repaint();

			}

		}

	}

	public boolean getStart() {

		return this.start;
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		switch (keyCode) {

		case KeyEvent.VK_DOWN:

			shape.setD(false);
			shape.setSpeed();
			break;
		case KeyEvent.VK_LEFT:

			shape.setL(false);

			break;
		case KeyEvent.VK_RIGHT:

			shape.setR(false);

			break;

		}
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		switch (keyCode) {
		case KeyEvent.VK_UP:
			if (ground.isMovable(shape, Global.ROTATE)) {

				shape.transformation();

			}

			break;

		case KeyEvent.VK_LEFT:

			shape.setL(true);

			break;

		case KeyEvent.VK_RIGHT:

			shape.setR(true);

			break;

		case KeyEvent.VK_DOWN:
			shape.setD(true);
			shape.setSpeed();

			break;

		}

	}

}
