package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanStaffDesignationFormPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	
	@FindBy(locator = "xpath=//h4[contains(text(),'  Staff Designation ')]")
    public QAFWebElement headerStaffSchoolType;
	
	@FindBy(locator = "xpath=//input[@id='designationNameId']")
    public QAFWebElement textboxStaffDesignation;
	
	@FindBy(locator = "xpath=//input[@id='saveDesignationID']")
    public QAFWebElement buttonSave;
	
	@FindBy(locator = "xpath=//input[@id='updateDesignationID']")
    public QAFWebElement buttonUpdate;
	
	@FindBy(locator = "xpath=//input[@id='reset']")
    public QAFWebElement buttonReset;
	
	@FindBy(locator = "xpath=//tr[@class='ui-widget-content jqgrow ui-row-ltr']//td[contains(text(),'1')]")
    public QAFWebElement tablerow1;
	
	@FindBy(locator = "xpath=//tr[@class='ui-widget-content jqgrow ui-row-ltr']//td[contains(text(),'2')]")
    public QAFWebElement tablerow2;
	
	@FindBy(locator = "xpath=//tr[@class='ui-widget-content jqgrow ui-row-ltr']//td[contains(text(),'3')]")
    public QAFWebElement tablerow3;
	
	@FindBy(locator = "xpath=//div[text()='Delete']")
    public QAFWebElement buttonDelete;
	
	
	@FindBy(locator = "xpath=//span[@class='ui-icon ui-icon-seek-prev']")
    public QAFWebElement iconPrevious;
	
	@FindBy(locator = "xpath=//span[@class='ui-icon ui-icon-seek-next']")
    public QAFWebElement iconNext;
	
	@FindBy(locator = "xpath=//span[@class='ui-icon ui-icon-seek-first']")
    public QAFWebElement iconFirst;
	
	@FindBy(locator = "xpath=//span[@class='ui-icon ui-icon-seek-end']")
    public QAFWebElement iconLast;
	
	@FindBy(locator = "xpath=//input[@class='ui-pg-input']")
    public QAFWebElement textboxPagination;
	
	@FindBy(locator = "xpath=//select[@class='ui-pg-selbox']")
    public QAFWebElement dropdownPagination;
	
	
	
	
	
	
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
