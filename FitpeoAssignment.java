package seleniummysscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FitpeoAssignment {

	public static void main(String args[]) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.fitpeo.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		By calculator=By.xpath("//a/div[text()='Revenue Calculator']");
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(calculator)).click();
		Thread.sleep(3000);
		
	    WebElement slider= driver.findElement(By.xpath("(//div[@class='MuiBox-root css-j7qwjs']//span)[4]"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, '140')");
		Thread.sleep(3000);

		Actions action=new Actions(driver);
		action.dragAndDropBy(slider, (int)94, 100).build().perform();
		Thread.sleep(3000);

		
//		WebElement textField=driver.findElement(By.xpath("//div[@class='MuiBox-root css-j7qwjs']//span/following-sibling::div//input[@id=':r0:']"));
//		Thread.sleep(3000);
//
//		textField.clear();
//		textField.sendKeys("560"+Keys.ENTER);
		js.executeScript("window.scrollTo(0, '70')");
		Thread.sleep(3000);
		
		WebElement firstCPT=driver.findElement(By.xpath("//div[@class='MuiBox-root css-1p19z09']/div/p[text()='CPT-99091']/..//label//input"));
		firstCPT.click();	
		WebElement secondCPT=driver.findElement(By.xpath("//div[@class='MuiBox-root css-1p19z09']/div/p[text()='CPT-99453']/..//label//input"));
		secondCPT.click();	
		WebElement thirdCPT=driver.findElement(By.xpath("//div[@class='MuiBox-root css-1p19z09']/div/p[text()='CPT-99454']/..//label//input"));
		thirdCPT.click();
		Thread.sleep(3000);

		WebElement textfield=driver.findElement(By.xpath("(//div[@class='MuiBox-root css-rfiegf']//header//div//p)[7]//p"));
		String text=textfield.getText();

		System.out.println("Total Recurring Reimbursement for all Patients Per Month: "+text);

		//Total Recurring Reimbursement for all Patients Per Month:98760
		driver.close();
	}


}
