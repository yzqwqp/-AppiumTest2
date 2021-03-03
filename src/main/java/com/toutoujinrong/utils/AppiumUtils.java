package com.toutoujinrong.utils;


import io.appium.java_client.android.AndroidDriver;
import mx4j.log.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toutoujinrong.executor.AppiumOperator;


/**
 * demo 类，已弃用
 * @author qiupeng
 *
 */
public class AppiumUtils {
	private static AndroidDriver<?>  driver;
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
//		AppiumUtils.stopAppium();
//		AppiumUtils.runAppium();
		
		//启动Android
		AppiumOperator a = new AppiumOperator();
		driver = a.getDriver();
//		Thread.sleep(10000);
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//		System.out.println(driver.getTitle());
//		driver.startActivity("com.yaojet.tma.goods", "com.yaojet.tma.goods.ui.agentui.main.activity.PasswordLoginActivity");
//		Thread.sleep(10000);
		driver.findElement(By.id("com.yaojet.tma.goods:id/et_phone_number")).sendKeys("18252726081");
		driver.findElement(By.id("com.yaojet.tma.goods:id/tv_get_verify_code")).click();
		
//		
//		com.yaojet.tma.goods:id/et_verify_code
//		//逛一下
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@text=' 密码登录']")).click();
////		driver.findElement(By.id("com.yaojet.tma.goods:id/tv_password_login")).click();
//		Thread.sleep(500);
////		driver.findElement(By.id("com.yaojet.tma.goods:id/bt_test")).click();
//		Thread.sleep(500);
//		driver.findElement(By.id("com.yaojet.tma.goods:id/et_phone_number")).sendKeys("18115568455");
//		Thread.sleep(500);
//		driver.findElement(By.id("com.yaojet.tma.goods:id/et_verify_code")).sendKeys("111111");
//		Thread.sleep(500);
//		driver.findElement(By.id("com.yaojet.tma.goods:id/tv_login")).click();
//		
//		AppiumUtils.stopAppium();
	}
	
	
	
	
	
	/**
	 * 启动安卓设备
	 * 
	 * @throws MalformedURLException
	 */
	public static void launchApp() throws MalformedURLException {

		//设置APK路径--如果这里不需要每次都安装apk的话，可以这里注释掉 
//		File classpathRoot = new File(System.getProperty("user.dir"));
//		File appDir = new File(classpathRoot, "apps");
//		File app = new File(appDir, "TouTou_1.7.0.10.apk");
		
		//设置Android参数
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
//		platformName|要测试的手机操作系统|`iOS`, `Android`, 或 `FirefoxOS`|
		capabilities.setCapability("platformName", "Android");
//		手机操作系统版本
		capabilities.setCapability("platformVersion", "4.4.2");
//		deviceName|使用的手机类型或模拟器类型|`iPhone Simulator`, `iPad Simulator`,
//		`iPhone Retina 4-inch`, `Android Emulator`, `Galaxy S4`, 等。
//		在 iOS 上，这个关键字的值必须是使用 `instruments -s devices` 得到的可使用的设备名称之一。在 Android 上，这个关键字目前不起作用
		capabilities.setCapability("deviceName", "Android Emulator");//TODO
//		连接的物理设备的唯一设备标识
//		capabilities.setCapability("udid", "127.0.0.1:26944");
		capabilities.setCapability("udid", "HC48FZ000271");
		
//		装载apk
//		capabilities.setCapability("app", app.getAbsolutePath());
		
//		|appPackage|你想运行的Android应用的包名|比如`com.example.android.myApp`, `com.android.settings`|
		capabilities.setCapability("appPackage", "com.toutouunion");//TODO
//		|appActivity| 你要从你的应用包中启动的 Android Activity 名称。它通常需要在前面添加 `.` 
//		capabilities.setCapability("appActivity", "com.toutouunion.ui.HomeActivity");//TODO
		capabilities.setCapability("appActivity", "com.toutouunion.ui.welcome.GuideActivity");//TODO
		//com.lcfool.enjoy.activity
//		|unicodeKeyboard|使用 Unicode 输入法
//		capabilities.setCapability("unicodeKeyboard", "True");
//		|resetKeyboard|重置输入法到原有状态
//		capabilities.setCapability("resetKeyboard", "True");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	/***
	* 左滑1/2屏幕
	*/
//	public static void slideLeft(){
//	int x=driver.manage().window().getSize().width;
//	int y=driver.manage().window().getSize().height;
//	driver.swipe(x/4*3, y/2, x/4*1, y/2, 0);
//	}
	
	
	/**
	 * 启动appium
	 */
	public void startAppuim(){
	   	 List<String> cmdLine = new ArrayList<String>(Arrays.asList(new String[] 
	   	 {"cmd.exe", "/C", "start", "node", "C:/Users/Administrator/AppData/Roaming/npm/appium", "--no-reset"}));  
	   	 //D:\00-ProgramFiles\Appium\Appium.exe
	        ProcessBuilder pb = new ProcessBuilder(cmdLine);  
	        try {  
	            pb.start();  
	            System.out.println("node start ok");  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	            System.out.println("node start error");  
	        }  
	        try {  
	            Thread.sleep(1000);  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        }  
	  }
	
	public static void runAppium() {
		String cmd= "cmd /c appium";  
		runCmd(cmd);
	}
	
	public static void stopAppium() {
		String cmd="taskkill /F /IM node.exe";
		runCmd(cmd);
	}
	
	public static void runCmd(String cmd){
		try {
            Runtime rt = Runtime.getRuntime(); // 获取运行时系统  
            Process proc = rt.exec(cmd);//执行命令
            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(), Charset.forName("GBK")));//解决打印结果乱码的问题
            //回显dos命令执行后的结果
            String line = null;  
            while ((line = br.readLine()) != null) { // 打印出命令执行的结果  
                System.out.println(line);  
            }  
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
