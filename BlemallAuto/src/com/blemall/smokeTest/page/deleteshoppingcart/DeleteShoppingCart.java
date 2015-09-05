package com.blemall.smokeTest.page.deleteshoppingcart;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.base.Page;
import com.test.util.Assertion;
import com.test.util.Log;

public class DeleteShoppingCart extends Page{

	public DeleteShoppingCart(WebDriver driver) throws IOException {
		super(driver);
	}
	@Test(dataProvider="providerMethod")
	public void deleteShoppingCart(Map<String,String> param) throws IOException
	{
		
		DeleteShoppingCart ds=new DeleteShoppingCart(driver);
		String num=ds.getElement("删除前购物车商品数量").getText();
		int goodNum = Integer.parseInt(num.substring(0,num.length()-1));
		Log.logInfo("删除前购物车商品数量= "+goodNum);
		ds.getElement("删除").click();
		ds.getElement("确认删除").click();
		if(goodNum==1)
		{
			String empty=ds.getElement("购物车为空").getText();
			Log.logInfo(empty);
			if(empty.equals("尝试买些东西再回来看看，肯定会有些不一样！"))
				Log.logInfo("如果你看到这句话，就说明购物车只有一件商品，删除后购物车为空！");
				
			
		}
		else
		{
			String num2=ds.getElement("删除后购物车商品数量").getText();
			int goodNum2 = Integer.parseInt(num2.substring(0,num2.length()-1));
			Log.logInfo("删除后购物车商品数量= "+goodNum2);
			Log.logInfo("删除商品数量： "+(goodNum-goodNum2));
			Assertion.verifyEquals(goodNum-goodNum2, 1);
		}
	}

}
