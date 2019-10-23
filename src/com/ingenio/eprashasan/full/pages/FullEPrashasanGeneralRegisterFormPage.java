package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.ingenio.eprashasan.components.AddressDetailsComponent;
import com.ingenio.eprashasan.components.BankDetailsComponent;
import com.ingenio.eprashasan.components.BasicDetailsComponent;
import com.ingenio.eprashasan.components.OfficeDetailsComponent;
import com.ingenio.eprashasan.components.OtherDetailsComponent;
import com.ingenio.eprashasan.components.ParentDetailsComponent;
import com.ingenio.eprashasan.components.SearchStudentComponent;
import com.ingenio.eprashasan.components.StudentContactDetailsComponent;
import com.ingenio.eprashasan.components.TCInformationComponent;
import com.ingenio.eprashasan.components.TopNavigationComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;



public class FullEPrashasanGeneralRegisterFormPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	
	@FindBy(locator = "xpath=//h4[text()='GENERAL REGISTER FORM'] | //b[text()='à¤¦à¤¾à¤–à¤² à¤–à¤¾à¤°à¥€à¤œ à¤…à¤°à¥�à¤œ']")
    public QAFWebElement headerGeneralRegisterForm;
	
	@FindBy(locator = "xpath=//a[contains(.,'General Register')]/ancestor::ul | //a[contains(.,'à¤¦à¤¾à¤–à¤² à¤–à¤¾à¤°à¥€à¤œà¤šà¤¾ à¤…à¤°à¥�à¤œ')]/ancestor::ul")
    public TopNavigationComponent topNavigationComponent;	
	
	@FindBy(locator = "xpath=//legend[contains(.,'Office Details')]/parent::fieldset | //legend[contains(.,'à¤•à¤¾à¤°à¥�à¤¯à¤¾à¤²à¤¯')]/parent::fieldset")
    public OfficeDetailsComponent officeDetailsComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Basic')]/parent::fieldset | //legend[contains(.,'à¤®à¥‚à¤²à¤­à¥‚à¤¤')]/parent::fieldset")
    public BasicDetailsComponent basicDetailsComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Parent')]/parent::fieldset | //legend[contains(.,'à¤ªà¤¾à¤²à¤•')]/parent::fieldset")
    public ParentDetailsComponent parentDetailsComponent;
	
	@FindBy(locator = "xpath=//input[@name='mmobile']/ancestor::fieldset[1] | ")
    public StudentContactDetailsComponent studentContactDetailsComponent;
	
	@FindBy(locator = "xpath=//input[@id='check']/parent::legend/parent::fieldset")
    public AddressDetailsComponent addressDetailsComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Bank')]/parent::fieldset | //legend[contains(.,'à¤¬à¤�à¤•')]/parent::fieldset")
    public BankDetailsComponent bankDetailsComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'TC Information')]/parent::fieldset | //legend[contains(.,'à¤¦à¤¾à¤–à¤²à¥�à¤¯à¤¾à¤šà¥€ à¤®à¤¾à¤¹à¤¿à¤¤à¥€')]/parent::fieldset")
    public TCInformationComponent tcInformationComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Other')]/parent::fieldset | //legend[contains(.,'à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥�à¤¯à¤¾à¤‚à¤šà¥€ à¤‡à¤¤à¤° à¤®à¤¾à¤¹à¤¿à¤¤à¥€')]/parent::fieldset")
    public OtherDetailsComponent otherDetailsComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Search Student')]/parent::fieldset | //legend[contains(.,'à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥€ à¤¶à¥‹à¤§à¤¾')]/parent::fieldset")
	public SearchStudentComponent SearchStudentComponent;
	
	@FindBy(locator = "xpath=//input[@id='hideAndSeekSubmitId'] | //input[@id='target']")
    public QAFWebElement buttonAdd;
	
	@FindBy(locator = "xpath=//input[@id='resetId'] | ")
    public QAFWebElement buttonReset;
	
	@FindBy(locator = "xpath=//u[contains(.,'here')] | //u[contains(.,'[ à¤¯à¥‡à¤¥à¥‡ ]')]")
    public QAFWebElement linkHere;
	
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
			headerGeneralRegisterForm.waitForVisible();
			headerGeneralRegisterForm.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
			
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
	   
	}
	
}
