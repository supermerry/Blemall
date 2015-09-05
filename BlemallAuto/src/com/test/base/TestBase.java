package com.test.base;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.dom4j.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.test.bean.Config;
import com.test.bean.Global;
import com.test.util.ParseXml;
import com.test.util.Util;

public class TestBase {
	protected WebDriver driver;
	private ParseXml px;
	private Map<String, String> commonMap;

	private void initalPx() {
		if (px == null) {

		}
		px = new ParseXml();
		px.load("test-data/" + this.getClass().getSimpleName() + ".xml");
	}

	public void getCommonMap() {
		if (commonMap == null) {
			Element element = px.getElementObject("/*/common");
			commonMap = px.getChildrenInfoByElement(element);
		}
	}

	@SuppressWarnings("unused")
	private Map<String, String> getMergeMapData(Map<String, String> map1,
			Map<String, String> map2) {
		Iterator<String> it = map2.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = map2.get(key);
			if (!map1.containsKey(key)) {
				map1.put(key, value);
			}
		}
		return map1;
	}

//	@BeforeTest
//	public void setUp() {
//		System.out.println("beforeTest");
//		SeleniumDriver sel = new SeleniumDriver();
//		driver = sel.selectBrowser();
//		driver.get(Config.path);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	}

	@DataProvider
	public Object[][] providerMethod(Method method) {
		this.initalPx();
		this.getCommonMap();
		String methodName = method.getName();
		List<Element> elements = px.getElementObjects("/*/" + methodName);
		System.out.println("elements: "+elements.size());
		Object[][] object = new Object[elements.size()][];
		for (int i = 0; i < elements.size(); i++) {
			Map<String,String> mergeCommon=this.getMergeMapData(px.getChildrenInfoByElement(elements
					.get(i)), commonMap);
					Map<String,String> mergeGlobal=this.getMergeMapData(mergeCommon,Global.global);
			Object[] temp = new Object[] { mergeGlobal};
			object[i] = temp;
		}
		return object;
	}

//	@AfterTest
//	public void tearDown() {
//		if (driver != null) {
//			driver.close();
//			driver.quit();
//		}
//	}

	public void goTo(String url) {
		driver.get(url);
		if (Config.browser.equals("firefox")) {
			Util.sleep(1);
		}
	}
	@BeforeMethod
	public void setUp() {
		System.out.println("BeforeMethod");
		SeleniumDriver sel = new SeleniumDriver();
		driver = sel.selectBrowser();
		driver.get(Config.path);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("AfterMethod");
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

}
