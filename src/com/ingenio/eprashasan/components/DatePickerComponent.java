package com.ingenio.eprashasan.components;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.ingenio.eprashasan.core.DropdownListWebElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class DatePickerComponent extends QAFWebComponent {

	@FindBy(locator = "xpath=//select[@class='ui-datepicker-month']")
    public DropdownListWebElement selectMonth;
	
	@FindBy(locator = "xpath=//select[@class='ui-datepicker-year']")
    public DropdownListWebElement selectYear;
	
	@FindBy(locator = "xpath=//button[@class='ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all']")
	public QAFWebElement buttonDONE;
	
	@FindBy(locator = "xpath=//button[@class='ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all']")
	public QAFWebElement buttonTODAY;
	
	public QAFWebElement selectDay(String day) {
		
		try {
			return(this.findElement(By.xpath("//a[text()='"+day+"']")));
			
		} catch (NoSuchElementException e) {
			Reporter.log("Day not found ");
		}
		return null;
	}
	
	
	public DatePickerComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public DatePickerComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
	public void waitForPopupToLoad() {
		
		try {
			
			Reporter.log(this.getClass().getSimpleName() + " Popup loaded Sucessfully");
		}catch(Exception e) {
			Reporter.log(this.getClass().getSimpleName() + " Popup Did not Load");
		}
		
	}
	

}