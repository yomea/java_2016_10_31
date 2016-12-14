package cn.itcast.tetris.listener;

/**
 * 游戏监听器
 * 
 * 
 * @author may
 * 
 */

public interface GameListener {

	/**
	 * 游戏开始了
	 */
	void gameStart();

	/**
	 * 游戏结束了
	 */
	void gameOver();

	/**
	 * 游戏暂停了
	 */
	void gamePause();

	/**
	 * 游戏继续了
	 */
	void gameContinue();
}
