package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.ingenio.eprashasan.components.ActivitySearchEngineComponent;
import com.ingenio.eprashasan.components.GeneralSearchEngineComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanExtraCurricularActivitySearchEngineFormPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	@FindBy(locator = "xpath=//h4[text()='Extra Curricular Activity Serach Engine'] | //a[normalize-space(.)='à¤…à¤­à¥�à¤¯à¤¾à¤¸à¥‡à¤¤à¤° à¤‰à¤ªà¤•à¥�à¤°à¤® à¤¶à¥‹à¤§ à¤µà¤¿à¤­à¤¾à¤—']")
    public QAFWebElement headerExtraCurricularActivitySearchEngine;
	
	@FindBy(locator = "xpath=//legend[contains(.,'General Search Engine')]/parent::fieldset | ")
	public GeneralSearchEngineComponent generalSearchEngineComponent;
	
	@FindBy(locator = "xpath=//legend[contains(.,'Activity Search Engine')]/parent::fieldset")
	public ActivitySearchEngineComponent activitySearchEngineComponent;
	
	@FindBy(locator = "xpath=//input[@id='searchbuttonid']")
	public QAFWebElement buttonSearch;
	
	@FindBy(locator = "xpath=//input[@value='Reset']")
	public QAFWebElement buttonReset;
	
	
	@FindBy(locator = "xpath=//input[@id='printActivityId']")
	public QAFWebElement buttonPrintActivityReport;
	
	
	
	
	
	public void waitForPopupToLoad() {
		try {
			headerExtraCurricularActivitySearchEngine.waitForVisible();
			headerExtraCurricularActivitySearchEngine.waitForPresent();
			
			Reporter.log(this.getClass().getSimpleName() + " Popup loaded Sucessfully");
		}catch(Exception e) {
			Reporter.log(this.getClass().getSimpleName() + " Popup Did not Load");
		}
		
	}
	
	
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void waitForPageToLoad() {
		Reporter.log("On Page "+this.getClass().getSimpleName());
		super.waitForPageToLoad();
		super.waitForAjaxToComplete();
		try {
			headerExtraCurricularActivitySearchEngine.waitForVisible();
			headerExtraCurricularActivitySearchEngine.waitForPresent();
			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
		
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
   
	}


}
