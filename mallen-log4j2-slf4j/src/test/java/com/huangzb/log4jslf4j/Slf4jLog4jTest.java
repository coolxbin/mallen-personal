package com.huangzb.log4jslf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLog4jTest {
	private static final Logger log = LoggerFactory.getLogger("com.huangzb");

	@Test
	public void test() {
		log.debug("debug logger test");
	}

}
