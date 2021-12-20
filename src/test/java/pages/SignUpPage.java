package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.Baseclass;

public class SignUpPage {
	WebDriver driver = Baseclass.driver;
	ExtentTest test = Baseclass.test;


	//*************************WebElements**********************
	@FindBy(linkText="Login/Signup")
	WebElement SignBtn;
	
	@FindBy(linkText="Not a member? Signup")
	WebElement SignUpLink;
	
	@FindBy(css="input[name*='email_id']")
	WebElement email;
	
	@FindBy(css="input[name*='pwd']")
	WebElement password;
	
	@FindBy(css="input[name*='pwd2']")
	WebElement Confirmpwd;
	
	@FindBy(css="input[name*='fname']")
	WebElement Firstname;
	
	@FindBy(css="input[name*='lname']")
	WebElement Lastname;
	
	@FindBy(css="input[name*='age']")
	WebElement Age;
	
	@FindBy(css="input[name*='address']")
	WebElement Address;
	
	@FindBy(css="button")
	WebElement SignUpFinal;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	public void signup(String Emailval,String Passwordval,String FirstNameval,String LastNameval,String Ageval,String Addressval) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(SignBtn));
		SignBtn.click();
		SignUpLink.click();
		email.sendKeys(Emailval);
		password.sendKeys(Passwordval);
		Confirmpwd.sendKeys(Passwordval);
		Firstname.sendKeys(FirstNameval);
		Lastname.sendKeys(LastNameval);
		Age.sendKeys(Ageval);
		Address.sendKeys(Addressval);
		SignUpFinal.click();
		test.log(LogStatus.PASS, "Sign Up using Provided Details", "Signed Up");
	}

}
