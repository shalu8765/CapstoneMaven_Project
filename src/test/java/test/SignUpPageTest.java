package test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.SignUpPage;


public class SignUpPageTest extends Baseclass {

	
	@Parameters({"Email","Password","FirstName","LastName","Age","Address"})
	@Test
	public void signupTest(String Emailval,String Passwordval,String FirstNameval,String LastNameval,String Ageval,String Addressval) {
		
		test = report.startTest("Sign Up Test");
		SignUpPage Signup = new SignUpPage();
		Signup.signup(Emailval, Passwordval, FirstNameval, LastNameval, Ageval, Addressval);
		report.endTest(test);
		
		
	}
}
