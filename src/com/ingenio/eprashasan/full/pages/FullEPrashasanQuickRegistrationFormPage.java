package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.ingenio.eprashasan.components.OfficeDetailsComponent;
import com.ingenio.eprashasan.components.RenewStudentComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanQuickRegistrationFormPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator = "xpath=//h4[text()='QUICK REGISTRATION FORM'] | //h4[contains(.,'à¤œà¤²à¤¦ à¤ªà¥�à¤°à¤µà¥‡à¤¶ à¤…à¤°à¥�à¤œ')]")
    public QAFWebElement headerQuickRegistrationForm;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Office')]/parent::fieldset | //legend[contains(.,'à¤•à¤¾à¤°à¥�à¤¯à¤¾à¤²à¤¯')]/parent::fieldset")
    public OfficeDetailsComponent officeDetailsComponent;
	
	@FindBy(locator = "xpath=//h4[contains(.,'Renew Student')]/ancestor::div[@class='modal-content']")
    public RenewStudentComponent renewStudentComponent;
	
	@FindBy(locator = "xpath=//input[@id='hideAndSeekSubmitId']")
    public QAFWebElement buttonAdd;
	
	@FindBy(locator = "xpath=//input[@id='resetId']")
    public QAFWebElement buttonReset;
	
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void waitForPageToLoad() {
		Reporter.log("On Page "+this.getClass().getSimpleName());
		super.waitForPageToLoad();
		super.waitForAjaxToComplete();
		try {
			headerQuickRegistrationForm.waitForVisible();
			headerQuickRegistrationForm.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
			
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
	   
	}
}
