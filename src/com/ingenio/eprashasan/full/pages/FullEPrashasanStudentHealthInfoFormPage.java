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

public class FullEPrashasanStudentHealthInfoFormPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	
	@FindBy(locator = "xpath=//h4[text()='STUDENT HEALTH INFORMATION'] | //a[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥�à¤¯à¤¾à¤‚à¤šà¥€ à¤†à¤°à¥‹à¤—à¥�à¤¯à¤¾à¤µà¤¿à¤·à¤¯à¥€ à¤®à¤¾à¤¹à¤¿à¤¤à¥€']")
    public QAFWebElement headerStudentHealthInformation;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Search Student')]/parent::fieldset")
	public SearchStudentComponent searchStudentComponent;
	
	@FindBy(locator = "xpath=//h4[contains(.,'Renew Student')]/ancestor::div[@class='modal-content']")
    public RenewStudentComponent renewStudentComponent;
	
	@FindBy(locator = "xpath=//select[@id='yearcombo']")
	public DropdownListWebElement dropdownSelectYear;
	
	@FindBy(locator = "xpath=//select[@id='standardcombo']")
	public DropdownListWebElement dropdownSelectClass;
	
	@FindBy(locator = "xpath=//select[@id='divisioncombo']")
	public DropdownListWebElement dropdownSelectDivision;
	
	@FindBy(locator = "xpath=//select[@id='semFlag']")
	public DropdownListWebElement dropdownSelectSemester;
	
	@FindBy(locator = "xpath=//input[@id='jqg_grid_1256']")
	public QAFWebElement checkbox1;
	
	@FindBy(locator = "xpath=//input[@id='cb_grid']")
	public QAFWebElement checkboxSelectAll;
	
	@FindBy(locator = "xpath=//input[@id='stud_weight0']")
    public QAFWebElement textboxWeight;
	
	@FindBy(locator = "xpath=//input[@id='stud_height0']")
    public QAFWebElement textboxHeight;
	
	@FindBy(locator = "xpath=//select[@id='cob0']")
	public DropdownListWebElement dropdownBloodGroup;
	
	@FindBy(locator = "xpath=//input[@id='stud_chest0']")
    public QAFWebElement textboxChest;
	
	@FindBy(locator = "xpath=//input[@id='stud_west0']")
    public QAFWebElement textboxWaist;
	
	@FindBy(locator = "xpath=//button[@id='updateId']")
	public QAFWebElement buttonSave;
	
	@FindBy(locator = "xpath=//button[contains(.,'Close')]")
	public QAFWebElement buttonClose;
	
	@FindBy(locator = "xpath=//input[@value='Search']")
	public QAFWebElement buttonSearch;
	
	@FindBy(locator = "xpath=//input[@id='submitId']")
	public QAFWebElement buttonFillDetails;
	
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
			headerStudentHealthInformation.waitForVisible();
			headerStudentHealthInformation.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
			
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
	   
	}
}



