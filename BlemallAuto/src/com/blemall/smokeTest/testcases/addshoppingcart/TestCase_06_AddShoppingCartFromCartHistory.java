package com.blemall.smokeTest.testcases.addshoppingcart;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.blemall.smokeTest.page.addShoppingCart.AddShoppingCartFromCartHistory;
import com.blemall.smokeTest.page.login.LoginPage;
import com.blemall.smokeTest.page.queryshoppingcart.QueryShoppingCart;
import com.test.base.TestBase;

import junit.framework.Assert;

public class TestCase_06_AddShoppingCartFromCartHistory extends TestBase{
	@Test(dataProvider="providerMethod")
	public void addShoppingCartFromCartHistory(Map<String,String> param) throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.loginBlemall(param);
		QueryShoppingCart qs=new QueryShoppingCart(driver);
		int addNum = qs.queryShoppingCart();
		AddShoppingCartFromCartHistory as=new AddShoppingCartFromCartHistory(driver);
		int totalNum = as.addShoppingCartFromCartHistory(param);
		Assert.assertEquals(1, totalNum-addNum);
	}
	

}
