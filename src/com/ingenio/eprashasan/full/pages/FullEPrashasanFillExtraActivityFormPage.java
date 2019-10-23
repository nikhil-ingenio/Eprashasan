package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.ingenio.eprashasan.components.RenewStudentComponent;
import com.ingenio.eprashasan.components.SearchStudentComponent;
import com.ingenio.eprashasan.core.DropdownListWebElement;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanFillExtraActivityFormPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	
	@FindBy(locator = "xpath=//h4[text()='Fill Extra Activity']")
    public QAFWebElement headerFillExtraActivity;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Search Student')]/parent::fieldset")
	public SearchStudentComponent searchStudentComponent;
	
	@FindBy(locator = "xpath=//h4[contains(.,'Renew Student')]/ancestor::div[@class='modal-content']")
    public RenewStudentComponent renewStudentComponent;
	
	@FindBy(locator = "xpath=//select[@id='categorycomboId']")
	public DropdownListWebElement dropdownSelectCategory;
	
	@FindBy(locator = "xpath=//select[@id='subcategorycomboId']")
	public DropdownListWebElement dropdownSelectSubCategory;
	
	@FindBy(locator = "xpath=//select[@id='playlevelcomboId']")
	public DropdownListWebElement dropdownSelectPlayLevel;
	
	@FindBy(locator = "xpath=//select[@id='rankcomboId']")
	public DropdownListWebElement dropdownSelectRank;
	
	@FindBy(locator = "xpath=//input[@id='activityDetails']")
	public QAFWebElement textboxActivityDetails;
	
	@FindBy(locator = "xpath=//select[@name='admissionday']")
	public DropdownListWebElement dropdownSelectDate;
	
	@FindBy(locator = "xpath=//select[@name='admissionmonth']")
	public DropdownListWebElement dropdownSelectMonth;
	
	@FindBy(locator = "xpath=//select[@name='admissionyear']")
	public DropdownListWebElement dropdownSelectYear;
	
	@FindBy(locator = "xpath=//input[@id='fillcategotyDetailsID']")
	public QAFWebElement buttonSave;
	
	@FindBy(locator = "xpath=//input[@id='closeid']")
	public QAFWebElement buttonCancel;
	
	
	
	public void waitForPopupToLoad() {
		Reporter.log("On Page "+this.getClass().getSimpleName());
		try {
			headerFillExtraActivity.waitForVisible();
			headerFillExtraActivity.waitForPresent();
			
			Reporter.log(this.getClass().getSimpleName() + " Popup loaded Sucessfully");
		}catch(Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
		
	}
	
	
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void waitForPageToLoad() {
		super.waitForPageToLoad();
		super.waitForAjaxToComplete();
		try {
			headerFillExtraActivity.waitForVisible();
			headerFillExtraActivity.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
		
		} catch (Exception e) {
		Reporter.log(this.getClass().getSimpleName() + " Page Did not Load");
		}
   
	}

}
