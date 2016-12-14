package cn.itcast.tetris.game;

import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;


/**
 * ��Ϸ�����������
 * 
 * 
 * @author may
 */
public class GameOptionPanel extends JPanel {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	URL imageURL = GameOptionPanel.class.getResource("/czbk.png");
	private ImageIcon czbkIcon = imageURL != null ? new ImageIcon(imageURL)
			: null;

	private JFrame frame;

	private final JTextField textField_stayTime = new JTextField();

	private final JTextField textField_obstacleNum = new JTextField();

	private JTextField textField_lineNum = new JTextField();

	private final JButton newGameButton = new JButton();

	private final JButton stopGameButton = new JButton();

	private final JButton pauseButton = new JButton();

	private final JCheckBox checkBox_drawGridding = new JCheckBox();

	private final JCheckBox checkBox_colorfulShape = new JCheckBox();

	private final JCheckBox checkBox_colorfulObstacle = new JCheckBox();

	private final JButton button_obstacleColor;

	private final JButton button_griddingColor;

	private final JButton button_shapeColor;

	private final JButton button_fullLineColor;

	private final JButton buttonBackgroundColor;

	private final JButton button_default;

	/**
	 * Create the panel
	 */
	public GameOptionPanel() {
		super();
		setSize(280, 334);
		setLayout(null);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		setFocusable(false);

		final JSeparator separator = new JSeparator();
		separator.setBounds(12, 69, 255, 30);
		add(separator);

		button_griddingColor = new JButton();
		button_griddingColor.setBounds(135, 5, 96, 23);
		separator.add(button_griddingColor);

		button_griddingColor.setFont(new Font("����", Font.PLAIN, 12));
		button_griddingColor.setFocusable(false);
		button_griddingColor.setText("������ɫ");

		button_griddingColor.setVisible(false);

		checkBox_drawGridding.setBounds(5, 5, 105, 23);
		separator.add(checkBox_drawGridding);

		checkBox_drawGridding.setText("��ʾ����");
		checkBox_drawGridding.setFont(new Font("����", Font.PLAIN, 12));

		final JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 105, 255, 39);
		add(separator_1);

		button_shapeColor = new JButton();
		button_shapeColor.setBounds(135, 10, 96, 23);
		separator_1.add(button_shapeColor);

		button_shapeColor.setFont(new Font("����", Font.PLAIN, 12));
		button_shapeColor.setFocusable(false);
		button_shapeColor.setText("������ɫ");

		checkBox_colorfulShape.setText("�رղ�ɫͼ��");
		checkBox_colorfulShape.setBounds(5, 10, 105, 23);
		separator_1.add(checkBox_colorfulShape);

		checkBox_colorfulShape.setSelected(true);
		checkBox_colorfulShape.setFont(new Font("����", Font.PLAIN, 12));

