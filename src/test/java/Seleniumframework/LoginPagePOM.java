package Seleniumframework;

public class LoginPagePOM extends BaseClasss{
	// username locator
	By username = By.id("txtUsername");


	// password locator
	By password = By.id("txtPassword");


	// login button
	By loginButton = By.xpath("//input[@id='btnLogin']");


	// forgotPasswordLink
	By forgotPasswordLink = By.xpath("//div[@id='forgotPasswordLink']/a");

	//Reset Password Button
	By resetPasswordButton= By.id("btnSearchValues");

	By forgetPasswordUsername= By.id("securityAuthentication_userName");



	/**
	* This method will perform the login operation based on provided username and
	* password
	*/
	public void loginToOrangeHrm(String username, String password) {


	driver.findElement(this.username).sendKeys(username);


	driver.findElement(this.password).sendKeys(password);


	driver.findElement(loginButton).click();


	}


	/**
	* This method will to reset the password for orange hrm website
	*/
	public void forgotPassword(String username) {

	driver.findElement(forgotPasswordLink).click();

	Assert.assertTrue(driver.findElement(resetPasswordButton).isDisplayed());

	driver.findElement(forgetPasswordUsername).sendKeys(username);

	driver.findElement(resetPasswordButton).click();

	}


}
