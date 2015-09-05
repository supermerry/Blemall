package com.blemall.smokeTest.testcases.addshoppingcart;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.blemall.smokeTest.page.addShoppingCart.AddShoppingCart1;
import com.test.base.TestBase;

public class TestCase_01_AddShoppingCartFromSingle extends TestBase {
	@Test(dataProvider="providerMethod")
	public void addshoppingcart(Map<String,String> param) throws IOException, InterruptedException
	{
		System.out.println("Good Morning,Merry!");
		AddShoppingCart1 as=new AddShoppingCart1(driver);
		as.addShoppingCart1(param);

		
	}

}
