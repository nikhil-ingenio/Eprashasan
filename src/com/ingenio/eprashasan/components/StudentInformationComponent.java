package com.ingenio.eprashasan.components;

import com.ingenio.eprashasan.core.DropdownListWebElement;


import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class StudentInformationComponent extends QAFWebComponent {
	
	@FindBy(locator = "xpath=//input[@id='mainserachId']")
	public QAFWebElement checkboxInformationOfStudent;

	@FindBy(locator = "xpath=//select[@id='criteriaId']")
    public DropdownListWebElement dropdownSearchCriteria;
	
	@FindBy(locator = "xpath=//select[@id='imageCriteriaId']")
    public DropdownListWebElement dropdownStudentImage;
	
	@FindBy(locator = "xpath=//select[@id='yearcombo']")
    public DropdownListWebElement dropdownAcademicYear;
	
	@FindBy(locator = "xpath=//select[@id='religioncombo']")
    public DropdownListWebElement dropdownReligion;
	
	@FindBy(locator = "xpath=//input[@id='searchRegNumId']")
    public QAFWebElement textboxRegistrationNumber;
	
	@FindBy(locator = "xpath=//select[@id='divisioncombo']")
    public DropdownListWebElement dropdownDivision;
	
	@FindBy(locator = "xpath=//select[@id='castcombo']")
    public DropdownListWebElement dropdownCaste;
	
	@FindBy(locator = "xpath=//select[@id='standardcombo']")
    public DropdownListWebElement dropdownClass;
	
	@FindBy(locator = "xpath=//input[@id='searchParentIncomeFromId']")
    public QAFWebElement textboxParentIncomeFrom;
	
	@FindBy(locator = "xpath=//input[@id='searchParentIncomeToId']")
    public QAFWebElement textboxParentIncomeTo;
	
	@FindBy(locator = "xpath=//input[@id='currdate']")
    public QAFWebElement textboxDateForAgeCalculation;
	
	@FindBy(locator = "xpath=//select[@id='categoryComboId'] | //select[@id='categorycombo']")
    public DropdownListWebElement dropdownCategory;
	
	@FindBy(locator = "xpath=//select[@id='gendercombo']")
    public DropdownListWebElement dropdownGender;
	
	@FindBy(locator = "xpath=//input[@id='nameSearchId']")
    public QAFWebElement textboxName;
	
	@FindBy(locator = "xpath=//input[@id='searchbtn']")
	public QAFWebElement buttonSearch;
	
	@FindBy(locator = "xpath=//input[@id='btnShowSimple']")
    public QAFWebElement checkboxCustomSearch;
	
	@FindBy(locator = "xpath=//input[@id='sortid']")
	public QAFWebElement checkboxSortByRollNo; 
	
	@FindBy(locator = "xpath=//input[@id='isprevdataid']")
	public QAFWebElement checkboxAdditionalStudentDetails;
	
	@FindBy(locator = "xpath=//input[@id='textbox1']")
	public QAFWebElement textboxStudentId;
	
	@FindBy(locator = "xpath=//select[@class='ui-pg-selbox']")
	public DropdownListWebElement dropdownPage;
	
	@FindBy(locator = "xpath=//input[@id='2_studname3']")
	public DropdownListWebElement textboxStudentLastName;
	
	
	@FindBy(locator = "xpath=//input[@id='gereratereportbutton']")
	public DropdownListWebElement buttonSaveData;
	

	
	public StudentInformationComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public StudentInformationComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
}
