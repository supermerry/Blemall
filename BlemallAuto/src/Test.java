import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www2.iokbl.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("first_header_search_input")).sendKeys("手机");
		driver.findElement(By.xpath(".//*[@id='search']/div/div/div[2]/div[4]/button")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("html/body/div[5]/div[4]/div[2]/ul/li[1]/div/div[3]/a")).click();
		driver.switchTo().defaultContent();
        String title="洛克（ROCK）清爽薄隐形壳手机套 适用于苹果iPhone6 4.7英寸-金色-百联";
        // get all window handles
		Set<String> handlers =driver.getWindowHandles();
		Iterator it=handlers.iterator();
		System.out.println(it.next());
      while(it.hasNext())
        {
            driver.switchTo().window((String) it.next());
            if (driver.getTitle() == title)
            {
                System.out.println("success");
            }
            else
            {
                driver.switchTo().defaultContent();
            }
        }
       System.out.println("the end");
       driver.findElement(By.xpath(".//*[@id='addCart']")).click();
       String num=driver.findElement(By.xpath(".//*[@id='cartNum']")).getText();
       System.out.println("加入购物车数量： "+num);
}

}
