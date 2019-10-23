package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.ingenio.eprashasan.core.DropdownListWebElement;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

/**
 * <img src="../../../../../../screenshots/EPrashasanLoginPage.png"><br>
 *
 * @author SATISH
 */


public class FullEPrashasanLoginPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	
	@FindBy(locator = "xpath=//h3[text()='Welcome to e-PRASHASAN'] | //h3[text()='Welcome to e-à¤ªà¥�à¤°à¤¶à¤¾à¤¸à¤¨']")
    public QAFWebElement headerWelcometoEPRASHASAN;
	
	@FindBy(locator = "xpath=//select[@id='dbName']")
    public DropdownListWebElement dropdownDBName;
	
	@FindBy(locator = "xpath=//input[@id='j_username']")
    public QAFWebElement textboxUsername;
	
	@FindBy(locator = "xpath=//input[@id='j_password']")
    public QAFWebElement textboxPassword;
	
	@FindBy(locator = "xpath=//input[@value='Login']")
    public QAFWebElement buttonLogin;
	
	@FindBy(locator = "xpath=//a[text()='Forgot Password?']")
    public QAFWebElement linkForgotPassword;
	
	@FindBy(locator = "xpath=//div[@id='basicModal']//div[@class='modal-dialog']")
    public PopupForgotPassword popupForgotPassword;
	
	@FindBy(locator = "xpath=//div[@id='basicModal']//div[@class='modal-dialog']")
    public PopupQuestionAnswer popupQuestionAnswer;
	
	@FindBy(locator = "xpath=//div[@id='basicModal']//div[@class='modal-dialog']")
    public PopupEnterNewPassword popupEnterNewPassword;
	
	public class PopupForgotPassword extends QAFWebComponent{

		@FindBy(locator = "xpath=//h4[text()='Forgot Password'] | //h4[text()='ÃƒÂ Ã‚Â¤Ã‚ÂªÃƒÂ Ã‚Â¤Ã‚Â¾ÃƒÂ Ã‚Â¤Ã‚Â¸ÃƒÂ Ã‚Â¤Ã‚ÂµÃƒÂ Ã‚Â¤Ã‚Â°ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â¡ ÃƒÂ Ã‚Â¤Ã‚ÂµÃƒÂ Ã‚Â¤Ã‚Â¿ÃƒÂ Ã‚Â¤Ã‚Â¸ÃƒÂ Ã‚Â¤Ã‚Â°ÃƒÂ Ã‚Â¤Ã‚Â²ÃƒÂ Ã‚Â¤Ã‚Â¾ÃƒÂ Ã‚Â¤Ã‚Â¤??']")
	    public QAFWebElement headerForgotPassword;
		
		@FindBy(locator = "xpath=//td[contains(.,'Enter UserName')] | //td[contains(.,' ÃƒÂ Ã‚Â¤Ã‚ÂµÃƒÂ Ã‚Â¤Ã‚Â¾ÃƒÂ Ã‚Â¤Ã‚ÂªÃƒÂ Ã‚Â¤Ã‚Â°ÃƒÂ Ã‚Â¤Ã¢â‚¬Â¢ÃƒÂ Ã‚Â¤Ã‚Â°ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â¤ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â¯ÃƒÂ Ã‚Â¤Ã‚Â¾ÃƒÂ Ã‚Â¤Ã…Â¡ÃƒÂ Ã‚Â¥Ã¢â‚¬Â¡ ÃƒÂ Ã‚Â¤Ã‚Â¨ÃƒÂ Ã‚Â¤Ã‚Â¾ÃƒÂ Ã‚Â¤Ã‚Âµ ÃƒÂ Ã‚Â¤Ã…Â¸ÃƒÂ Ã‚Â¤Ã‚Â¾ÃƒÂ Ã‚Â¤Ã¢â‚¬Â¢ÃƒÂ Ã‚Â¤Ã‚Â¾')]")
	    public QAFWebElement labelEnterUserName;
		
		@FindBy(locator = "xpath=//input[@id='userbox']")
	    public QAFWebElement textboxUsername;
		
		@FindBy(locator = "xpath=//input[@value='Next'] | //input[@value='ÃƒÂ Ã‚Â¤Ã‚ÂªÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â¢ÃƒÂ Ã‚Â¥Ã¢â‚¬Â¡']")
	    public QAFWebElement buttonNext;
		
		@FindBy(locator = "xpath=//button[@class='close']")
	    public QAFWebElement buttonClose;
		
		public PopupForgotPassword(QAFExtendedWebElement parent, String locator) {
			super(parent, locator);
			// TODO Auto-generated constructor stub
		}
		public PopupForgotPassword(String locator) {
			super(locator);
			// TODO Auto-generated constructor stub
		}
		
		public void waitForPopupToLoad() {
			try {
				headerForgotPassword.waitForPresent();
				headerForgotPassword.waitForVisible();
				
				Reporter.log(this.getClass().getSimpleName() + " Popup loaded Sucessfully");
			}catch(Exception e) {
				Reporter.log(this.getClass().getSimpleName() + " Popup Did not Load");
			}
			
		}
		
	}
	
	public class PopupQuestionAnswer extends QAFWebComponent{

		@FindBy(locator = "xpath=//h4[text()='Forgot Password'] | //h4[text()='ÃƒÂ Ã‚Â¤Ã‚ÂªÃƒÂ Ã‚Â¤Ã‚Â¾ÃƒÂ Ã‚Â¤Ã‚Â¸ÃƒÂ Ã‚Â¤Ã‚ÂµÃƒÂ Ã‚Â¤Ã‚Â°ÃƒÂ Ã‚Â¥Ã¯Â¿Â½ÃƒÂ Ã‚Â¤Ã‚Â¡ ÃƒÂ Ã‚Â¤Ã‚ÂµÃƒÂ Ã‚Â¤Ã‚Â¿ÃƒÂ Ã‚Â¤Ã‚Â¸ÃƒÂ Ã‚Â¤Ã‚Â°ÃƒÂ Ã‚Â¤Ã‚Â²ÃƒÂ Ã‚Â¤Ã‚Â¾ÃƒÂ Ã‚Â¤Ã‚Â¤??']")
	    public QAFWebElement headerForgotPassword;
		
		@FindBy(locator = "xpath=//input[@id='answer1Id']")
	    public QAFWebElement textboxAnswer1;
		
		@FindBy(locator = "xpath=//input[@id='answer2Id']")
	    public QAFWebElement textboxAnswer2;
		
		@FindBy(locator = "xpath=//input[@id='submit']")
	    public QAFWebElement buttonSubmit;
		
		@FindBy(locator = "xpath=//button[@class='close']")
	    public QAFWebElement buttonClose;
		
		public PopupQuestionAnswer(QAFExtendedWebElement parent, String locator) {
			super(parent, locator);
			// TODO Auto-generated constructor stub
		}
		public PopupQuestionAnswer(String locator) {
			super(locator);
			// TODO Auto-generated constructor stub
		}
		
		public void waitForPopupToLoad() {
			try {
				headerForgotPassword.waitForPresent();
				headerForgotPassword.waitForVisible();
				
				Reporter.log(this.getClass().getSimpleName() + " Popup loaded Sucessfully");
			}catch(Exception e) {
				Reporter.log(this.getClass().getSimpleName() + " Popup Did not Load");
			}
			
		}
		
	}
	
	public class PopupEnterNewPassword extends QAFWebComponent{

		@FindBy(locator = "xpath=//h4[text()='Forgot Password']")
	    public QAFWebElement headerForgotPassword;
		
		@FindBy(locator = "xpath=//td[contains(.,'Enter New Password')]")
	    public QAFWebElement labelEnterUserName;
		
		@FindBy(locator = "xpath=//input[@id='passwordBox1']")
	    public QAFWebElement textboxEnterNewPassword;
		
		@FindBy(locator = "xpath=//input[@id='submit1']")
	    public QAFWebElement buttonSubmit;
		
		@FindBy(locator = "xpath=//button[@class='close']")
	    public QAFWebElement buttonClose;
		
		public PopupEnterNewPassword(QAFExtendedWebElement parent, String locator) {
			super(parent, locator);
			// TODO Auto-generated constructor stub
		}
		public PopupEnterNewPassword(String locator) {
			super(locator);
			// TODO Auto-generated constructor stub
		}
		
		public void waitForPopupToLoad() {
			try {
				headerForgotPassword.waitForPresent();
				headerForgotPassword.waitForVisible();
				
				Reporter.log(this.getClass().getSimpleName() + " Popup loaded Sucessfully");
			}catch(Exception e) {
				Reporter.log(this.getClass().getSimpleName() + " Popup Did not Load");
			}
			
		}
		
	}

	
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
		driver.get("/");
	}

	public void invoke() {
		launchPage(null);
	}
	
	@Override
	public void waitForPageToLoad() {
		Reporter.log("On Page "+this.getClass().getSimpleName());
			 //super.waitForAjaxToComplete();
		try {
			headerWelcometoEPRASHASAN.waitForVisible();
			headerWelcometoEPRASHASAN.waitForPresent();
			
			buttonLogin.waitForVisible();
			buttonLogin.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
	   
	}

}
