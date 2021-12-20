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

public class AfterLoginPage {
	WebDriver driver = Baseclass.driver;
	ExtentTest test = Baseclass.test;

	//*************************WebElements**********************
	@FindBy(linkText="Home")
	WebElement Home;

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

	@FindBy(css="a[href*='cartadditem?id=2']")
	WebElement Item1;


	@FindBy(css="a[href*='cartadditem?id=5']")
	WebElement Item2;

	@FindBy(xpath="//*[contains(text(),'Acer Laptop ABC')]")
	WebElement Item1Veri;

	@FindBy(xpath="//*[contains(text(),'iPhone x')]")
	WebElement Item2Veri;

	@FindBy(linkText="Checkout Now")
	WebElement CheckOut;

	@FindBy(linkText="Pay via secure Payment Gateway")
	WebElement PayNow;

	@FindBy(linkText="Click to complete checkout")
	WebElement CompleteNow;


	public AfterLoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void afterlogin(String Emailval,String Passwordval) {

		String Exp1= "Acer Laptop ABC";
		String Exp2 = "iPhone x";

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(Home));
		SignBtn.click();
		email.sendKeys(Emailval);
		password.sendKeys(Passwordval);
		LoginFinal.click();
		test.log(LogStatus.PASS, "Click on Login Button", "Clicked on Login Button");
		Home.click();
		Item1.click();
		test.log(LogStatus.PASS, "Adding Item to cart", "Item added to cart");
		Home.click();
		Item2.click();
		Assert.assertEquals(Item1Veri.getText(), Exp1);
		test.log(LogStatus.PASS, "Adding Item to cart", "Item added to cart");
		CheckOut.click();
		PayNow.click();
		CompleteNow.click();

		test.log(LogStatus.PASS, "Order Complete", "Order Completed");
	}

}
