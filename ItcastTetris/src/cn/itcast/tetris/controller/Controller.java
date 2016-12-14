package cn.itcast.tetris.controller;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JLabel;

import cn.itcast.tetris.entities.Ground;
import cn.itcast.tetris.entities.Shape;
import cn.itcast.tetris.entities.ShapeFactory;
import cn.itcast.tetris.listener.GameListener;
import cn.itcast.tetris.listener.GroundListener;
import cn.itcast.tetris.listener.ShapeListener;
import cn.itcast.tetris.util.Global;
import cn.itcast.tetris.view.GamePanel;


/**
 * ������
 * ����Ground, Snake, Food
 * ������Ϸ���߼�
 * �������¼�
 * 
 * 
 * 
 * @author may
 * 
 */
public class Controller extends KeyAdapter implements ShapeListener,
		GroundListener {

	protected Set<GameListener> listeners = new HashSet<GameListener>();
	/**
	 * ͼ�ι���
	 * 
	 */
	protected ShapeFactory shapeFactory;

	protected Shape shape;

	protected Ground ground;

	protected GamePanel gamePanel;

	protected JLabel gameInfoLabel;

	/**
	 * ��ǰ����Ϸ״̬
	 */
	protected boolean playing;

	/**
	 * 
	 * @param shapeFactory
	 * @param ground
	 * @param gamePanel
	 */
	public Controller(ShapeFactory shapeFactory, Ground ground,
			GamePanel gamePanel) {
		super();
		this.shapeFactory = shapeFactory;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}

	/**
	 * �����һ�� JTextComponent, ���Ը�������������ʾ��ʾ��Ϣ
	 * 
	 * @param shapeFactory
	 * @param ground
	 * @param gamePanel
	 * @param gameInfoLabel
	 */
	public Controller(ShapeFactory shapeFactory, Ground ground,
			GamePanel gamePanel, JLabel gameInfoLabel) {

		this(shapeFactory, ground, gamePanel);
		this.setGameInfoLabel(gameInfoLabel);
	}

	/**
	 * ������̰��� <BR>
	 * LEFT: �����ƶ�<BR>
	 * RIGHT�������ƶ�<BR>
	 * DOWN: �����ƶ�<BR>
	 * UP: ����<BR>
	 * PAGE UP: �ӿ��ٶ�<BR>
	 * PAGE DOWN: �����ٶ�<BR>
	 * Y: ���¿�ʼ��Ϸ<BR>
	 * ENTER: ��ͣ/����
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() != KeyEvent.VK_Y && !playing)
			return;

		switch (e.getKeyCode()) {
		/**
		 * ������
		 */
		case KeyEvent.VK_LEFT:
			if (isPausingGame()) {
				this.continueGame();
			}
			shape.setSwift(false);

			if (isPlaying() && ground.isMoveable(shape, Shape.LEFT))
				shape.moveLeft();
			break;
		/**
		 * ������
		 */
		case KeyEvent.VK_RIGHT:
			if (isPausingGame()) {
				this.continueGame();
			}
			shape.setSwift(false);

			if (isPlaying() && ground.isMoveable(shape, Shape.RIGHT))
				shape.moveRight();
			break;
		/**
		 * ������
		 */
		case KeyEvent.VK_UP:

			if (isPlaying()) {
				if (!shape.isPause()) {
					if (ground.isMoveable(shape, Shape.ROTATE)) {
						shape.setSwift(false);
						shape.rotate();
					}
				} else {
					if (ground.isMoveable(shape, Shape.UP))
						shape.moveUp();
					else {
						shape.die();
						shape = shapeFactory.getShape(this);
					}
				}
			}

			break;
		/**
		 * ������
		 */
		case KeyEvent.VK_DOWN:
			if (isPausingGame()) {
				this.continueGame();
			}
			if (isPlaying() && isShapeMoveDownable(shape))
				shape.moveDown();
			break;
		/**
		 * PAGE UP
		 */
		case KeyEvent.VK_PAGE_UP:
			shape.speedUp();
			break;
		/**
		 * PAGE DOWN
		 */
		case KeyEvent.VK_PAGE_DOWN:
			shape.speedDown();
			break;
		/**
		 * ������,��һ��ͼ��
		 */
		case KeyEvent.VK_BACK_QUOTE:
			if (isPlaying()) {
				shape.die();
				shape = shapeFactory.getShape(this);
			}
			break;
		case KeyEvent.VK_ENTER:
			if (isPausingGame())
				this.continueGame();
			else
				this.pauseGame();
			break;
		case KeyEvent.VK_Y:
			if (!isPlaying())
				newGame();
			break;
		case KeyEvent.VK_SPACE:

			if (isPlaying() && !isPausingGame())
				shape.setSwift(true);
			break;
		}
		/**
		 * ������ʾ
		 */
		gamePanel.redisplay(ground, shape);
		if (gameInfoLabel != null)
			gameInfoLabel.setText(this.getNewInfo());
	}

	/**
	 * ѯ��һ��ͼ���Ƿ�������䣬������������ˣ��ͻ���ͼ�α���ϰ���<BR>
	 * ���������ͬ����
	 */
	public synchronized boolean isShapeMoveDownable(Shape s) {

		if (shape == null)
			return true;
		if (!playing || shape != s)
			return false;

		if (ground.isMoveable(shape, Shape.DOWN))
			return true;

		shape.die();
		ground.accept(shape);
		if (playing && !ground.isFull()) {
			shape = shapeFactory.getShape(this);
		}
		gamePanel.redisplay(ground, shape);
		if (gameInfoLabel != null)
			gameInfoLabel.setText(this.getNewInfo());

		return false;
	}

	/**
	 * ����ͼ�δ����� shapeMovedDown (ͼ������) �¼�<BR>
	 * ����������ʾ
	 */
	public void shapeMovedDown(Shape s) {
		// TODO Auto-generated method stub
		if (playing && ground != null && shape != null)
			gamePanel.redisplay(ground, shape);
	}

	/**
	 * ��ʼһ������Ϸ
	 */
	public void newGame() {
		playing = true;
		ground.init();
		ground.addGroundListener(this);

		Global.CURRENT_SPEED = Global.DEFAULT_SPEED;
		shape = shapeFactory.getShape(this);

		if (playing)
			gamePanel.redisplay(ground, shape);

		if (gameInfoLabel != null)
			gameInfoLabel.setText(this.getNewInfo());

		for (GameListener l : listeners)
			l.gameStart();
	}

	/**
	 * ֹͣ��ǰ��Ϸ
	 */
	public void stopGame() {
		if (shape == null)
			return;
		playing = false;
		for (GameListener l : listeners)
			l.gameOver();
	}

	/**
	 * ��ͣ��Ϸ
	 */
	public void pauseGame() {
		if (shape == null)
			return;
		shape.setPause(true);
		for (GameListener l : listeners)
			l.gamePause();
	}

	/**
	 * ������Ϸ
	 */
	public void continueGame() {
		shape.setPause(false);
		for (GameListener l : listeners)
			l.gameContinue();
	}

	/**
	 * ��Ϸ�Ƿ�������ͣ״̬
	 */
	public boolean isPausingGame() {
		return shape.isPause();
	}

	/**
	 * �����Ϸ��������ʾ��Ϣ
	 * 
	 * @return
	 */
	public String getNewInfo() {
		if (!playing || ground.isFull())
			return " ";// "��ʾ: �� Y ��ʼ����Ϸ";
		else
			return new StringBuffer().append("��ʾ: ").append(" �ٶ� ").append(
					shape.getSpeed()).append("����/��").toString();
	}

	public ShapeFactory getShapeFactory() {
		return shapeFactory;
	}

	public void setShapeFactory(ShapeFactory shapeFactory) {
		this.shapeFactory = shapeFactory;
	}

	public Ground getGround() {
		return ground;
	}

	public void setGround(Ground ground) {
		this.ground = ground;
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	/**
	 * ����Ground ������ beforeDeleteFullLine �¼�����ı����е���ɫ����ͣһ��ʱ��
	 */
	public void beforeDeleteFullLine(Ground ground, int lineNum) {
		// TODO Auto-generated method stub
		ground.changeFullLineColor(lineNum);
		gamePanel.redisplay(ground, shape);
		try {
			Thread.sleep(Global.STAY_TIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ����Ground ������ fullLineDeleted �¼�, �������ʲôҲû��, ֻ�Ǵ�ӡ��һ�仰
	 */
	public void fullLineDeleted(Ground ground, int deletedLineCount) {
		// TODO Auto-generated method stub
		System.out.println("���� " + deletedLineCount + " ��");
	}

	/**
	 * �Ƿ�������Ϸ��
	 * 
	 * @return
	 */
	public boolean isPlaying() {
		if (playing && !ground.isFull())
			return true;
		return false;
	}

	/**
	 * �õ���ʾ��ʾ��Ϣ�����
	 * 
	 * @return
	 */
	public JLabel getGameInfoLabel() {
		return gameInfoLabel;
	}

	/**
	 * ����
	 * 
	 * @param gameInfoLabel
	 */
	public void setGameInfoLabel(JLabel gameInfoLabel) {
		this.gameInfoLabel = gameInfoLabel;
		this.gameInfoLabel.setSize(Global.WIDTH * Global.CELL_WIDTH, 20);
		this.gameInfoLabel.setFont(new Font("����", Font.PLAIN, 12));
		gameInfoLabel.setText(this.getNewInfo());
	}

	/**
	 * ����Ground �� groundIsFull() �¼�, ��������Ϸ�����¼�
	 */
	public void groundIsFull(Ground ground) {
		// TODO Auto-generated method stub
		if (playing) {
			playing = false;
			for (GameListener l : listeners)
				l.gameOver();
		}
	}

	/**
	 * ��Ӽ�����, ����Ӷ��
	 * 
	 * @param l
	 */
	public void addGameListener(GameListener l) {
		if (l != null)
			this.listeners.add(l);
	}

	/**
	 * �Ƴ�������
	 * 
	 * @param l
	 */
	public void removeGameListener(GameListener l) {
		if (l != null)
			this.listeners.remove(l);
	}

}
