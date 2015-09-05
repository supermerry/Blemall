package com.blemall.smokeTest.page.addShoppingCart;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.base.Page;

public class AddShoppingCartFromCartHistory extends Page {

	public AddShoppingCartFromCartHistory(WebDriver driver) throws IOException {
		super(driver);
	}
	@Test(dataProvider="providerMethod")
	public int addShoppingCartFromCartHistory(Map<String,String> param) throws IOException
	{
		AddShoppingCartFromCartHistory as=new AddShoppingCartFromCartHistory(driver);
		as.getElement("收藏商品").click();
		as.getElement("加入购物车").click();
		String s=as.getElement("商品总数").getText();
		int num=Integer.parseInt(s.substring(0,s.length()-1));
		return num;
		
	}
	
}
