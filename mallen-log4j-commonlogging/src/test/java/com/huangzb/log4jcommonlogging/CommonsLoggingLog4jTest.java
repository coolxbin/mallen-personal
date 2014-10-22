package com.huangzb.log4jcommonlogging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class CommonsLoggingLog4jTest {
	private   static  Log log  =  LogFactory.getLog(CommonsLoggingLog4jTest.class);   

	@Test
	public void test() {
		log.debug("debug test");
	}

}
