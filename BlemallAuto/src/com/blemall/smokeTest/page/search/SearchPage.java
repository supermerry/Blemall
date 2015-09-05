package com.blemall.smokeTest.page.search;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.base.Page;
import com.test.util.Log;
import com.test.util.ScreenShot;

public class SearchPage extends Page{

	public SearchPage(WebDriver driver) throws IOException {
		super(driver);
	}
	@Test(dataProvider="providerMethod")
	public void searchGoods(Map<String,String> param) throws IOException, InterruptedException
	{
		SearchPage sp=new SearchPage(driver);
		sp.getElement("inputbox").sendKeys(param.get("goodsname"));
		Log.logInfo("查询商品关键字："+param.get("goodsname"));
		sp.getElement("button").click();
		Log.logInfo("点击搜索按钮");
//		Thread.sleep(30000);
//		new ScreenShot(driver).takeScreenshot();
		
		Log.logInfo("搜索商品成功");
		
	}
}
