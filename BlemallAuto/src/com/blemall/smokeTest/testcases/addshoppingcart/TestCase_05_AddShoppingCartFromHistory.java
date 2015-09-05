package com.blemall.smokeTest.testcases.addshoppingcart;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.blemall.smokeTest.page.addShoppingCart.AddShoppingCartFromHistory;
import com.blemall.smokeTest.page.login.LoginPage;
import com.test.base.TestBase;

public class TestCase_05_AddShoppingCartFromHistory extends TestBase{
	@Test(dataProvider="providerMethod")
	public void addShoppingCartFromHistory(Map<String,String> param) throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.loginBlemall(param);
		AddShoppingCartFromHistory as=new AddShoppingCartFromHistory(driver);
		as.addShoppingCartFromHistory(param);
	}

}
