package com.qam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qam.tests.HelperClass;

public class HomePage {
	
	WebDriver driver;
		public HomePage(WebDriver driver) {
		this.driver = driver;
		}
	
	public void showNavMenu() throws InterruptedException{
		try
		  {
//			  Find if we are on Syneos App
			  driver.findElement(By.xpath("//span[@title='SyneosHealth Agent Console']"));
			  System.out.println("We are on SyneosHealth Agent Console App");
		  }catch(Exception e){
			  System.out.println("catch");
			  driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			  Thread.sleep(15000);
//			  search a text from model window search box
			  driver.findElement(By.linkText("View All")).click();
			  driver.findElement(By.xpath("//p[text()='SyneosHealth Agent Console']")).click();
			  Thread.sleep(2000);
			  try{
				  driver.findElement(By.xpath("//button[text()='Discard Changes']")).click();
				  Thread.sleep(15000);
			  }
			  catch(Exception f){
			  System.out.println("Catch inside catch");
			  }
		  					}
		  driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		  Thread.sleep(2000);
	  }
}