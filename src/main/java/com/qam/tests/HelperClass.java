package com.qam.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.qam.pages.CreateManualCasePage;
import com.qam.pages.HomePage;
import com.qam.pages.loginmPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.ExcelUtils;



public class HelperClass {
	WebDriver driver;
	// create variables for ExtentTest and ExtentReports
	static ExtentTest test;
	static ExtentReports report;
//	static File FilePath;
	
	// create a variable of the class that we want to create an object and pass driver
	loginmPage vopenURL;
	HomePage navMenu;
	CreateManualCasePage manualcase;
	
	public void callAllPageClasses(){
		System.out.println("Inside base class url method");
		//creating object of the page class and passing the driver
		vopenURL = new loginmPage(driver);
		navMenu = new HomePage(driver);
		manualcase = new CreateManualCasePage(driver);
	}
	
	
	@BeforeClass (alwaysRun = true)
	public void intialize(){				  
				  System.out.println("Inside base class insiatlize method");	  		
				  String exePath = "D:\\Salesforce\\Selenium files and exes\\Browser exe\\chromedriver.exe";
				  System.setProperty("webdriver.chrome.driver", exePath);
				  driver = new ChromeDriver();
				  // calling the method where new obj is created for page class
				  callAllPageClasses();
				  System.out.println("before method last statement");
				  report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
				  test = report.startTest("ExtentDemoMyApps");
	}
	 
	@AfterClass
	public void afterClass(){
		  report.endTest(test);
		  report.flush();
	}
	
	@DataProvider
    public Object[][] AccountData() throws Exception{

         Object[][] testObjArray = ExcelUtils.getTableArray("D://Salesforce//Workspace_automation//MavenProject//DDD//LoginVamDevTest.xlsx","Sheet1");
 //        File FilePath = new File("D://Salesforce//Workspace_automation//MavenProject//DDD//LoginVamDevTest.xlsx");
         return (testObjArray);
	}

	public static String capture(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File scrFile = (ts.getScreenshotAs(OutputType.FILE));
		File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()
		+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		} 
	
	 public void loginsf() throws InterruptedException, IOException {
		  System.out.println("Login to salesforce");
		  //only call methods in test class
		  vopenURL.launchURL();				  
		  vopenURL.enterUN();
		  vopenURL.enterPWD();
		  vopenURL.login();
		  }
}
