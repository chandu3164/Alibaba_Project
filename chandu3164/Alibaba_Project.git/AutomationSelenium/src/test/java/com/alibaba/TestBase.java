package com.alibaba;

import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;






public class TestBase {
	WebDriver driver;
	Ali_Pages ap;
	Actions action;
	
	
	SoftAssert SAssert;
	

	@Parameters({ "Url"})
	@BeforeClass
	
	public void setUp(String Url) {
	 {
		 System.setProperty("webdriver.chrome.driver","E:\\Softwares\\Testing files\\Chrome_Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		ap=new Ali_Pages(driver);
		action=new Actions(driver);
		driver.get(Url);
		SAssert = new SoftAssert();
	 }
	 }
	public void CaptureScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(
				System.getProperty("user.dir") + "/Screenshots/" + name + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(Source, target);
		System.out.println("Screenshot captured");

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
