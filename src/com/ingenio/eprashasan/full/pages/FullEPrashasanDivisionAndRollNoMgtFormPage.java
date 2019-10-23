package com.ingenio.eprashasan.full.pages;



import java.util.List;

import org.testng.Assert;

import com.ingenio.eprashasan.components.DatePickerComponent;
import com.ingenio.eprashasan.core.DropdownListWebElement;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanDivisionAndRollNoMgtFormPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	@FindBy(locator = "xpath=//h4[contains(.,'DIVISION AND ROLL NUMBER MANAGEMENT')] | //b[normalize-space(.)='à¤¤à¥�à¤•à¤¡à¥€ à¤†à¤£à¤¿ à¤¹à¤œà¥‡à¤°à¥€ à¤•à¥�à¤°. à¤µà¥�à¤¯à¤µà¤¸à¥�à¤¥à¤¾à¤ªà¤¨']")
    public QAFWebElement headerDivisionAndRollNoMgt;
	
	@FindBy(locator = "xpath=//u[contains(.,'Click Here To Undo Readmitted Students')] | //b[normalize-space(.)='à¤ªà¥�à¤¨à¤ƒà¤ªà¥�à¤°à¤µà¥‡à¤¶ à¤�à¤¾à¤²à¥‡à¤²à¥‡ à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥€ à¤ªà¥‚à¤°à¥�à¤µà¤µà¤¤ à¤•à¤°à¤¾']")
    public QAFWebElement linkUndoReAdmittedStudents;
	
	@FindBy(locator = "xpath=//u[contains(.,'Clear Student Roll No')] | //b[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥€ à¤°à¥‹à¤².à¤¨à¤‚.à¤•à¤¾à¤¢à¤¾']")
    public QAFWebElement linkClearStudentRollNo;
	
	@FindBy(locator = "xpath=//select[@id='yearcomboId']")
	public DropdownListWebElement dropdownSelectYear;
	
	@FindBy(locator = "xpath=//select[@id='standardcomboId']")
	public DropdownListWebElement dropdownSelectStandard;
	
	@FindBy(locator = "xpath=//input[@id='divAndRollId']")
	public QAFWebElement textboxSelectNoOfStudents;
	
	@FindBy(locator = "xpath=//input[@id='renewDate']")
	public QAFWebElement textboxRenewDate;
	
	@FindBy(locator = "xpath=//input[@id='tableCheckBoxId']")
	public QAFWebElement buttonGetFields;
	
	@FindBy(locator = "xpath=//input[@id='saveButtonId']")
	public QAFWebElement buttonSAVE;
	
	@FindBy(locator = "xpath=//input[@id='resetid']")
	public QAFWebElement buttonCANCEL;
	
	@FindBy(locator = "xpath=//select[@id='divisioncomboId']")
	public DropdownListWebElement dropdownSelectDivision;
	
	@FindBy(locator = "xpath=//input[@id='regno_0']")
	public List<QAFWebElement> textboxRegistrationNo;
	
	@FindBy(locator = "xpath=//input[@id='rollno_0']")
	public List<QAFWebElement> textboxRollNo;
	
	@FindBy(locator = "xpath=//div[@id='ui-datepicker-div']")
    public DatePickerComponent datePickerComponent;
	
	
	
	public void waitForPopupToLoad() {
	try {
		headerDivisionAndRollNoMgt.waitForVisible();
		headerDivisionAndRollNoMgt.waitForPresent();

		Reporter.log(this.getClass().getSimpleName() + " Popup loaded Sucessfully");
	}catch(Exception e) {
		Reporter.log(this.getClass().getSimpleName() + " Popup Did not Load");
	}
		
	}
	
	
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
			headerDivisionAndRollNoMgt.waitForVisible();
			headerDivisionAndRollNoMgt.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
		
		} catch (Exception e) {
		Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
   
	}

}
