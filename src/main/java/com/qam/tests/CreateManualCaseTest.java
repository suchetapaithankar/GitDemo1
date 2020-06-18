package com.qam.tests;

import com.relevantcodes.extentreports.LogStatus;

public class CreateManualCaseTest extends HelperClass{

	public void CreateManualCase() throws InterruptedException{
		manualcase.createNewCase();
		test.log(LogStatus.PASS, "New manual case is created");
	}

}
