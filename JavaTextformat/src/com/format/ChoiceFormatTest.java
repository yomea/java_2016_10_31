package com.format;

import java.text.ChoiceFormat;
import java.text.MessageFormat;

public class ChoiceFormatTest {
	
	public static void main(String[] args) {
		
		String pattern = "The disk \"{0}\" contains {1}.";
		
		MessageFormat mf = new MessageFormat(pattern);
		//对应的下标
		double[] filelinits = {0, 1, 2};
		//下标对应的内容
		String[] filepart = {"no files", "one file", "{1, number} files"};
		
		ChoiceFormat cf = new ChoiceFormat(filelinits, filepart);
		
		mf.setFormatByArgumentIndex(1, cf);
		
		int fileCount = 3;
		
		String diskName = "MyDisk";
		//new Long(fileCount)如果这个值大于了对应的下标就对应最后的一个值
		Object[] testArgs = {diskName, new Long(fileCount)};
		
		System.out.println(mf.format(testArgs));
		
	}

}
