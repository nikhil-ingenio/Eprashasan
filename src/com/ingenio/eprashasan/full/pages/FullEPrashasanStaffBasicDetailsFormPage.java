package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.ingenio.eprashasan.components.TopNavigationComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanStaffBasicDetailsFormPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	@FindBy(locator = "xpath=//h4[text()='  Staff Basic Details ']")
	public QAFWebElement headerStaffBasicDetailsForm;
	
	@FindBy(locator = "xpath=//*[text()='Setting']/ancestor::ul")
    public TopNavigationComponent topNavigationStaffBasicDetailsComponent;
	
	
	
	
	
	
	
	
	
	
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stubs
		
	}
	
	@Override
	public void waitForPageToLoad() {
		Reporter.log("On Page "+this.getClass().getSimpleName());
		super.waitForPageToLoad();
		super.waitForAjaxToComplete();
		try {
			headerStaffBasicDetailsForm.waitForVisible();
			headerStaffBasicDetailsForm.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
			
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
	   
	}

}
