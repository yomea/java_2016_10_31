package com.deleteFile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DeleteFile extends JFrame {
	
	private static final long serialVersionUID = -6558968662170651907L;
	//存储需要删除的文件或者文件名
	private List<String> fileNames = new ArrayList<String>();
	
	private JLabel lable = null;
	
	private JPanel main = null;
	
	private JPanel input1 = null;
	
	private JPanel input2 = null;
	
	private JPanel input3 = null;
	
	private JPanel textArea = null;
	
	private JPanel tip1 = null;
	
	private JPanel tip2 = null;
	
	private JPanel deletePanel = null;
	
	private JTextField deletetf = null; 
	
	private JButton addButton = null;
	
	private JPanel addIgnore = null;
	
	private JPanel iteratorDir = null;
	
	private JTextArea jTextArea = null;
	
	private JButton delete = null;
	
	private JScrollPane scrollPane = null;
	
	private JTextField parentDir = null;
	
	private boolean isAdd = false;
	
	public DeleteFile() {
		this.setTitle("删除不想要的文件或文件夹");
		this.setSize(300,300);
		input1 = new JPanel(new BorderLayout());
		main = new JPanel(new GridLayout(3, 1, 0, 10));
		main.setBackground(Color.WHITE);
		tip1 = new JPanel();
		lable = new JLabel("提示");
		tip1.setBackground(new Color(242, 242, 242));
		lable.setHorizontalAlignment(JLabel.CENTER);
		lable.setVerticalAlignment(JLabel.CENTER);
		tip1.add(lable);
		input1.add(tip1,BorderLayout.NORTH);
		textArea = new JPanel();
		JLabel jta = new JLabel("<html>默认删除.settings，bin，.git文件夹<br />.project，.classpath，.gitignore文件</html>");
		
		jta.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		textArea.add(jta);
		input1.add(textArea, BorderLayout.CENTER);
		main.add(input1);
		
		input2 = new JPanel();
		tip2 = new JPanel(new BorderLayout());
		JLabel label = new JLabel("输入要删除的文件或文件夹名");
		tip2.add(label);
		input2.add(tip2, BorderLayout.NORTH);
		deletePanel = new JPanel();
		addButton = new JButton("添   加");
		addButton.setFont(new Font("微软雅黑", Font.PLAIN, 8));
		addButton.setBackground(Color.green);
		addButton.addActionListener(new AddAction());
		addIgnore = new JPanel(new FlowLayout());
		
		deletePanel.add(new JPanel());
		deletetf = new JTextField(10);
		addIgnore.add(deletetf);
		addIgnore.add(addButton);
		deletePanel.add(addIgnore);
		input2.add(deletePanel);
		main.add(input2);
		
		
		input3 = new JPanel(new BorderLayout());
		iteratorDir = new JPanel(new BorderLayout());
		JPanel deletePanel = new JPanel();
		parentDir = new JTextField(10);
		delete = new JButton("删   除");
		delete.addActionListener(new DeleteAction());
		delete.setFont(new Font("微软雅黑", Font.PLAIN, 8));
		deletePanel.add(delete);
		deletePanel.add(parentDir);
		iteratorDir.add(deletePanel, BorderLayout.NORTH);
		jTextArea = new JTextArea();
		jTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 10));
		jTextArea.setForeground(Color.BLACK);
		jTextArea.setEnabled(true);
		scrollPane = new JScrollPane(jTextArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		iteratorDir.add(scrollPane);
		input3.add(iteratorDir);
		main.add(input3);
		
		
		this.getContentPane().add(main);
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * 点击事件，点击后删除在方框中填入的文件名
	 * @author may
	 *
	 */
	private class AddAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String fileName = deletetf.getText().trim();
			deletetf.setText("");
			if(!fileName.equals("")) {
				if(!isAdd) {
					fileNames.clear();
					
				}
				isAdd = true;
				if(!fileNames.contains(fileName)) {
					
					fileNames.add(fileName);
					
				}
				
			}
		}
		
		
	}
	
	/**
	 * 点击删除按钮直接删除list中指定的文件
	 * 如果用户没有添加要删除的文件，将会删除默认文件
	 * @author may
	 *
	 */
	private class DeleteAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String parentStr = parentDir.getText().trim();
			if(!parentStr.equals("")) {
				
				search(new File(parentStr));
				
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		DeleteFile deleteFile = new DeleteFile();
		//记录默认要删除的文件
		deleteFile.fileNames.add(".settings");
		deleteFile.fileNames.add("bin");
		deleteFile.fileNames.add(".git");
		deleteFile.fileNames.add(".classpath");
		deleteFile.fileNames.add(".gitignore");
		deleteFile.fileNames.add(".project");
		deleteFile.fileNames.add("build");
	}

	/**
	 * 搜索要删除的文件，找到就将它删除，没有找到就什么也不做
	 * @param f
	 */
	public void search(File f) {
		if (!f.exists()) {

			System.exit(0);
		}
		String str = f.getAbsolutePath();
		
		for (String string : fileNames) {
			if (str.endsWith(string)) {
				deleteFile(f);

			} 
		}

		/*if (f.isDirectory()) {
			
			if (str.endsWith(".settings")) {
				deleteFile(f);

			} else if (str.endsWith("bin")) {
				deleteFile(f);

			} else if (str.endsWith(".git")) {
				deleteFile(f);

			}

		} else if (f.isFile()) {
			if (str.endsWith(".project")) {
				deleteFile(f);

			} else if (str.endsWith(".classpath")) {
				deleteFile(f);

			} else if (str.endsWith(".gitignore")) {

				deleteFile(f);
			}

		}*/
		
		File[] files = f.listFiles();
		//递归查找
		if(files != null && files.length > 0) {
			for (File file : files) {
				search(file);
			}
		}
		
		

	}

	/**
	 * 递归删除文件
	 * @author may
	 * @param file
	 */
	public void deleteFile(File file) {
		// 如果不存在就直接返回
		if (!file.exists()) {
			return;

		}
		// 如果它是个目录就循环找到子目录，删除子目录
		if (file.isDirectory()) {
			File[] files = file.listFiles();

			for (File f : files) {
				deleteFile(f);

			}

		}
		// 删除文件或文件夹
		file.delete();
		jTextArea.append(file.getAbsolutePath() + "\r\n");
	}

}
