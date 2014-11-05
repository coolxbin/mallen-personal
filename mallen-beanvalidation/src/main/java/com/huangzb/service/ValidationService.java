package com.huangzb.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.huangzb.bean.ValidateBean;

@Service("vs")
@Validated
public class ValidationService {
	 
	public void validateParam(@Valid ValidateBean bean){
		System.out.println(bean);
	}
}
