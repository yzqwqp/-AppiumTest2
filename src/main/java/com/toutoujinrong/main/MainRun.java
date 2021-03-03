package com.toutoujinrong.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.toutoujinrong.excel.ExcelData;
import com.toutoujinrong.executor.AppiumExecutor;
import com.toutoujinrong.executor.AppiumOperator;
import com.toutoujinrong.utils.AppiumUtils;
import com.toutoujinrong.utils.ConstantUtils;
import com.toutoujinrong.utils.ExcelUtils;
import com.toutoujinrong.vo.TestCaseVo;
import com.toutoujinrong.vo.TestSuiteVo;

/**
 * 自动化执行主方法
 * @author qiupeng
 *
 */
public class MainRun {
//	private final static Logger LOGGER = LoggerFactory.getLogger(MainRun.class);

	
	public static void main(String[] args) throws Exception {
//		AppiumUtils.stopAppium();
//		AppiumUtils.runAppium();
		
		String str = ConstantUtils.TEST_SUITE_PATH;
		System.out.println(str);
		InputStream in = new FileInputStream(new File(str));
		InputStream in2 = new FileInputStream(new File(str));
		
		ExcelData<TestSuiteVo> testSuite = ExcelUtils.read(in, "TestSuites", TestSuiteVo.class);
		ExcelData<TestCaseVo> testCase = ExcelUtils.read(in2, "PublicMethods", TestCaseVo.class);
		
//		Thread.sleep(5000);
		AppiumOperator a = new AppiumOperator();
		AppiumExecutor b = new AppiumExecutor(a);
		b.executeSuite(testSuite, testCase);
//		LOGGER.info("appium start ok ");
//		AppiumUtils.stopAppium();
	}
}
