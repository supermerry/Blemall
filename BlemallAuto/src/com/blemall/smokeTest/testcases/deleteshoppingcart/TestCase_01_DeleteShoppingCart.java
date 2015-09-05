package com.blemall.smokeTest.testcases.deleteshoppingcart;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.blemall.smokeTest.page.deleteshoppingcart.DeleteShoppingCart;
import com.blemall.smokeTest.page.login.LoginPage;
import com.blemall.smokeTest.page.queryshoppingcart.QueryShoppingCart;
import com.test.base.TestBase;

public class TestCase_01_DeleteShoppingCart extends TestBase{
	@Test(dataProvider="providerMethod")
	public void deleteShoppingCart(Map<String,String> param) throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.loginBlemall(param);
		QueryShoppingCart qs=new QueryShoppingCart(driver);
		qs.queryShoppingCart();
		DeleteShoppingCart ds=new DeleteShoppingCart(driver);
		ds.deleteShoppingCart(param);
	}

}
