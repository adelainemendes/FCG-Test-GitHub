package GitHub;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GitHub {

	public static void main(String[] args) throws InterruptedException {
		
		//Chrome driver.
		//System.setProperty("webdriver.chrome.driver", 
		//		"C:\\Users\\Virtual Machine\\Downloads\\chromedriver_win32\\chromedriver.exe");
					
		//Create Firefox Selenium WebDriver.
		WebDriver driver = new FirefoxDriver();
		//End driver after 3 seconds timeout.
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Load URL https://github.com.
		driver.get("https://github.com");
		
		
		Thread.sleep(2000);
		

		//Click on "Sign in" button.
		driver.findElement(By.xpath("html/body/header/div/div/div/a[2]")).click();
		
		
		
		//Credentials Test login fail.
		
		//Valid Login.
		driver.findElement(By.id("login_field")).sendKeys("rbrasiltester");
		//Wrong Password.
		driver.findElement(By.id("password")).sendKeys("rbrasiltesterpassword2015");
		//Click on "Sign in" button.
		driver.findElement(By.name("commit")).click();
		//Print error message.
		WebElement error = driver.findElement(By.id("js-flash-container"));
		System.out.println(error.getText());
		
		
		Thread.sleep(2000);
		
		
		//Credentials Test login successfully.
		
		//Clear Login field.
		driver.findElement(By.id("login_field")).clear();
		//Valid Login.
		driver.findElement(By.id("login_field")).sendKeys("rbrasiltester");
		//Clear Password field.
		driver.findElement(By.id("password")).clear();
		//Correct Password.
		driver.findElement(By.id("password")).sendKeys("rbrasiltesterpassword2016");
		//Click on - "Sign in" button.
		driver.findElement(By.name("commit")).click();
		
		
		Thread.sleep(2000);
		
		
		//Click on the specific repository "test_rb".
		driver.findElement(By.className("repo")).click();
		
		//Click on "Issues".
		driver.findElement(By.xpath(".//*[@id='js-repo-pjax-container']/div[1]/div[2]/nav/span[2]/a")).click();
		//Click on "New Issue" button.
		driver.findElement(By.xpath(".//*[@id='js-repo-pjax-container']/div[2]/div[1]/div/div[1]/a")).click();


		Thread.sleep(2000);
		
		
		//Write issue name.	
		driver.findElement(By.id("issue_title")).sendKeys("GitHub Selenium test - Gabane, Fernando");
		
		Thread.sleep(2000);
		
		//Click on "Submit new issue" button.
		driver.findElement(By.xpath("//*[@id='new_issue']/div[2]/div[1]/div/div/div[3]/button")).click();

		Thread.sleep(2000);

		//Write comment.
		driver.findElement(By.id("new_comment_field")).sendKeys
			("Dear, "
				+ "Thank you for this opportunity to be pre-selected in the recruitment process, for the Test Analyst role."
				+ "I do hope meet you personally soon."
				+ "Once more, thank you."
				+ "Faithfully,"
				+ "Fernando Cardoso Gabane");
		
				//Apply comment.				
		driver.findElement(By.xpath(".//*[@id='partial-new-comment-form-actions']/button[1]")).click();
		
		
		Thread.sleep(3000);
		
		
		//Locate label section to add a new one.
		WebElement labelGear = driver.findElement
				(By.xpath(".//*[@id='partial-discussion-sidebar']/div[1]/form/div[2]/button"));
						
		//Create a action to receive the driver.
		Actions action = new Actions(driver);
		//Click on label selection list.
		action.click(labelGear).perform();
		
		Thread.sleep(2000);
		
		//Locate the specific label "Duplicate".
		WebElement secondLabelGear = driver.findElement
				(By.xpath(".//*[@id='partial-discussion-sidebar']"
						+ "/div[1]/form/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/span[1]"));
		
		//Move driver over the label "Duplicate".
		action.moveToElement(labelGear).perform();
		//Select the label "Duplicate".
		action.click(secondLabelGear).perform();
		//Close label selection list.
		action.click(labelGear).perform();
		
			
		Thread.sleep(1000);
		
		
		//Click on "Close issue" button.
		driver.findElement(By.xpath(".//*[@id='partial-new-comment-form-actions']/button[2]")).click();
		
		//Close driver.
		driver.close();
	}

}
