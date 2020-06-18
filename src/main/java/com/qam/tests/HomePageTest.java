package com.qam.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends HelperClass{

	@Test
	public void showNavigationMenu() throws InterruptedException, IOException {
		loginsf();
		navMenu.showNavMenu();
		test.log(LogStatus.PASS,"Navigated to the Menu dropdown");
	}
}
