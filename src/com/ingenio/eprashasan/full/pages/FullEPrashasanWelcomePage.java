package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.ingenio.eprashasan.components.LeftNavigationComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

/**
 * <img src="../../../../../../screenshots/EPrashasanWelcomePage.png"><br>
 * 
 * @author SATISH
 */

public class FullEPrashasanWelcomePage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "xpath=//*[text()='Welcome To e-PRASHASAN'] | //*[text()='Welcome To e-PRASHASAN']")
    public QAFWebElement headerWelcometoEPRASHASAN;
	
	@FindBy(locator = "xpath=//ul[@class='dropdown-menu']//li//a[text()='Change Password'] | ")
    public QAFWebElement linkChangePassword;
	
	@FindBy(locator = "xpath=//li[@class='dropdown user']//span[@class='username']")
    public QAFWebElement dropdownToggleOnUsername;
	
	@FindBy(locator = "xpath=//h4[text()='Change Password']/ancestor::div[@class='modal-content'] | ")
    public PopupChangePassword popupChangePassword;
	
	@FindBy(locator = "xpath=//div[starts-with(@class,'page-sidebar navbar')]")
    public LeftNavigationComponent leftNavigationComponent;
	
	
	public class PopupChangePassword extends QAFWebComponent{

		@FindBy(locator = "xpath=//h4[text()='Change Password'] | ")
	    public QAFWebElement headerChangePassword;
		
		@FindBy(locator = "xpath=//td[contains(text(),'Username')] | ")
	    public QAFWebElement labelUserName;
		
		@FindBy(locator = "xpath=//td[contains(text(),'Enter Current Password')] | //td[normalize-space(.)='à¤œà¥�à¤¨à¤¾ à¤—à¥�à¤ªà¥�à¤¤à¤¶à¤¬à¥�à¤¦ / à¤ªà¤¾à¤¸à¤µà¤°à¥�à¤¡ à¤Ÿà¤¾à¤•à¤¾']")
	    public QAFWebElement labelEnterCurrentPassword;
		
		@FindBy(locator = "xpath=//td[contains(text(),'Enter New Password')] | //td[normalize-space(.)='à¤¨à¤µà¥€à¤¨ à¤—à¥�à¤ªà¥�à¤¤à¤¶à¤¬à¥�à¤¦ / à¤ªà¤¾à¤¸à¤µà¤°à¥�à¤¡ à¤Ÿà¤¾à¤•à¤¾']")
	    public QAFWebElement labelEnterNewPassword;
		
		@FindBy(locator = "xpath=//td[contains(text(),'Confirm New Password')] | //td[[normalize-space(.)='à¤¨à¤µà¥€à¤¨ à¤—à¥�à¤ªà¥�à¤¤à¤¶à¤¬à¥�à¤¦ / à¤ªà¤¾à¤¸à¤µà¤°à¥�à¤¡ à¤šà¥€ à¤–à¤¾à¤¤à¥�à¤°à¥€ à¤•à¤°à¥‚à¤¨ à¤˜à¥�à¤¯à¤¾'] ")//not found
	    public QAFWebElement labelConfirmNewPassword;
		
		@FindBy(locator = "xpath=//input[@id='ddnoid']")
	    public QAFWebElement textboxUsername;
		
		@FindBy(locator = "xpath=//input[@id='ddnoid1']")
	    public QAFWebElement textboxEnterCurrentPassword;
		
		@FindBy(locator = "xpath=//input[@id='banknameid']")
	    public QAFWebElement textboxEnterNewPassword;
		
		@FindBy(locator = "xpath=//input[@id='banknameid1']")
	    public QAFWebElement textboxConfrimNewPassword;
		
		@FindBy(locator = "xpath=//a[@id='addId1'] | //input[@id='addId1']")
	    public QAFWebElement buttonSubmit;
		
		@FindBy(locator = "xpath=//a[contains(text(),'Close')]")
	    public QAFWebElement buttonClose;
		
		public PopupChangePassword(QAFExtendedWebElement parent, String locator) {
			super(parent, locator);
			// TODO Auto-generated constructor stub
		}
		public PopupChangePassword(String locator) {
			super(locator);
			// TODO Auto-generated constructor stub
		}
		
		public void waitForPopupToLoad() {
			Reporter.log("On Page "+this.getClass().getSimpleName());
			try {
				headerChangePassword.waitForPresent();
				headerChangePassword.waitForVisible();
				
				Reporter.log(this.getClass().getSimpleName() + " Popup loaded Sucessfully");
			}catch(Exception e) {
				Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
			}
			
		}
		
	}

	
	
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void waitForPageToLoad() {
		super.waitForPageToLoad();
	//	super.waitForAjaxToComplete();
		try {
			headerWelcometoEPRASHASAN.waitForVisible(30000);
			headerWelcometoEPRASHASAN.waitForPresent(30000);
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
			
		} catch (Exception e) {
			Reporter.log(this.getClass().getSimpleName() + " Page Did not Load");
		}
	   
	}
}
