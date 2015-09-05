package com.blemall.smokeTest.page.addShoppingCart;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.base.Page;
import com.test.util.Log;

public class AddShoppingCart1 extends Page{

	public AddShoppingCart1(WebDriver driver) throws IOException {
		super(driver);
	}
	@Test(dataProvider = "providerMethod")
	public void addShoppingCart1(Map<String,String> param) throws IOException{
		System.out.println("Hello Merry！");
		AddShoppingCart1 as=new AddShoppingCart1(driver);
		
		as.getElement("inputbox").sendKeys(param.get("keyword"));
    	as.getElement("button").click();
    	Boolean result=as.getElement("isgoodsexist").isDisplayed();
		if(result)
		{
		as.getElement("goodsclick").click();
		switchWindow(param.get("goodsname"));
		as.getElement("addshoppingcard").click();
		String num=as.getElement("goodsnum").getText();
		Log.logInfo("添加后购物车数量= "+num);
		
		}
		else {
			Log.logError("你要加入购物车的商品不存在，请尝试加入其他商品");
		}
    	
    	
	}
	public void switchWindow(String title)
	{
		driver.switchTo().defaultContent();
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
	}
}
