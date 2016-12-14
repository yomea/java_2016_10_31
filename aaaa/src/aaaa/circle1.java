package aaaa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class circle1 extends JFrame implements ActionListener {
	JButton button1, button2, button3;
	JTextField nametext1, nametext2;
	JLabel label1, label2, label3, label4, label5;
	int r, h;
	double area, s, V;
	String str1, str2, str3;

	public circle1() {
		super("图形界面输入输出");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1 = new JLabel("请输入圆柱的半径:");
		label2 = new JLabel("请输入圆柱的高");
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		nametext1 = new JTextField("请输入圆柱的半径", 15);
		nametext2 = new JTextField("请输入圆柱的高", 15);
		button1 = new JButton("计算周长");
		button2 = new JButton("计算面积");
		button3 = new JButton("计算体积");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(label1);
		cp.add(nametext1);
		cp.add(label2);
		cp.add(nametext2);
		cp.add(button1);
		cp.add(label3);
		cp.add(button2);
		cp.add(label4);
		cp.add(button3);
		cp.add(label5);
		setSize(300, 300);
	}

	public void actionPerformed(ActionEvent e) {

		r = Integer.parseInt((nametext1.getText()));
		h = Integer.parseInt((nametext2.getText()));
		if (e.getSource() == button1) {
			area = Math.PI * r * r;
			str1 = String.valueOf(area);
			label3.setText("圆的面积为：" + str1);
		}
		if (e.getSource() == button2) {
			s = Math.PI * r * 2;
			str2 = String.valueOf(area);
			label4.setText("圆的周长为：" + str2);
		}
		if (e.getSource() == button3) {
			V = Math.PI * r * r * h;
			str3 = String.valueOf(area);
			label5.setText("圆的面积为：" + str3);
		}
	}

	public static void main(String args[]) {
		circle1 frame = new circle1();
		frame.setVisible(true);
	}
}
