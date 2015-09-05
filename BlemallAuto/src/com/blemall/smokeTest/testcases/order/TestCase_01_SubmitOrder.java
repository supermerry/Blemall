package com.blemall.smokeTest.testcases.order;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.blemall.smokeTest.page.login.LoginPage;
import com.blemall.smokeTest.page.order.SubmitOrder;
import com.blemall.smokeTest.page.queryshoppingcart.QueryShoppingCart;
import com.test.base.TestBase;

public class TestCase_01_SubmitOrder extends TestBase {
	@Test(dataProvider="providerMethod")
	public void submitOrder(Map<String,String> param) throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.loginBlemall(param);
		QueryShoppingCart qs=new QueryShoppingCart(driver);
		qs.queryShoppingCart();
		SubmitOrder so=new SubmitOrder(driver);
		so.submitOrder();
	}

}
