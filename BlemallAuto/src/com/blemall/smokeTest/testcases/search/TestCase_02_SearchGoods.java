package com.blemall.smokeTest.testcases.search;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.blemall.smokeTest.page.search.SearchPage;
import com.test.base.TestBase;

public class TestCase_02_SearchGoods extends TestBase{
	@Test(dataProvider="providerMethod")
	public void searchGoods(Map<String,String> param) throws IOException, InterruptedException
	{
		SearchPage sp=new SearchPage(driver);
		sp.searchGoods(param);
		
	}

}
