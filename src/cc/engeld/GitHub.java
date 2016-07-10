
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class GitHub {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://github.com");
	
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("html/body/header/div/div/div/a[2]")).click();
	
		driver.findElement(By.id("login_field")).sendKeys("rbrasiltester");
		driver.findElement(By.id("password")).sendKeys("rbrasiltesterpassword2015");
		driver.findElement(By.name("commit")).click();
		WebElement error = driver.findElement(By.id("js-flash-container"));
		System.out.println(error.getText());
	
		Thread.sleep(2000);
	
		driver.findElement(By.id("login_field")).clear();
		driver.findElement(By.id("login_field")).sendKeys("rbrasiltester");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("rbrasiltesterpassword2016");
	
		driver.findElement(By.name("commit")).click();

		Thread.sleep(2000);
	
		driver.findElement(By.className("repo")).click();

		driver.findElement(By.xpath(".//*[@id='js-repo-pjax-container']/div[1]/div[2]/nav/span[2]/a")).click();
		driver.findElement(By.xpath(".//*[@id='js-repo-pjax-container']/div[2]/div[1]/div/div[1]/a")).click();

		Thread.sleep(2000);
	
		driver.findElement(By.id("issue_title")).sendKeys("GitHub Selenium test - Gabane, Fernando");
	
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//*[@id='new_issue']/div[2]/div[1]/div/div/div[3]/button")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("new_comment_field")).sendKeys
			("Dear, "
				+ "Thank you for this opportunity to be pre-selected in the recruitment process, for the Test Analyst role."
				+ "I do hope meet you personally soon."
				+ "Once more, thank you."
				+ "Faithfully,"
				+ "Fernando Cardoso Gabane");
	
		driver.findElement(By.xpath(".//*[@id='partial-new-comment-form-actions']/button[1]")).click();
	
		Thread.sleep(3000);
		
		WebElement labelGear = driver.findElement
				(By.xpath(".//*[@id='partial-discussion-sidebar']/div[1]/form/div[2]/button"));

		Actions action = new Actions(driver);
		action.click(labelGear).perform();
		
		Thread.sleep(2000);
		
		WebElement secondLabelGear = driver.findElement
				(By.xpath(".//*[@id='partial-discussion-sidebar']"
						+ "/div[1]/form/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/span[1]"));
	
		action.moveToElement(labelGear).perform();
		action.click(secondLabelGear).perform();
		action.click(labelGear).perform();
	
		Thread.sleep(1000);

		driver.findElement(By.xpath(".//*[@id='partial-new-comment-form-actions']/button[2]")).click();

		driver.close();
	}

}
