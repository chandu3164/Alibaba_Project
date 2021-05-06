package com.alibaba;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;






public class TC_Alibaba extends TestBase{
	
	//sign in to alibaba
	
	@Test(priority=1,dataProvider="getData")
	public void SignIn(String Input1,String Input2) throws InterruptedException, Exception
	{
		
		ap.getSigninlink().click();
		ap.getEmailid().sendKeys(Input1);
		ap.getPassword().sendKeys(Input2);
		Boolean C=	ap.getChechinbox().isSelected();
		Reporter.log("checkin Box is selected",true);
		
		ap.getSigninbtn().click();
		CaptureScreenshot(driver, "signIn");
		Thread.sleep(5000);
		
	}	
		// searching for an item
	
	
	@Test(priority=2,dataProvider = "getValue",    dependsOnMethods="SignIn")
	public void SearchItem(String Input) throws InterruptedException, Exception {	
		ap.getSearchbox().sendKeys(Input);
		 ap.getSearchbox().submit();
		 CaptureScreenshot(driver, "SearchItem");
		 Thread.sleep(2000);
	}	 
		 //Perform the sign out option using Action class
	
	@Test(priority=3,dependsOnMethods="SearchItem")
	public void SignOut() throws InterruptedException, Exception { 
		 WebElement ele=ap.getMyalibaba();
		 action.moveToElement(ele).perform();
		 Thread.sleep(2000);
		 CaptureScreenshot(driver, "SignOut");
		 WebElement ele1=ap.getSignout();
		 action.moveToElement(ele1).perform();
		 ap.getSignout().click();
		 
	
		}
	@DataProvider
	public String[][] getData() throws IOException
	{
	
		String xlPath="F:\\Eclipse_2021\\AutomationSelenium\\src\\test\\java\\com\\testdata\\TestData.xlsx";
		String xlSheet="Sheet1";
		int rowCount=ExcelUtility.getRowCount(xlPath, xlSheet);
		int cellCount=ExcelUtility.getCellCount(xlPath, xlSheet,rowCount);
		
	
		String[][] data=new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=ExcelUtility.getCellData(xlPath,xlSheet,i,j);
			}
		}	
		return data;		

	
		
	}
	@DataProvider
	public String[][] getValue() throws IOException
	{
	
		String xlPath="E:\\Softwares\\Testing_programs\\AutomationSelenium\\src\\test\\java\\com\\testData\\TestData.xlsx";
		String xlSheet="Sheet2";
		int rowCount=ExcelUtility.getRowCount(xlPath, xlSheet);
		int cellCount=ExcelUtility.getCellCount(xlPath, xlSheet,rowCount);
		
	
		String[][] data=new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=ExcelUtility.getCellData(xlPath,xlSheet,i,j);
			}
		}	
		return data;		

	
		
	}
	
	
}

