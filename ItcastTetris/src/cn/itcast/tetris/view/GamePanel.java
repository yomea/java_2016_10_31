package cn.itcast.tetris.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import cn.itcast.tetris.entities.Ground;
import cn.itcast.tetris.entities.Shape;
import cn.itcast.tetris.util.Global;


/**
 * ��Ϸ����ʾ����<BR>
 * ������ setBackgroundColor() ������Ϸ�ı���ɫ
 * 
 * 
 * @author may
 * 
 * 
 */
public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Image oimg;

	private Graphics og;

	public static final Color DEFAULT_BACKGROUND_COLOR = new Color(0xcfcfcf);
	/**
	 * ������ɫ
	 */
	protected Color backgroundColor = DEFAULT_BACKGROUND_COLOR;

	public GamePanel() {
		/* ���ô�С�Ͳ��� */
		this.setSize(Global.WIDTH * Global.CELL_WIDTH, Global.HEIGHT
				* Global.CELL_HEIGHT);
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		this.setFocusable(true);
	}

	/**
	 * ������ʾ Ground, Shape
	 * 
	 * @param ground
	 * @param shape
	 */
	public synchronized void redisplay(Ground ground, Shape shape) {

		/* ������ʾ */
		if (og == null) {
			oimg = createImage(getSize().width, getSize().height);
			if (oimg != null)
				og = oimg.getGraphics();
		}
		if (og != null) {
			og.setColor(backgroundColor);
			og.fillRect(0, 0, Global.WIDTH * Global.CELL_WIDTH, Global.HEIGHT
					* Global.CELL_HEIGHT);
			ground.drawMe(og);
			if (shape != null)
				shape.drawMe(og);
			this.paint(this.getGraphics());
		}
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(oimg, 0, 0, this);
	}

	/**
	 * �õ���ǰ�ı�����ɫ
	 * 
	 * @return
	 */
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * ���õ�ǰ�ı�����ɫ
	 * 
	 * @param backgroundColor
	 */
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
}
