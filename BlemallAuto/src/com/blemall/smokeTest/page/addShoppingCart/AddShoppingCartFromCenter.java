package com.blemall.smokeTest.page.addShoppingCart;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.base.Page;

public class AddShoppingCartFromCenter extends Page {

	public AddShoppingCartFromCenter(WebDriver driver) throws IOException {
		super(driver);
	}
	@Test(dataProvider="providerMethod")
	public int addShoppingCartFromCenter(Map<String,String> param) throws IOException
	{
		AddShoppingCartFromCenter as=new AddShoppingCartFromCenter(driver);
		as.getElement("我的百联").click();
		as.getElement("我的收藏").click();  
		as.getElement("加入购物车").click();
		String s=as.getElement("商品总数").getText();
		int num=Integer.parseInt(s.substring(0,s.length()-1));
		return num;
		
	}
	
}