		final JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 145, 255, 39);
		add(separator_2);

		button_obstacleColor = new JButton();
		button_obstacleColor.setBounds(135, 10, 96, 23);
		separator_2.add(button_obstacleColor);

		button_obstacleColor.setFont(new Font("����", Font.PLAIN, 12));
		button_obstacleColor.setFocusable(false);
		button_obstacleColor.setText("������ɫ");

		checkBox_colorfulObstacle.setText("�رղ�ɫ�ϰ���");
		checkBox_colorfulObstacle.setBounds(5, 10, 122, 23);
		separator_2.add(checkBox_colorfulObstacle);

		checkBox_colorfulObstacle.setSelected(true);
		checkBox_colorfulObstacle.setFont(new Font("����", Font.PLAIN, 12));

		final JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(12, 185, 255, 33);
		add(separator_3);

		final JLabel label_7 = new JLabel();
		label_7.setBounds(10, 10, 48, 15);
		separator_3.add(label_7);
		label_7.setFont(new Font("����", Font.PLAIN, 12));
		label_7.setFocusable(false);
		label_7.setText("�������");

		textField_obstacleNum.setFont(new Font("����", Font.PLAIN, 12));
		textField_obstacleNum.setBounds(65, 10, 32, 15);
		separator_3.add(textField_obstacleNum);
		textField_obstacleNum.setText("30");

		final JLabel label_2 = new JLabel();
		label_2.setBounds(100, 10, 18, 15);
		separator_3.add(label_2);
		label_2.setText("��");
		label_2.setFont(new Font("����", Font.PLAIN, 12));

		textField_lineNum.setBounds(120, 10, 24, 15);
		textField_lineNum.setFont(new Font("����", Font.PLAIN, 12));
		separator_3.add(textField_lineNum);
		//

		textField_lineNum.setText("0");

		final JLabel label_8 = new JLabel();
		label_8.setBounds(150, 10, 66, 15);
		separator_3.add(label_8);
		label_8.setFont(new Font("����", Font.PLAIN, 12));
		label_8.setFocusable(false);
		label_8.setText("���ϰ���");

		final JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(12, 220, 255, 33);
		add(separator_4);

		textField_stayTime.setFont(new Font("����", Font.PLAIN, 12));
		textField_stayTime.setBounds(110, 14, 42, 15);
		separator_4.add(textField_stayTime);
		textField_stayTime.setText("300");

		final JLabel label_1 = new JLabel();
		label_1.setBounds(160, 14, 24, 15);
		separator_4.add(label_1);
		label_1.setFont(new Font("����", Font.PLAIN, 12));
		label_1.setFocusable(false);
		label_1.setText("����");

		button_fullLineColor = new JButton();
		button_fullLineColor.setBounds(195, 10, 60, 23);
		separator_4.add(button_fullLineColor);

		button_fullLineColor.setFont(new Font("����", Font.PLAIN, 12));
		button_fullLineColor.setFocusable(false);
		button_fullLineColor.setText("��ɫ");

		final JLabel label = new JLabel();
		label.setBounds(10, 14, 120, 15);
		separator_4.add(label);
		label.setFont(new Font("����", Font.PLAIN, 12));
		label.setFocusable(false);
		label.setText("���е�Ч��ʱ�䣺");

		final JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(15, 260, 250, 69);
		add(separator_5);

		stopGameButton.setText("ֹͣ��Ϸ");

		stopGameButton.setBounds(10, 10, 101, 23);
		separator_5.add(stopGameButton);
		stopGameButton.setFont(new Font("����", Font.PLAIN, 12));
		stopGameButton.setFocusable(false);

		pauseButton.setBounds(135, 10, 103, 23);
		separator_5.add(pauseButton);
		pauseButton.setText("��ͣ/����");
		pauseButton.setFont(new Font("����", Font.PLAIN, 12));
		pauseButton.setFocusable(false);

		newGameButton.setFont(new Font("����", Font.PLAIN, 12));
		newGameButton.setBounds(65, 40, 110, 23);
		separator_5.add(newGameButton);
		newGameButton.setFocusable(false);
		newGameButton.setText("��ʼ����Ϸ");
		// button_obstacleColor.setVisible(false);
		// button_shapeColor.setVisible(false);

		final JLabel label_logo = czbkIcon == null ? new JLabel() : new JLabel(
				czbkIcon);
		label_logo.setBounds(140, 10, 125, 50);
		add(label_logo);

		final JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(12, 35, 119, 33);
		add(separator_6);

		buttonBackgroundColor = new JButton();
		buttonBackgroundColor.setBounds(5, 5, 110, 23);
		separator_6.add(buttonBackgroundColor);
		buttonBackgroundColor.setFont(new Font("����", Font.PLAIN, 12));
		buttonBackgroundColor.setFocusable(false);
		buttonBackgroundColor.setText("���ñ�����ɫ");

		button_default = new JButton();
		button_default.setFont(new Font("����", Font.PLAIN, 12));
		button_default.setText("�ָ�Ĭ������");
		button_default.setBounds(17, 5, 110, 23);
		button_default.setFocusable(false);
		add(button_default);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public int getObstacleNum() {
		try {
			return Integer.parseInt(textField_obstacleNum.getText());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public int getStayTime() {
		try {
			return Integer.parseInt(textField_stayTime.getText());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public JButton getNewGameButton() {
		return newGameButton;
	}

	public JButton getStopGameButton() {
		return stopGameButton;
	}

	public int getLineNum() {
		try {
			return Integer.parseInt(textField_lineNum.getText());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public void setTextField_lineNum(JTextField textField_lineNum) {
		this.textField_lineNum = textField_lineNum;
	}

	public JCheckBox getCheckBox_colorfulShape() {
		return checkBox_colorfulShape;
	}

	public JCheckBox getCheckBox_drawGridding() {
		return checkBox_drawGridding;
	}

	public JTextField getTextField_stayTime() {
		return textField_stayTime;
	}

	public JTextField getTextField_obstacleNum() {
		return textField_obstacleNum;
	}

	public JTextField getTextField_lineNum() {
		return textField_lineNum;
	}

	public boolean isDrawGridding() {

		return checkBox_drawGridding.isSelected();
	}

	public boolean isColorfulShape() {
		return checkBox_colorfulShape.isSelected();
	}

	public boolean isColorfulObstacle() {
		return checkBox_colorfulObstacle.isSelected();
	}

	public ImageIcon getCzbkIcon() {
		return czbkIcon;
	}

	public void setCzbkIcon(ImageIcon czbkIcon) {
		this.czbkIcon = czbkIcon;
	}

	public JButton getPauseButton() {
		return pauseButton;
	}

	public JCheckBox getCheckBox_colorfulObstacle() {
		return checkBox_colorfulObstacle;
	}

	public JButton getButton_obstacleColor() {
		return button_obstacleColor;
	}

	public JButton getButton_griddingColor() {
		return button_griddingColor;
	}

	public JButton getButton_shapeColor() {
		return button_shapeColor;
	}

	public JButton getButton_fullLineColor() {
		return button_fullLineColor;
	}

	public JButton getButtonBackgroundColor() {
		return buttonBackgroundColor;
	}

	public JButton getButton_default() {
		return button_default;
	}

}
