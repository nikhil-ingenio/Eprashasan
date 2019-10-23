package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.ingenio.eprashasan.components.RenewStudentComponent;
import com.ingenio.eprashasan.components.SearchStudentComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanOtherDetailsFormPage extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	@FindBy(locator = "xpath=//h4[text()=EDUCATION OFFICER NO. AND CONCESSION']")
    public QAFWebElement headerOtherDetails;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Search Student')]/parent::fieldset | //legend[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥€ à¤¶à¥‹à¤§à¤¾']")
    public SearchStudentComponent searchStudentComponent;
	
	@FindBy(locator = "xpath=//h4[contains(.,'Renew Student')]/ancestor::div[@class='modal-content']")
    public RenewStudentComponent renewStudentComponent;
	
	@FindBy(locator = "xpath=//input[@onclick='reloadGrid();']")
    public QAFWebElement buttonSSearch;

	@FindBy(locator = "xpath=//input[@value='Reset']")
	public QAFWebElement buttonReset;
	
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void waitForPageToLoad() {
		Reporter.log("On Page "+this.getClass().getSimpleName());
		super.waitForPageToLoad();
		//super.waitForAjaxToComplete();
		try {
			headerOtherDetails.waitForVisible();
			headerOtherDetails.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
			
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
	   
	}
}
