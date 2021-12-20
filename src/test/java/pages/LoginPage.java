package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.Baseclass;

public class LoginPage {
	WebDriver driver = Baseclass.driver;
	ExtentTest test = Baseclass.test;
	
	//*************************WebElements**********************
	@FindBy(linkText="Login/Signup")
	WebElement SignBtn;
	
	@FindBy(css="input[name*='email_id']")
	WebElement email;
	
	@FindBy(css="input[name*='pwd']")
	WebElement password;
	
	@FindBy(css="button")
	WebElement LoginFinal;
	
	@FindBy(css="h3")
	WebElement Header;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String Emailval,String Passwordval) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(SignBtn));
		SignBtn.click();
		email.sendKeys(Emailval);
		password.sendKeys(Passwordval);
		LoginFinal.click();
	}
	
	public void Positiveverify() {
		String ExpText = "SPORTY SHOES - DASHBOARD";
		String ActualText = Header.getText();
		
		Assert.assertEquals(ActualText, ExpText);
		test.log(LogStatus.PASS, "Logging in", "Logged in");
	}
	
	public void Negetiveverify() {
		String ExpURL = "http://localhost:8080/Section7LEP2/loginaction";
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ExpURL, ActualURL);
		test.log(LogStatus.PASS, "Using Wrong Password", "Not Logged In");
	}
	

}
