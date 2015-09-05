package com.blemall.smokeTest.page.order;

import java.io.IOException;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.base.Page;
import com.test.util.Assertion;
import com.test.util.Log;

public class SubmitOrder extends Page {

	public SubmitOrder(WebDriver driver) throws IOException {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@Test(dataProvider="providerMethod")
	public void submitOrder() throws IOException
	{
		SubmitOrder so=new SubmitOrder(driver);
		String sNum=so.getElement("已选商品数量").getText();
		Log.logInfo("已选商品数量= "+sNum);
		int num=Integer.parseInt(sNum);
		if(num>=1)
		{
			so.getElement("去结算").click();
			Log.logInfo("点击去结算");
		}
		else
		{
			Log.logError("购物车可下单的商品数量小于1，无法下单");
		}
		so.getElement("提交订单").click();
		Log.logInfo("提交订单");
		String result=so.getElement("支付页面").getText();
		Assertion.verifyEquals("订单提交成功，请您尽快付款！", result,"下单成功");
		Log.logInfo(result);
		
	}

}
