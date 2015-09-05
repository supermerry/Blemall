package com.blemall.smokeTest.testcases.queryshoppingcart;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.blemall.smokeTest.page.login.LoginPage;
import com.blemall.smokeTest.page.queryshoppingcart.QueryShoppingCart;
import com.test.base.TestBase;

public class TestCase_03_QueryShoppingCart extends TestBase{
	@Test(dataProvider="providerMethod")
	public void queryShoppingCart(Map<String,String> param) throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.loginBlemall(param);
		QueryShoppingCart qs=new QueryShoppingCart(driver);
		qs.queryShoppingCart();
	}

}
