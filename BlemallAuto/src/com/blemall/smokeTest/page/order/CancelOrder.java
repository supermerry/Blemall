package com.blemall.smokeTest.page.order;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.test.base.Page;
import com.test.util.Assertion;
import com.test.util.Log;

public class CancelOrder extends Page{

	public CancelOrder(WebDriver driver) throws IOException {
		super(driver);
	}
	@Test(dataProvider="providerMethod")
	public void cancelOrder(Map<String,String> param) throws IOException, InterruptedException
	{
		CancelOrder co=new CancelOrder(driver);
		co.getElement("我的订单").click();
		Select select=new Select(co.getElement("订单状态"));
		select.selectByVisibleText("待付款");
		co.getElement("取消订单").click();
		co.getElement("确认取消").click();
		String orderNum=co.getElement("订单号").getText();
		String actual=co.getElement("已取消").getText();
		Assertion.verifyEquals(actual, "已取消","取消成功");
		Log.logInfo(orderNum+" 取消成功");
		
		
	}

}
