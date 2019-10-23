package com.ingenio.eprashasan.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class AddressDetailsComponent  extends QAFWebComponent{
	
	@FindBy(locator = "xpath=//input[@id='check']")
    public QAFWebElement checkboxPermanentAddressSameAsLocalAddress;
	
	@FindBy(locator = "xpath=//b[starts-with(.,'Permanent address same')] | //b[normalize-space(.)='स्थानिक आणि कायमचा पत्ता एकच आहे का ?']")
    public QAFWebElement checkboxLabelPermanentAddressSameAsLocalAddress;
	
	@FindBy(locator = "xpath=//following::fieldset[contains(.,'Local')] | //legend[text()='स्थानिक पत्ता']")//not found
    public LocalAddressDetailsComponent localAddressDetailsComponent;
	
	@FindBy(locator = "xpath=//following::fieldset[contains(.,'Permanent')] | //legend[starts-with(.,'कायमचा पत्ता')]")//not found
    public PermanentAddressDetailsComponent permanentAddressDetailsComponent;
	
	public AddressDetailsComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public AddressDetailsComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
	public class LocalAddressDetailsComponent extends QAFWebComponent{
		
		@FindBy(locator = "xpath=//textarea[@id='laddressId']")
	    public QAFWebElement textareaAddress;
		
		@FindBy(locator = "xpath=//input[@name='lcity']")
	    public QAFWebElement textboxDistrict;
		
		@FindBy(locator = "xpath=//input[@name='lpincode']")
	    public QAFWebElement textboxPincode;
		
		@FindBy(locator = "xpath=//input[@name='lstate']")
	    public QAFWebElement textboxState;
		
		@FindBy(locator = "xpath=//input[@name='lcountry']")
	    public QAFWebElement textboxCountry;
		
		
		public LocalAddressDetailsComponent(QAFExtendedWebElement parent, String locator) {
			super(parent, locator);
			// TODO Auto-generated constructor stub
		}
		public LocalAddressDetailsComponent(String locator) {
			super(locator);
			// TODO Auto-generated constructor stub
		}
		
	}
	
	public class PermanentAddressDetailsComponent extends QAFWebComponent{
		
		@FindBy(locator = "xpath=//textarea[@id='paddressId']")
	    public QAFWebElement textareaAddress;
		
		@FindBy(locator = "xpath=//input[@name='pcity']")
	    public QAFWebElement textboxDistrict;
		
		@FindBy(locator = "xpath=//input[@name='ppincode']")
	    public QAFWebElement textboxPincode;
		
		@FindBy(locator = "xpath=//input[@name='pstate']")
	    public QAFWebElement textboxState;
		
		@FindBy(locator = "xpath=//input[@name='pcountry']")
	    public QAFWebElement textboxCountry;
		
		
		public PermanentAddressDetailsComponent(QAFExtendedWebElement parent, String locator) {
			super(parent, locator);
			// TODO Auto-generated constructor stub
		}
		public PermanentAddressDetailsComponent(String locator) {
			super(locator);
			// TODO Auto-generated constructor stub
		}
		
	}
	
}
