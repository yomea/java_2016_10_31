package com.copyDirectory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件的拷贝
 * 
 * @author may
 *
 */
public class FileUtil {

	/**
	 * 
	 * @param src
	 *            源文件路径
	 * @param dest
	 *            目标文件路径
	 * @return
	 */
	public static boolean copyDir(String src, String dest) {

		File srcFile = new File(src);

		File destFile = new File(dest, srcFile.getName());

		InputStream in = null;

		OutputStream out = null;

		try {
			// 如果是文件就直接进行拷贝
			if (srcFile.isFile()) {
				// 如果文件已经存在就重命名
				if(destFile.getAbsolutePath().contains(srcFile.getAbsolutePath())) {
					System.out.println("不能将父目录拷贝给子目录！！！");
					return false;
				}
				if (destFile.exists()) {
					String destName = destFile.getAbsolutePath();
					int pos = destName.lastIndexOf(".");
					if (pos != -1) {
						destName = destName.substring(0, pos) + ".bak" + destName.substring(pos);
					}
					destFile = new File(destName);
					System.out.println("存在同名文件，已重命名为" + destFile.getName());

				} 
				in = new FileInputStream(srcFile);
				out = new FileOutputStream(destFile);
				byte[] buff = new byte[1024];
				int len = 0;
				while ((len = in.read(buff)) != -1) {
					out.write(buff, 0, len);

				}
				out.flush();
				// 如果是文件夹就进行递归
			} else if (srcFile.isDirectory()) {
				// 判断这个文件夹是否已经存在，不存在就创建
				if (!destFile.exists()) {
					destFile.mkdirs();
					// 如果它存在且又不是文件夹，如果进行相同名字（这个文件没有后缀，有后缀的视为不同名字）文件夹的创建就会出错
				} else if (!destFile.isDirectory()) {
					throw new IOException("文件夹中存在相同名称的文件！！！");
				}
				// 获取子file进行递归操作
				File[] files = srcFile.listFiles();
				for (File file : files) {
					copyDir(src + "/" + file.getName(), destFile.getAbsolutePath());
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到！！！");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("拷贝失败！！！");
			e.printStackTrace();
		} finally {
			ResoucesClose.close(out, in);

		}

		return true;
	}

}
