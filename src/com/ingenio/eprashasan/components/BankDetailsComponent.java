package com.ingenio.eprashasan.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class BankDetailsComponent extends QAFWebComponent{
	
	@FindBy(locator = "xpath=//input[@name='meducation']")
    public QAFWebElement textboxBankName;
	
	@FindBy(locator = "xpath=//input[@name='moccupation']")
    public QAFWebElement textboxBranchName;
	
	@FindBy(locator = "xpath=//input[@name='mincome']")
    public QAFWebElement textboxAccountNumber;
	
	@FindBy(locator = "xpath=//input[@name='mage']")
    public QAFWebElement textboxBankIFSCNo;
	
	@FindBy(locator = "xpath=//input[@name='mtelephone']")
    public QAFWebElement textboxAadhaarCardNo;
	
	public BankDetailsComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public BankDetailsComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
}