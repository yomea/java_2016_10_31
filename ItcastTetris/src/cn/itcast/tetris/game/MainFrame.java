package cn.itcast.tetris.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cn.itcast.tetris.controller.Controller;
import cn.itcast.tetris.entities.Ground;
import cn.itcast.tetris.entities.ShapeFactory;
import cn.itcast.tetris.listener.GameListener;
import cn.itcast.tetris.util.Global;
import cn.itcast.tetris.view.GamePanel;


/**
 * ������, ʵ���� GameListener �ӿ�
 * 
 * 
 * @author may
 * 
 */
public class MainFrame extends JFrame implements GameListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Controller controller = new Controller(new ShapeFactory(),
					new Ground(), new GamePanel());
			MainFrame frame = new MainFrame(controller);
			/* ��ʾ���� */
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private final Controller controller;

	private final GameOptionPanel gameOptionPanel;
	private final GamePanel gamePanel;
	private final Ground ground;
	private final ShapeFactory shapeFactory;

	public MainFrame(Controller c) {
		super();
		this.setTitle("���ǲ��Ͱ����˹����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);

		if(c.getGameInfoLabel() == null)
			c.setGameInfoLabel(new JLabel());
		this.controller = c;
		

		this.shapeFactory = c.getShapeFactory();
		this.ground = c.getGround();
		this.gamePanel = c.getGamePanel();
		this.gameOptionPanel = new GameOptionPanel();
		final JLabel infoLabel = c.getGameInfoLabel();

		/* ������ */
		MyGroundListener mgl = new MyGroundListener();
		ground.addGroundListener(mgl);
		/* ������ */
		// controller = new Controller(shapeFactory, ground, gamePanel,
		// infoLabel);
		gameOptionPanel.getNewGameButton().setEnabled(true);
		gameOptionPanel.getStopGameButton().setEnabled(false);

		this.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				// controller.continueGame();
			}

			public void focusLost(FocusEvent arg0) {
				controller.pauseGame();
				if (gameOptionPanel.getPauseButton().isEnabled())
					gameOptionPanel.getPauseButton().setText("������Ϸ");
			}
		});
		
		gamePanel.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				// controller.continueGame();
			}

			public void focusLost(FocusEvent arg0) {
				controller.pauseGame();
				if (gameOptionPanel.getPauseButton().isEnabled())
					gameOptionPanel.getPauseButton().setText("������Ϸ");
			}
		});

		gameOptionPanel.getNewGameButton().addActionListener(
				new ActionListener() {
					/**
					 * ��ʼ��Ϸ�İ�ť
					 */
					public void actionPerformed(ActionEvent e) {

						// TODO Auto-generated method stub
						if (controller.isPlaying()) {
							return;
						}
						int lineNum = gameOptionPanel.getLineNum();
						int obstacleNum = gameOptionPanel.getObstacleNum();

						controller.newGame();
						/* �ŵ����� */
						ground.generateSomeStochasticObstacle(obstacleNum,
								lineNum);
					}
				});

		gameOptionPanel.getStopGameButton().addActionListener(
				new ActionListener() {
					/**
					 * ֹͣ��Ϸ�İ�ť
					 */
					public void actionPerformed(ActionEvent e) {

						controller.stopGame();
					}
				});

		gameOptionPanel.getPauseButton().setEnabled(false);
		gameOptionPanel.getPauseButton().addActionListener(
				new ActionListener() {
					/**
					 * ��ͣ/������Ϸ�İ�ť
					 */
					public void actionPerformed(ActionEvent e) {
						if (controller.isPausingGame()) {
							controller.continueGame();

						} else {
							controller.pauseGame();
						}
						if (controller.isPausingGame())
							gameOptionPanel.getPauseButton().setText("������Ϸ");
						else
							gameOptionPanel.getPauseButton().setText("��ͣ��Ϸ");
					}
				});

		gameOptionPanel.getCheckBox_drawGridding().addChangeListener(
				new ChangeListener() {
					public void stateChanged(ChangeEvent arg0) {
						gameOptionPanel.getButton_griddingColor().setVisible(
								gameOptionPanel.getCheckBox_drawGridding()
										.isSelected());
						MainFrame.this.refreshOption();
					}
				});
		gameOptionPanel.getCheckBox_colorfulShape().addChangeListener(
				new ChangeListener() {
					public void stateChanged(ChangeEvent arg0) {
						gameOptionPanel.getButton_shapeColor().setVisible(
								gameOptionPanel.getCheckBox_colorfulShape()
										.isSelected());
						MainFrame.this.refreshOption();
					}
				});
		gameOptionPanel.getCheckBox_colorfulObstacle().addChangeListener(
				new ChangeListener() {
					public void stateChanged(ChangeEvent arg0) {
						gameOptionPanel.getButton_obstacleColor().setVisible(
								gameOptionPanel.getCheckBox_colorfulObstacle()
										.isSelected());
						MainFrame.this.refreshOption();
					}
				});

		gameOptionPanel.getButton_shapeColor().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Color shapeColor = JColorChooser
								.showDialog(MainFrame.this, "��ѡ��ͼ�ε���ɫ",
										new Color(0xFF4500));
						if (shapeColor != null)
							shapeFactory.setDefaultShapeColor(shapeColor);
					}
				});
		gameOptionPanel.getButton_griddingColor().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Color griddingColor = JColorChooser.showDialog(
								MainFrame.this, "��ѡ���������ɫ", Color.LIGHT_GRAY);
						if (griddingColor != null)
							ground.setGriddingColor(griddingColor);
					}
				});
		gameOptionPanel.getButton_obstacleColor().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Color obstacleColor = JColorChooser.showDialog(
								MainFrame.this, "��ѡ���ϰ������ɫ", Color.DARK_GRAY);
						if (obstacleColor != null)
							ground.setObstacleColor(obstacleColor);
					}
				});
		gameOptionPanel.getButton_fullLineColor().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Color fullLineColor = JColorChooser.showDialog(
								MainFrame.this, "��ѡ�����е�Ч������ɫ", Color.DARK_GRAY);
						if (fullLineColor != null) {
							ground.setFullLineColor(fullLineColor);
						}
					}
				});
		gameOptionPanel.getButtonBackgroundColor().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Color backgroundColor = JColorChooser
								.showDialog(MainFrame.this, "��ѡ�񱳾�����ɫ",
										new Color(0xcfcfcf));
						if (backgroundColor != null)
							gamePanel.setBackgroundColor(backgroundColor);
					}
				});

		gameOptionPanel.getButton_default().addActionListener(
				new ActionListener() {
					/**
					 * �ָ�Ĭ�����õİ�ť
					 */
					public void actionPerformed(ActionEvent e) {

						gamePanel
								.setBackgroundColor(GamePanel.DEFAULT_BACKGROUND_COLOR);
						gameOptionPanel.getCheckBox_drawGridding().setSelected(
								false);
						ground.setGriddingColor(Ground.DEFAULT_GRIDDING_COLOR);
						gameOptionPanel.getCheckBox_colorfulShape()
								.setSelected(true);
						shapeFactory
								.setDefaultShapeColor(ShapeFactory.DEFAULT_SHAPE_COLOR);
						gameOptionPanel.getCheckBox_colorfulObstacle()
								.setSelected(true);
						ground.setObstacleColor(Ground.DEFAULT_OBSTACLE_COLOR);
						gameOptionPanel.getTextField_obstacleNum()
								.setText("30");
						gameOptionPanel.getTextField_lineNum().setText("0");
						gameOptionPanel.getTextField_stayTime().setText("300");
						ground.setFullLineColor(Ground.DEFAULT_FULL_LINE_COLOR);
					}
				});

		/** ****** */

		/**
		 * subPanel
		 */
		JPanel subPanel = new JPanel();
		subPanel.setLayout(null);
		subPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

		subPanel.setSize(gamePanel.getSize().width + 3,
				infoLabel.getSize().height + gamePanel.getSize().height + 2);
		infoLabel.setBounds(5, 0, infoLabel.getSize().width - 5, infoLabel
				.getSize().height);
		gamePanel.setBounds(1, infoLabel.getSize().height,
				gamePanel.getSize().width, gamePanel.getSize().height);
		subPanel.add(infoLabel);
		subPanel.add(gamePanel);

		int left = 10, left2 = 5;
		gameOptionPanel.setBounds(left, 21, gameOptionPanel.getSize().width,
				gameOptionPanel.getSize().height);
		subPanel.setBounds(left + left2 + gameOptionPanel.getSize().width, 1,
				subPanel.getSize().width, subPanel.getSize().height);

		/**
		 * ˵��
		 */
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		infoPanel.setLayout(null);
		infoPanel.setBounds(10, 25 + gameOptionPanel.getSize().height,
				gameOptionPanel.getSize().width, subPanel.getSize().height
						- gameOptionPanel.getSize().height - 25);

		final JLabel infoTitleLable = new JLabel();
		infoTitleLable.setFont(new Font("����", Font.PLAIN, 12));
		infoTitleLable.setText(Global.TITLE_LABEL_TEXT);
		infoTitleLable.setBounds(10, 5, infoPanel.getSize().width - 10, 20);

		final JTextArea InfoTextArea = new JTextArea();
		InfoTextArea.setFont(new Font("����", Font.PLAIN, 12));
		InfoTextArea.setText(Global.INFO_LABEL_TEXT);
		InfoTextArea.setFocusable(false);
		InfoTextArea.setBackground(this.getBackground());
		InfoTextArea.setBounds(10, 25, infoPanel.getSize().width - 20,
				infoPanel.getSize().height - 50);

		infoPanel.add(infoTitleLable);
		infoPanel.add(InfoTextArea);

		gameOptionPanel.getCheckBox_colorfulObstacle().setFocusable(false);
		gameOptionPanel.getCheckBox_colorfulShape().setFocusable(false);
		gameOptionPanel.getCheckBox_drawGridding().setFocusable(false);

		/* �����������С */
		this
				.setSize(
						gameOptionPanel.getSize().width
								+ gamePanel.getSize().width + left + left2 + 15,
						gamePanel.getSize().height > gameOptionPanel.getSize().height + 20 ? gamePanel
								.getSize().height + 60
								: gameOptionPanel.getSize().height + 60);

		// this.pack();
		/* �ô��ھ��� */
		this.setLocation(this.getToolkit().getScreenSize().width / 2
				- this.getWidth() / 2, this.getToolkit().getScreenSize().height
				/ 2 - this.getHeight() / 2);

		/**
		 * ��Ӽ�����
		 */
		gamePanel.addKeyListener(controller);
		gameOptionPanel.addKeyListener(controller);
		this.addKeyListener(controller);
		controller.addGameListener(this);
		subPanel.addKeyListener(controller);

		this.getContentPane().add(gameOptionPanel);
		this.getContentPane().add(infoPanel);
		this.getContentPane().add(subPanel);
	}

	public void gameOver() {
		// TODO Auto-generated method stub

		gameOptionPanel.getTextField_lineNum().setFocusable(true);
		gameOptionPanel.getTextField_stayTime().setFocusable(true);
		gameOptionPanel.getTextField_obstacleNum().setFocusable(true);
		gameOptionPanel.getPauseButton().setEnabled(false);

		gameOptionPanel.getStopGameButton().setEnabled(false);
		gameOptionPanel.getNewGameButton().setEnabled(true);

		gameOptionPanel.getPauseButton().setText("��ͣ/����");
	}

	public void gameStart() {
		// TODO Auto-generated method stub

		gameOptionPanel.getTextField_lineNum().setFocusable(false);
		gameOptionPanel.getTextField_stayTime().setFocusable(false);
		gameOptionPanel.getTextField_obstacleNum().setFocusable(false);

		gameOptionPanel.getPauseButton().setEnabled(true);

		gameOptionPanel.getNewGameButton().setEnabled(false);
		gameOptionPanel.getStopGameButton().setEnabled(true);
	}

	public void gameContinue() {
		// TODO Auto-generated method stub
		gameOptionPanel.getPauseButton().setText("��ͣ��Ϸ");
	}

	public void gamePause() {
		// TODO Auto-generated method stub
		gameOptionPanel.getPauseButton().setText("������Ϸ");
	}

	private void refreshOption() {
		int stayTime = gameOptionPanel.getStayTime();

		ground.setDrawGridding(gameOptionPanel.isDrawGridding());
		shapeFactory.setColorfulShape(!gameOptionPanel.isColorfulShape());
		ground.setColorfulSupport(!gameOptionPanel.isColorfulObstacle());

		Global.STAY_TIME = stayTime;

	}
}
