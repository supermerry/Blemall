import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
public class BaiLian {
	
	public static void main (String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.ie.driver", "file/IEDriverServer.exe");
		DesiredCapabilities capabilities=DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability("ignoreProtectedModeSettings", true);
		driver=new InternetExplorerDriver(capabilities);
		driver.manage().window().maximize();
		driver.get("http://www2.iokbl.com/");
		driver.findElement(By.id("first_header_search_input")).sendKeys("手机");
//		
		
		driver.findElement(By.xpath(".//*[@id='search']/div/div/div[2]/div[4]/button")).click();
		Actions act = new Actions(driver); 
//		
		WebElement link = driver.findElement(By.xpath("html/body/div[5]/div[4]/div[2]/ul/li[1]/div/div[1]/a/img"));
		act.moveToElement(link).build().perform(); 
		driver.findElement(By.xpath("html/body/div[5]/div[4]/div[2]/ul/li[1]/div/div[5]/button")).click();
	}
}