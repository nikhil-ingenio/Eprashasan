package com.ingenio.eprashasan.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class LeftNavigationComponent extends QAFWebComponent {

	
	@FindBy(locator = "xpath=//a[contains(.,'Settings')] | //span[normalize-space(.)='à¤¸à¥‡à¤Ÿà¤¿à¤‚à¤—']")
    public QAFWebElement linkSettings;
	
	@FindBy(locator = "xpath=//a[contains(.,'Principal Desk')] | //a[normalize-space(.)='à¤ªà¥�à¤°à¤¿.à¤¡à¥‡à¤¸à¥�à¤•']")
    public QAFWebElement linkPrincipalDesk;
	
	@FindBy(locator = "xpath=//a[contains(.,'Enquiry')] | ")
    public QAFWebElement linkEnquiry;
	
	@FindBy(locator = "xpath=//a[contains(.,'Admission')] | //span[normalize-space(.)='à¤ªà¥�à¤°à¤µà¥‡à¤¶']")
    public QAFWebElement linkAdmission;
	
	@FindBy(locator = "xpath=//a[contains(.,'Gen.Reg.')] | //a[normalize-space(.)='à¤œà¤¨-à¤°à¤œà¤¿']")
    public QAFWebElement linkGenReg;
	
	@FindBy(locator = "xpath=//a[contains(.,'Class')] | //span[normalize-space(.)='à¤µà¤°à¥�à¤—']")//not found
    public QAFWebElement linkClass;
	
	@FindBy(locator = "xpath=//a[contains(.,'Exam')] | //a[normalize-space(.)='à¤ªà¤°à¥€à¤•à¥�à¤·à¤¾']")//not found
    public QAFWebElement linkExam;
	
	@FindBy(locator = "xpath=//a[contains(.,'Co-Scholastic')] | //span[normalize-space(.)='à¤ªà¤°à¤¿à¤•à¥�à¤·à¤¾-à¤¶à¥‡à¤°à¤¾']")//not found
    public QAFWebElement linkCoScholastic;
	
	@FindBy(locator = "xpath=//a[contains(.,'Fess')] | //a[normalize-space(.)='à¤¶à¥�à¤²à¥�à¤•']")
    public QAFWebElement linkFess;
	
	@FindBy(locator = "xpath=//a[contains(.,'Certificate')] | //a[normalize-space(.)='à¤ªà¥�à¤°à¤®à¤¾à¤£à¤ªà¤¤à¥�à¤°à¥‡']")
    public QAFWebElement linkCertificate;
	
	@FindBy(locator = "xpath=//a[contains(.,'I/O Lettering')] | ")
    public QAFWebElement linkIOLettering;
	
	@FindBy(locator = "xpath=//a[contains(.,'Search')] | //a[normalize-space(.)='à¤¶à¥‹à¤§']")
    public QAFWebElement linkSearch;
	
	@FindBy(locator = "xpath=//a[contains(.,'ID-Card')] | //a[normalize-space(.)='à¤“à¤³à¤–à¤ªà¤¤à¥�à¤°']")
    public QAFWebElement linkIDCard;
	
	@FindBy(locator = "xpath=//a[contains(.,'SMS')] | //a[normalize-space(.)='à¤¸à¤‚à¤¦à¥‡à¤¶']")
    public QAFWebElement linkSMS;
	
	@FindBy(locator = "xpath=//a[contains(.,'Backup')]")
    public QAFWebElement linkBackup;
	
	@FindBy(locator = "xpath=//a[contains(.,'Staff')]")
    public QAFWebElement linkStaff;
	
	@FindBy(locator = "xpath=//a[contains(.,'DSS')]")
    public QAFWebElement linkDSS;
	
	@FindBy(locator = "xpath=//a[contains(.,'Photo')] | //a[normalize-space(.)='à¤«à¥‹à¤Ÿà¥‹']")
    public QAFWebElement linkPhoto;
	
	
	public LeftNavigationComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public LeftNavigationComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
}
