package com.blemall.smokeTest.page.login;

import java.io.IOException;
import java.util.Map;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.base.Page;
import com.test.util.Assertion;
import com.test.util.Log;
import com.test.util.ScreenShot;

public class LoginPage extends Page {

	public LoginPage(WebDriver driver) throws IOException {
		super(driver);

	}

	@Test(dataProvider = "providerMethod")
	public void loginBlemall(Map<String, String> param) throws IOException, InterruptedException {
		Assertion.flag = true;
		LoginPage blemall = new LoginPage(driver);
		blemall.getElement("loginbutton").click();
		Log.logInfo("点击首页右上角的登录链接");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("conbar_0_iframe");

		blemall.getElement("username").sendKeys(param.get("username"));
		Log.logInfo("用户名: " + param.get("username"));
		blemall.getElement("password").sendKeys(param.get("password"));
		Log.logInfo("密码: " + param.get("password"));
		// String yanzhenma=JOptionPane.showInputDialog("checknumber");
		// blemall.getElement("checknumber").sendKeys(yanzhenma);
		// Log.logInfo("checknumber: "+yanzhenma);
		blemall.getElement("click").click();
		driver.switchTo().defaultContent();
		blemall.getElement("logincheck").click();
		String actual = blemall.getElement("logincheck").getText();
		Assert.assertEquals(actual, "生产环境");
		Log.logInfo("用户名/昵称/账号: " + actual);
		Log.logInfo("如果你看到这句话，就说明我登录成功啦！");
		// WebElement el=blemall.getElement("截图定位");
		// JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("arguments[0].scrollIntoView", el);
		// Thread.sleep(10000);
		// ScreenShot ss = new ScreenShot(driver);
		// ss.takeScreenshot();

	}

}
