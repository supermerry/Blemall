package com.blemall.smokeTest.testcases.addshoppingcart;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.blemall.smokeTest.page.addShoppingCart.AddShoppingCart;
import com.blemall.smokeTest.page.login.LoginPage;
import com.test.base.TestBase;

public class TestCase_04_AddShoppingCart extends TestBase {
	@Test(dataProvider="providerMethod")
	public void addShoppingCart(Map<String,String> param) throws IOException, InterruptedException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.loginBlemall(param);
		AddShoppingCart add=new AddShoppingCart(driver);
		add.addShoppingCart(param);
		
		
	}
	

}
