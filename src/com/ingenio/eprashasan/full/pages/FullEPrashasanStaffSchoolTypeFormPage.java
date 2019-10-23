package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanStaffSchoolTypeFormPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	
	@FindBy(locator = "xpath=//h4[contains(text(),'Staff School Type')]")
    public QAFWebElement headerStaffSchoolType;
	
	@FindBy(locator = "xpath=//input[@id='staffSchooltypeId']")
    public QAFWebElement textboxSchoolType;
	
	@FindBy(locator = "xpath=//input[@id='saveStaffSchooltypeID']")
    public QAFWebElement buttonSave;
	
	@FindBy(locator = "xpath=//input[@id='updateStaffSchooltypeID']")
    public QAFWebElement buttonUpdate;
	
	@FindBy(locator = "xpath=//input[@id='reset']")
    public QAFWebElement buttonReset;
	
	@FindBy(locator = "xpath=//tr[@class='ui-widget-content jqgrow ui-row-ltr']//td[contains(text(),'1')]")
    public QAFWebElement tablerow1;
	
	@FindBy(locator = "xpath=//tr[@class='ui-widget-content jqgrow ui-row-ltr']//td[contains(text(),'3')]")
    public QAFWebElement tablerow3;
	
	@FindBy(locator = "xpath=//div[text()='Delete']")
    public QAFWebElement buttonDelete;
	
	
	
	
	
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
			headerStaffSchoolType.waitForVisible();
			headerStaffSchoolType.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
			
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
	   
	}
}
