package com.ingenio.eprashasan.full.pages;


import java.util.List;

import org.testng.Assert;

import com.ingenio.eprashasan.components.RenewStudentComponent;
import com.ingenio.eprashasan.components.StudentInformationTableComponent;
import com.ingenio.eprashasan.core.DropdownListWebElement;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;


public class FullEPrashasanDivisionManagementFormPage extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	@FindBy(locator = "xpath=//h4[text()='DIVISION MANAGEMENT FORM'] | //b[normalize-space(.)='à¤¤à¥�à¤•à¤¡à¥€ à¤µà¥�à¤¯à¤µà¤¸à¥�à¤¥à¤¾à¤ªà¤¨']")
    public QAFWebElement headerDivisionManagementForm;
	
	@FindBy(locator = "xpath=//select[@id='divtype']")
	public DropdownListWebElement dropdownSelectDivisionAllocationtype;
	
	@FindBy(locator = "xpath=//select[@id=\"yearcombo\"]")
    public DropdownListWebElement dropdownSelectYear;
	
	@FindBy(locator = "xpath=//select[@id=\"standardcombo\"]")
    public DropdownListWebElement dropdownClass;
	
	@FindBy(locator = "xpath=//input[@id=\"singlesel\"]")
    public QAFWebElement buttonSearch;
	
	@FindBy(locator = "xpath=//input[@id='multisel']")
    public QAFWebElement buttonMultiSearch;
	
	@FindBy(locator = "xpath=//textarea[@id='regnostextarea']")
	public QAFWebElement textareaStudRegNo;
	
	@FindBy(locator = "xpath=//select[@id=\"divisioncombo\"]")
    public DropdownListWebElement dropdownSetDivision;
	
	@FindBy(locator = "xpath=//input[@id=\"changeDivisionIdManual\"]")
    public QAFWebElement buttonSetDivision;
	
	@FindBy(locator = "xpath=//input[@id='changeDivisionId']")
    public QAFWebElement buttonMultiSetDivision;
	
	@FindBy(locator = "xpath=//div[@id='gview_grid']")
    public StudentInformationTableComponent  studentInformationTableComponent;
	
	@FindBy(locator = "xpath=//h4[contains(.,'Renew Student')]/ancestor::div[@class='modal-content']")//not found
    public RenewStudentComponent renewStudentComponent;
	
	@FindBy(locator = "xpath=//div[@id='jqgh_cb']")
    public List<QAFWebElement> Checkboxes;
	
	@FindBy(locator = "xpath=//input[@role='checkbox']")
    public List<QAFWebElement> Checkbox;
	
	@FindBy(locator = "xpath=jqg_grid_1209")
    public QAFWebElement Checkbox2;
	
	@FindBy(locator = "xpath=//span[@class='ui-icon ui-icon-seek-next']")
    public QAFWebElement IconNext;
	
	@FindBy(locator = "xpath=//span[@class='ui-icon ui-icon-seek-prev']")
    public QAFWebElement IconPrevious;
	
	@FindBy(locator = "xpath=//span[@class='ui-icon ui-icon-seek-first']")
    public QAFWebElement IconFirst;
	
	@FindBy(locator = "xpath=//span[@class='ui-icon ui-icon-seek-end']")
    public QAFWebElement IconLast;
	
	
	
	
	
	
	
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
			headerDivisionManagementForm.waitForVisible();
			headerDivisionManagementForm.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
			
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
	   
	}
}