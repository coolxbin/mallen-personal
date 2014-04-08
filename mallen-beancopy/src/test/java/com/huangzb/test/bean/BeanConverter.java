package com.huangzb.test.bean;

import com.huangzb.test.beancoper.DateUtil;

import net.sf.cglib.core.Converter;

public class BeanConverter implements Converter {

	@SuppressWarnings("rawtypes")
	public Object convert(Object value, Class target, Object context) {
		System.out.println("value: " + value +"\nvalue type: " + value.getClass() + "\ntarget class: " + target +  "\ncontext: " + context);
		System.out.println();
		if(context.equals("setCreateTime")){
			return DateUtil.strToDateTime((String)value);}
		else{
			return value;	
		}
	}
}
