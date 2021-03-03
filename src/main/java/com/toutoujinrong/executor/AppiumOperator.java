package com.toutoujinrong.executor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.toutoujinrong.utils.ConstantUtils;
import com.toutoujinrong.utils.LoggerUtils;

/**
 * appium操作对象类
 * @author qiupeng
 *
 */
public class AppiumOperator {
	private LoggerUtils logger =  LoggerUtils.getInstant();
	private static HashMap<Long, AppiumOperator> osMap = new HashMap<Long, AppiumOperator>();
	private Long dateTime;
	private String strDateTime;
	private AndroidDriver<AndroidElement>  driver;

	/**
	 * 获取当前线程
	 * @return
	 */
	public static AppiumOperator getInstance() {
		return osMap.get(Thread.currentThread().getId());
	}
	
	public AppiumOperator() {
		Long threadName = Thread.currentThread().getId();
		logger.info("Thread name is " + String.valueOf(threadName));
		
		if (osMap.get(threadName) == null)
			osMap.put(threadName, this);//TODO
		
		Date date = new Date();
		dateTime = date.getTime();
		strDateTime = String.valueOf(dateTime);
		
		//TODO log初始化
		//初始化appium
		initAppium();
	}
	
	@SuppressWarnings("rawtypes")
	private void initAppium() {
		//设置APK路径--如果这里不需要每次都安装apk的话，可以这里注释掉 
//		File classpathRoot = new File(System.getProperty("user.dir"));
//		File appDir = new File(classpathRoot, "apps");
//		File app = new File(appDir, "TouTou_1.7.0.10.apk");
		
		//设置Android参数
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
//		platformName|要测试的手机操作系统|`iOS`, `Android`, 或 `FirefoxOS`|
		capabilities.setCapability("platformName", ConstantUtils.CAPABILITY_PLATFORMNAME);
//		手机操作系统版本
		capabilities.setCapability("platformVersion", ConstantUtils.CAPABILITY_PLATFORMVERSION);
//		deviceName|使用的手机类型或模拟器类型|`iPhone Simulator`, `iPad Simulator`,
//		`iPhone Retina 4-inch`, `Android Emulator`, `Galaxy S4`, 等。
//		在 iOS 上，这个关键字的值必须是使用 `instruments -s devices` 得到的可使用的设备名称之一。在 Android 上，这个关键字目前不起作用
		capabilities.setCapability("deviceName", ConstantUtils.CAPABILITY_DEVICENAME);//TODO
//		连接的物理设备的唯一设备标识
		capabilities.setCapability("udid", ConstantUtils.CAPABILITY_UDID);
		capabilities.setCapability("noReset", true); //不需要再次安装
//		装载apk
//		capabilities.setCapability("app", app.getAbsolutePath());
		
//		|appPackage|你想运行的Android应用的包名|比如`com.example.android.myApp`, `com.android.settings`|
		capabilities.setCapability("appPackage", "com.yaojet.tma.goods");//TODO
//		|appActivity| 你要从你的应用包中启动的 Android Activity 名称。它通常需要在前面添加 `.` 
//		capabilities.setCapability("appActivity", "com.toutouunion.ui.HomeActivity");//TODO
		capabilities.setCapability("appActivity", "com.yaojet.tma.goods.ui.dirverui.main.activity.SplashActivity");//TODO 
//		capabilities.setCapability("appActivity", "com.yaojet.tma.goods.ui.agentui.main.activity.PasswordLoginActivity");//TODO SplashActivity
		//com.lcfool.enjoy.activity
//		|unicodeKeyboard|使用 Unicode 输入法
//		capabilities.setCapability("unicodeKeyboard", "True");
//		|resetKeyboard|重置输入法到原有状态
//		capabilities.setCapability("resetKeyboard", "True");
		
		try {
			
			logger.info("Start a new driver");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(ConstantUtils.TIME_WAIT, TimeUnit.SECONDS);
			logger.info("Start a new driver done");
			
			Thread.sleep(5000);
			
			// 处理权限问题
//			int j;
//			for(j = 0; j<3; j++) {
//				Thread.sleep(ConstantUtils.RETRY_SHORT_INTERVAL);
//				driver.findElement(By.id("android:id/button1")).click();
//			}
			
//			driver.closeApp();
//			driver.launchApp();
			
			
//			driver.switchTo();
//			driver.launchApp();
//			driver.runAppInBackground(int 1000);
			
		} catch (MalformedURLException e) {
			logger.info("url not correct");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	
	
	
	
	public AndroidDriver getDriver() {
		return driver;
	}

	public void setDriver(AndroidDriver driver) {
		this.driver = driver;
	}
}
