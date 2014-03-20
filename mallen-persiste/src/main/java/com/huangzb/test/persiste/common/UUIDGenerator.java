package com.huangzb.test.persiste.common;

import java.io.Serializable;
import java.net.InetAddress;

/**
 * 与hibernate中的UUIDGenerator实现相同, 返回一个32位长度的字符窜.
 * UUID主要用于同时使用多个数据库,不能依赖单个数据库自增生成主键的情形.
 * UUID包含：IP地址，JVM的启动时间（精确到1/4秒），系统时间和一个计数器值（在JVM中唯一）.
 */
public class UUIDGenerator {
	private String sep = "";
	private static final int IP;
	private static UUIDGenerator generator = null;
	static {
		int ipadd;
		try {
			ipadd = toInt(InetAddress.getLocalHost().getAddress());
		} catch (Exception e) {
			ipadd = 0;
		}
		IP = ipadd;
	}
	private static short counter = (short) 0;
	private static final int JVM = (int) (System.currentTimeMillis() >>> 8);

	private UUIDGenerator() {
	}

	protected int getJVM() {
		return JVM;
	}

	protected short getCount() {
		synchronized (UUIDGenerator.class) {
			if (counter < 0)
				counter = 0;
			return counter++;
		}
	}

	protected int getIP() {
		return IP;
	}

	protected short getHiTime() {
		return (short) (System.currentTimeMillis() >>> 32);
	}

	protected int getLoTime() {
		return (int) System.currentTimeMillis();
	}

	private static int toInt(byte[] bytes) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
		}
		return result;
	}

	protected String format(int intval) {
		String formatted = Integer.toHexString(intval);
		StringBuffer buf = new StringBuffer("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	protected String format(short shortval) {
		String formatted = Integer.toHexString(shortval);
		StringBuffer buf = new StringBuffer("0000");
		buf.replace(4 - formatted.length(), 4, formatted);
		return buf.toString();
	}

	public static Serializable generate() {
		if (null == generator) {
			generator = new UUIDGenerator();
		}
		return generator.generateUUID();
	}

	private Serializable generateUUID() {
		return new StringBuffer(36).append(format(getIP())).append(sep)
				.append(format(getJVM())).append(sep)
				.append(format(getHiTime())).append(sep)
				.append(format(getLoTime())).append(sep)
				.append(format(getCount())).toString();
	}
}
