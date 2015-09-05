package com.blemall.smokeTest.testcases.order;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.blemall.smokeTest.page.login.LoginPage;
import com.blemall.smokeTest.page.order.CancelOrder;
import com.test.base.TestBase;

public class TestCase_02_CancelOrder extends TestBase {
	@Test(dataProvider="providerMethod")
	public void cancelOrder(Map<String,String> param) throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.loginBlemall(param);
		CancelOrder co=new CancelOrder(driver);
		co.cancelOrder(param);
	}

}
