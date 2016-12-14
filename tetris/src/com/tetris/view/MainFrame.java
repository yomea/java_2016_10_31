package com.tetris.view;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import com.tetris.global.Global;

public class MainFrame extends JFrame {
	
	private MyPanel panel;
	
	private static final long serialVersionUID = -1828711638455910277L;

	public void setPanel(MyPanel panel) {
		this.panel = panel;
		
	}
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		
		frame.mianFrameSet();
		
		
	}
	
	public void mianFrameSet() {
		this.setLayout(new BorderLayout());
		panel = new MyPanel();
		this.add(panel, BorderLayout.CENTER);
		this.setSize(Global.GAME_WIDTH, Global.GAME_HEIGHT);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLocationRelativeTo(null);
		
		this.addKeyListener(new MyListener());
		
		this.setVisible(true);

		panel.startGame();
		
		
	}
	
	
	private class MyListener extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			panel.keyPressed(e);
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			panel.keyReleased(e);
		}
		
	}

}
