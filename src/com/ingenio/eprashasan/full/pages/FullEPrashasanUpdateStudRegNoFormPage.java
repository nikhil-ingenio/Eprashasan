package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanUpdateStudRegNoFormPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	@FindBy(locator = "xpath=//b[text()='UPDATE STUDENT REGISTRATION NO.']")
    public QAFWebElement headerUpdateStudentRegistrationNo;
	
	@FindBy(locator = "xpath=//input[@id='studRegiNo']")
	public QAFWebElement textboxStudentRegNo;
	
	@FindBy(locator = "xpath=//input[@id='nameSearchId']")
	public QAFWebElement textboxStudentName;
	
	@FindBy(locator = "xpath=//input[@id='getStud']")
	public QAFWebElement buttonSearch;
	
	@FindBy(locator = "xpath=//span[text()='Mr. Shete Shubham S -[1 st]']")
	public QAFWebElement dropdownSelectStudent;
	
	@FindBy(locator = "xpath=//input[@id='studNewRegiNo900']")
	public QAFWebElement textboxNewRegNo;
	
	@FindBy(locator = "xpath=//input[@id='studNewRegiNo29']")
	public QAFWebElement textboxNewRegNo1;
	
	@FindBy(locator = "xpath=//input[@value='save']")
	public QAFWebElement buttonSave;
	
	
	public void waitForPopupToLoad() {
		try {
			headerUpdateStudentRegistrationNo.waitForVisible();
			headerUpdateStudentRegistrationNo.waitForPresent();
			
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
			headerUpdateStudentRegistrationNo.waitForVisible();
			headerUpdateStudentRegistrationNo.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
		
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
   
	}

}
