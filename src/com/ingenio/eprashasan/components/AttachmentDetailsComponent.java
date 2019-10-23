package com.ingenio.eprashasan.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class AttachmentDetailsComponent extends QAFWebComponent{
	
	@FindBy(locator = "xpath=//input[@id='tcbox1']")
    public QAFWebElement checkboxTC;
	
	@FindBy(locator = "xpath=//input[@id='Marksheetbox1']")
    public QAFWebElement checkboxMarksheet;
	
	@FindBy(locator = "xpath=//input[@id='Castebox1']")
    public QAFWebElement checkboxCasteCertificate;
	
	@FindBy(locator = "xpath=//input[@id='Validitybox1']")
    public QAFWebElement checkboxCasteValidity;
	
	@FindBy(locator = "xpath=//input[@id='NonCriminalox1']")
    public QAFWebElement checkboxNonCreamyLayer;
	
	@FindBy(locator = "xpath=//input[@id='Migrationbox1']")
    public QAFWebElement checkboxMigrationCertificate;
	
	@FindBy(locator = "xpath=//input[@id='Domicilebox1']")
    public QAFWebElement checkboxDomicileCertificate;
	
	@FindBy(locator = "xpath=//input[@id='Incomebox1']")
    public QAFWebElement checkboxIncomeCertificate;
	
	@FindBy(locator = "xpath=//input[@id='blankbox1']")
    public QAFWebElement checkboxBirthCertificate;
	
	
	public AttachmentDetailsComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public AttachmentDetailsComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
}