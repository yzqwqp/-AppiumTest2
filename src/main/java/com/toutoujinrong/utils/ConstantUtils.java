package com.toutoujinrong.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 常量类
 * @author qiupeng
 *
 */
public class ConstantUtils {
	
	public static final String TEST_SUITE_PATH	= System.getProperty("user.dir")+"\\TestSuite.xlsx";
	
	public static final String REDIS_KEYSPILT 	= ":";
	public static final String REDIS_INSTID 	= "LT0000001";
	public static final String REDIS_TYPE_REGISTER 	= "1";
	public static final String REDIS_TYPE_SETPWD 	= "2";
	public static final String REDIS_TYPE_FINDPWD 	= "3";
	
	public static final String PATH_SYS = SystemUtils.getSysPath();
	public static final String PATH_CONFIG_PROPERTIES = PATH_SYS + "config/properties/";

	/*重试的次数和间隔*/
	public static final int RETRY_FAIL_SHORT_COUNT = Integer.valueOf(getProperties("retryFailShortCount"));
	public static final int RETRY_SHORT_COUNT = Integer.valueOf(getProperties("retryShortCount"));
	public static final int RETRY_SHORT_INTERVAL = Integer.valueOf(getProperties("retryShortInterval"));
	public static final int RETRY_LONG_COUNT = Integer.valueOf(getProperties("retryLongCount"));
	public static final int RETRY_LONG_INTERVAL = Integer.valueOf(getProperties("retryLongInterval"));
	
	//单步最长等待
	public static final int TIME_WAIT = Integer.valueOf(getProperties("timeWait"));//prop.getProperty("timeWait",null));
	public static final Integer stepInterval = Integer.valueOf(getProperties("StepInterval"));//prop.getProperty("StepInterval", null));

	//	//Android模拟器配置
	public static final String CAPABILITY_PLATFORMNAME = getProperties("capabilityPlatformName");//String.valueOf(prop.getProperty("capabilityPlatformName",null));
	public static final String CAPABILITY_PLATFORMVERSION = getProperties("capabilityPlatformVersion");//String.valueOf(prop.getProperty("capabilityPlatformVersion",null));
	public static final String CAPABILITY_DEVICENAME = getProperties("capabilityDeviceName");//String.valueOf(prop.getProperty("capabilityDeviceName",null));
	public static final String CAPABILITY_UDID = getProperties("capabilityUdid");

	public static String getProperties(String str) {
		PropertyConfigurer getConfiguere = new PropertyConfigurer("prop");
	    return getConfiguere.getValue(str);
	}
	
}
