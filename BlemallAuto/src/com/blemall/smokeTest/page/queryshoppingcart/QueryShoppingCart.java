package com.blemall.smokeTest.page.queryshoppingcart;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.base.Page;
import com.test.util.Log;

public class QueryShoppingCart extends Page {

	public QueryShoppingCart(WebDriver driver) throws IOException {
		super(driver);
	}

	public int queryShoppingCart() throws IOException {
		int goodNum = 0;
		QueryShoppingCart qs = new QueryShoppingCart(driver);
		qs.getElement("shoppingcart").click();
		String result = qs.getElement("isempty").getText();
		if (result.equals("尝试买些东西再回来看看，肯定会有些不一样！")) {
			Log.logInfo("购物车没有商品，请去首页添加些商品吧！");
		} else {
			Log.logInfo("购物车有商品： " + qs.getElement("goodsnum").getText());
			String num = qs.getElement("goodsnum").getText();
			goodNum = Integer.parseInt(num.substring(0,num.length()-1));
		}
		Log.logInfo("查询购物车成功");
		return goodNum;
	}

}
