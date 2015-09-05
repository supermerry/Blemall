package com.blemall.smokeTest.testcases.addshoppingcart;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.blemall.smokeTest.page.addShoppingCart.AddShoppingCartFromCollection;
import com.blemall.smokeTest.page.login.LoginPage;
import com.test.base.TestBase;

public class TestCase_03_AddShoppingCartFromCollection extends TestBase{
	@Test(dataProvider="providerMethod")
	public void addShoppingCartFromCollection(Map<String,String> param) throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.loginBlemall(param);
		AddShoppingCartFromCollection as=new AddShoppingCartFromCollection(driver);
		as.addShoppingCartFromCollection(param);
		
	}

}
