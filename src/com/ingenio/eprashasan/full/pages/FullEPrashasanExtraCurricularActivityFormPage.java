package com.ingenio.eprashasan.full.pages;

import java.util.List;

import org.testng.Assert;

import com.ingenio.eprashasan.components.RenewStudentComponent;
import com.ingenio.eprashasan.components.SearchStudentComponent;
import com.ingenio.eprashasan.components.TopNavigationComponent;
import com.ingenio.eprashasan.core.DropdownListWebElement;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanExtraCurricularActivityFormPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	@FindBy(locator = "xpath=//h4[text()='Extra Curricular Activity'] |//a[normalize-space(.)='à¤…à¤­à¥�à¤¯à¤¾à¤¸à¥‡à¤¤à¤° à¤‰à¤ªà¤•à¥�à¤°à¤®']")
    public QAFWebElement headerExtraCurricularActivity;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Search Student')]/parent::fieldset | //legend[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥€ à¤¶à¥‹à¤§à¤¾']/parent::fieldset")
	public SearchStudentComponent searchStudentComponent;
	
	@FindBy(locator = "xpath=//h4[contains(.,'Renew Student')]/ancestor::div[@class='modal-content']")
    public RenewStudentComponent renewStudentComponent;
	
	@FindBy(locator = "xpath=//*[text()='Quick Registration']/ancestor::ul | //*[normalize-space(.)='à¤œà¤²à¤¦ à¤ªà¥�à¤°à¤µà¥‡à¤¶ à¤…à¤°à¥�à¤œ']/ancestor::ul")
    public TopNavigationComponent topNavigationAdmissionPageComponent;
	
	@FindBy(locator = "xpath=//select[@id='yearcombo']")
	public DropdownListWebElement dropdownSelectYear;
	
	@FindBy(locator = "xpath=//select[@id='standardcombo']")
	public DropdownListWebElement dropdownSelectClass;
	
	@FindBy(locator = "xpath=//select[@id='divisioncombo']")
	public DropdownListWebElement dropdownSelectDivision;
	
	@FindBy(locator = "xpath=//input[@value='Search']")
	public QAFWebElement buttonSearch;
	
	@FindBy(locator = "xpath=//input[@value='Reset']")
	public QAFWebElement buttonReset;
	
	@FindBy(locator = "xpath=//a[text()='Extra Curricular Activity Search Engine'] | //a[normalize-space(.)='à¤…à¤­à¥�à¤¯à¤¾à¤¸à¥‡à¤¤à¤° à¤‰à¤ªà¤•à¥�à¤°à¤® à¤¶à¥‹à¤§ à¤µà¤¿à¤­à¤¾à¤—']")
    public QAFWebElement linkExtraCurricularActivitySearchEngine;
	
	
	@FindBy(locator = "xpath=//td[@aria-describedby='grid_rollNo']")
    public List<QAFWebElement> textStudentRollNoList;
	
	@FindBy(locator = "xpath=//td[@aria-describedby='grid_studentRegNo']")
    public List<QAFWebElement> textStudentRegNoList;
	
	@FindBy(locator = "xpath=//td[@aria-describedby='grid_studentName']")
    public List<QAFWebElement> textboxStudentName;
	
	@FindBy(locator = "xpath=//td[@aria-describedby='grid_studGender']")
    public List<QAFWebElement> textboxGender;
	
	@FindBy(locator = "xpath=//input[@id='cb_grid']")
	public DropdownListWebElement checkboxSelectAll;
	
	@FindBy(locator = "xpath=//input[@id='jqg_grid_1256']")
	public DropdownListWebElement dropdownSelect1;
	
	@FindBy(locator = "xpath=//input[@id='jqg_grid_1284']")
	public DropdownListWebElement dropdownSelect2;
	
	@FindBy(locator = "xpath=//input[@id='fillactivity']")
	public QAFWebElement buttonFillStudentActivity;
	
	@FindBy(locator = "xpath=//input[@id='addExtraActivityId']")
	public QAFWebElement buttonAddExtraActivity;
	
	
	
	public void waitForPopupToLoad() {
		try {
			headerExtraCurricularActivity.waitForVisible();
			headerExtraCurricularActivity.waitForPresent();
			
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
			headerExtraCurricularActivity.waitForVisible();
			headerExtraCurricularActivity.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
		
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
   
	}
}
