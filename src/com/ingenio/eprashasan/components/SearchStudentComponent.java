package com.ingenio.eprashasan.components;

import java.util.List;

import com.ingenio.eprashasan.core.DropdownListWebElement;



import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class SearchStudentComponent extends QAFWebComponent {
	
	@FindBy(locator = "xpath=//input[@id='2_textbox1 | //input[@id='1499_textbox1']")
	public QAFWebElement textboxStudentID;
	
	@FindBy(locator = "xpath=//select[@id='2_minority_type'] | //select[@id='1499_minority_type']")
	public DropdownListWebElement dropdownMinority;
	
	@FindBy(locator = "xpath=//select[@id='2_concession'] | //select[@id='1499_concession']")
	public DropdownListWebElement dropdownConcession;
	
	@FindBy(locator = "xpath=//select[@id='2_casteName']")
	public DropdownListWebElement dropdownCaste;
	
	@FindBy(locator = "xpath=//input[@id='2_memail'] | //input[@id='1499_memail']")
	public QAFWebElement textboxEmailId;
	
	@FindBy(locator = "xpath=//input[@id='2_mmobile'] | //input[@id='1499_mmobile']")
	public QAFWebElement textboxMobileNo;
	
	@FindBy(locator = "xpath=//input[@id='1499_motherName']")
	public QAFWebElement textboxMotherName;
	
	@FindBy(locator = "xpath=//input[@id='1499_fatherName']")
	public QAFWebElement textboxFatherName;
	
	@FindBy(locator = "xpath=//select[@id='yearcombo'] | //select[@id='yearcombo1']")
	public DropdownListWebElement dropdownSelectYear;
	
	@FindBy(locator = "xpath=//select[@id='standardcombo'] | //select[@id='standardcombo1']")
	public DropdownListWebElement dropdownSelectClass;
	

	@FindBy(locator = "xpath=//select[@id='categorycombo1']")
	public DropdownListWebElement dropdownSelectCategory;
	
	@FindBy(locator = "xpath=//select[@id='divisioncombo']")
	public DropdownListWebElement dropdownSelectDivision;
	
	@FindBy(locator = "xpath=//select[@id='semFlag']")
	public DropdownListWebElement dropdownSelectSemester;
	
	@FindBy(locator = "xpath=//input[@id='regno11']")
	public QAFWebElement textboxRegistrationNo;
	
	@FindBy(locator = "xpath=//input[@id='studname'] | //input[@onchange='characterValidation(nameSearchId)']")
	public QAFWebElement textboxStudentName;
	
	@FindBy(locator = "xpath=//select[@id='gendercombo']")
	public DropdownListWebElement dropdownGender;
	
	@FindBy(locator = "xpath=//select[@id='categorycombo']")
	public DropdownListWebElement dropdownCategory;
	
	@FindBy(locator = "xpath=//input[@id='casteautotextbox']")
	public QAFWebElement textboxCaste;
	
	@FindBy(locator = "xpath=//input[@id='searchbuttonid'] | input[@value='Search']")
	public QAFWebElement buttonSearch;
	
	@FindBy(locator = "xpath=//input[@value='Reset']")
	public QAFWebElement buttonReset;
	
	@FindBy(locator = "xpath=//input[@onclick='reloadGrid();']")
	public QAFWebElement buttonSSearch;
	
	@FindBy(locator = "xpath=//select[@id='divisioncombo']")
	public DropdownListWebElement dropdownSelectDDivision;
	
	@FindBy(locator = "xpath=//input[@id='searchRegNumId']")
	public QAFWebElement textboxRRegistrationNo;
	
	@FindBy(locator = "xpath=//span[@class='ui-icon ui-icon-seek-next']")
	public QAFWebElement iconNext;
	
	@FindBy(locator = "xpath=//input[@id='1131_eduOfficerNo']")
	public QAFWebElement textboxEduOffNo;
	
	@FindBy(locator = "xpath=//select[@id='1131_concession']")
	public DropdownListWebElement dropdownCConcession;
	
	@FindBy(locator = "xpath=//select[@id='1131_status']")
	public DropdownListWebElement dropdownMMinority;
	
	@FindBy(locator = "xpath=//input[@id='saveButtonId']")
	public QAFWebElement buttonSave;
	
	@FindBy(locator = "xpath=//span[text()=' Lunkad Sonali Vijay -[4 th]']")
    public QAFWebElement OptionSelectName;
	
	@FindBy(locator = "xpath=//input[@class='cbox']")
    public List<QAFWebElement> CheckBox;
	
	@FindBy(locator = "xpath=//input[@id='getRenewIdNew']")
	public QAFWebElement buttonRenewStudent;
	
	@FindBy(locator = "xpath=//input[@id='recieptButtom']")
	public QAFWebElement buttonFeeReceipt;
	
	
	
	
	
	

public SearchStudentComponent(QAFExtendedWebElement parent, String locator) {
	super(parent, locator);
	// TODO Auto-generated constructor stub
}
public SearchStudentComponent(String locator) {
	super(locator);
	// TODO Auto-generated constructor stub
}

}