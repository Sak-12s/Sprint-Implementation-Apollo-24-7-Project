package objectrepository;

import org.openqa.selenium.By;

public class Locators {
	
	public static By loginbtn = By.xpath("//*[@id=\"loginPopup\"]/div");
	public static By mobileinput = By.xpath("//input[@title='Please enter mobile number']");
	public static By continuebtn = By.xpath("//button[text()='Continue']");
	public static By otpinput = By.xpath("//input[@title='Please enter the otp']");
	public static By resendbtn = By.xpath("//span[text()='Resend OTP']");
	                                      
	public static By verifybtn = By.xpath("//button[text()='Verify']");
	public static By loginicon = By.xpath("//*[@id=\"loginPopup\"]/img");
	public static By mobilefield = By.xpath("//*[@id=\"fixedHeaderCT\"]/div/div[1]/div[2]/ul/li/div/div/div[2]/div[2]/div[2]/div/p[2]");
	public static By logoutbtn = By.xpath("//span[text()='Logout']");
	public static By invalidmobileerrormsg = By.xpath("//div[text()='This seems like a wrong number']");
	public static By closebtn = By.xpath("//span[@class='Rb']");
	
	public static By managefamilymembersbtn = By.xpath("//a[@href='/my-account']");
	public static By addnewbtn = By.xpath("//span[text()='Add New Profile']");
	public static By firstnameinput = By.xpath("//input[@placeholder='First Name']");
	public static By lastnameinput = By.xpath("//input[@placeholder='Last name']");
	public static By dobinput = By.xpath("//input[@placeholder='dd/mm/yyyy']");
	public static By relationdropdown = By.xpath("/html/body/main/div/div/div/div[2]/div/div[4]/div/div[2]/div[1]/div/div[3]/div/div");
	public static By emailinput = By.xpath("//input[@placeholder='name@email.com']");
	public static By savebtn = By.xpath("//span[text()='Save']");
	public static By confirmbtn = By.xpath("//span[text()='CONFIRM']");
	public static By okbtn = By.xpath("//span[text()='OK']");
	public static By profileclosebtn = By.xpath("//button[@title='Close']");
	
	public static By notificationpreferencesbtn = By.xpath("//span[text()='Notification Preferences']");
	public static By pushnotification = By.xpath("//span[text()='Push Notifications']/following::input[@type='checkbox'][1]");
	public static By smsnotification = By.xpath("//span[text()='SMS Notifications']/following::input[@type='checkbox'][1]");
	
	public static By buyinsurancebtn = By.xpath("//a[text()='Buy Insurance']");
	public static By locationdropdown = By.xpath("//div[@class='LocationInsurance_dropdownWrap__pYgH0']");
	public static By pincodeinput = By.xpath("//input[@placeholder='Enter 6 digit pincode']");
	public static By submitpincodebtn = By.xpath("//button[text()='Submit']");
	public static By viewplansbtn = By.xpath("//span[text()='View Plans']");
	public static By checkviewplans = By.xpath("//p[text()='View Plans']");
	
	public static By homebtn = By.xpath("//*[@id=\"fixedHeaderCT\"]/div/div[1]/div[1]/div/a/img");
	public static By weightmanagement = By.xpath("//a[text()='Weight Management']");
	public static By bmimeter = By.xpath("//li[@class='nav-item'][4]");
	public static By heightinput = By.xpath("//input[@id='height']");
	public static By weightinput = By.xpath("//input[@id='weight']");
	public static By calculatebtn = By.id("calculateBMI");
	public static By invaliderrmsg = By.xpath("//p[text()='Please enter valid height and weight']");
	public static By bmivalue = By.id("bmiValue");
	
	public static By profileicon = By.xpath("//div[@title='Login/SignUp']");
	
	
	
}
