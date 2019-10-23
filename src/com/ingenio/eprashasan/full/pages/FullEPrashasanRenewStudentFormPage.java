package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.ingenio.eprashasan.components.RenewStudentComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanRenewStudentFormPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	
	@FindBy(locator = "xpath=//h4[contains(.,'Renew Student')] | //a[contains(.,'à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥�à¤¯à¤¾à¤šà¥‡ à¤¨à¥�à¤¤à¤¨à¥€à¤•à¤°à¤£')]")
    public QAFWebElement headerRenewStudent;
	
	
	@FindBy(locator = "xpath=//h4[contains(.,'Renew Student')]/ancestor::div[@class='modal-content'] | ")
    public RenewStudentComponent renewStudentComponent;
	
	
	
	
		
		
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
		driver.get("/");
	}

	public void invoke() {
		launchPage(null);
	}
	
	@Override
	public void waitForPageToLoad() {
		Reporter.log("On Page "+this.getClass().getSimpleName());
		super.waitForPageToLoad();
		//super.waitForAjaxToComplete();
		try {
			headerRenewStudent.waitForVisible();
			headerRenewStudent.waitForPresent();
			
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
	   
	}

}
