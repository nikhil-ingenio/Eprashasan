package com.ingenio.eprashasan.components;

import com.ingenio.eprashasan.core.DropdownListWebElement;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class RenewStudentComponent extends QAFWebComponent{

	@FindBy(locator = "xpath=//h4[contains(.,'Renew Student')] | //a[normalize-space(.)='विद्यार्थ्याचे नुतनीकरण']")
    public QAFWebElement headerRenewStudent;
	
	@FindBy(locator = "xpath=//select[@id='nextyearcombo']")
    public DropdownListWebElement dropdownNewAcademicYear;
	
	@FindBy(locator = "xpath=//select[@id='nextstandardcombo']")
    public DropdownListWebElement dropdownNewClass;
	
	@FindBy(locator = "xpath=//select[@id='nextyearcombo']")
    public DropdownListWebElement dropdownDivision;
	
	@FindBy(locator = "xpath=//select[@id='selectadmissiondayId']")
    public DropdownListWebElement dropdownAdmissionDay;
	
	@FindBy(locator = "xpath=//select[@id='selectadmissionmonthId']")
    public DropdownListWebElement dropdownAdmissionMonth;
	
	@FindBy(locator = "xpath=//select[@id='selectdummyyear']")
    public DropdownListWebElement dropdownAdmissionYear;
	
	@FindBy(locator = "xpath=//input[@id='renewButtonId']")
    public QAFWebElement buttonRenew;
	
	public void waitForPopupToLoad() {
		try {
			headerRenewStudent.waitForVisible();
			headerRenewStudent.waitForPresent();
			
			Reporter.log(this.getClass().getSimpleName() + " Popup loaded Sucessfully");
		}catch(Exception e) {
			Reporter.log(this.getClass().getSimpleName() + " Popup Did not Load");
		}
		
	}
	
	
	public RenewStudentComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public RenewStudentComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
}
