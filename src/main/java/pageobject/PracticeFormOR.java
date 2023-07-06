package pageobject;

import org.openqa.selenium.By;

public class PracticeFormOR {
	
	public static final By TXT_FIRST = By.id("firstName");
	public static final By TXT_LAST = By.id("lastName");
	public static final By TXT_EMAIL = By.id("userEmail");
	
	public static final By GENDER = By.id("gender-radio-1");
	
	public static final By TXT_MOBILE = By.id("userNumber");
	public static final By TXT_ADDRESS = By.id("currentAddress");
	
	public static final By DOB = By.id("dateOfBirthInput");
	public static final By MONTH = By.className("react-datepicker__month-select");
	public static final By YEAR = By.className("react-datepicker__year-select");
	public static final By DAY = By.className("react-datepicker__day");
	
	public static final By SUBJECT = By.cssSelector(".subjects-auto-complete__value-container input");
	public static final By TXT_SUB = By.id("react-select-2-option-0");
	public static final By HOBBIES = By.id("hobbies-checkbox-1");
	
	public static final By IMG = By.id("uploadPicture");
	
	public static final By STATE = By.id("state");
	public static final By TXT_STATE = By.id("react-select-3-option-0");
	
	public static final By City = By.id("city");
	public static final By TXT_CITY = By.id("react-select-4-option-1");
	
	public static final By SUBMIT = By.id("submit");
}
