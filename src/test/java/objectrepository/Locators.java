package objectrepository;

import org.openqa.selenium.By;

public class Locators {
	
	public static By loginbtn = By.xpath("//*[@id=\"loginPopup\"]/div");
	public static By mobileinput = By.xpath("//input[@title='Please enter mobile number']");
	public static By continuebtn = By.xpath("//button[text()='Continue']");
	public static By otpinput = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div/div/form/div/div[1]/div[1]/input");
	public static By verifybtn = By.xpath("//button[text()='Verify']");
	public static By loginicon = By.xpath("//*[@id=\"loginPopup\"]/img");
	public static By mobilefield = By.xpath("//p[text()='+919176226906']");
}
