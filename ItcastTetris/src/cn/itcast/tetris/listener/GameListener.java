package cn.itcast.tetris.listener;

/**
 * ��Ϸ������
 * 
 * 
 * @author may
 * 
 */

public interface GameListener {

	/**
	 * ��Ϸ��ʼ��
	 */
	void gameStart();

	/**
	 * ��Ϸ������
	 */
	void gameOver();

	/**
	 * ��Ϸ��ͣ��
	 */
	void gamePause();

	/**
	 * ��Ϸ������
	 */
	void gameContinue();
}
