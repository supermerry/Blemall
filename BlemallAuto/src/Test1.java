import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Test1 {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://search.iokbl.com/k-%E6%89%8B%E6%9C%BA.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement el=driver.findElement(By.xpath("//a[contains(text()='洛克（ROCK）清爽薄隐形壳手机')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", el);
		System.out.println(el.isDisplayed());
		Actions action=new Actions(driver);
		action.moveToElement(el,0,0).build().perform();
		driver.findElement(By.xpath("//a[text()='洛克（ROCK）清爽薄隐形壳手机套 适用于苹果iPhone6 4.7英寸-金色']")).click();
		
	}

}
