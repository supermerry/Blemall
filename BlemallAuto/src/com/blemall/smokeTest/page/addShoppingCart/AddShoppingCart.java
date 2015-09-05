package com.blemall.smokeTest.page.addShoppingCart;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.base.Page;
import com.test.util.Log;

public class AddShoppingCart extends Page {

	public AddShoppingCart(WebDriver driver) throws IOException {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "providerMethod")
	public void addShoppingCart(Map<String, String> param) throws IOException {
        
		AddShoppingCart sp = new AddShoppingCart(driver);
		sp.getElement("inputbox").sendKeys(param.get("keyword"));
		Log.logInfo("搜索关键字： " + param.get("keyword"));
		sp.getElement("button").click();
		sp.getElement("button").click();
		Boolean result = sp.getElement("isgoodsexist").isDisplayed();
		System.out.println("result= "+result);
		String s = null;
		if (result) {
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", sp.getElement("isgoodsexist"));
			//sp.getElement("isgoodsexist").click();
			try {
				Boolean empty = sp.getElement("goodsnum").isDisplayed();
				String num=sp.getElement("goodsnum").getText();
				Log.logInfo("添加购物车前数量= "+num);
				s=num;
			} catch (Exception e) {
				Log.logInfo("购物车为空");
				s="0";
			}
			finally{
				sp.getElement("goodsclick").click();
				switchWindow(param.get("goodsname"));
				sp.getElement("addshoppingcard").click();
				String num1=sp.getElement("goodsnum").getText();
				num1 = sp.getElement("goodsnum").getText();
				Log.logInfo("添加购物车后数量= " + num1);
				Assert.assertEquals(1, Integer.parseInt(num1)-Integer.parseInt(s));
			}
		}

		else {
			Log.logError("你要加入购物车的商品不存在，请尝试加入其他商品");
		}

	}

	public void switchWindow(String title) {
		driver.switchTo().defaultContent();
		// get all window handles
		Set<String> handlers = driver.getWindowHandles();
		Iterator it = handlers.iterator();
		while (it.hasNext()) {
			driver.switchTo().window((String) it.next());
			if (driver.getTitle() == title) {
				System.out.println("success");
			} else {
				driver.switchTo().defaultContent();
			}
		}
	}

}
