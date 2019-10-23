package com.ingenio.eprashasan.core;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.util.Reporter;

public class DropdownListWebElement extends QAFWebComponent {


	public DropdownListWebElement(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public DropdownListWebElement(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	public void selectByValue(String Value) {
		
		Select thisSelect = new Select(this);
		try {
			thisSelect.selectByValue(Value);
		}catch(Exception e) {
			Reporter.log("Expected option not present in drop down list"+ e.getMessage());
		}	
	}
	
	public void selectByOptionValue(String Option) {
		
		Select thisSelect = new Select(this);
		List<WebElement> options =thisSelect.getOptions();
		try {
			for (WebElement element1 : options) {
			if (element1.getText().equals(Option)) {
			         element1.click();
			     EPUtils.sleep(3000);
			    }
		}
		}catch(Exception e) {
			Reporter.log("Expected option not present in drop down list"+ e.getMessage());
		}	
		
		
	}
	
	public void selectByIndex(int index) {
		
		Select thisSelect = new Select(this);
		try {
			thisSelect.selectByIndex(index);
		}catch(Exception e) {
			Reporter.log("Expected index not present in drop down list"+ e.getMessage());
		}	
	}
	
	public void selectByVisibleText(String option) {
		
		Select thisSelect = new Select(this);
		try {
			thisSelect.selectByVisibleText(option);;
		}catch(Exception e) {
			Reporter.log("Expected option not present in drop down list"+ e.getMessage());
		}	
		
		//verifyOptionInDropdownList() , verifySelectedOptionInDropdownList(), verifyAllOptionsInDropdownList()
	}
}
