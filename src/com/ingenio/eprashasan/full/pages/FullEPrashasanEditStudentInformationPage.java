package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.ingenio.eprashasan.components.DatePickerComponent;
import com.ingenio.eprashasan.components.RenewStudentComponent;
import com.ingenio.eprashasan.components.SearchStudentComponent;
import com.ingenio.eprashasan.components.SelectColumnsForSearchComponent;
import com.ingenio.eprashasan.components.StudentInformationComponent;
import com.ingenio.eprashasan.components.StudentInformationTableComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanEditStudentInformationPage  extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator = "xpath=//h4[text()='Edit Student Information'] | //a[normalize-space(.)='विद्यार्थ्याच्या माहितीत बदल']")
    public QAFWebElement headerEditStudentInformation;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Information of Student')]/parent::fieldset | //legend[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥�à¤¯à¤¾à¤‚à¤šà¥€ à¤®à¤¾à¤¹à¤¿à¤¤à¥€']/parent::fieldset")
    public StudentInformationComponent informationOfStudentComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Select Columns For Search')]/parent::fieldset | //legend[normalize-space(.)='à¤‡à¤šà¥�à¤›à¤¿à¤¤ à¤®à¤¾à¤¹à¤¿à¤¤à¥€ à¤¶à¥‹à¤§à¤£à¥�à¤¯à¤¾à¤¸à¤¾à¤ à¥€ à¤–à¤¾à¤²à¥€à¤² à¤ªà¤°à¥�à¤¯à¤¾à¤¯ à¤¨à¤¿à¤µà¤¡à¤¾']/parent::fieldset")
	public SelectColumnsForSearchComponent selectColumnsForSearchComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Search Student')]/parent::fieldset | //span[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥�à¤¯à¤¾à¤‚à¤šà¥€ à¤®à¤¾à¤¹à¤¿à¤¤à¥€']")
	public SearchStudentComponent SearchStudentComponent;
	
	@FindBy(locator = "xpath=//h4[contains(.,'Renew Student')]/ancestor::div[@class='modal-content']")
    public RenewStudentComponent renewStudentComponent;
	
	@FindBy(locator = "xpath=//div[@id='jqgrid']")
    public StudentInformationTableComponent studentInformationTableComponent;
	
	@FindBy(locator = "xpath=//input[@id='searchbtn']")
	public QAFWebElement buttonSearch;
	
	@FindBy(locator = "xpath=//input[@id='resetbtn']")
	public QAFWebElement buttonReset;
	
	@FindBy(locator = "xpath=//div[@id='ui-datepicker-div']")
    public DatePickerComponent datePickerComponent;
	
	//@FindBy(locator = "xpath=//b[contains(.,'Additional Student')]/ancestor::fieldset")
    //public AdditionalStudentDetailsComponent  additionalStudentDetailsComponent;
	
	
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
			headerEditStudentInformation.waitForVisible();
			headerEditStudentInformation.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
			
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
	   
	}
}
