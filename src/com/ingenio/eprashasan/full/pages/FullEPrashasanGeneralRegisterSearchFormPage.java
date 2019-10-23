package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.ingenio.eprashasan.components.AdditionalStudentDetailsComponent;
import com.ingenio.eprashasan.components.StudentInformationComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanGeneralRegisterSearchFormPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator = "xpath=//h4[text()='GENERAL REGISTER SEARCH FORM'] | //b[text()='à¤¦à¤¾à¤–à¤² à¤–à¤¾à¤°à¥€à¤œ à¤¶à¥‹à¤§ à¤…à¤°à¥�à¤œ']")
    public QAFWebElement headerGeneralRegisterSearchForm;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Student Information')]/parent::fieldset | //legend[contains(.,'à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥�à¤¯à¤¾à¤‚à¤šà¥€ à¤®à¤¾à¤¹à¤¿à¤¤à¥€')]/parent::fieldset")
    public StudentInformationComponent studentInformationComponent;
	
	@FindBy(locator = "xpath=//b[contains(.,'Additional Student')]/ancestor::fieldset")
    public AdditionalStudentDetailsComponent  additionalStudentDetailsComponent;
	
	
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
			headerGeneralRegisterSearchForm.waitForVisible();
			headerGeneralRegisterSearchForm.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
			
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
	   
	}
}
