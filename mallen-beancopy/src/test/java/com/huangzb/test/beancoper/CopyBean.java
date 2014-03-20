package com.huangzb.test.beancoper;

import com.huangzb.test.bean.SourceBean;
import com.huangzb.test.bean.SourceInnerBean;
import com.huangzb.test.bean.TargetBean;

import net.sf.cglib.beans.BeanCopier;

public class CopyBean {
	public static void main(String[] args) {
		BeanCopier coper = BeanCopier.create(SourceBean.class, TargetBean.class, false);
		
		SourceBean source = new SourceBean("sourceName", 10);
		SourceInnerBean sib = new SourceInnerBean();
		sib.setAge(1);
		sib.setName("sib");
		source.setInnerBean(sib);
		
		TargetBean target = new TargetBean();
		coper.copy(source, target, null);
		
		System.out.println(target);
	}
}
