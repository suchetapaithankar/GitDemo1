package com.qam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginmPage {

	WebDriver driver;
	//create a constructor and add this.driver to have the same driver as that of base class otherwise it will give NPE
	public loginmPage(WebDriver driver) {
		this.driver = driver;
	}


	public void launchURL(){
		  System.out.println(driver);
		  driver.get("http://test.salesforce.com/");
		  driver.manage().window().maximize();
		  System.out.println("URL launched");
	}
	
	  public void enterUN(){
		  driver.findElement(By.xpath("//*[@id='username']")).sendKeys("testagent3@syneoshealth.com.vamdevtest");
	  }
	  
	  public void enterPWD(){
		  driver.findElement(By.xpath("//*[@id='password']")).sendKeys("User@123!");
	  }
	  
	  public void login() throws InterruptedException{
	  driver.findElement(By.xpath("//*[@id='Login']")).click();
	  Thread.sleep(10000);
	  }

}
