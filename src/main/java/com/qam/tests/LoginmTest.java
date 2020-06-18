package com.qam.tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


public class LoginmTest {

	public class TestLoginPage extends HelperClass{
		

		  @Test
		  public void loginsf() throws InterruptedException, IOException {
			  System.out.println("Login to salesforce");
			  //only call methods in test class
			  vopenURL.launchURL();	
			  test.log(LogStatus.PASS, "Browser launched"); 			  
			  vopenURL.enterUN();
			  test.log(LogStatus.PASS, "UN entered");
			  vopenURL.enterPWD();
			  vopenURL.login();
			  test.log(LogStatus.PASS, "Login successful");
//			  test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Step Failed");
			  }

		@BeforeTest
		
		  public void launchBrowser() throws Exception {
			  System.out.println("beforetest");
			  
		  }
		
		  @AfterTest
		  public void closeBrowser() throws Exception {
			  System.out.println("aftertest");
//			  driver.findElement(By.xpath("//img[@title='User' and @class='icon noicon']")).click();
		/*	  Thread.sleep(3000);
			  driver.findElement(By.xpath("//a[text()='Log Out']")).click();
			  driver.close();*/
		  }
}
}
