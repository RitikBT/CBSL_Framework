
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailLogin {
	
	@Test
	public void login() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();		

	    driver.get("https://accounts.google.com");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
	    driver.findElement(By.xpath("//*[@jsname='YPqjbf' and @id='identifierId']")).sendKeys("ritikbt2001@gmail.com");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@jsname='V67aGc'and text()='Next']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("//*[@jsname='YPqjbf' and @name='password']")).sendKeys("PASSSWORD");
	    Thread.sleep(5000);
	    driver.findElement(By.id("passwordNext")).click();
	    Thread.sleep(5000);
		
	}

}
