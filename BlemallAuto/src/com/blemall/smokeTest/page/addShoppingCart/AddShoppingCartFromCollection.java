package com.blemall.smokeTest.page.addShoppingCart;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.test.base.Page;
import com.test.util.Log;

public class AddShoppingCartFromCollection extends Page {

	public AddShoppingCartFromCollection(WebDriver driver) throws IOException {
		super(driver);
	}

	@Test(dataProvider = "providerMethod")
	public void addShoppingCartFromCollection(Map<String, String> param)
			throws IOException {
		AddShoppingCartFromCollection as = new AddShoppingCartFromCollection(
				driver);
		as.getElement("collection").click();
		Actions action = new Actions(driver);
		WebElement element = as.getElement("goods");
		action.moveToElement(element).build().perform();
		action.moveToElement(element).build().perform();
		as.getElement("addshoppingcart").click();
		as.getElement("shoppingcart").click();
		List<WebElement> list = as.getElements("allgoods");
		System.out.println(list.size());
		int count=0;
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i).getText();
			Log.logInfo(s);
			if (s.equals(param.get("goods"))) {
				Log.logInfo("商品加入购物车成功");
				break;
			}
			else{
				count++;
			}
			if(count==list.size()){
             Log.logInfo("添加失败");
			}
		}
	}

}
