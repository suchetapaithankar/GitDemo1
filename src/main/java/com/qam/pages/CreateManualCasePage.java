package com.qam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateManualCasePage {
	WebDriver driver;
	public CreateManualCasePage(WebDriver driver) {
		this.driver = driver;
	}
	  public void createNewCase() throws InterruptedException{
	  driver.findElement(By.xpath("//a[@role='option' and @title='Create Manual Case']")).click();
	  Thread.sleep(10000);
	  driver.findElement(By.xpath("//select[@name='SelectProject']")).click();

	  
//	  will select a value from 'Project' dropdown
	  WebElement ele1 = driver.findElement(By.xpath("//select[@name='SelectProject']"));
	  Select s1 = new Select(ele1);
	  s1.selectByVisibleText("LifeScan");
	  
//	  will select a value from 'Direction' dropdown
	  WebElement ele2 = driver.findElement(By.xpath("//select[@name='SelectDirection']"));
	  Select s2 = new Select(ele2);
	  s2.selectByVisibleText("OUT");
	  System.out.println("direction selected");
	  
//	  add value in Contact lookup
	  driver.findElement(By.xpath("//input[@type='search' and @name='lookup']")).sendKeys("john cardio");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[@data-aura-class='cLookupInputDetail']")).click();
	  Thread.sleep(2000);
	  System.out.println("lookup searched");
	  
//	  select CCG
	  WebElement ele3 = driver.findElement(By.xpath("//select[@name='SelectCCG']"));
	  Select s3 = new Select(ele3);
	  s3.selectByVisibleText("Test call lifescan");
	  System.out.println("CCG Selected");
	  driver.findElement(By.xpath("//button[text()='Create Case']")).click();
	  System.out.println("case created");
	  Thread.sleep(20000);
	  
//    Find Case Number
	  String Casenumber = driver.findElement(By.xpath("(//span[text()='Case' and @class='slds-p-top_large'])[2]//following::span[1]")).getText();
	  System.out.println(Casenumber);
	}
}
