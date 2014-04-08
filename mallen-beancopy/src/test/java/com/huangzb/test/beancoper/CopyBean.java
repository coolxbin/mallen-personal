package com.huangzb.test.beancoper;

import java.io.File;
import java.util.Date;

import com.huangzb.test.bean.BeanConverter;
import com.huangzb.test.bean.SourceBean;
import com.huangzb.test.bean.SourceInnerBean;
import com.huangzb.test.bean.TargetBean;

import net.sf.cglib.beans.BeanCopier;

public class CopyBean {
	public static void main(String[] args) {
		BeanCopier coper = BeanCopier.create(SourceBean.class, TargetBean.class, true);
		
		SourceBean source = new SourceBean("sourceName", 10);
		source.setCreateTime(DateUtil.dateTimeToStr(new Date()));
		SourceInnerBean sib = new SourceInnerBean();
		sib.setAge(1);
		sib.setName("sib");
		source.setFile(new File("d:/表单设计20131226.docx"));
		
		TargetBean target = new TargetBean();
		coper.copy(source, target, new BeanConverter());
		
		System.out.println(target);
	}
}
