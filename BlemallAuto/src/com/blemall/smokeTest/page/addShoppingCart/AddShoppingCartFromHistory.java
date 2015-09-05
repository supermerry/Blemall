package com.blemall.smokeTest.page.addShoppingCart;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.test.base.Page;
import com.test.util.Log;

public class AddShoppingCartFromHistory extends Page {

	public AddShoppingCartFromHistory(WebDriver driver) throws IOException {
		super(driver);
	}

	@Test(dataProvider = "providerMethod")
	public void addShoppingCartFromHistory(Map<String, String> param)
			throws IOException {
		AddShoppingCartFromHistory as = new AddShoppingCartFromHistory(driver);
		//通过cookies的方式往已浏览的商品中注入数据
		Cookie cookies = new Cookie("_IOKBL_B_P", "112854", "/", null);
		driver.manage().addCookie(cookies);
		as.getElement("history").click();
		Actions action = new Actions(driver);
		WebElement element = as.getElement("goods");
		action.moveToElement(element).build().perform();
		action.moveToElement(element).build().perform();
		as.getElement("addshoppingcart").click();
		as.getElement("shoppingcart").click();
		//遍历购物车中所有的商品，循环比较是否有预期加入的商品
		List<WebElement> list = as.getElements("allgoods");
		System.out.println(list.size());
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i).getText();
			Log.logInfo(s);
			if (s.equals(param.get("goods"))) {
				Log.logInfo("添加成功");
				break;
			} else {
				count++;
			}
			if (count == list.size()) {
				Log.logInfo("添加失败");
			}
		}
	}

}
