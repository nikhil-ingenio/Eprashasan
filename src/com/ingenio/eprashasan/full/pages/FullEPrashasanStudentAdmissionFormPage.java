package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.ingenio.eprashasan.components.AddressDetailsComponent;
import com.ingenio.eprashasan.components.AttachmentDetailsComponent;
import com.ingenio.eprashasan.components.BankDetailsComponent;
import com.ingenio.eprashasan.components.BasicDetailsComponent;
import com.ingenio.eprashasan.components.DatePickerComponent;
import com.ingenio.eprashasan.components.OfficeDetailsComponent;
import com.ingenio.eprashasan.components.OtherDetailsComponent;
import com.ingenio.eprashasan.components.ParentDetailsComponent;
import com.ingenio.eprashasan.components.PreviousSchoolDetailsComponent;
import com.ingenio.eprashasan.components.RenewStudentComponent;
import com.ingenio.eprashasan.components.StudentContactDetailsComponent;
import com.ingenio.eprashasan.components.TopNavigationComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanStudentAdmissionFormPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator = "xpath=//h4[text()='STUDENT ADMISSION FORM'] | //b[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥€ à¤ªà¥�à¤°à¤µà¥‡à¤¶ à¤…à¤°à¥�à¤œ']")
	public QAFWebElement headerStudentAddmissionForm;
	
	@FindBy(locator = "xpath=//*[text()='Quick Registration']/ancestor::ul | //*[normalize-space(.)='à¤œà¤²à¤¦ à¤ªà¥�à¤°à¤µà¥‡à¤¶ à¤…à¤°à¥�à¤œ']/ancestor::ul")
    public TopNavigationComponent topNavigationAdmissionPageComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Office Details')]/parent::fieldset | //legend[contains(.,'à¤•à¤¾à¤°à¥�à¤¯à¤¾à¤²à¤¯')]/parent::fieldset")
    public OfficeDetailsComponent officeDetailsComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Basic')]/parent::fieldset | //legend[contains(.,'à¤®à¥‚à¤²à¤­à¥‚à¤¤')]/parent::fieldset")
    public BasicDetailsComponent basicDetailsComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Parent')]/parent::fieldset | //legend[normalize-space(.)='à¤ªà¤¾à¤²à¤•']/parent::fieldset")
    public ParentDetailsComponent parentDetailsComponent;
	
	@FindBy(locator = "xpath=//input[@id='check']/parent::legend/parent::fieldset")
    public AddressDetailsComponent addressDetailsComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Student Contact Details')]/parent::fieldset | //legend[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥�à¤¯à¤¾à¤šà¤¾ à¤¸à¤‚à¤ªà¤°à¥�à¤• à¤¤à¤ªà¤¶à¥€à¤²']/parent::fieldset")
    public StudentContactDetailsComponent studentContactDetailsComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Bank')]/parent::fieldset | //legend[normalize-space(.)='à¤¬à¤�à¤•']/parent::fieldset")
    public BankDetailsComponent bankDetailsComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Previous School Detail')]/parent::fieldset | //legend[normalize-space(.)='à¤ªà¥�à¤°à¥�à¤µà¥€à¤šà¥�à¤¯à¤¾ à¤¶à¤¾à¤³à¥‡à¤šà¤¾ à¤¤à¤ªà¤¶à¥€à¤²']/parent::fieldset")
    public PreviousSchoolDetailsComponent previousSchoolDetailsComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Attachment')]/parent::fieldset | //legend[normalize-space(.)='à¤œà¥‹à¤¡à¤¾à¤µà¤¯à¤¾à¤šà¥€ à¤•à¤¾à¤—à¤¦à¤ªà¤¤à¥�à¤°à¥‡']/parent::fieldset")
    public AttachmentDetailsComponent attachmentDetailsComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Other')]/parent::fieldset | //legend[normalize-space(.)='à¤‡à¤¤à¤° à¤®à¤¾à¤¹à¤¿à¤¤à¥€']/parent::fieldset")
    public OtherDetailsComponent otherDetailsComponent;
	
	@FindBy(locator = "xpath=//h4[contains(.,'Renew Student')]/ancestor::div[@class='modal-content']")
    public RenewStudentComponent renewStudentComponent;
	
	@FindBy(locator = "xpath=//div[@id='ui-datepicker-div']")
    public DatePickerComponent datePickerComponent;
	
	@FindBy(locator = "xpath=//input[@id='hideAndSeekSubmitId'] | //input[@id='target'] ")
    public QAFWebElement buttonAdd;
	
	@FindBy(locator = "xpath=//input[@id='resetId']")
    public QAFWebElement buttonReset;
	
	
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
			headerStudentAddmissionForm.waitForVisible();
			headerStudentAddmissionForm.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
			
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
	   
	}
}
