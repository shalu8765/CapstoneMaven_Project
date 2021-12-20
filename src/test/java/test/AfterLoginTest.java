package test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AfterLoginPage;
import pages.LoginPage;


public class AfterLoginTest extends Baseclass {

	
	@Parameters({"Email","Password"})
	@Test
	public void afterLogin(String Emailval,String Passwordval) {
		test = report.startTest("Check out Test");
		AfterLoginPage AfterLogin = new AfterLoginPage();
		AfterLogin.afterlogin(Emailval, Passwordval);
		report.endTest(test);
		
	}

}
