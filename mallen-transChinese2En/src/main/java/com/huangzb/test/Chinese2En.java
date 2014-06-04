package com.huangzb.test;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Chinese2En {

	public static void main(String[] args) {
		HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
		outputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		try {
			String[] str = PinyinHelper.toHanyuPinyinStringArray('d', outputFormat);
			
			for(int i = 0; i < str.length; i++){
				System.out.println(str[i]);
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
	}
}
