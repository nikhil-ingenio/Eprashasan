package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.ingenio.eprashasan.components.DatePickerComponent;
import com.ingenio.eprashasan.core.DropdownListWebElement;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanUpdateStudDivisionFormPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	@FindBy(locator = "xpath=//b[text()='Update Student Division']")
    public QAFWebElement headerUpdateStudentDivision;
	
	@FindBy(locator = "xpath=//input[@id='studRegiNo']")
	public QAFWebElement textboxStudRegNo;
	
	@FindBy(locator = "xpath=//input[@id='studNameId']")
	public QAFWebElement textboxStudentName;
	
	@FindBy(locator = "xpath=//input[@id='getStud']")
    public QAFWebElement buttonSearch;
	
	@FindBy(locator = "xpath=//div[@id='ui-datepicker-div']")
    public DatePickerComponent datePickerComponent;
	
	@FindBy(locator = "xpath=//input[@id='datepicker13']")
	public QAFWebElement textboxDate;
	
	@FindBy(locator = "xpath=//select[@id='divisioncomboId']")
	public DropdownListWebElement dropdownSelectNewDivision;
	
	@FindBy(locator = "xpath=//input[@onclick='addDataStudPriviousTable();setDivisionForEdit();']")
    public QAFWebElement buttonSave;
	
	
	
	
	
	public void waitForPopupToLoad() {
		try {
			headerUpdateStudentDivision.waitForVisible();
			headerUpdateStudentDivision.waitForPresent();
			
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
			headerUpdateStudentDivision.waitForVisible();
			headerUpdateStudentDivision.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
		
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
   
	}

}
