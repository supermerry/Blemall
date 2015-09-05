package com.blemall.smokeTest.testcases.addshoppingcart;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.blemall.smokeTest.page.addShoppingCart.AddShoppingCartFromList;
import com.test.base.TestBase;
import com.test.util.Log;

public class TestCase_02_AddShoppingCartFromList extends TestBase {
	@Test(dataProvider="providerMethod")
	public void addShoppingCart(Map<String,String> param) throws IOException, InterruptedException
	{
		driver.get("http://search.iokbl.com/k-%E6%89%8B%E6%9C%BA.html");
		AddShoppingCartFromList as=new AddShoppingCartFromList(driver);
		Actions action = new Actions(driver);
		WebElement e1=as.getElementNoWait("goodsbutton");
		WebElement e2=as.getElementNoWait("goodsimg");
		action.clickAndHold(e2).build().perform();
		e1.click();
		action.release(e2);
		String num=as.getElement("goodsnum").getText();
		Log.logInfo("加入购物车的商品数量= "+num);
		as.getElement("shoppingcart").click();
		String actualgoodsname=as.getElement("goodsname").getText();
		String expectedgoodsname=param.get("goodsname");
		Log.logInfo("商品名： "+actualgoodsname);
		Assert.assertEquals(expectedgoodsname,actualgoodsname);
		driver.close();
	}

}
